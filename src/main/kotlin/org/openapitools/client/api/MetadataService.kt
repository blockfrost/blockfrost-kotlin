package org.openapitools.client.api

import org.openapitools.client.exception.APIException
import org.openapitools.client.infrastructure.PaginationSetting
import org.openapitools.client.infrastructure.SortOrder
import org.openapitools.client.models.TransactionMetadataLabel
import org.openapitools.client.models.TransactionMetadataLabelCbor
import org.openapitools.client.models.TransactionMetadataLabelJson

interface MetadataService {
    /**
     * Transaction metadata labels
     * List of all used transaction metadata labels.
     *
     * @param count The number of results displayed on one page.
     * @param page  The page number for listing the results.
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return List&lt;TransactionMetadataLabel&gt;
     */
    @Throws(APIException::class)
    fun getTransactionMetadataLabels(paging: PaginationSetting? = null): List<TransactionMetadataLabel?>?

    /**
     * Transaction metadata labels
     * List of all used transaction metadata labels.
     *
     * @param order The ordering of items from the point of view of the blockchain.
     * @return List&lt;TransactionMetadataLabel&gt;
     */
    @Throws(APIException::class)
    fun getAllTransactionMetadataLabels(order: SortOrder? = null): List<TransactionMetadataLabel?>?

    /**
     * Transaction metadata content in CBOR
     * Transaction metadata per label.
     *
     * @param label Metadata label (required)
     * @param count The number of results displayed on one page.
     * @param page  The page number for listing the results.
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return List&lt;TransactionMetadataLabelCbor&gt;
     */
    @Throws(APIException::class)
    fun getTransactionMetadataCborForLabel(
        label: String?,
        paging: PaginationSetting? = null
    ): List<TransactionMetadataLabelCbor?>?

    /**
     * Transaction metadata content in CBOR
     * Transaction metadata per label.
     *
     * @param label Metadata label (required)
     * @param order The ordering of items from the point of view of the blockchain.
     * @return List&lt;TransactionMetadataLabelCbor&gt;
     */
    @Throws(APIException::class)
    fun getAllTransactionMetadataCborForLabel(label: String?, order: SortOrder? = null): List<TransactionMetadataLabelCbor?>?

    /**
     * Transaction metadata content in JSON
     * Transaction metadata per label.
     *
     * @param label Metadata label (required)
     * @param count The number of results displayed on one page.
     * @param page  The page number for listing the results.
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return List&lt;TransactionMetadataLabelJson&gt;
     */
    @Throws(APIException::class)
    fun getTransactionMetadataJsonForLabel(
        label: String?,
        paging: PaginationSetting? = null
    ): List<TransactionMetadataLabelJson?>?

    /**
     * Transaction metadata content in JSON
     * Transaction metadata per label.
     *
     * @param label Metadata label (required)
     * @param order The ordering of items from the point of view of the blockchain.
     * @return List&lt;TransactionMetadataLabelJson&gt;
     */
    @Throws(APIException::class)
    fun getAllTransactionMetadataJsonForLabel(label: String?, order: SortOrder? = null): List<TransactionMetadataLabelJson?>?
}