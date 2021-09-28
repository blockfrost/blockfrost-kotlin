package org.openapitools.client.retrofit

import okhttp3.ResponseBody
import org.openapitools.client.models.Clock
import org.openapitools.client.models.Health
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface HealthApi {
    /**
     * Current backend time
     * This endpoint provides the current UNIX time. Your application might use this to verify if the client clock is not out of sync.
     *
     * @return Call&lt;Clock&gt;
     */
    @GET("health/clock")
    fun healthClockGet(@Header("project_id") projectId: String?): Response<Clock?>?


    /**
     * Backend health status
     * Return backend status as a boolean. Your application  should handle situations when backend for the given chain is unavailable.
     *
     * @return Call&lt;Health&gt;
     */
    @GET("health")
    fun healthGet(@Header("project_id") projectId: String?): Response<Health?>?


    /**
     * Root endpoint
     * Root endpoint has no other function than to point end users to documentation.
     *
     * @return Call&lt;ApiRoot&gt;
     */
    @GET("/")
    fun rootGet(@Header("project_id") projectId: String?): Response<ResponseBody?>?


}