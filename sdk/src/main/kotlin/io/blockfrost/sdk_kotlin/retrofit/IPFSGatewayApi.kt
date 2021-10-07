package io.blockfrost.sdk_kotlin.retrofit

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IPFSGatewayApi {
    /**
     * Relay to an IPFS gateway
     * Retrieve an object from the IFPS gateway (useful if you do not want to rely on a public gateway, such as &#x60;ipfs.blockfrost.dev&#x60;).
     * Responses:
     *  - 200: Returns the object content
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param ipFSPath  
     * @return [Unit]
     */
    @GET("ipfs/gateway/{IPFS_path}")
    suspend fun get(@Path("IPFS_path") ipFSPath: kotlin.String): Response<ResponseBody>

}
