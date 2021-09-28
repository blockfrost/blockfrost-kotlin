package org.openapitools.client.retrofit

import org.openapitools.client.models.Genesis
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface LedgerApi {
    /**
     * Blockchain genesis
     * Return the information about blockchain genesis.
     *
     * @return Call&lt;GenesisContent&gt;
     */
    @GET("genesis")
    fun genesisGet(@Header("project_id") projectId: String?): Response<Genesis?>?
}