package org.openapitools.client.api

import org.openapitools.client.exception.APIException
import org.openapitools.client.infrastructure.PaginationSetting
import org.openapitools.client.infrastructure.SortOrder
import org.openapitools.client.models.nutlink.NutLinkAddress
import org.openapitools.client.models.nutlink.Ticker
import org.openapitools.client.models.nutlink.TickerRecord

interface NutLinkService {
    /**
     * List metadata about specific address
     * @param address
     * @return NutLinkAddress
     * @throws APIException
     */
    @Throws(APIException::class)
    fun getNutLinkAddress(address: String?): NutLinkAddress?

    /**
     *
     * List tickers for a specific metadata oracle
     * @param address
     * @param count The number of results displayed on one page.
     * @param page The page number for listing the results.
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself.
     * @return List&lt;Ticker&gt;
     * @throws APIException
     */
    @Throws(APIException::class)
    fun getTickersByAddress(address: String?, paging: PaginationSetting? = null): List<Ticker?>?

    /**
     *
     * List all tickers for a specific metadata oracle
     * @param address
     * @param order
     * @return List&lt;Ticker&gt;
     * @throws APIException
     */
    @Throws(APIException::class)
    fun getAllTickersByAddress(address: String?, order: SortOrder? = null): List<Ticker?>?

    /**
     * List of records of a specific ticker
     * @param address
     * @param ticker
     * @param count The number of results displayed on one page.
     * @param page The page number for listing the results.
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.
     * @return
     */
    @Throws(APIException::class)
    fun getTickerRecordsByAddressAndTicker(
        address: String?,
        ticker: String?,
        paging: PaginationSetting? = null
    ): List<TickerRecord?>?

    /**
     * List of all records of a specific ticker
     * @param address
     * @param ticker
     * @param order
     * @return
     */
    @Throws(APIException::class)
    fun getAllTickerRecordsByAddressAndTicker(
        address: String?,
        ticker: String?,
        order: SortOrder? = null
    ): List<TickerRecord?>?

    /**
     * List of records of a specific ticker
     * @param ticker
     * @param count The number of results displayed on one page.
     * @param page The page number for listing the results.
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.
     * @return
     */
    @Throws(APIException::class)
    fun getTickerRecordsByTicker(ticker: String?, paging: PaginationSetting? = null): List<TickerRecord?>?

    /**
     * List of records of a specific ticker
     * @param ticker
     * @param order
     * @return
     */
    @Throws(APIException::class)
    fun getAllTickerRecordsByTicker(ticker: String?, order: SortOrder? = null): List<TickerRecord?>?
}