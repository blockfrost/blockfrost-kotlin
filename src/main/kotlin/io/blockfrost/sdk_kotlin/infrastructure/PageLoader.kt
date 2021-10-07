package io.blockfrost.sdk_kotlin.infrastructure

import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Semaphore
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.concurrent.PriorityBlockingQueue
import java.util.concurrent.atomic.AtomicInteger

// Enables easy conversion of Response<List<T>> to List<T> in PageLister
typealias PageLoaderResponse<T> = List<T>
fun PageLoaderResponse<*>.code(): Int {
    return 200
}
val PageLoaderResponse<*>.isSuccessful: Boolean get() { return true }
fun <T> PageLoaderResponse<T>.body(): List<T> {
    return this
}

data class PagedResponse<T>(val page: Int, val response: PageLoaderResponse<T>? = null)

open class PageListerException(message: String? = null, val page: Int? = null, cause: Throwable? = null) : BlockfrostException(message, cause) {
    companion object {
        private const val serialVersionUID: Long = 23L
    }
}

class PageLoader<T>(
    val countPerPage: Int = 100,
    val concurrentPages: Int = 10,

) {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)
    private var genJob: Job? = null

    private var semWork: Semaphore? = null
    private var outputChannel: Channel<PageLoaderResponse<T>?>? = null
    private var pageQueue: PriorityBlockingQueue<PagedResponse<T>>? = null
    private var numPages = 0

    suspend fun load(loader: suspend (count: Int, page: Int) -> PageLoaderResponse<T>) : Flow<T> = flow { coroutineScope {
        val lowestEmptyPage = AtomicInteger(Int.MAX_VALUE - concurrentPages - 1)
        val semWorkers = Semaphore(concurrentPages, 0).also { this@PageLoader.semWork = it }

        val outputChannel = Channel<PageLoaderResponse<T>?>().also { this@PageLoader.outputChannel = it }
        val pageQueue = PriorityBlockingQueue<PagedResponse<T>>(11, compareBy { it.page }).also { this@PageLoader.pageQueue = it }
        val taskChannel = Channel<Int>()

        val taskErrorProcessor: suspend (PagedResponse<T>, Exception?) -> Unit = process@{ cpr, exc ->
            logger.debug("Page loading error ${cpr.page}")
            semWorkers.release()

            if (cpr.page >= lowestEmptyPage.get()) {
                outputChannel.trySend(null)
                return@process
            }

            val excNew = PageListerException("Page loader error - could not load the page ${cpr.page}", page=cpr.page, cause=exc)
            outputChannel.close(excNew)
            throw excNew
        }

        val taskProcessor: suspend (PagedResponse<T>) -> Unit = process@{ cpr ->
            val cr = cpr.response
            logger.debug("Finished page load ${cpr.page} res: ${cr?.code()}, size: ${cr?.body()?.size ?: -1}, avail works ${semWorkers.availablePermits}")

            if (cr == null || !cr.isSuccessful){
                taskErrorProcessor(cpr, null)
            }

            if ((cr?.body()?.size ?: 0) == 0){
                val origLastPage = lowestEmptyPage.get()
                val newLast = ensureMinAndGet(lowestEmptyPage, cpr.page).also { numPages = it }
                logger.debug("Handling empty page ${cpr.page}, orig last: $origLastPage, newLast: $newLast")

                outputChannel.trySend(null)  // can fail, have to insert null as order can be permuted
                semWorkers.release()
                return@process
            }

            try {
                outputChannel.send(cr)
                pageQueue.add(cpr)
            } catch(e: Exception){
                logger.error("Exception adding page ${cpr.page}, results: ${cr?.body()?.size}")
                throw e
            }

            semWorkers.release()
            logger.debug("Released, avail ${semWorkers.availablePermits}")
        }

        val pageLoader: suspend (Int) -> Unit = { page ->
            logger.debug("Starting async page load for page $page")
            try {
                val rr = loader(countPerPage, page)
                taskProcessor(PagedResponse(page, rr))
            } catch (e: Exception){
                taskErrorProcessor(PagedResponse(page, null), e)
                logger.error("Exception in loader, page: $page", e)
            }
        }

        // Page downloaders and processors
        repeat(concurrentPages){
            launch {
                for(page in taskChannel) {
                    pageLoader(page)
                }
            }
        }

        // Page number generator
        genJob = launch {
            for(page in generateSequence(1) { it + 1 }){
                if (page >= lowestEmptyPage.get()){
                    logger.debug("Paging stopped at $page")
                    break
                }

                taskChannel.send(page)

                // Coroutine per request - more robust in case of failures
                // launch { pageLoader(page) }
                semWorkers.acquire()
            }
        }

        var lastQueuePage = 0  // ensure strict ordering of pages
        val queueDrainer : suspend (Int) -> Unit = { ix: Int ->
            while (!pageQueue.isEmpty() && lastQueuePage + 1 == pageQueue.peek().page){
                val toReturn = pageQueue.poll()
                lastQueuePage = toReturn.page
                logger.debug(".. Sorted page: ${toReturn.page} in cycle $ix")
                for (elem in toReturn?.response?.body()?: emptyList()){
                    elem?.let { emit(it) }
                }
            }
        }

        var nread = 0
        var nNotNull = 0
        for(res in outputChannel){
            logger.debug("output[$nread]: $res")
            if (res != null){
                nNotNull += 1
            }
            nread += 1

            queueDrainer(nread)
            val firstEmpty = lowestEmptyPage.get()
            if ((nNotNull + 1) >= firstEmpty){
                logger.debug("Closing channel, processed $nread, nnull $nNotNull, last ${lowestEmptyPage.get()}")
                outputChannel.close()
                taskChannel.close()
                break
            }
        }

        queueDrainer(nread)

        logger.debug("Finished, perms: ${semWorkers.availablePermits}")
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