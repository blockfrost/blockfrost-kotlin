package org.openapitools.client.apis

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody

import org.openapitools.client.models.InlineResponse400
import org.openapitools.client.models.InlineResponse403
import org.openapitools.client.models.InlineResponse404
import org.openapitools.client.models.InlineResponse418
import org.openapitools.client.models.InlineResponse429
import org.openapitools.client.models.InlineResponse500
import org.openapitools.client.models.NutlinkAddress
import org.openapitools.client.models.NutlinkAddressTicker
import org.openapitools.client.models.NutlinkAddressTickers
import org.openapitools.client.models.NutlinkTickersTicker

interface NutLinkApi {
    /**
     * 
     * List metadata about specific address
     * Responses:
     *  - 200: Return the metadata about metadata oracle
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param address  
     * @return [NutlinkAddress]
     */
    @GET("nutlink/{address}")
    suspend fun getAddress(@Path("address") address: kotlin.String): Response<NutlinkAddress>

    /**
     * 
     * List tickers for a specific metadata oracle
     * Responses:
     *  - 200: Return the tickers provided by the metadata oracle
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param address  
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<NutlinkAddressTickers>]
     */
    @GET("nutlink/{address}/tickers")
    suspend fun getAddressTickers(@Path("address") address: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<NutlinkAddressTickers>>

    /**
     * 
     * List of records of a specific ticker
     * Responses:
     *  - 200: Return the tickers provided by the metadata oracle
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param address  
     * @param ticker  
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<NutlinkAddressTicker>]
     */
    @GET("nutlink/{address}/tickers/{ticker}")
    suspend fun getTickerRecordsByAddressAndTicker(@Path("address") address: kotlin.String, @Path("ticker") ticker: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<NutlinkAddressTicker>>

    /**
     * 
     * List of records of a specific ticker
     * Responses:
     *  - 200: Return the tickers provided by the metadata oracle
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param ticker  
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<NutlinkTickersTicker>]
     */
    @GET("nutlink/tickers/{ticker}")
    suspend fun getTickerRecordsByTicker(@Path("ticker") ticker: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<NutlinkTickersTicker>>

}
