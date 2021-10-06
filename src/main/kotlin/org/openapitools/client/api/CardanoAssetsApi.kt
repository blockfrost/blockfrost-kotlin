/**
 * Blockfrost.io ~ API Documentation
 *
 * Blockfrost is an API as a service that allows users to interact with the Cardano blockchain and parts of its ecosystem.  ## Tokens  After signing up on https://blockfrost.io, a `project_id` token is automatically generated for each project. HTTP header of your request MUST include this `project_id` in order to authenticate against Blockfrost servers.  ## Available networks  At the moment, you can use the following networks. Please, note that each network has its own `project_id`.  <table>   <tr><td><b>Network</b></td><td><b>Endpoint</b></td></tr>   <tr><td>Cardano mainnet</td><td><tt>https://cardano-mainnet.blockfrost.io/api/v0</td></tt></tr>   <tr><td>Cardano testnet</td><td><tt>https://cardano-testnet.blockfrost.io/api/v0</tt></td></tr>   <tr><td>InterPlanetary File System</td><td><tt>https://ipfs.blockfrost.io/api/v0</tt></td></tr> </table>  ## Concepts  * All endpoints return either a JSON object or an array. * Data is returned in *ascending* (oldest first, newest last) order.   * You might use the `?order=desc` query parameter to reverse this order. * By default, we return 100 results at a time. You have to use `?page=2` to list through the results. * All time and timestamp related fields (except `server_time`) are in seconds of UNIX time. * All amounts are returned in Lovelaces, where 1 ADA = 1 000 000 Lovelaces. * Addresses, accounts and pool IDs are in Bech32 format. * All values are case sensitive. * All hex encoded values are lower case. * Examples are not based on real data. Any resemblance to actual events is purely coincidental. * We allow to upload files up to 100MB of size to IPFS. This might increase in the future.  ## Errors  ### HTTP Status codes  The following are HTTP status code your application might receive when reaching Blockfrost endpoints and it should handle all of these cases.  * HTTP `400` return code is used when the request is not valid. * HTTP `402` return code is used when the projects exceed their daily request limit. * HTTP `403` return code is used when the request is not authenticated. * HTTP `404` return code is used when the resource doesn't exist. * HTTP `418` return code is used when the user has been auto-banned for flooding too much after previously receiving error code `402` or `429`. * HTTP `429` return code is used when the user has sent too many requests in a given amount of time and therefore has been rate-limited. * HTTP `500` return code is used when our endpoints are having a problem.  ### Error codes  An internal error code number is used for better indication of the error in question. It is passed using the following payload.  ```json {   \"status_code\": 403,   \"error\": \"Forbidden\",   \"message\": \"Invalid project token.\" } ``` ## Limits   There are two types of limits we are enforcing:   The first depends on your plan and is the number of request we allow per day. We defined the day from midnight to midnight of UTC time.   The second is rate limiting. We limit an end user, distinguished by IP address, to 10 requests per second. On top of that, we allow  each user to send burst of 500 requests, which cools off at rate of 10 requests per second. In essence, a user is allowed to make another  whole burst after (currently) 500/10 = 50 seconds. E.g. if a user attemtps to make a call 3 seconds after whole burst, 30 requests will be processed.  We believe this should be sufficient for most of the use cases. If it is not and you have a specific use case, please get in touch with us, and  we will make sure to take it into account as much as we can.   ## SDKs  We support a number of SDKs that will help you in developing your application on top of Blockfrost.  <table>   <tr><td><b>Programming language</b></td><td><b>SDK</b></td></tr>   <tr><td>JavaScript</td><td><a href=\"https://github.com/blockfrost/blockfrost-js\">blockfrost-js</a></tr>   <tr><td>Haskell</td><td><a href=\"https://github.com/blockfrost/blockfrost-haskell\">blockfrost-haskell</a></tr> </table> 
 *
 * The version of the OpenAPI document: 0.1.27
 * Contact: contact@blockfrost.io
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package org.openapitools.client.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.withContext
import org.openapitools.client.infrastructure.*
import org.openapitools.client.models.*
import org.openapitools.client.retrofit.CardanoAssetsApi as CardanoAssetsApiRetrofit

open class CardanoAssetsApi(config: BlockfrostConfig = BlockfrostConfig.defaultConfig) : ApiClient(config) {
    val api by lazy {
        createService(CardanoAssetsApiRetrofit::class.java)
    }

    /**
     * Specific asset
     * Information about a specific asset
     * @param asset Concatenation of the policy_id and hex-encoded asset_name
     * @return Asset
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    open suspend fun getAsset(
        asset: kotlin.String
    ): Asset? = withContext(Dispatchers.IO) {
        handleResponse(api.getAsset(asset = asset))
    }


    /**
     * Asset addresses
     * List of a addresses containing a specific asset
     * @param asset Concatenation of the policy_id and hex-encoded asset_name
     * @param count The number of results displayed on one page. (optional, default to null)
     * @param page The page number for listing the results. (optional, default to null)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to null)
     * @return kotlin.collections.List<AssetAddress>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    open suspend fun getAssetAddresses(
        asset: kotlin.String, count: kotlin.Int? = null, page: kotlin.Int? = null, order: SortOrder? = null
    ): kotlin.collections.List<AssetAddress> = withContext(Dispatchers.IO) {
        handleListResponse(api.getAssetAddresses(asset = asset, count = count, page = page, order = order?.toString()))
    }

    /**
     * Asset addresses. Fetches all paged records, returns a Flow.
     * List of a addresses containing a specific asset
     * parameter asset: (path) Concatenation of the policy_id and hex-encoded asset_name
     * parameter order: (query) The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to null)
     * parameter batchSize: Number of concurrent requests for page download. If null, config.batchSize is used.
     * @return Flow<kotlin.collections.List<AssetAddress>>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    open suspend fun getAssetAddressesAll(
        asset: kotlin.String, order: SortOrder? = null,
        batchSize: Int? = null,
    ): Flow<AssetAddress> {
        val pager = PageLister<AssetAddress>(concurrentPages = batchSize ?: config.batchSize)
        return pager.load { count, page ->
            api.getAssetAddresses(asset = asset, count = count, page = page, order = order?.toString())
        }
    }

    /**
     * Asset addresses. Fetches all paged records, returns as a list.
     * List of a addresses containing a specific asset
     * parameter asset: (path) Concatenation of the policy_id and hex-encoded asset_name
     * parameter order: (query) The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to null)
     * parameter batchSize: Number of concurrent requests for page download. If null, config.batchSize is used.
     * @return List<kotlin.collections.List<AssetAddress>>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    open suspend fun getAssetAddressesAllList(
        asset: kotlin.String, order: SortOrder? = null,
        batchSize: Int? = null,
    ): List<AssetAddress> {
        return getAssetAddressesAll(asset = asset, order = order, batchSize = batchSize).toList()
    }

    /**
     * Asset history
     * History of a specific asset
     * @param asset Concatenation of the policy_id and hex-encoded asset_name
     * @param count The number of results displayed on one page. (optional, default to null)
     * @param page The page number for listing the results. (optional, default to null)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to null)
     * @return kotlin.collections.List<AssetHistory>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    open suspend fun getAssetHistory(
        asset: kotlin.String, count: kotlin.Int? = null, page: kotlin.Int? = null, order: SortOrder? = null
    ): kotlin.collections.List<AssetHistory> = withContext(Dispatchers.IO) {
        handleListResponse(api.getAssetHistory(asset = asset, count = count, page = page, order = order?.toString()))
    }

    /**
     * Asset history. Fetches all paged records, returns a Flow.
     * History of a specific asset
     * parameter asset: (path) Concatenation of the policy_id and hex-encoded asset_name
     * parameter order: (query) The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to null)
     * parameter batchSize: Number of concurrent requests for page download. If null, config.batchSize is used.
     * @return Flow<kotlin.collections.List<AssetHistory>>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    open suspend fun getAssetHistoryAll(
        asset: kotlin.String, order: SortOrder? = null,
        batchSize: Int? = null,
    ): Flow<AssetHistory> {
        val pager = PageLister<AssetHistory>(concurrentPages = batchSize ?: config.batchSize)
        return pager.load { count, page ->
            api.getAssetHistory(asset = asset, count = count, page = page, order = order?.toString())
        }
    }

    /**
     * Asset history. Fetches all paged records, returns as a list.
     * History of a specific asset
     * parameter asset: (path) Concatenation of the policy_id and hex-encoded asset_name
     * parameter order: (query) The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to null)
     * parameter batchSize: Number of concurrent requests for page download. If null, config.batchSize is used.
     * @return List<kotlin.collections.List<AssetHistory>>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    open suspend fun getAssetHistoryAllList(
        asset: kotlin.String, order: SortOrder? = null,
        batchSize: Int? = null,
    ): List<AssetHistory> {
        return getAssetHistoryAll(asset = asset, order = order, batchSize = batchSize).toList()
    }

    /**
     * Asset transactions
     * List of a specific asset transactions
     * @param asset Concatenation of the policy_id and hex-encoded asset_name
     * @param count The number of results displayed on one page. (optional, default to null)
     * @param page The page number for listing the results. (optional, default to null)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to null)
     * @return kotlin.collections.List<AssetTransaction>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    open suspend fun getAssetTransactions(
        asset: kotlin.String, count: kotlin.Int? = null, page: kotlin.Int? = null, order: SortOrder? = null
    ): kotlin.collections.List<AssetTransaction> = withContext(Dispatchers.IO) {
        handleListResponse(
            api.getAssetTransactions(
                asset = asset,
                count = count,
                page = page,
                order = order?.toString()
            )
        )
    }

    /**
     * Asset transactions. Fetches all paged records, returns a Flow.
     * List of a specific asset transactions
     * parameter asset: (path) Concatenation of the policy_id and hex-encoded asset_name
     * parameter order: (query) The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to null)
     * parameter batchSize: Number of concurrent requests for page download. If null, config.batchSize is used.
     * @return Flow<kotlin.collections.List<AssetTransaction>>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    open suspend fun getAssetTransactionsAll(
        asset: kotlin.String, order: SortOrder? = null,
        batchSize: Int? = null,
    ): Flow<AssetTransaction> {
        val pager = PageLister<AssetTransaction>(concurrentPages = batchSize ?: config.batchSize)
        return pager.load { count, page ->
            api.getAssetTransactions(asset = asset, count = count, page = page, order = order?.toString())
        }
    }

    /**
     * Asset transactions. Fetches all paged records, returns as a list.
     * List of a specific asset transactions
     * parameter asset: (path) Concatenation of the policy_id and hex-encoded asset_name
     * parameter order: (query) The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to null)
     * parameter batchSize: Number of concurrent requests for page download. If null, config.batchSize is used.
     * @return List<kotlin.collections.List<AssetTransaction>>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    open suspend fun getAssetTransactionsAllList(
        asset: kotlin.String, order: SortOrder? = null,
        batchSize: Int? = null,
    ): List<AssetTransaction> {
        return getAssetTransactionsAll(asset = asset, order = order, batchSize = batchSize).toList()
    }

    /**
     * Asset transactions
     * List of a specific asset transactions
     * @param asset Concatenation of the policy_id and hex-encoded asset_name
     * @param count The number of results displayed on one page. (optional, default to null)
     * @param page The page number for listing the results. (optional, default to null)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to null)
     * @return kotlin.collections.List<kotlin.String>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    @Deprecated(message = "This operation is deprecated.")
    open suspend fun getAssetTxs(
        asset: kotlin.String, count: kotlin.Int? = null, page: kotlin.Int? = null, order: SortOrder? = null
    ): kotlin.collections.List<kotlin.String> = withContext(Dispatchers.IO) {
        @Suppress("DEPRECATION")
        handleListResponse(api.getAssetTxs(asset = asset, count = count, page = page, order = order?.toString()))
    }

    /**
     * Asset transactions. Fetches all paged records, returns a Flow.
     * List of a specific asset transactions
     * parameter asset: (path) Concatenation of the policy_id and hex-encoded asset_name
     * parameter order: (query) The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to null)
     * parameter batchSize: Number of concurrent requests for page download. If null, config.batchSize is used.
     * @return Flow<kotlin.collections.List<kotlin.String>>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    open suspend fun getAssetTxsAll(
        asset: kotlin.String, order: SortOrder? = null,
        batchSize: Int? = null,
    ): Flow<kotlin.String> {
        val pager = PageLister<kotlin.String>(concurrentPages = batchSize ?: config.batchSize)
        return pager.load { count, page ->
            api.getAssetTxs(asset = asset, count = count, page = page, order = order?.toString())
        }
    }

    /**
     * Asset transactions. Fetches all paged records, returns as a list.
     * List of a specific asset transactions
     * parameter asset: (path) Concatenation of the policy_id and hex-encoded asset_name
     * parameter order: (query) The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to null)
     * parameter batchSize: Number of concurrent requests for page download. If null, config.batchSize is used.
     * @return List<kotlin.collections.List<kotlin.String>>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    open suspend fun getAssetTxsAllList(
        asset: kotlin.String, order: SortOrder? = null,
        batchSize: Int? = null,
    ): List<kotlin.String> {
        return getAssetTxsAll(asset = asset, order = order, batchSize = batchSize).toList()
    }

    /**
     * Assets
     * List of assets.
     * @param count The number of results displayed on one page. (optional, default to null)
     * @param page The page number for listing the results. (optional, default to null)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to null)
     * @return kotlin.collections.List<Assets>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    open suspend fun getAssets(
        count: kotlin.Int? = null, page: kotlin.Int? = null, order: SortOrder? = null
    ): kotlin.collections.List<Assets> = withContext(Dispatchers.IO) {
        handleListResponse(api.getAssets(count = count, page = page, order = order?.toString()))
    }

    /**
     * Assets. Fetches all paged records, returns a Flow.
     * List of assets.
     * parameter order: (query) The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to null)
     * parameter batchSize: Number of concurrent requests for page download. If null, config.batchSize is used.
     * @return Flow<kotlin.collections.List<Assets>>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    open suspend fun getAssetsAll(
        order: SortOrder? = null,
        batchSize: Int? = null,
    ): Flow<Assets> {
        val pager = PageLister<Assets>(concurrentPages = batchSize ?: config.batchSize)
        return pager.load { count, page ->
            api.getAssets(count = count, page = page, order = order?.toString())
        }
    }

    /**
     * Assets. Fetches all paged records, returns as a list.
     * List of assets.
     * parameter order: (query) The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to null)
     * parameter batchSize: Number of concurrent requests for page download. If null, config.batchSize is used.
     * @return List<kotlin.collections.List<Assets>>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    open suspend fun getAssetsAllList(
        order: SortOrder? = null,
        batchSize: Int? = null,
    ): List<Assets> {
        return getAssetsAll(order = order, batchSize = batchSize).toList()
    }

    /**
     * Assets of a specific policy
     * List of asset minted under a specific policy
     * @param policyId Specific policy_id
     * @param count The number of results displayed on one page. (optional, default to null)
     * @param page The page number for listing the results. (optional, default to null)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to null)
     * @return kotlin.collections.List<AssetPolicy>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    open suspend fun getPolicyAssets(
        policyId: kotlin.String, count: kotlin.Int? = null, page: kotlin.Int? = null, order: SortOrder? = null
    ): kotlin.collections.List<AssetPolicy> = withContext(Dispatchers.IO) {
        handleListResponse(
            api.getPolicyAssets(
                policyId = policyId,
                count = count,
                page = page,
                order = order?.toString()
            )
        )
    }

    /**
     * Assets of a specific policy. Fetches all paged records, returns a Flow.
     * List of asset minted under a specific policy
     * parameter policyId: (path) Specific policy_id
     * parameter order: (query) The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to null)
     * parameter batchSize: Number of concurrent requests for page download. If null, config.batchSize is used.
     * @return Flow<kotlin.collections.List<AssetPolicy>>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    open suspend fun getPolicyAssetsAll(
        policyId: kotlin.String, order: SortOrder? = null,
        batchSize: Int? = null,
    ): Flow<AssetPolicy> {
        val pager = PageLister<AssetPolicy>(concurrentPages = batchSize ?: config.batchSize)
        return pager.load { count, page ->
            api.getPolicyAssets(policyId = policyId, count = count, page = page, order = order?.toString())
        }
    }

    /**
     * Assets of a specific policy. Fetches all paged records, returns as a list.
     * List of asset minted under a specific policy
     * parameter policyId: (path) Specific policy_id
     * parameter order: (query) The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to null)
     * parameter batchSize: Number of concurrent requests for page download. If null, config.batchSize is used.
     * @return List<kotlin.collections.List<AssetPolicy>>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    open suspend fun getPolicyAssetsAllList(
        policyId: kotlin.String, order: SortOrder? = null,
        batchSize: Int? = null,
    ): List<AssetPolicy> {
        return getPolicyAssetsAll(policyId = policyId, order = order, batchSize = batchSize).toList()
    }

}
