package io.blockfrost.sdk.kotlin.retrofit

import io.blockfrost.sdk.kotlin.models.TxMetadataLabel
import io.blockfrost.sdk.kotlin.models.TxMetadataLabelCbor
import io.blockfrost.sdk.kotlin.models.TxMetadataLabelJson
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CardanoMetadataApi {
    /**
     * Transaction metadata content in CBOR
     * Transaction metadata per label.
     * Responses:
     *  - 200: Return the account delegations content in CBOR
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param label Metadata label 
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<TxMetadataLabelCbor>]
     */
    @GET("metadata/txs/labels/{label}/cbor")
    suspend fun getTransactionMetadataCborForLabel(@Path("label") label: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<TxMetadataLabelCbor>>

    /**
     * Transaction metadata content in JSON
     * Transaction metadata per label.
     * Responses:
     *  - 200: Return the account delegations content
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param label Metadata label 
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<TxMetadataLabelJson>]
     */
    @GET("metadata/txs/labels/{label}")
    suspend fun getTransactionMetadataJsonForLabel(@Path("label") label: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<TxMetadataLabelJson>>

    /**
     * Transaction metadata labels
     * List of all used transaction metadata labels. 
     * Responses:
     *  - 200: Return the account delegations content
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
     * @return [kotlin.collections.List<TxMetadataLabel>]
     */
    @GET("metadata/txs/labels")
    suspend fun getTransactionMetadataLabels(@Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<TxMetadataLabel>>

}
