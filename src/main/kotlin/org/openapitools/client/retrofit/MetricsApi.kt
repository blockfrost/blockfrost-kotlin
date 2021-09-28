package org.openapitools.client.retrofit

import org.openapitools.client.models.EndpointUsageMetric
import org.openapitools.client.models.UsageMetric
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface MetricsApi {
    /**
     * Blockfrost endpoint usage metrics
     * History of your Blockfrost usage metrics per endpoint in the past 30 days.
     *
     * @return Call&lt;List&lt;EndpointUsageMetric&gt;&gt;
     */
    @GET("metrics/endpoints")
    fun metricsEndpointsGet(@Header("project_id") projectId: String?): Response<List<EndpointUsageMetric?>?>?


    /**
     * Blockfrost usage metrics
     * History of your Blockfrost usage metrics in the past 30 days.
     *
     * @return Call&lt;List&lt;UsageMetric&gt;&gt;
     */
    @GET("metrics/")
    fun metricsGet(@Header("project_id") projectId: String?): Response<List<UsageMetric?>?>?


}