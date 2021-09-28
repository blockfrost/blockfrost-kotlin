package org.openapitools.client.api

import org.openapitools.client.exception.APIException
import org.openapitools.client.infrastructure.PaginationSetting
import org.openapitools.client.infrastructure.SortOrder
import org.openapitools.client.models.*

interface PoolService {
    /**
     * List of networkStake pools
     * List of registered networkStake pools.
     *
     * @param count The numbers of pools per page.
     * @param page  The page number for listing the results.
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. We return oldest first, newest last.
     * @return Call&lt;List&lt;String&gt;&gt;
     */
    @Throws(APIException::class)
    fun getPools(paging: PaginationSetting? = null): List<String?>?

    /**
     * List of networkStake pools
     * List of all registered networkStake pools.
     *
     * @param order The ordering of items from the point of view of the blockchain.
     * @return List&lt;String&gt;
     */
    @Throws(APIException::class)
    fun getAllPools(order: SortOrder? = null): List<String?>?

    /**
     * List of retired pools
     * List of retired networkStake pools.
     *
     * @param count The numbers of pools per page.
     * @param page  The page number for listing the results.
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. We return oldest first, newest last.
     * @return Call&lt;List&lt;PoolRetirementInfo&gt;&gt;
     */
    @Throws(APIException::class)
    fun getRetiredPools(paging: PaginationSetting? = null): List<PoolRetirementInfo?>?

    /**
     * List of retired pools
     * List of all retired networkStake pools.
     *
     * @param order The ordering of items from the point of view of the blockchain.
     * @return List&lt;PoolRetirementInfo&gt;
     */
    @Throws(APIException::class)
    fun getAllRetiredPools(order: SortOrder? = null): List<PoolRetirementInfo?>?

    /**
     * List of retiring pools
     * List of retiring networkStake pools.
     *
     * @param count The numbers of pools per page.
     * @param page  The page number for listing the results.
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. We return oldest first, newest last.
     * @return Call&lt;List&lt;PoolRetirementInfo&gt;&gt;
     */
    @Throws(APIException::class)
    fun getRetiringPools(paging: PaginationSetting? = null): List<PoolRetirementInfo?>?

    /**
     * List of retiring pools
     * List of all retiring networkStake pools.
     *
     * @param order The ordering of items from the point of view of the blockchain.
     * @return List&lt;PoolRetirementInfo&gt;
     */
    @Throws(APIException::class)
    fun getAllRetiringPools(order: SortOrder? = null): List<PoolRetirementInfo?>?

    /**
     * Specific networkStake pool
     * Pool information.
     *
     * @param poolId Bech32 or hexadecimal pool ID. (required)
     * @return Pool
     */
    @Throws(APIException::class)
    fun getPool(poolId: String?): Pool?

    /**
     * NetworkStake pool history
     * History of networkStake pool parameters over epochs.
     *
     * @param poolId Bech32 or hexadecimal pool ID. (required)
     * @param count  The number of results displayed on one page.
     * @param page   The page number for listing the results.
     * @param order  The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return List&lt;PoolHistory&gt;
     */
    @Throws(APIException::class)
    fun getPoolHistory(poolId: String?, paging: PaginationSetting? = null): List<PoolHistory?>?

    /**
     * NetworkStake pool history
     * History of networkStake pool parameters over epochs.
     *
     * @param poolId Bech32 or hexadecimal pool ID. (required)
     * @param order  The ordering of items from the point of view of the blockchain.
     * @return List&lt;PoolHistory&gt;
     */
    @Throws(APIException::class)
    fun getEntirePoolHistory(poolId: String?, order: SortOrder? = null): List<PoolHistory?>?

    /**
     * NetworkStake pool metadata
     * NetworkStake pool registration metadata.
     *
     * @param poolId Bech32 or hexadecimal pool ID. (required)
     * @return PoolMetadata
     */
    @Throws(APIException::class)
    fun getPoolMetadata(poolId: String?): PoolMetadata?

    /**
     * NetworkStake pool relays
     * Relays of a networkStake pool.
     *
     * @param poolId Bech32 or hexadecimal pool ID. (required)
     * @return List&lt;Object&gt;
     */
    @Throws(APIException::class)
    fun getPoolRelays(poolId: String?): List<PoolRelay?>?

    /**
     * NetworkStake pool delegators
     * List of current networkStake pools delegators.
     *
     * @param poolId Bech32 or hexadecimal pool ID. (required)
     * @param count  The number of results displayed on one page.
     * @param page   The page number for listing the results.
     * @param order  The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return List&lt;PoolDelegator&gt;
     */
    @Throws(APIException::class)
    fun getPoolDelegators(poolId: String?, paging: PaginationSetting? = null): List<PoolDelegator?>?

    /**
     * List of networkStake pool delegators
     * List of networkStake pool delegators
     *
     * @param poolId Bech32 or hexadecimal pool ID. (required)
     * @param order  The ordering of items from the point of view of the blockchain.
     * @return List&lt;PoolDelegator&gt;
     */
    @Throws(APIException::class)
    fun getAllPoolDelegators(poolId: String?, order: SortOrder? = null): List<PoolDelegator?>?

    /**
     * NetworkStake pool blocks
     * List of networkStake pools blocks.
     *
     * @param poolId Bech32 or hexadecimal pool ID. (required)
     * @param count  The number of results displayed on one page.
     * @param page   The page number for listing the results.
     * @param order  The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return List&lt;String&gt;
     */
    @Throws(APIException::class)
    fun getPoolBlocks(poolId: String?, paging: PaginationSetting? = null): List<String?>?

    /**
     * NetworkStake pool blocks
     * List of networkStake pools blocks.
     *
     * @param poolId Bech32 or hexadecimal pool ID. (required)
     * @param order  The ordering of items from the point of view of the blockchain.
     * @return List&lt;String&gt;
     */
    @Throws(APIException::class)
    fun getAllPoolBlocks(poolId: String?, order: SortOrder? = null): List<String?>?

    /**
     * NetworkStake pool updates
     * List of certificate updates to the networkStake pool.
     *
     * @param poolId Bech32 or hexadecimal pool ID. (required)
     * @param count  The number of results displayed on one page. (optional, default to 100)
     * @param page   The page number for listing the results. (optional, default to 1)
     * @param order  The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return List&lt;PoolUpdate&gt;
     */
    @Throws(APIException::class)
    fun getPoolUpdates(poolId: String?, paging: PaginationSetting? = null): List<PoolUpdate?>?

    /**
     * NetworkStake pool updates
     * List of certificate updates to the networkStake pool.
     *
     * @param poolId Bech32 or hexadecimal pool ID. (required)
     * @param order  The ordering of items from the point of view of the blockchain.
     * @return List&lt;PoolUpdate&gt;
     */
    @Throws(APIException::class)
    fun getAllPoolUpdates(poolId: String?, order: SortOrder? = null): List<PoolUpdate?>?
}