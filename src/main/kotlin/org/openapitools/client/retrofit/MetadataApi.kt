package org.openapitools.client.retrofit

import org.openapitools.client.models.TransactionMetadataLabel
import org.openapitools.client.models.TransactionMetadataLabelCbor
import org.openapitools.client.models.TransactionMetadataLabelJson
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface MetadataApi {
    /**
     * Transaction metadata labels
     * List of all used transaction metadata labels.
     *
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page  The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return Call&lt;List&lt;Object&gt;&gt;
     */
    @GET("metadata/txs/labels")
    fun metadataTxsLabelsGet(
        @Header("project_id") projectId: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?,
        @Query("order") order: String?
    ): Response<List<TransactionMetadataLabel?>?>?

    /**
     * Transaction metadata content in CBOR
     * Transaction metadata per label.
     *
     * @param label Metadata label (required)
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page  The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return Call&lt;List&lt;Object&gt;&gt;
     */
    @GET("metadata/txs/labels/{label}/cbor")
    fun metadataTxsLabelsLabelCborGet(
        @Header("project_id") projectId: String?,
        @Path("label") label: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?,
        @Query("order") order: String?
    ): Response<List<TransactionMetadataLabelCbor?>?>?

    /**
     * Transaction metadata content in JSON
     * Transaction metadata per label.
     *
     * @param label Metadata label (required)
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page  The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return Call&lt;List&lt;Object&gt;&gt;
     */
    @GET("metadata/txs/labels/{label}")
    fun metadataTxsLabelsLabelGet(
        @Header("project_id") projectId: String?,
        @Path("label") label: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?,
        @Query("order") order: String?
    ): Response<List<TransactionMetadataLabelJson?>?>?
}