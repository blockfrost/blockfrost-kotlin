package org.openapitools.client.retrofit

import org.openapitools.client.models.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface PoolsApi {
    /**
     * List of networkStake pools
     * List of registered networkStake pools.
     *
     * @param count The numbers of pools per page. (optional, default to 100)
     * @param page  The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return Call&lt;List&lt;String&gt;&gt;
     */
    @GET("pools")
    fun poolsGet(
        @Header("project_id") projectId: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?,
        @Query("order") order: String?
    ): Response<List<String?>?>?

    /**
     * NetworkStake pool blocks
     * List of networkStake pools blocks.
     *
     * @param poolId Bech32 or hexadecimal pool ID. (required)
     * @param count  The number of results displayed on one page. (optional, default to 100)
     * @param page   The page number for listing the results. (optional, default to 1)
     * @param order  The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return Call&lt;List&lt;String&gt;&gt;
     */
    @GET("pools/{pool_id}/blocks")
    fun poolsPoolIdBlocksGet(
        @Header("project_id") projectId: String?,
        @Path("pool_id") poolId: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?,
        @Query("order") order: String?
    ): Response<List<String?>?>?

    /**
     * NetworkStake pool delegators
     * List of current networkStake pools delegators.
     *
     * @param poolId Bech32 or hexadecimal pool ID. (required)
     * @param count  The number of results displayed on one page. (optional, default to 100)
     * @param page   The page number for listing the results. (optional, default to 1)
     * @param order  The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return Call&lt;List&lt;Object&gt;&gt;
     */
    @GET("pools/{pool_id}/delegators")
    fun poolsPoolIdDelegatorsGet(
        @Header("project_id") projectId: String?,
        @Path("pool_id") poolId: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?,
        @Query("order") order: String?
    ): Response<List<PoolDelegator?>?>?

    /**
     * Specific networkStake pool
     * Pool information.
     *
     * @param poolId Bech32 or hexadecimal pool ID. (required)
     * @return Call&lt;Pool&gt;
     */
    @GET("pools/{pool_id}")
    fun poolsPoolIdGet(
        @Header("project_id") projectId: String?,
        @Path("pool_id") poolId: String?
    ): Response<Pool?>?

    /**
     * NetworkStake pool history
     * History of networkStake pool parameters over epochs.
     *
     * @param poolId Bech32 or hexadecimal pool ID. (required)
     * @param count  The number of results displayed on one page. (optional, default to 100)
     * @param page   The page number for listing the results (optional, default to 1)
     * @param order  The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return Call&lt;List&lt;PoolHistory&gt;&gt;
     */
    @GET("pools/{pool_id}/history")
    fun poolsPoolIdHistoryGet(
        @Header("project_id") projectId: String?,
        @Path("pool_id") poolId: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?,
        @Query("order") order: String?
    ): Response<List<PoolHistory?>?>?

    /**
     * NetworkStake pool metadata
     * NetworkStake pool registration metadata.
     *
     * @param poolId Bech32 or hexadecimal pool ID. (required)
     * @return Call&lt;PoolMetadata&gt;
     */
    @GET("pools/{pool_id}/metadata")
    fun poolsPoolIdMetadataGet(
        @Header("project_id") projectId: String?,
        @Path("pool_id") poolId: String?
    ): Response<PoolMetadata?>?

    /**
     * NetworkStake pool relays
     * Relays of a networkStake pool.
     *
     * @param poolId Bech32 or hexadecimal pool ID. (required)
     * @return Call&lt;List&lt;Object&gt;&gt;
     */
    @GET("pools/{pool_id}/relays")
    fun poolsPoolIdRelaysGet(
        @Header("project_id") projectId: String?,
        @Path("pool_id") poolId: String?
    ): Response<List<PoolRelay?>?>?

    /**
     * NetworkStake pool updates
     * List of certificate updates to the networkStake pool.
     *
     * @param poolId Bech32 or hexadecimal pool ID. (required)
     * @param count  The number of results displayed on one page. (optional, default to 100)
     * @param page   The page number for listing the results. (optional, default to 1)
     * @param order  The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return Call&lt;List&lt;Object&gt;&gt;
     */
    @GET("pools/{pool_id}/updates")
    fun poolsPoolIdUpdatesGet(
        @Header("project_id") projectId: String?,
        @Path("pool_id") poolId: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?,
        @Query("order") order: String?
    ): Response<List<PoolUpdate?>?>?

    /**
     * List of retired networkStake pools
     * List of already retired pools.
     *
     * @param count The numbers of pools per page. (optional, default to 100)
     * @param page  The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return Call&lt;List&lt;Object&gt;&gt;
     */
    @GET("pools/retired")
    fun poolsRetiredGet(
        @Header("project_id") projectId: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?,
        @Query("order") order: String?
    ): Response<List<PoolRetirementInfo?>?>?

    /**
     * List of retiring networkStake pools
     * List of networkStake pools retiring in the upcoming epochs
     *
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page  The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return Call&lt;List&lt;Object&gt;&gt;
     */
    @GET("pools/retiring")
    fun poolsRetiringGet(
        @Header("project_id") projectId: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?,
        @Query("order") order: String?
    ): Response<List<PoolRetirementInfo?>?>?
}