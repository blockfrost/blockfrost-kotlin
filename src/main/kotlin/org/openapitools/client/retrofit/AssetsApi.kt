package org.openapitools.client.retrofit

import org.openapitools.client.models.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface AssetsApi {
    /**
     * Asset addresses
     * List of a addresses containing a specific asset
     *
     * @param asset Concatenation of the policy_id and hex-encoded asset_name (required)
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page  The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return Call&lt;List&lt;Object&gt;&gt;
     */
    @GET("assets/{asset}/addresses")
    suspend fun assetsAssetAddressesGet(
        @Header("project_id") projectId: String?,
        @Path("asset") asset: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?,
        @Query("order") order: String?
    ): Response<List<AssetAddress?>?>?

    /**
     * Specific asset
     * Information about a specific asset
     *
     * @param asset Concatenation of the policy_id and hex-encoded asset_name (required)
     * @return Call&lt;Asset&gt;
     */
    @GET("assets/{asset}")
    suspend fun assetsAssetGet(
        @Header("project_id") projectId: String?,
        @Path("asset") asset: String?
    ): Response<Asset?>?

    /**
     * Asset history
     * History of a specific asset
     *
     * @param asset Concatenation of the policy_id and hex-encoded asset_name (required)
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page  The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return Call&lt;List&lt;Object&gt;&gt;
     */
    @GET("assets/{asset}/history")
    suspend fun assetsAssetHistoryGet(
        @Header("project_id") projectId: String?,
        @Path("asset") asset: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?,
        @Query("order") order: String?
    ): Response<List<AssetHistory?>?>?

    /**
     * Asset transactions
     * List of a specific asset transactions
     *
     * @param asset Concatenation of the policy_id and hex-encoded asset_name (required)
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page  The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return Call&lt;List&lt;Object&gt;&gt;
     */
    @GET("assets/{asset}/transactions")
    suspend fun assetsAssetTransactionsGet(
        @Header("project_id") projectId: String?,
        @Path("asset") asset: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?,
        @Query("order") order: String?
    ): Response<List<AssetTransaction?>?>?


    /**
     * Assets
     * List of assets.
     *
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page  The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return Call&lt;List&lt;Object&gt;&gt;
     */
    @GET("assets")
    suspend fun assetsGet(
        @Header("project_id") projectId: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?,
        @Query("order") order: String?
    ): Response<List<Asset?>?>?

    /**
     * Assets of a specific policy
     * List of asset minted under a specific policy
     *
     * @param policyId Specific policy_id (required)
     * @param count    The number of results displayed on one page. (optional, default to 100)
     * @param page     The page number for listing the results. (optional, default to 1)
     * @param order    The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return Call&lt;List&lt;PolicyAsset&gt;&gt;
     */
    @GET("assets/policy/{policy_id}")
    suspend fun assetsPolicyPolicyIdGet(
        @Header("project_id") projectId: String?,
        @Path("policy_id") policyId: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?,
        @Query("order") order: String?
    ): Response<List<PolicyAsset?>?>?
}