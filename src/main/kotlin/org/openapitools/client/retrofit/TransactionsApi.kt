package org.openapitools.client.retrofit

import okhttp3.RequestBody
import org.openapitools.client.models.*
import retrofit2.Response
import retrofit2.http.*

interface TransactionsApi {
    /**
     * Submit a transaction
     * Submit an already serialized transaction to the network.
     *
     * @return Call&lt;String&gt;
     */
    @POST("tx/submit")
    fun txSubmitPost(
        @Header("project_id") projectId: String?,
        @Body signedTxn: RequestBody?
    ): Response<String?>?

    /**
     * Transaction delegation certificates
     * Obtain information about delegation certificates of a specific transaction.
     *
     * @param hash Hash of the requested transaction. (required)
     * @return Call&lt;List&lt;Object&gt;&gt;
     */
    @GET("txs/{hash}/delegations")
    fun txsHashDelegationsGet(
        @Header("project_id") projectId: String?,
        @Path("hash") hash: String?
    ): Response<List<TransactionDelegation?>?>?

    /**
     * Specific transaction
     * Return content of the requested transaction.
     *
     * @param hash Hash of the requested transaction (required)
     * @return Call&lt;TxContent&gt;
     */
    @GET("txs/{hash}")
    fun txsHashGet(
        @Header("project_id") projectId: String?,
        @Path("hash") hash: String?
    ): Response<Transaction?>?

    /**
     * Transaction metadata in CBOR
     * Obtain the transaction metadata in CBOR.
     *
     * @param hash Hash of the requested transaction (required)
     * @return Call&lt;List&lt;Object&gt;&gt;
     */
    @GET("txs/{hash}/metadata/cbor")
    fun txsHashMetadataCborGet(
        @Header("project_id") projectId: String?,
        @Path("hash") hash: String?
    ): Response<List<TransactionMetadataCbor?>?>?

    /**
     * Transaction metadata
     * Obtain the transaction metadata.
     *
     * @param hash Hash of the requested transaction (required)
     * @return Call&lt;List&lt;Object&gt;&gt;
     */
    @GET("txs/{hash}/metadata")
    fun txsHashMetadataGet(
        @Header("project_id") projectId: String?,
        @Path("hash") hash: String?
    ): Response<List<TransactionMetadataJson?>?>?

    /**
     * Transaction MIRs
     * Obtain information about Move Instantaneous Rewards (MIRs) of a specific transaction.
     *
     * @param hash Hash of the requested transaction. (required)
     * @return Call&lt;List&lt;Object&gt;&gt;
     */
    @GET("txs/{hash}/mirs")
    fun txsHashMirsGet(
        @Header("project_id") projectId: String?,
        @Path("hash") hash: String?
    ): Response<List<TransactionMir?>?>?

    /**
     * Transaction networkStake pool retirement certificates
     * Obtain information about networkStake pool retirements within a specific transaction.
     *
     * @param hash Hash of the requested transaction (required)
     * @return Call&lt;List&lt;Object&gt;&gt;
     */
    @GET("txs/{hash}/pool_retires")
    fun txsHashPoolRetiresGet(
        @Header("project_id") projectId: String?,
        @Path("hash") hash: String?
    ): Response<List<TransactionPoolRetire?>?>?

    /**
     * Transaction networkStake pool registration and update certificates
     * Obtain information about networkStake pool registration and update certificates of a specific transaction.
     *
     * @param hash Hash of the requested transaction (required)
     * @return Call&lt;List&lt;Object&gt;&gt;
     */
    @GET("txs/{hash}/pool_updates")
    fun txsHashPoolUpdatesGet(
        @Header("project_id") projectId: String?,
        @Path("hash") hash: String?
    ): Response<List<TransactionPoolUpdate?>?>?

    /**
     * Transaction networkStake addresses certificates
     * Obtain information about (de)registration of networkStake addresses within a transaction.
     *
     * @param hash Hash of the requested transaction. (required)
     * @return Call&lt;List&lt;Object&gt;&gt;
     */
    @GET("txs/{hash}/stakes")
    fun txsHashStakesGet(
        @Header("project_id") projectId: String?,
        @Path("hash") hash: String?
    ): Response<List<TransactionStake?>?>?

    /**
     * Transaction UTXOs
     * Return the inputs and UTXOs of the specific transaction.
     *
     * @param hash Hash of the requested transaction (required)
     * @return Call&lt;TxContentUtxo&gt;
     */
    @GET("txs/{hash}/utxos")
    fun txsHashUtxosGet(
        @Header("project_id") projectId: String?,
        @Path("hash") hash: String?
    ): Response<TransactionUtxo?>?

    /**
     * Transaction withdrawal
     * Obtain information about withdrawals of a specific transaction.
     *
     * @param hash Hash of the requested transaction. (required)
     * @return Call&lt;List&lt;Object&gt;&gt;
     */
    @GET("txs/{hash}/withdrawals")
    fun txsHashWithdrawalsGet(
        @Header("project_id") projectId: String?,
        @Path("hash") hash: String?
    ): Response<List<TransactionWithdrawal?>?>?
}