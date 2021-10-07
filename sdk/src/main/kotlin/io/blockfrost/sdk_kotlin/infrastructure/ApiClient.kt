package io.blockfrost.sdk_kotlin.infrastructure

import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Retrofit
import java.net.URLConnection

open class ApiClient(val config: BlockfrostConfig) {
    companion object {
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
    val baseUrl: String get() = config.baseUrl

    open fun getRetrofit(): Retrofit {
        return config.getRetrofit()
    }

    open fun <S> createService(serviceClass: Class<S>): S {
        return config.createService(serviceClass)
    }

    /**
     * Guess Content-Type header from the given file (defaults to "application/octet-stream").
     *
     * @param fileName The given file name
     * @return The guessed Content-Type
     */
    protected fun guessContentTypeFromFile(fileName: String?, default: String? = null): String {
        return fileName?.let {
            URLConnection.guessContentTypeFromName(fileName)
        } ?: default ?: "application/octet-stream"
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

    open fun handleDataResponse(res: retrofit2.Response<ResponseBody>): ByteArray? {
        handleError(res)
        return res.body()?.bytes()
    }
}
