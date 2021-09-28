package org.openapitools.client.api

import org.openapitools.client.exception.APIException
import org.openapitools.client.models.*

interface TransactionService {
    /**
     * Specific transaction
     * Return content of the requested transaction.
     *
     * @param hash Hash of the requested transaction (required)
     * @return Transaction;
     */
    @Throws(APIException::class)
    fun getTransaction(hash: String?): Transaction?

    /**
     * Transaction UTXOs
     * Return the inputs and UTXOs of the specific transaction.
     *
     * @param hash Hash of the requested transaction (required)
     * @return TransactionUtxo;
     */
    @Throws(APIException::class)
    fun getTransactionUtxo(hash: String?): TransactionUtxo?

    /**
     * Transaction networkStake addresses certificates
     * Obtain information about (de)registration of networkStake addresses within a transaction.
     *
     * @param hash Hash of the requested transaction. (required)
     * @return List&lt;TransactionStake&gt;
     */
    @Throws(APIException::class)
    fun getTransactionStakes(hash: String?): List<TransactionStake?>?

    /**
     * Transaction delegation certificates
     * Obtain information about delegation certificates of a specific transaction.
     *
     * @param hash Hash of the requested transaction. (required)
     * @return List&lt;TransactionDelegation&gt;
     */
    @Throws(APIException::class)
    fun getTransactionDelegations(hash: String?): List<TransactionDelegation?>?

    /**
     * Transaction withdrawal
     * Obtain information about withdrawals of a specific transaction.
     *
     * @param hash Hash of the requested transaction. (required)
     * @return List&lt;TransactionWithdrawal&gt;
     */
    @Throws(APIException::class)
    fun getTransactionWithdrawals(hash: String?): List<TransactionWithdrawal?>?

    /**
     * Transaction MIRs
     * Obtain information about Move Instantaneous Rewards (MIRs) of a specific transaction.
     *
     * @param hash Hash of the requested transaction. (required)
     * @return List&lt;TransactionMir&gt;
     */
    @Throws(APIException::class)
    fun getTransactionMirs(hash: String?): List<TransactionMir?>?

    /**
     * Transaction networkStake pool registration and update certificates
     * Obtain information about networkStake pool registration and update certificates of a specific transaction.
     *
     * @param hash Hash of the requested transaction (required)
     * @return List&lt;TransactionPoolUpdate&gt;
     */
    @Throws(APIException::class)
    fun getTransactionPoolUpdates(hash: String?): List<TransactionPoolUpdate?>?

    /**
     * Transaction networkStake pool retirement certificates
     * Obtain information about networkStake pool retirements within a specific transaction.
     *
     * @param hash Hash of the requested transaction (required)
     * @return List&lt;TransactionPoolRetire&gt;
     */
    @Throws(APIException::class)
    fun getTransactionPoolRetires(hash: String?): List<TransactionPoolRetire?>?

    /**
     * Transaction metadata
     * Obtain the transaction metadata.
     *
     * @param hash Hash of the requested transaction (required)
     * @return List&lt;TransactionMetadataJson&gt;
     */
    @Throws(APIException::class)
    fun getTransactionMetadata(hash: String?): List<TransactionMetadataJson?>?

    /**
     * Transaction metadata in CBOR
     * Obtain the transaction metadata in CBOR.
     *
     * @param hash Hash of the requested transaction (required)
     * @return List&lt;TransactionMetadataCbor&gt;
     */
    @Throws(APIException::class)
    fun getTransactionMetadataCbor(hash: String?): List<TransactionMetadataCbor?>?

    /**
     * Submit a transaction
     * Submit an already serialized transaction to the network.
     *
     * @param serializedTransaction Serialized transaction in Cbor (required)
     * @return String
     */
    @Throws(APIException::class)
    fun submitTransaction(serializedTransaction: ByteArray?): String?
}