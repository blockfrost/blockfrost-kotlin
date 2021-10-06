package org.openapitools.client.retrofit

import org.openapitools.client.models.ipfs.PinItem
import org.openapitools.client.models.ipfs.PinResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface IPFSPinsApi {
    /**
     * List pinned objects
     * List objects pinned to local storage
     * Responses:
     *  - 200: Returns pinned objects
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<PinItem>]
     */
    @GET("ipfs/pin/list/")
    suspend fun getPinList(@Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<PinItem>>

    /**
     * Get details about pinned object
     * Get information about locally pinned IPFS object
     * Responses:
     *  - 200: Returns the pins pinned
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param ipFSPath  
     * @return [PinItem]
     */
    @GET("ipfs/pin/list/{IPFS_path}")
    suspend fun getPinListByIpfsPath(@Path("IPFS_path") ipFSPath: kotlin.String): Response<PinItem>

    /**
     * Pin an object
     * Pinned objects are counted in your user storage quota.
     * Responses:
     *  - 200: Returns pinned object
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param ipFSPath  
     * @return [PinResponse]
     */
    @POST("ipfs/pin/add/{IPFS_path}")
    suspend fun pinAdd(@Path("IPFS_path") ipFSPath: kotlin.String): Response<PinResponse>

    /**
     * 
     * Remove pinned objects from local storage
     * Responses:
     *  - 200: Returns the pins removed
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param ipFSPath  
     * @return [PinResponse]
     */
    @POST("ipfs/pin/remove/{IPFS_path}")
    suspend fun removePin(@Path("IPFS_path") ipFSPath: kotlin.String): Response<PinResponse>

}
