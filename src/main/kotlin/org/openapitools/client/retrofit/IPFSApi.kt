package org.openapitools.client.retrofit

import okhttp3.ResponseBody
import org.openapitools.client.models.ipfs.IPFSObject
import org.openapitools.client.models.ipfs.PinItem
import org.openapitools.client.models.ipfs.PinResponse
import retrofit2.Response
import retrofit2.http.*

interface IPFSApi {
    /**
     * Add a file or directory to IPFS
     *
     * @return
     */
    @Multipart
    @POST("ipfs/add")
    fun add(
        @Header("project_id") projectId: String?,
        @Part file: Part?
    ): Response<IPFSObject?>?

    /**
     * Relay to an IPFS gateway
     * Retrieve an object from the IFPS gateway (useful if you do not want to rely on a public gateway, such as &#x60;ipfs.blockfrost.dev&#x60;).
     * @param ipFSPath  (required)
     * @return Call&lt;ResponseBody&gt;
     */
    @GET("ipfs/gateway/{IPFS_path}")
    operator fun get(
        @Header("project_id") projectId: String?,
        @Path("IPFS_path") ipFSPath: String?
    ): Response<ResponseBody?>?

    /**
     * Pin an object
     * Pinned objects are counted in your user storage quota.
     * @param ipFSPath  (required)
     * @return Call&lt;IPFSAddPinResponse&gt;
     */
    @POST("ipfs/pin/add/{IPFS_path}")
    fun pinAdd(
        @Header("project_id") projectId: String?,
        @Path("IPFS_path") ipFSPath: String?
    ): Response<PinResponse?>?

    /**
     *
     * List objects pinned to local storage
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return Call&lt;List&lt;PinItem&gt;&gt;
     */
    @GET("ipfs/pin/list/")
    fun pinList(
        @Header("project_id") projectId: String?,
        @Query("count") count: Int?, @Query("page") page: Int?, @Query("order") order: String?
    ): Response<List<PinItem?>?>?


    /**
     *
     * List objects pinned to local storage
     * @param ipFSPath  (required)
     * @return Call&lt;PinItem&gt;
     */
    @GET("ipfs/pin/list/{IPFS_path}")
    fun pinListByIpfsPath(
        @Header("project_id") projectId: String?,
        @Path("IPFS_path") ipFSPath: String?
    ): Response<PinItem?>?

    /**
     *
     * Remove pinned objects from local storage
     * @param ipFSPath  (required)
     * @return Call&lt;PinItem&gt;
     */
    @POST("ipfs/pin/remove/{IPFS_path}")
    fun pinRemove(
        @Header("project_id") projectId: String?,
        @Path("IPFS_path") ipFSPath: String?
    ): Response<PinItem?>?
}