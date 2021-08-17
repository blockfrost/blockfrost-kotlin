package org.openapitools.client.infrastructure

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.sync.Semaphore
import org.openapitools.client.models.BlockContent
import retrofit2.Response
import java.util.concurrent.PriorityBlockingQueue
import java.util.concurrent.atomic.AtomicInteger
import org.slf4j.Logger
import org.slf4j.LoggerFactory


class PageLister<T>(
    val countPerPage: Int = 100,
    val concurrentPages: Int = 10,

) {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)
    private var genJob: Job? = null

    private var semWork: Semaphore? = null
    private var outputChannel: Channel<Response<List<T?>?>?>? = null
    private var pageQueue: PriorityBlockingQueue<PagedResponse<T?>>? = null
    private var numPages = 0

    suspend fun load(loader: suspend (count: Int, page: Int) -> Response<List<T?>?>) : Flow<T> = flow { coroutineScope {
        val lowestEmptyPage = AtomicInteger(Int.MAX_VALUE - concurrentPages - 1)
        val semWork = Semaphore(concurrentPages, 0).also { this@PageLister.semWork = it }

        val outputChannel = Channel<Response<List<T?>?>?>().also { this@PageLister.outputChannel = it }
        val pageQueue = PriorityBlockingQueue<PagedResponse<T?>>(11, compareBy { it.page }).also { this@PageLister.pageQueue = it }
        val taskChannel = Channel<Deferred<PagedResponse<T?>>>()

        val taskProcessor: suspend (Deferred<PagedResponse<T?>>) -> Unit = process@{ task ->
            val cpr = task.await()
            val cr = cpr.response
            logger.info("Finished page load ${cpr.page} res: ${cr?.code()}, size: ${cr?.body()?.size ?: -1}, avail works ${semWork.availablePermits}")

            if (cr == null || !cr.isSuccessful){
                logger.info("Page loading error ${cpr.page}")
                val exc = RuntimeException("Page loader error - could not load the page ${cpr.page}")
                outputChannel.close(exc)
                semWork.release()
                throw exc
            }

            if ((cr.body()?.size ?: 0) == 0){
                val origLastPage = lowestEmptyPage.get()
                val newLast = ensureMinAndGet(lowestEmptyPage, cpr.page).also { numPages = it }
                logger.info("Handling empty page ${cpr.page}, orig last: $origLastPage, newLast: $newLast")

                outputChannel.trySend(null)  // can fail, have to insert null as order can be permuted
                semWork.release()
                return@process
            }

            try {
                outputChannel.send(cr)
                pageQueue.add(cpr)
            } catch(e: Exception){
                logger.error("Exception adding page ${cpr.page}, results: ${cr.body()?.size}")
                throw e
            }

            semWork.release()
            logger.info("Released, avail ${semWork.availablePermits}")
        }

        repeat(concurrentPages){
            launch {
                for(task in taskChannel) {
                    taskProcessor(task)
                }
            }
        }

        genJob = launch {
            for(page in generateSequence(1) { it + 1 }){
                if (page >= lowestEmptyPage.get()){
                    logger.info("Paging stopped at $page")
                    break
                }

                val task = async {
                    logger.info("Starting async page load for page $page")
                    val rr = loader(countPerPage, page)
                    PagedResponse(page, rr)
                }
                taskChannel.send(task)

                // launch { taskProcessor(task) }

                semWork.acquire()
            }
        }

        var lastQueuePage = 0  // ensure strict ordering of pages
        val queueDrainer : suspend (Int) -> Unit = { ix: Int ->
            while (!pageQueue.isEmpty() && lastQueuePage + 1 == pageQueue.peek().page){
                val toReturn = pageQueue.poll()
                lastQueuePage = toReturn.page
                logger.info(".. Sorted page: ${toReturn.page} in cycle $ix")
                for (elem in toReturn?.response?.body()?: emptyList()){
                    elem?.let { emit(it) }
                }
            }
        }

        var nread = 0
        var nNotNull = 0
        for(res in outputChannel){
            logger.info("output[$nread]: $res")
            if (res != null){
                nNotNull += 1
            }
            nread += 1

            queueDrainer(nread)
            val firstEmpty = lowestEmptyPage.get()
            if ((nNotNull + 1) >= firstEmpty){
                logger.info("Closing channel, processed $nread, nnull $nNotNull, last ${lowestEmptyPage.get()}")
                outputChannel.close()
                taskChannel.close()
                break
            }
        }

        queueDrainer(nread)

        logger.info("Finished, perms: ${semWork.availablePermits}")
        if (nNotNull + 1 != lowestEmptyPage.get()){
            logger.error("nread: $nread, nNotNull: $nNotNull, lowest empty: ${lowestEmptyPage.get()}")
            throw RuntimeException("Page loader error - pages missing")
        }
    }
    }

    companion object {
        fun ensureMinAndGet(atomic: AtomicInteger, value: Int): Int {
            var tmpLastReturned: Int
            do {
                tmpLastReturned = atomic.get()
                if (tmpLastReturned <= value) {
                    return tmpLastReturned
                }

            } while (!atomic.compareAndSet(tmpLastReturned, value))
            return value
        }

        fun ensureMaxAndGet(atomic: AtomicInteger, value: Int): Int {
            var tmpLastReturned: Int
            do {
                tmpLastReturned = atomic.get()
                if (tmpLastReturned >= value) {
                    return tmpLastReturned
                }

            } while (!atomic.compareAndSet(tmpLastReturned, value))
            return value
        }
    }
}