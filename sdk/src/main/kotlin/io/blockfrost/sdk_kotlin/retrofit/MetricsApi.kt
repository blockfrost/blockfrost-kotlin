package io.blockfrost.sdk_kotlin.retrofit

import io.blockfrost.sdk_kotlin.models.Metric
import io.blockfrost.sdk_kotlin.models.MetricsEndpoint
import retrofit2.Response
import retrofit2.http.GET

interface MetricsApi {
    /**
     * Blockfrost usage metrics
     * History of your Blockfrost usage metrics in the past 30 days.
     * Responses:
     *  - 200: Return the last 30 days of metrics
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @return [kotlin.collections.List<Metric>]
     */
    @GET("metrics/")
    suspend fun getMetrics(): Response<kotlin.collections.List<Metric>>

    /**
     * Blockfrost endpoint usage metrics
     * History of your Blockfrost usage metrics per endpoint in the past 30 days. 
     * Responses:
     *  - 200: Return the last 30 days of metrics
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @return [kotlin.collections.List<MetricsEndpoint>]
     */
    @GET("metrics/endpoints")
    suspend fun getMetricsEndpoints(): Response<kotlin.collections.List<MetricsEndpoint>>

}
