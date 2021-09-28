package org.openapitools.client.api

import org.openapitools.client.exception.APIException
import org.openapitools.client.infrastructure.SortOrder
import org.openapitools.client.models.*

interface AssetService {
    /**
     * Specific asset
     * Information about a specific asset
     *
     * @param asset Concatenation of the policy_id and hex-encoded asset_name (required)
     * @return Asset
     */
    @Throws(APIException::class)
    fun getAsset(asset: String?): Asset?

    /**
     * Assets
     * List of assets.
     *
     * @param count The number of results displayed on one page. (&lt;=100).
     * @param page  The page number for listing the results.
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.
     * @return List&lt;Asset&gt;
     */
    @Throws(APIException::class)
    fun getAssets(count: Int, page: Int, order: SortOrder? = null): List<Asset?>?

    /**
     * Assets
     * List of assets ordered ascending from the point of view of the blockchain, not the page listing itself.
     *
     * @param count The number of results displayed on one page. (&lt;=100).
     * @param page  The page number for listing the results.
     * @return List&lt;Asset&gt;
     */
    @Throws(APIException::class)
    fun getAssets(count: Int, page: Int): List<Asset?>?

    /**
     * Asset history
     * History of a specific asset
     *
     * @param asset Concatenation of the policy_id and hex-encoded asset_name (required)
     * @param count The number of results displayed on one page. (&lt;=100).
     * @param page  The page number for listing the results.
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last
     * @return List&lt;AssetHistory&gt;
     */
    @Throws(APIException::class)
    fun getAssetHistory(asset: String?, count: Int, page: Int, order: SortOrder? = null): List<AssetHistory?>?

    /**
     * Asset history
     * History of a specific asset ordered ascending from the point of view of the blockchain, not the page listing itself.
     *
     * @param asset Concatenation of the policy_id and hex-encoded asset_name (required)
     * @param count The number of results displayed on one page. (&lt;=100).
     * @param page  The page number for listing the results.
     * @return List&lt;AssetHistory&gt;
     */
    @Throws(APIException::class)
    fun getAssetHistory(asset: String?, count: Int, page: Int): List<AssetHistory?>?

    /**
     * Asset history
     * Entire History of a specific asset
     *
     * @param asset Concatenation of the policy_id and hex-encoded asset_name (required)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last
     * @return List&lt;AssetHistory&gt;
     */
    @Throws(APIException::class)
    fun getEntireAssetHistory(asset: String?, order: SortOrder? = null): List<AssetHistory?>?

    /**
     * Asset history
     * Entire History of a specific asset ordered ascending from the point of view of the blockchain, not the page listing itself.
     *
     * @param asset Concatenation of the policy_id and hex-encoded asset_name (required)
     * @return List&lt;AssetHistory&gt;
     */
    @Throws(APIException::class)
    fun getEntireAssetHistory(asset: String?): List<AssetHistory?>?

    /**
     * Asset transactions
     * List of a specific asset transactions
     *
     * @param asset Concatenation of the policy_id and hex-encoded asset_name (required)
     * @param count The number of results displayed on one page. (&lt;=100).
     * @param page  The page number for listing the results.
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.
     * @return List&lt;AssetTransaction&gt;
     */
    @Throws(APIException::class)
    fun getAssetTransactions(asset: String?, count: Int, page: Int, order: SortOrder? = null): List<AssetTransaction?>?

    /**
     * Asset transactions
     * List of a specific asset transactions ordered ascending from the point of view of the blockchain, not the page listing itself.
     *
     * @param asset Concatenation of the policy_id and hex-encoded asset_name (required)
     * @param count The number of results displayed on one page. (&lt;=100).
     * @param page  The page number for listing the results.
     * @return List&lt;AssetTransaction&gt;
     */
    @Throws(APIException::class)
    fun getAssetTransactions(asset: String?, count: Int, page: Int): List<AssetTransaction?>?

    /**
     * Asset transactions
     * A list of all transactions for a specific asset
     *
     * @param asset Concatenation of the policy_id and hex-encoded asset_name (required)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.
     * @return List&lt;AssetTransaction&gt;
     */
    @Throws(APIException::class)
    fun getAllAssetTransactions(asset: String?, order: SortOrder? = null): List<AssetTransaction?>?

    /**
     * Asset transactions
     * A list of all transactions for a specific asset ordered ascending from the point of view of the blockchain, not the page listing itself.
     *
     * @param asset Concatenation of the policy_id and hex-encoded asset_name (required)
     * @return List&lt;AssetTransaction&gt;
     */
    @Throws(APIException::class)
    fun getAllAssetTransactions(asset: String?): List<AssetTransaction?>?

    /**
     * Asset addresses
     * List of addresses containing a specific asset
     *
     * @param asset Concatenation of the policy_id and hex-encoded asset_name (required)
     * @param count The number of results displayed on one page. (&lt;=100).
     * @param page  The page number for listing the results.
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last
     * @return List&lt;AssetAddress&gt;
     */
    @Throws(APIException::class)
    fun getAssetAddresses(asset: String?, count: Int, page: Int, order: SortOrder? = null): List<AssetAddress?>?

    /**
     * Asset addresses
     * List of addresses containing a specific asset ordered ascending from the point of view of the blockchain, not the page listing itself.
     *
     * @param asset Concatenation of the policy_id and hex-encoded asset_name (required)
     * @param count The number of results displayed on one page. (&lt;=100).
     * @param page  The page number for listing the results.
     * @return List&lt;AssetAddress&gt;
     */
    @Throws(APIException::class)
    fun getAssetAddresses(asset: String?, count: Int, page: Int): List<AssetAddress?>?

    /**
     * Asset addresses
     * List of addresses containing a specific asset
     *
     * @param asset Concatenation of the policy_id and hex-encoded asset_name (required)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last
     * @return List&lt;AssetAddress&gt;
     */
    @Throws(APIException::class)
    fun getAllAssetAddresses(asset: String?, order: SortOrder? = null): List<AssetAddress?>?

    /**
     * Asset addresses
     * List of addresses containing a specific asset ordered ascending from the point of view of the blockchain, not the page listing itself.
     *
     * @param asset Concatenation of the policy_id and hex-encoded asset_name (required)
     * @return List&lt;AssetAddress&gt;
     */
    @Throws(APIException::class)
    fun getAllAssetAddresses(asset: String?): List<AssetAddress?>?

    /**
     * Assets of a specific policy
     * List of asset minted under a specific policy
     *
     * @param policyId Specific policy_id (required)
     * @param count    The number of results displayed on one page. (&lt;=100).
     * @param page     The page number for listing the results.
     * @param order    The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.
     * @return List&lt;PolicyAsset&gt;&gt;
     */
    @Throws(APIException::class)
    fun getPolicyAssets(policyId: String?, count: Int, page: Int, order: SortOrder? = null): List<PolicyAsset?>?

    /**
     * Assets of a specific policy
     * List of asset minted under a specific policy ordered ascending from the point of view of the blockchain, not the page listing itself.
     *
     * @param policyId Specific policy_id (required)
     * @param count    The number of results displayed on one page. (&lt;=100).
     * @param page     The page number for listing the results.
     * @return List&lt;PolicyAsset&gt;&gt;
     */
    @Throws(APIException::class)
    fun getPolicyAssets(policyId: String?, count: Int, page: Int): List<PolicyAsset?>?

    /**
     * Assets of a specific policy
     * List of asset minted under a specific policy
     *
     * @param policyId Specific policy_id (required)
     * @param order    The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.
     * @return List&lt;PolicyAsset&gt;&gt;
     */
    @Throws(APIException::class)
    fun getAllPolicyAssets(policyId: String?, order: SortOrder? = null): List<PolicyAsset?>?

    /**
     * Assets of a specific policy
     * List of asset minted under a specific policy ordered ascending from the point of view of the blockchain, not the page listing itself.
     *
     * @param policyId Specific policy_id (required)
     * @return List&lt;PolicyAsset&gt;&gt;
     */
    @Throws(APIException::class)
    fun getAllPolicyAssets(policyId: String?): List<PolicyAsset?>?
}