package org.openapitools.client.retrofit

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import org.openapitools.client.models.*

interface HealthApi {
    /**
     * Root endpoint
     * Root endpoint has no other function than to point end users to documentation. 
     * Responses:
     *  - 200: Information pointing to the documentation.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @return [ApiRoot]
     */
    @GET(".")
    suspend fun getApiRoot(): Response<ApiRoot>

    /**
     * Current backend time
     * This endpoint provides the current UNIX time. Your application might use this to verify if the client clock is not out of sync. 
     * Responses:
     *  - 200: Return the current UNIX time in milliseconds.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @return [Clock]
     */
    @GET("health/clock")
    suspend fun getCurrentBackendTime(): Response<Clock>

    /**
     * Backend health status
     * Return backend status as a boolean. Your application     should handle situations when backend for the given chain is unavailable. 
     * Responses:
     *  - 200: Return the boolean indicating the health of the backend.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @return [Health]
     */
    @GET("health")
    suspend fun getHealth(): Response<Health>

}
