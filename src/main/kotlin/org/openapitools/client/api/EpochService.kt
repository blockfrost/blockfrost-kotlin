package org.openapitools.client.api

import org.openapitools.client.exception.APIException
import org.openapitools.client.infrastructure.PaginationSetting
import org.openapitools.client.infrastructure.SortOrder
import org.openapitools.client.models.Epoch
import org.openapitools.client.models.EpochParam
import org.openapitools.client.models.Stake

interface EpochService {
    /**
     * Latest epoch
     * Return the information about the latest, therefore current, epoch.
     *
     * @return Epoch
     */
    @get:Throws(APIException::class)
    val latestEpoch: Epoch?

    /**
     * Latest epoch protocol parameters
     * Return the protocol parameters for the latest epoch.
     *
     * @return EpochParam
     */
    @get:Throws(APIException::class)
    val latestEpochParam: EpochParam?

    /**
     * Specific epoch
     * Return the content of the requested epoch.
     *
     * @param number Number of the epoch (required)
     * @return Epoch
     */
    @Throws(APIException::class)
    fun getEpoch(number: Int): Epoch?

    /**
     * Listing of next epochs
     * Return the list of epochs following a specific epoch.
     *
     * @param number Number of the requested epoch. (required)
     * @param count  The number of results displayed on one page. (&lt;=100)
     * @param page   The page number for listing the results.
     * @return List&lt;Epoch&gt;
     */
    @Throws(APIException::class)
    fun getNextEpochs(number: Int, paging: PaginationSetting? = null): List<Epoch?>?

    /**
     * Listing of next epochs
     * Return the list of all epochs following a specific epoch.
     *
     * @param number Number of the requested epoch. (required)
     * @return List&lt;Epoch&gt;
     */
    @Throws(APIException::class)
    fun getAllNextEpochs(number: Int): List<Epoch?>?

    /**
     * Listing of previous epochs
     * Return the list of epochs following a specific epoch.
     *
     * @param number Number of the requested epoch. (required)
     * @param count  The number of results displayed on one page. (&lt;=100)
     * @param page   The page number for listing the results.
     * @return List&lt;Epoch&gt;
     */
    @Throws(APIException::class)
    fun getPreviousEpochs(number: Int, paging: PaginationSetting? = null): List<Epoch?>?

    /**
     * Listing of previous epochs
     * Return the list of all epochs preceding a specific epoch.
     *
     * @param number Number of the requested epoch. (required)
     * @return List&lt;Epoch&gt;
     */
    @Throws(APIException::class)
    fun getAllPreviousEpochs(number: Int): List<Epoch?>?

    /**
     * Stake distribution
     * Return the active stakes for the epoch specified.
     *
     * @param number Number of the epoch (required)
     * @param count  The number of results displayed on one page. (&lt;=100)
     * @param page   The page number for listing the results.
     * @return List&lt;Stake&gt;
     */
    @Throws(APIException::class)
    fun getActiveStakesForEpoch(number: Int, paging: PaginationSetting? = null): List<Stake?>?

    /**
     * Stake distribution
     * Return all active stakes for the epoch specified.
     *
     * @param number Number of the epoch (required)
     * @return List&lt;Stake&gt;
     */
    @Throws(APIException::class)
    fun getAllActiveStakesForEpoch(number: Int): List<Stake?>?

    /**
     * Stake distribution
     * Return the active stakes for the epoch specified by networkStake pool.
     *
     * @param number Number of the epoch (required)
     * @param poolId
     * @param count  The number of results displayed on one page. (&lt;=100)
     * @param page   The page number for listing the results.
     * @return List&lt;Stake&gt;
     */
    @Throws(APIException::class)
    fun getActiveStakesForEpochAndPool(number: Int, poolId: String?, paging: PaginationSetting? = null): List<Stake?>?

    /**
     * Stake distribution
     * Return all the active stakes for the epoch specified by networkStake pool.
     *
     * @param number Number of the epoch (required)
     * @param poolId
     * @return List&lt;Stake&gt;
     */
    @Throws(APIException::class)
    fun getAllActiveStakesForEpochAndPool(number: Int, poolId: String?): List<Stake?>?

    /**
     * Protocol parameters
     * Return the protocol parameters for the epoch specified.
     *
     * @param number Number of the epoch (required)
     * @return EpochParam
     */
    @Throws(APIException::class)
    fun getEpochParam(number: Int): EpochParam?

    /**
     * Block distribution
     * Return the blocks minted for the epoch specified.
     *
     * @param number Number of the epoch (required)
     * @param count  The number of results displayed on one page. (&lt;=100)
     * @param page   The page number for listing the results.
     * @param order  The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.
     * @return List&lt;String&gt;
     */
    @Throws(APIException::class)
    fun getBlocksForEpoch(number: Int, paging: PaginationSetting? = null): List<String?>?

    /**
     * Block distribution
     * Return all the blocks minted for the epoch specified
     *
     * @param number Number of the epoch (required)
     * @param order  The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.
     * @return List&lt;String&gt;
     */
    //TODO Commented as it's not practical to get all the blocks in an epoch
    //    List<String> getBlocksForEpoch(int number, OrderEnum order) throws APIException;
    /**
     * Block distribution
     * Return the blocks minted for the epoch specified ordered ascending from the point of view of the blockchain, not the page listing itself.
     *
     * @param number Number of the epoch (required)
     * @return List&lt;String&gt;
     */
    //TODO Commented as it's not practical to get all the blocks in an epoch
    //List<String> getBlocksForEpoch(int number) throws APIException;
    /**
     * Block distribution
     * Return the blocks minted for the epoch specified by stake pool
     *
     * @param number Number of the epoch (required)
     * @param poolId NetworkStake pool ID to filter (required)
     * @param count  The number of results displayed on one page. (&lt;=100)
     * @param page   The page number for listing the results.
     * @param order  The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.
     * @return List&lt;String&gt;
     */
    @Throws(APIException::class)
    fun getBlocksForEpochAndPool(number: Int, poolId: String?, paging: PaginationSetting? = null): List<String?>?

    /**
     * Block distribution
     * Return all the blocks minted for the epoch specified by stake pool
     *
     * @param number Number of the epoch (required)
     * @param poolId NetworkStake pool ID to filter (required)
     * @param order  The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.
     * @return List&lt;String&gt;
     */
    @Throws(APIException::class)
    fun getAllBlocksForEpochAndPool(number: Int, poolId: String?, order: SortOrder? = null): List<String?>?
}