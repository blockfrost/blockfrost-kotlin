package org.openapitools.client.retrofit

import org.openapitools.client.models.Block
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface BlocksApi {
    /**
     * Specific block in a slot in an epoch
     * Return the content of a requested block for a specific slot in an epoch
     *
     * @param epochNumber Epoch for specific epoch slot. (required)
     * @param slotNumber  Slot position for requested block. (required)
     * @return Call&lt;Block&gt;
     */
    @GET("blocks/epoch/{epoch_number}/slot/{slot_number}")
    fun blocksEpochEpochNumberSlotSlotNumberGet(
        @Header("project_id") projectId: String?,
        @Path("epoch_number") epochNumber: Int?,
        @Path("slot_number") slotNumber: Int?
    ): Response<Block?>?

    /**
     * Specific block
     * Return the content of a requested block.
     *
     * @param hashOrNumber Hash of the requested block. (required)
     * @return Call&lt;Block&gt;
     */
    @GET("blocks/{hash_or_number}")
    fun blocksHashOrNumberGet(
        @Header("project_id") projectId: String?,
        @Path("hash_or_number") hashOrNumber: String?
    ): Response<Block?>?

    /**
     * Listing of next blocks
     * Return the list of blocks following a specific block.
     *
     * @param hashOrNumber Hash of the requested block. (required)
     * @param count        The number of results displayed on one page. (optional, default to 100)
     * @param page         The page number for listing the results. (optional, default to 1)
     * @return Call&lt;List&lt;Block&gt;&gt;
     */
    @GET("blocks/{hash_or_number}/next")
    suspend fun blocksHashOrNumberNextGet(
        @Header("project_id") projectId: String?,
        @Path("hash_or_number") hashOrNumber: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?
    ): Response<List<Block?>?>

    /**
     * Listing of previous blocks
     * Return the list of blocks preceding a specific block.
     *
     * @param hashOrNumber Hash of the requested block (required)
     * @param count        The number of results displayed on one page. (optional, default to 100)
     * @param page         The page number for listing the results. (optional, default to 1)
     * @return Call&lt;List&lt;Block&gt;&gt;
     */
    @GET("blocks/{hash_or_number}/previous")
    fun blocksHashOrNumberPreviousGet(
        @Header("project_id") projectId: String?,
        @Path("hash_or_number") hashOrNumber: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?
    ): Response<List<Block?>?>?

    /**
     * Block transactions
     * Return the transactions within the block.
     *
     * @param hashOrNumber Hash of the requested block. (required)
     * @param count        The number of results displayed on one page. (optional, default to 100)
     * @param page         The page number for listing the results. (optional, default to 1)
     * @param order        Ordered by tx index in the block. The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return Call&lt;List&lt;String&gt;&gt;
     */
    @GET("blocks/{hash_or_number}/txs")
    fun blocksHashOrNumberTxsGet(
        @Path("hash_or_number") hashOrNumber: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?,
        @Query("order") order: String?
    ): Response<List<String?>?>?

    /**
     * Latest block
     * Return the latest block available to the backends, also known as the tip of the blockchain.
     *
     * @return Call&lt;Block&gt;
     */
    @GET("blocks/latest")
    fun blocksLatestGet(@Header("project_id") projectId: String?): Response<Block?>?


    /**
     * Latest block transactions
     * Return the transactions within the latest block.
     *
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page  The page number for listing the results. (optional, default to 1)
     * @param order Ordered by tx index in the block. The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return Call&lt;List&lt;String&gt;&gt;
     */
    @GET("blocks/latest/txs")
    fun blocksLatestTxsGet(
        @Header("project_id") projectId: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?,
        @Query("order") order: String?
    ): Response<List<String?>?>?

    /**
     * Specific block in a slot
     * Return the content of a requested block for a specific slot.
     *
     * @param slotNumber Slot position for requested block. (required)
     * @return Call&lt;Block&gt;
     */
    @GET("blocks/slot/{slot_number}")
    fun blocksSlotSlotNumberGet(
        @Header("project_id") projectId: String?,
        @Path("slot_number") slotNumber: Int?
    ): Response<Block?>?
}