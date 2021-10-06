package org.openapitools.client.retrofit

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody

import org.openapitools.client.models.InlineResponse2003
import org.openapitools.client.models.InlineResponse400
import org.openapitools.client.models.InlineResponse403
import org.openapitools.client.models.InlineResponse404
import org.openapitools.client.models.InlineResponse418
import org.openapitools.client.models.InlineResponse429
import org.openapitools.client.models.InlineResponse500

interface IPFSAddApi {
    /**
     * Add a file to IPFS
     * You need to &#x60;/ipfs/pin/add&#x60; an object to avoid it being garbage collected. This usage is being counted in your user account quota. 
     * Responses:
     *  - 200: Returns information about added IPFS object
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @return [InlineResponse2003]
     */
    @POST("ipfs/add")
    suspend fun add(): Response<InlineResponse2003>

}
