package org.openapitools.client.retrofit

import org.openapitools.client.models.AddressContent
import org.openapitools.client.models.AddressContentTotal
import org.openapitools.client.models.AddressTransactionsContent
import org.openapitools.client.models.AddressUtxoContent
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CardanoAddressesApi {
    /**
     * Specific address
     * Obtain information about a specific address.
     * Responses:
     *  - 200: Return the address content.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param address Bech32 address. 
     * @return [AddressContent]
     */
    @GET("addresses/{address}")
    suspend fun getAddress(@Path("address") address: kotlin.String): Response<AddressContent>

    /**
     * Address details
     * Obtain details about an address.
     * Responses:
     *  - 200: Return the Address details.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param address Bech32 address. 
     * @return [AddressContentTotal]
     */
    @GET("addresses/{address}/total")
    suspend fun getAddressDetails(@Path("address") address: kotlin.String): Response<AddressContentTotal>

    /**
     * Address transactions
     * Transactions on the address.
     * Responses:
     *  - 200: Return the address content
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param address Bech32 address. 
     * @param count The numbers of pools per page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @param from The block number and optionally also index from which (inclusive) to start search for results, concatenated using colon. Has to be lower than or equal to &#x60;to&#x60; parameter.  (optional)
     * @param to The block number and optionally also index where (inclusive) to end the search for results, concatenated using colon. Has to be higher than or equal to &#x60;from&#x60; parameter.  (optional)
     * @return [kotlin.collections.List<AddressTransactionsContent>]
     */
    @GET("addresses/{address}/transactions")
    suspend fun getAddressTransactions(@Path("address") address: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null, @Query("from") from: kotlin.String? = null, @Query("to") to: kotlin.String? = null): Response<kotlin.collections.List<AddressTransactionsContent>>

    /**
     * Address transactions
     * Transactions on the address.
     * Responses:
     *  - 200: Return the address content
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param address Bech32 address. 
     * @param count The number of transactions per page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<kotlin.String>]
     */
    @Deprecated("This api was deprecated")
    @GET("addresses/{address}/txs")
    suspend fun getAddressTxs(@Path("address") address: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<kotlin.String>>

    /**
     * Address UTXOs
     * UTXOs of the address.
     * Responses:
     *  - 200: Return the address content
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param address Bech32 address. 
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order Ordered by tx index in the block. The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<AddressUtxoContent>]
     */
    @GET("addresses/{address}/utxos")
    suspend fun getAddressUtxos(@Path("address") address: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<AddressUtxoContent>>

}
