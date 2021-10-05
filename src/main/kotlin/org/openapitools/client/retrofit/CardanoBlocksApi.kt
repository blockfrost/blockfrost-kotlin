package org.openapitools.client.apis

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody

import org.openapitools.client.models.BlockContent
import org.openapitools.client.models.InlineResponse400
import org.openapitools.client.models.InlineResponse403
import org.openapitools.client.models.InlineResponse404
import org.openapitools.client.models.InlineResponse418
import org.openapitools.client.models.InlineResponse429
import org.openapitools.client.models.InlineResponse500

interface CardanoBlocksApi {
    /**
     * Specific block
     * Return the content of a requested block. 
     * Responses:
     *  - 200: Return the contents of the block
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param hashOrNumber Hash or number of the requested block. 
     * @return [BlockContent]
     */
    @GET("blocks/{hash_or_number}")
    suspend fun getBlock(@Path("hash_or_number") hashOrNumber: kotlin.String): Response<BlockContent>

    /**
     * Specific block in a slot in an epoch
     * Return the content of a requested block for a specific slot in an epoch. 
     * Responses:
     *  - 200: Return the contents of the block
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param epochNumber Epoch for specific epoch slot. 
     * @param slotNumber Slot position for requested block. 
     * @return [BlockContent]
     */
    @GET("blocks/epoch/{epoch_number}/slot/{slot_number}")
    suspend fun getBlockInEpochInSlot(@Path("epoch_number") epochNumber: kotlin.Int, @Path("slot_number") slotNumber: kotlin.Int): Response<BlockContent>

    /**
     * Specific block in a slot
     * Return the content of a requested block for a specific slot. 
     * Responses:
     *  - 200: Return the contents of the block
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param slotNumber Slot position for requested block. 
     * @return [BlockContent]
     */
    @GET("blocks/slot/{slot_number}")
    suspend fun getBlockInSlot(@Path("slot_number") slotNumber: kotlin.Int): Response<BlockContent>

    /**
     * Block transactions
     * Return the transactions within the block.
     * Responses:
     *  - 200: Return the transactions within the block.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param hashOrNumber Hash of the requested block. 
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order Ordered by tx index in the block. The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<kotlin.String>]
     */
    @GET("blocks/{hash_or_number}/txs")
    suspend fun getBlockTransactions(@Path("hash_or_number") hashOrNumber: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<kotlin.String>>

    /**
     * Latest block
     * Return the latest block available to the backends, also known as the tip of the blockchain. 
     * Responses:
     *  - 200: Return the contents of the latest block.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @return [BlockContent]
     */
    @GET("blocks/latest")
    suspend fun getLatestBlock(): Response<BlockContent>

    /**
     * Listing of next blocks
     * Return the list of blocks following a specific block. 
     * Responses:
     *  - 200: Return the contents of the block.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param hashOrNumber Hash of the requested block. 
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @return [kotlin.collections.List<BlockContent>]
     */
    @GET("blocks/{hash_or_number}/next")
    suspend fun getNextBlocks(@Path("hash_or_number") hashOrNumber: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null): Response<kotlin.collections.List<BlockContent>>

    /**
     * Listing of previous blocks
     * Return the list of blocks preceding a specific block. 
     * Responses:
     *  - 200: Return the contents of the block
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param hashOrNumber Hash of the requested block 
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @return [kotlin.collections.List<BlockContent>]
     */
    @GET("blocks/{hash_or_number}/previous")
    suspend fun getPreviousBlocks(@Path("hash_or_number") hashOrNumber: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null): Response<kotlin.collections.List<BlockContent>>

    /**
     * Latest block transactions
     * Return the transactions within the latest block.
     * Responses:
     *  - 200: Return the transactions within the block.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order Ordered by tx index in the block. The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<kotlin.String>]
     */
    @GET("blocks/latest/txs")
    suspend fun getTransactionsInLatestBlock(@Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<kotlin.String>>

}
