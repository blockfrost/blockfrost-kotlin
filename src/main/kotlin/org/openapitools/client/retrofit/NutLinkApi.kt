package org.openapitools.client.retrofit

import org.openapitools.client.models.nutlink.NutLinkAddress
import org.openapitools.client.models.nutlink.Ticker
import org.openapitools.client.models.nutlink.TickerRecord
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface NutLinkApi {
    /**
     *
     * List metadata about specific address
     * @param address  (required)
     * @return Call&lt;[NutLinkAddress]&gt;
     */
    @GET("nutlink/{address}")
    fun addressGet(
        @Header("project_id") projectId: String?,
        @Path("address") address: String?
    ): Response<NutLinkAddress?>?

    /**
     *
     * List tickers for a specific metadata oracle
     * @param address  (required)
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return Call&lt;List&lt;Object&gt;&gt;
     */
    @GET("nutlink/{address}/tickers")
    fun addressTickersGet(
        @Header("project_id") projectId: String?,
        @Path("address") address: String?, @Query("count") count: Int?, @Query("page") page: Int?,
        @Query("order") order: String?
    ): Response<List<Ticker?>?>?


    /**
     *
     * List of records of a specific ticker
     * @param address  (required)
     * @param ticker  (required)
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return Call&lt;List&lt;Object&gt;&gt;
     */
    @GET("nutlink/{address}/tickers/{ticker}")
    fun addressTickerRecords(
        @Header("project_id") projectId: String?,
        @Path("address") address: String?, @Path("ticker") ticker: String?, @Query("count") count: Int?,
        @Query("page") page: Int?, @Query("order") order: String?
    ): Response<List<TickerRecord?>?>?

    /**
     *
     * List of records of a specific ticker
     * @param ticker  (required)
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return Call&lt;List&lt;Object&gt;&gt;
     */
    @GET("nutlink/tickers/{ticker}")
    fun tickerRecords(
        @Header("project_id") projectId: String?,
        @Path("ticker") ticker: String?, @Query("count") count: Int?, @Query("page") page: Int?,
        @Query("order") order: String?
    ): Response<List<TickerRecord?>?>?
}