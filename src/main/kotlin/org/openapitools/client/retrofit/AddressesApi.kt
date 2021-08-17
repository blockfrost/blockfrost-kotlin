package org.openapitools.client.retrofit

import org.openapitools.client.models.TxContent
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface AddressesApi {
    /**
     * Address transactions
     * Transactions on the address.
     *
     * @param address Bech32 address. (required)
     * @param count   The numbers of pools per page. (optional, default to 100)
     * @param page    The page number for listing the results. (optional, default to 1)
     * @param order   The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @param from    The block number and optionally also index from which (inclusive) to start search for results, concatenated using colon. Has to be lower than or equal to &#x60;to&#x60; parameter.  (optional)
     * @param to      The block number and optionally also index where (inclusive) to end the search for results, concatenated using colon. Has to be higher than or equal to &#x60;from&#x60; parameter.  (optional)
     * @return Call&lt;List&lt;Object&gt;&gt;
     */
    @GET("addresses/{address}/transactions")
    suspend fun addressesAddressTransactionsGet(
        @Header("project_id") projectId: String?,
        @Path("address") address: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?,
        @Query("order") order: String?,
        @Query("from") from: String?,
        @Query("to") to: String?
    ): Response<List<TxContent?>?>
}