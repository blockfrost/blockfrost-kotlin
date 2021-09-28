package org.openapitools.client.retrofit

import org.openapitools.client.models.Epoch
import org.openapitools.client.models.EpochParam
import org.openapitools.client.models.Stake
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface EpochsApi {
    /**
     * Latest epoch
     * Return the information about the latest, therefore current, epoch.
     *
     * @return Call&lt;Epoch&gt;
     */
    @GET("epochs/latest")
    fun epochsLatestGet(
        @Header("project_id") projectId: String?
    ): Response<Epoch?>?


    /**
     * Latest epoch protocol parameters
     * Return the protocol parameters for the latest epoch.
     *
     * @return Call&lt;EpochParam&gt;
     */
    @GET("epochs/latest/parameters")
    fun epochsLatestParametersGet(
        @Header("project_id") projectId: String?
    ): Response<EpochParam?>?


    /**
     * Block distribution
     * Return the blocks minted for the epoch specified.
     *
     * @param number Number of the epoch (required)
     * @param count  The number of results displayed on one page. (optional, default to 100)
     * @param page   The page number for listing the results. (optional, default to 1)
     * @param order  The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return Call&lt;List&lt;String&gt;&gt;
     */
    @GET("epochs/{number}/blocks")
    fun epochsNumberBlocksGet(
        @Header("project_id") projectId: String?,
        @Path("number") number: Int?,
        @Query("count") count: Int?,
        @Query("page") page: Int?,
        @Query("order") order: String?
    ): Response<List<String?>?>?

    /**
     * Block distribution
     * Return the block minted for the epoch specified by networkStake pool.
     *
     * @param number Number of the epoch (required)
     * @param poolId NetworkStake pool ID to filter (required)
     * @param count  The number of results displayed on one page. (optional, default to 100)
     * @param page   The page number for listing the results. (optional, default to 1)
     * @param order  The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return Call&lt;List&lt;String&gt;&gt;
     */
    @GET("epochs/{number}/blocks/{pool_id}")
    fun epochsNumberBlocksPoolIdGet(
        @Header("project_id") projectId: String?,
        @Path("number") number: Int?,
        @Path("pool_id") poolId: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?,
        @Query("order") order: String?
    ): Response<List<String?>?>?

    /**
     * Specific epoch
     * Return the content of the requested epoch.
     *
     * @param number Number of the epoch (required)
     * @return Call&lt;Epoch&gt;
     */
    @GET("epochs/{number}")
    fun epochsNumberGet(
        @Header("project_id") projectId: String?,
        @Path("number") number: Int?
    ): Response<Epoch?>?

    /**
     * Listing of next epochs
     * Return the list of epochs following a specific epoch.
     *
     * @param number Number of the requested epoch. (required)
     * @param count  The number of results displayed on one page. (optional, default to 100)
     * @param page   The page number for listing the results. (optional, default to 1)
     * @return Call&lt;List&lt;Epoch&gt;&gt;
     */
    @GET("epochs/{number}/next")
    fun epochsNumberNextGet(
        @Header("project_id") projectId: String?,
        @Path("number") number: Int?,
        @Query("count") count: Int?,
        @Query("page") page: Int?
    ): Response<List<Epoch?>?>?

    /**
     * Protocol parameters
     * Return the protocol parameters for the epoch specified.
     *
     * @param number Number of the epoch (required)
     * @return Call&lt;EpochParam&gt;
     */
    @GET("epochs/{number}/parameters")
    fun epochsNumberParametersGet(
        @Header("project_id") projectId: String?,
        @Path("number") number: Int?
    ): Response<EpochParam?>?

    /**
     * Listing of previous epochs
     * Return the list of epochs preceding a specific epoch.
     *
     * @param number Number of the epoch (required)
     * @param count  The number of results displayed on one page. (optional, default to 100)
     * @param page   The page number for listing the results (optional, default to 1)
     * @return Call&lt;List&lt;Epoch&gt;&gt;
     */
    @GET("epochs/{number}/previous")
    fun epochsNumberPreviousGet(
        @Header("project_id") projectId: String?,
        @Path("number") number: Int?,
        @Query("count") count: Int?,
        @Query("page") page: Int?
    ): Response<List<Epoch?>?>?

    /**
     * NetworkStake distribution
     * Return the active networkStake distribution for the epoch specified.
     *
     * @param number Number of the epoch (required)
     * @param count  The number of results displayed on one page. (optional, default to 100)
     * @param page   The page number for listing the results. (optional, default to 1)
     * @return Call&lt;List&lt;Object&gt;&gt;
     */
    @GET("epochs/{number}/stakes")
    fun epochsNumberStakesGet(
        @Header("project_id") projectId: String?,
        @Path("number") number: Int?,
        @Query("count") count: Int?,
        @Query("page") page: Int?
    ): Response<List<Stake?>?>?

    /**
     * NetworkStake distribution by pool
     * Return the active networkStake distribution for the epoch specified by networkStake pool.
     *
     * @param number Number of the epoch (required)
     * @param poolId NetworkStake pool ID to filter (required)
     * @param count  The number of results displayed on one page. (optional, default to 100)
     * @param page   The page number for listing the results. (optional, default to 1)
     * @return Call&lt;List&lt;Object&gt;&gt;
     */
    @GET("epochs/{number}/stakes/{pool_id}")
    fun epochsNumberStakesPoolIdGet(
        @Header("project_id") projectId: String?,
        @Path("number") number: Int?,
        @Path("pool_id") poolId: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?
    ): Response<List<Stake?>?>?
}