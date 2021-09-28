package org.openapitools.client.api

import org.openapitools.client.exception.APIException
import org.openapitools.client.infrastructure.PaginationSetting
import org.openapitools.client.infrastructure.SortOrder
import org.openapitools.client.models.Block

interface BlockService {
    /**
     * Latest block
     * Return the latest block available to the backends, also known as the tip of the blockchain.
     *
     * @return Block
     */
    @get:Throws(APIException::class)
    val latestBlock: Block?

    /**
     * Specific block
     * Return the content of a requested block.
     *
     * @param hashOrNumber Hash of the requested block. (required)
     * @return Block
     */
    @Throws(APIException::class)
    fun getBlock(hashOrNumber: String?): Block?

    /**
     * Specific block in a slot
     * Return the content of a requested block for a specific slot.
     *
     * @param slotNumber Slot position for requested block. (required)
     * @return Block
     */
    @Throws(APIException::class)
    fun getBlockInSlot(slotNumber: Int): Block?

    /**
     * Specific block in a slot in an epoch
     * Return the content of a requested block for a specific slot in an epoch
     *
     * @param epochNumber Epoch for specific epoch slot. (required)
     * @param slotNumber  Slot position for requested block. (required)
     * @return Block
     */
    @Throws(APIException::class)
    fun getBlockInEpochInSlot(epochNumber: Int, slotNumber: Int): Block?

    /**
     * Latest block transactions
     * Return the transactions within the latest block.
     *
     * @param count The number of results displayed on one page. (&lt;=100).
     * @param page  The page number for listing the results.
     * @param order Ordered by tx index in the block. The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last
     * @return List&lt;String&gt;
     */
    @Throws(APIException::class)
    fun getTransactionsInLatestBlock(paging: PaginationSetting? = null): List<String?>?

    /**
     * Latest block transactions
     * Return all the transactions within the latest block.
     *
     * @param order Ordered by tx index in the block. The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last
     * @return List&lt;String&gt;
     */
    @Throws(APIException::class)
    fun getAllTransactionsInLatestBlock(order: SortOrder? = null): List<String?>?

    /**
     * Listing of next blocks
     * Return the list of blocks following a specific block.
     *
     * @param hashOrNumber Hash of the requested block.
     * @param count        The number of results displayed on one page. (&lt;=100).
     * @param page         The page number for listing the results.
     * @return List&lt;Block&gt;
     */
    @Throws(APIException::class)
    fun getNextBlocks(hashOrNumber: String?, paging: PaginationSetting? = null): List<Block?>?

    /**
     * Listing of next blocks
     * Return the list of all blocks following a specific block.
     *
     * @param hashOrNumber Hash of the requested block.
     * @return List&lt;Block&gt;
     */
    @Throws(APIException::class)
    fun getAllNextBlocks(hashOrNumber: String?): List<Block?>?

    /**
     * Listing of previous blocks
     * Return the list of blocks following a specific block.
     *
     * @param hashOrNumber Hash of the requested block.
     * @param count        The number of results displayed on one page. (&lt;=100).
     * @param page         The page number for listing the results.
     * @return List&lt;Block&gt;
     */
    @Throws(APIException::class)
    fun getPreviousBlocks(hashOrNumber: String?, paging: PaginationSetting? = null): List<Block?>?

    /**
     * Listing of previous blocks
     * Return the list of all blocks following a specific block.
     *
     * @param hashOrNumber Hash of the requested block.
     * @return List&lt;Block&gt;
     */
    @Throws(APIException::class)
    fun getAllPreviousBlocks(hashOrNumber: String?): List<Block?>?
}