package org.openapitools.client.api

import org.openapitools.client.exception.APIException
import org.openapitools.client.infrastructure.PaginationSetting
import org.openapitools.client.infrastructure.SortOrder
import org.openapitools.client.models.Address
import org.openapitools.client.models.AddressTotal
import org.openapitools.client.models.AddressTransaction
import org.openapitools.client.models.AddressUtxo

interface AddressService {
    /**
     * Specific address
     * Obtain information about a specific address.
     *
     * @param address Bech32 address. (required)
     * @return Address
     */
    @Throws(APIException::class)
    fun getAddress(address: String?): Address?

    /**
     * Address total
     * Obtain details about an address.
     *
     * @param address Bech32 address. (required)
     * @return AddressTotal
     */
    @Throws(APIException::class)
    fun getAddressDetails(address: String?): AddressTotal?

    /**
     * Address UTXOs
     * UTXOs of the address.
     *
     * @param address Bech32 address. (required)
     * @param count   The number of results displayed on one page.
     * @param page    The page number for listing the results.
     * @param order   Ordered by tx index in the block. The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.
     * @return List&lt;AddressUtxo&gt;
     */
    @Throws(APIException::class)
    fun getAddressUtxos(address: String?, paging: PaginationSetting? = null): List<AddressUtxo?>?

    /**
     * Address UTXOs
     * All UTXOs of the address.
     *
     * @param address Bech32 address. (required)
     * @param order   Ordered by tx index in the block. The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.     *
     * @return List&lt;AddressUtxo&gt;
     */
    @Throws(APIException::class)
    fun getAllAddressUtxos(address: String?, order: SortOrder? = null): List<AddressUtxo?>?

    /**
     * Address UTXOs
     * All UTXOs of the address ascending ordered by tx index in the block.
     *
     * @param address Bech32 address. (required)
     * @return List&lt;AddressUtxo&gt;
     */
    @Throws(APIException::class)
    fun getAllAddressUtxos(address: String?): List<AddressUtxo?>?

    /**
     * Address transactions
     * Transactions on the address.
     *
     * @param address Bech32 address. (required)
     * @param count   The numbers of pools per page.
     * @param page    The page number for listing the results.
     * @param order   The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.
     * @return
     * @throws APIException
     */
    @Throws(APIException::class)
    fun getAddressTransactions(address: String?, paging: PaginationSetting? = null): List<AddressTransaction?>?

    /**
     * Address transactions
     * Transactions on the address.
     *
     * @param address Bech32 address. (required)
     * @param count   The numbers of pools per page.
     * @param page    The page number for listing the results.
     * @param order   The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.
     * @param from    The block number and optionally also index from which (inclusive) to start search for results, concatenated using colon. Has to be lower than or equal to &#x60;to&#x60; parameter.
     * @param to      The block number and optionally also index where (inclusive) to end the search for results, concatenated using colon. Has to be higher than or equal to &#x60;from&#x60; parameter.
     * @return List&lt;AddressTransaction&gt;
     */
    @Throws(APIException::class)
    fun getAddressTransactions(
        address: String?,
        paging: PaginationSetting?,
        from: String?,
        to: String?
    ): List<AddressTransaction?>?

    /**
     * Address transactions
     * Transactions on the address.
     *
     * @param address Bech32 address. (required)
     * @param order   The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.
     * @param from    The block number and optionally also index from which (inclusive) to start search for results, concatenated using colon. Has to be lower than or equal to &#x60;to&#x60; parameter.
     * @param to      The block number and optionally also index where (inclusive) to end the search for results, concatenated using colon. Has to be higher than or equal to &#x60;from&#x60; parameter.
     * @return List&lt;AddressTransaction&gt;
     */
    @Throws(APIException::class)
    fun getAddressTransactions(
        address: String?,
        order: SortOrder? = null,
        from: String?,
        to: String?
    ): List<AddressTransaction?>?

    /**
     * Address transactions
     * Transactions on the address in ascending order from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.
     *
     * @param address Bech32 address. (required)
     * @param from    The block number and optionally also index from which (inclusive) to start search for results, concatenated using colon. Has to be lower than or equal to &#x60;to&#x60; parameter.
     * @param to      The block number and optionally also index where (inclusive) to end the search for results, concatenated using colon. Has to be higher than or equal to &#x60;from&#x60; parameter.
     * @return List&lt;AddressTransaction&gt;
     */
    @Throws(APIException::class)
    fun getAddressTransactions(address: String?, from: String?, to: String?): List<AddressTransaction?>?
}