package org.openapitools.client.retrofit

import org.openapitools.client.models.Network
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface NetworkApi {
    /**
     * Blockchain network
     * Return the information about network.
     *
     * @return Call&lt;Network&gt;
     */
    @GET("network")
    fun networkGet(@Header("project_id") projectId: String?): Response<Network?>?
}