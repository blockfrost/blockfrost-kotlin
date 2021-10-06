package org.openapitools.client.retrofit

import org.openapitools.client.models.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CardanoAssetsApi {
    /**
     * Specific asset
     * Information about a specific asset
     * Responses:
     *  - 200: Return the information about a specific asset
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param asset Concatenation of the policy_id and hex-encoded asset_name 
     * @return [Asset]
     */
    @GET("assets/{asset}")
    suspend fun getAsset(@Path("asset") asset: kotlin.String): Response<Asset>

    /**
     * Asset addresses
     * List of a addresses containing a specific asset
     * Responses:
     *  - 200: Return the information about the history of a specific asset
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param asset Concatenation of the policy_id and hex-encoded asset_name 
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<AssetAddress>]
     */
    @GET("assets/{asset}/addresses")
    suspend fun getAssetAddresses(@Path("asset") asset: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<AssetAddress>>

    /**
     * Asset history
     * History of a specific asset
     * Responses:
     *  - 200: Return the information about the history of a specific asset
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param asset Concatenation of the policy_id and hex-encoded asset_name 
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<AssetHistory>]
     */
    @GET("assets/{asset}/history")
    suspend fun getAssetHistory(@Path("asset") asset: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<AssetHistory>>

    /**
     * Asset transactions
     * List of a specific asset transactions
     * Responses:
     *  - 200: Return the information about the history of a specific asset
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param asset Concatenation of the policy_id and hex-encoded asset_name 
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<AssetTransaction>]
     */
    @GET("assets/{asset}/transactions")
    suspend fun getAssetTransactions(@Path("asset") asset: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<AssetTransaction>>

    /**
     * Asset transactions
     * List of a specific asset transactions
     * Responses:
     *  - 200: Return the information about the history of a specific asset
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param asset Concatenation of the policy_id and hex-encoded asset_name 
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<kotlin.String>]
     */
    @Deprecated("This api was deprecated")
    @GET("assets/{asset}/txs")
    suspend fun getAssetTxs(@Path("asset") asset: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<kotlin.String>>

    /**
     * Assets
     * List of assets.
     * Responses:
     *  - 200: Return list of assets
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
     * @return [kotlin.collections.List<Assets>]
     */
    @GET("assets")
    suspend fun getAssets(@Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<Assets>>

    /**
     * Assets of a specific policy
     * List of asset minted under a specific policy
     * Responses:
     *  - 200: Return the information about a specific asset
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param policyId Specific policy_id 
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<AssetPolicy>]
     */
    @GET("assets/policy/{policy_id}")
    suspend fun getPolicyAssets(@Path("policy_id") policyId: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<AssetPolicy>>

}
