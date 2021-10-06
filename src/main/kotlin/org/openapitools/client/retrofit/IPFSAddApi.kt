package org.openapitools.client.retrofit

import okhttp3.MultipartBody
import org.openapitools.client.models.ipfs.IPFSObject
import retrofit2.Response
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

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
     * @return [IPFSObject]
     */
    @POST("ipfs/add")
    @Multipart
    suspend fun addFile(@Part file: MultipartBody.Part): Response<IPFSObject>
}
