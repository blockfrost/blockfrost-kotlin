@file:Suppress("unused")
package io.blockfrost.sdk.kotlin.infrastructure

open class BlockfrostException(message: String? = null, cause: Throwable? = null) : RuntimeException(message, cause) {
    companion object {
        private const val serialVersionUID: Long = 121L
    }
}

open class APIRuntimeException(message: String? = null, cause: Throwable? = null) : BlockfrostException(message, cause) {
    companion object {
        private const val serialVersionUID: Long = 121L
    }
}

open class ClientException(message: String? = null, val statusCode: Int = -1, val response: retrofit2.Response<*>? = null) : BlockfrostException(message) {

    companion object {
        private const val serialVersionUID: Long = 123L
    }
}

open class BadRequestException(message: String? = null, response: retrofit2.Response<*>? = null) : ClientException(message, 400, response) {

    companion object {
        private const val serialVersionUID: Long = 124L
    }
}

open class ForbiddenException(message: String? = null, response: retrofit2.Response<*>? = null) : ClientException(message, 403, response) {

    companion object {
        private const val serialVersionUID: Long = 125L
    }
}

open class NotFoundException(message: String? = null, response: retrofit2.Response<*>? = null) : ClientException(message, 404, response) {

    companion object {
        private const val serialVersionUID: Long = 126L
    }
}

open class BannedException(message: String? = null, response: retrofit2.Response<*>? = null) : ClientException(message, 418, response) {

    companion object {
        private const val serialVersionUID: Long = 127L
    }
}

open class RateLimitedException(message: String? = null, response: retrofit2.Response<*>? = null) : ClientException(message, 429, response) {

    companion object {
        private const val serialVersionUID: Long = 128L
    }
}

open class ServerException(message: String? = null, val statusCode: Int = -1, val response: retrofit2.Response<*>? = null) : BlockfrostException(message) {

    companion object {
        private const val serialVersionUID: Long = 456L
    }
}