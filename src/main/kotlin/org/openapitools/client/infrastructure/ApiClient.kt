package org.openapitools.client.infrastructure

import okhttp3.*
import org.openapitools.client.models.AccountAddressesContent
import retrofit2.Retrofit
import java.io.File
import java.net.URLConnection

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

    open fun handleError(res: retrofit2.Response<*>) {
        when {
            res.code() == 400 -> {
                throw BadRequestException(res.message(), res)
            }
            res.code() == 403 -> {
                throw ForbiddenException(res.message(), res)
            }
            res.code() == 404 -> {
                throw NotFoundException(res.message(), res)
            }
            res.code() == 418 -> {
                throw BannedException(res.message(), res)
            }
            res.code() == 429 -> {
                throw RateLimitedException(res.message(), res)
            }
            res.isClientError -> {
                throw ClientException(res.message(), res.code(), res)
            }
            res.isServerError -> {
                throw ServerException(res.message(), res.code(), res)
            }
        }
    }

    open fun <T> handleListResponse(res: retrofit2.Response<List<T>>): List<T> {
        handleError(res)
        return res.body() ?: emptyList()
    }

    open fun <T> handleResponse(res: retrofit2.Response<T>): T? {
        handleError(res)
        return res.body()
    }

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
