package org.openapitools.client.infrastructure

import io.github.resilience4j.circuitbreaker.CircuitBreaker
import io.github.resilience4j.core.IntervalFunction
import io.github.resilience4j.retrofit.CircuitBreakerCallAdapter
import io.github.resilience4j.retrofit.RetryCallAdapter
import io.github.resilience4j.retry.Retry
import io.github.resilience4j.retry.RetryConfig
import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.suspendCancellableCoroutine
import okhttp3.*
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.net.URLConnection
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.OffsetTime
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeoutException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

// TODO: error handling?
open class ApiClient(val config: BlockfrostConfig) {
    companion object {
        protected const val ContentType = "Content-Type"
        protected const val Accept = "Accept"
        protected const val Authorization = "Authorization"
        protected const val JsonMediaType = "application/json"
        protected const val FormDataMediaType = "multipart/form-data"
        protected const val FormUrlEncMediaType = "application/x-www-form-urlencoded"
        protected const val XmlMediaType = "application/xml"

        val apiKey: MutableMap<String, String> = mutableMapOf()
        val apiKeyPrefix: MutableMap<String, String> = mutableMapOf()

        @JvmStatic
        val client: OkHttpClient by lazy {
            builder.build()
        }

        @JvmStatic
        val builder: OkHttpClient.Builder = OkHttpClient.Builder()
    }

    /**
     * BaseURL loaded from configuration
     */
    val baseUrl: String get() = config.baseUrl ?: BlockfrostConfig.UrlMainnet

    open fun getRetrofit(): Retrofit {
        return config.getRetrofit()
    }

    open fun <S> createService(serviceClass: Class<S>): S {
        return config.createService(serviceClass)
    }

    /**
     * Guess Content-Type header from the given file (defaults to "application/octet-stream").
     *
     * @param file The given file
     * @return The guessed Content-Type
     */
    protected fun guessContentTypeFromFile(file: File): String {
        val contentType = URLConnection.guessContentTypeFromName(file.name)
        return contentType ?: "application/octet-stream"
    }

    protected fun <T> updateAuthParams(requestConfig: RequestConfig<T>) {
        if (requestConfig.headers["project_id"].isNullOrEmpty()) {
            if (apiKey["project_id"] != null) {
                if (apiKeyPrefix["project_id"] != null) {
                    requestConfig.headers["project_id"] = apiKeyPrefix["project_id"]!! + " " + apiKey["project_id"]!!
                } else {
                    requestConfig.headers["project_id"] = apiKey["project_id"]!!
                }
            }
        }
    }

    open fun <T> handleListResponse(res: retrofit2.Response<List<T>>): List<T> {
        return res.body() ?: emptyList()
    }

    open fun <T> handleResponse(res: retrofit2.Response<T>): T? {
        return res.body()
    }

//    protected suspend inline fun <reified I, reified T: Any?> request(requestConfig: RequestConfig<I>): ApiInfrastructureResponse<T?> {
//        val httpUrl = baseUrl.toHttpUrlOrNull() ?: throw IllegalStateException("baseUrl is invalid.")
//
//        // take authMethod from operation
//        updateAuthParams(requestConfig)
//
//        val url = httpUrl.newBuilder()
//            .addPathSegments(requestConfig.path.trimStart('/'))
//            .apply {
//                requestConfig.query.forEach { query ->
//                    query.value.forEach { queryValue ->
//                        addQueryParameter(query.key, queryValue)
//                    }
//                }
//            }.build()
//
//        // take content-type/accept from spec or set to default (application/json) if not defined
//        if (requestConfig.headers[ContentType].isNullOrEmpty()) {
//            requestConfig.headers[ContentType] = JsonMediaType
//        }
//        if (requestConfig.headers[Accept].isNullOrEmpty()) {
//            requestConfig.headers[Accept] = JsonMediaType
//        }
//        val headers = requestConfig.headers
//
//        if((headers[ContentType] ?: "") == "") {
//            throw kotlin.IllegalStateException("Missing Content-Type header. This is required.")
//        }
//
//        if((headers[Accept] ?: "") == "") {
//            throw kotlin.IllegalStateException("Missing Accept header. This is required.")
//        }
//
//        // TODO: support multiple contentType options here.
//        val contentType = (headers[ContentType] as String).substringBefore(";").lowercase(Locale.getDefault())
//
//        val request = when (requestConfig.method) {
//            RequestMethod.DELETE -> Request.Builder().url(url).delete(requestBody(requestConfig.body, contentType))
//            RequestMethod.GET -> Request.Builder().url(url)
//            RequestMethod.HEAD -> Request.Builder().url(url).head()
//            RequestMethod.PATCH -> Request.Builder().url(url).patch(requestBody(requestConfig.body, contentType))
//            RequestMethod.PUT -> Request.Builder().url(url).put(requestBody(requestConfig.body, contentType))
//            RequestMethod.POST -> Request.Builder().url(url).post(requestBody(requestConfig.body, contentType))
//            RequestMethod.OPTIONS -> Request.Builder().url(url).method("OPTIONS", null)
//        }.apply {
//            headers.forEach { header -> addHeader(header.key, header.value) }
//        }.build()
//
//        val reqCall = client.newCall(request)
//        return suspendCancellableCoroutine { cont: CancellableContinuation<ApiInfrastructureResponse<T?>> ->
//            cont.invokeOnCancellation {
//                reqCall.cancel()
//            }
//
//            reqCall.enqueue(object : Callback {
//                override fun onFailure(call: Call, e: IOException) {
//                    cont.resumeWithException(e)
//                    //throw RuntimeException("Request error : ${e.localizedMessage.orEmpty()}", e)
//                }
//
//                override fun onResponse(call: Call, response: Response) {
//                    val accept = response.header(ContentType)?.substringBefore(";")?.lowercase(Locale.getDefault())
//
//                    // TODO: handle specific mapping types. e.g. Map<int, Class<?>>
//                    val res = when {
//                        response.isRedirect -> Redirection<T?>(
//                            response.code,
//                            response.headers.toMultimap()
//                        )
//                        response.isInformational -> Informational(
//                            response.message,
//                            response.code,
//                            response.headers.toMultimap()
//                        )
//                        response.isSuccessful -> Success(
//                            responseBody(response.body, accept),
//                            response.code,
//                            response.headers.toMultimap()
//                        )
//                        response.isClientError -> ClientError(
//                            response.message,
//                            response.body?.string(),
//                            response.code,
//                            response.headers.toMultimap()
//                        )
//                        else -> ServerError(
//                            response.message,
//                            response.body?.string(),
//                            response.code,
//                            response.headers.toMultimap()
//                        )
//                    }
//
//                    cont.resume(res)
//                }
//            })
//
//        }

        //val response = client.newCall(request).execute()
//        val accept = response.header(ContentType)?.substringBefore(";")?.lowercase(Locale.getDefault())
//
//        // TODO: handle specific mapping types. e.g. Map<int, Class<?>>
//        return when {
//            response.isRedirect -> Redirection(
//                response.code,
//                response.headers.toMultimap()
//            )
//            response.isInformational -> Informational(
//                response.message,
//                response.code,
//                response.headers.toMultimap()
//            )
//            response.isSuccessful -> Success(
//                responseBody(response.body, accept),
//                response.code,
//                response.headers.toMultimap()
//            )
//            response.isClientError -> ClientError(
//                response.message,
//                response.body?.string(),
//                response.code,
//                response.headers.toMultimap()
//            )
//            else -> ServerError(
//                response.message,
//                response.body?.string(),
//                response.code,
//                response.headers.toMultimap()
//            )
//        }
//    }

//    protected fun parameterToString(value: Any?): String = when (value) {
//        null -> ""
//        is Array<*> -> toMultiValue(value, "csv").toString()
//        is Iterable<*> -> toMultiValue(value, "csv").toString()
//        is OffsetDateTime, is OffsetTime, is LocalDateTime, is LocalDate, is LocalTime, is Date ->
//            parseDateToQueryString(value)
//        else -> value.toString()
//    }
//
//    protected inline fun <reified T: Any> parseDateToQueryString(value : T): String {
//        /*
//        .replace("\"", "") converts the json object string to an actual string for the query parameter.
//        The moshi or gson adapter allows a more generic solution instead of trying to use a native
//        formatter. It also easily allows to provide a simple way to define a custom date format pattern
//        inside a gson/moshi adapter.
//        */
//        return Serializer.moshi.adapter(T::class.java).toJson(value).replace("\"", "")
//    }
}
