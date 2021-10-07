package io.blockfrost.sdk.kotlin.retrofit

import io.blockfrost.sdk.kotlin.models.*
import retrofit2.Response
import retrofit2.http.*

interface CardanoTransactionsApi {
    /**
     * Specific transaction
     * Return content of the requested transaction.
     * Responses:
     *  - 200: Return the contents of the transaction.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param hash Hash of the requested transaction 
     * @return [TxContent]
     */
    @GET("txs/{hash}")
    suspend fun getTransaction(@Path("hash") hash: kotlin.String): Response<TxContent>

    /**
     * Transaction delegation certificates
     * Obtain information about delegation certificates of a specific transaction. 
     * Responses:
     *  - 200: Obtain information about delegation certificates of a specific transaction
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param hash Hash of the requested transaction. 
     * @return [kotlin.collections.List<TxContentDelegation>]
     */
    @GET("txs/{hash}/delegations")
    suspend fun getTransactionDelegations(@Path("hash") hash: kotlin.String): Response<kotlin.collections.List<TxContentDelegation>>

    /**
     * Transaction metadata
     * Obtain the transaction metadata.
     * Responses:
     *  - 200: Obtain information about stake pool retirements within a specific transaction.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param hash Hash of the requested transaction 
     * @return [kotlin.collections.List<TxContentMetadata>]
     */
    @GET("txs/{hash}/metadata")
    suspend fun getTransactionMetadata(@Path("hash") hash: kotlin.String): Response<kotlin.collections.List<TxContentMetadata>>

    /**
     * Transaction metadata in CBOR
     * Obtain the transaction metadata in CBOR.
     * Responses:
     *  - 200: Obtain information about stake pool retirements within a specific transaction.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param hash Hash of the requested transaction 
     * @return [kotlin.collections.List<TxContentMetadataCbor>]
     */
    @GET("txs/{hash}/metadata/cbor")
    suspend fun getTransactionMetadataCbor(@Path("hash") hash: kotlin.String): Response<kotlin.collections.List<TxContentMetadataCbor>>

    /**
     * Transaction MIRs
     * Obtain information about Move Instantaneous Rewards (MIRs) of a specific transaction.
     * Responses:
     *  - 200: Obtain information about Move Instantaneous Rewards (MIRs) of a specific transaction.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param hash Hash of the requested transaction. 
     * @return [kotlin.collections.List<TxContentMir>]
     */
    @GET("txs/{hash}/mirs")
    suspend fun getTransactionMirs(@Path("hash") hash: kotlin.String): Response<kotlin.collections.List<TxContentMir>>

    /**
     * Transaction stake pool retirement certificates
     * Obtain information about stake pool retirements within a specific transaction. 
     * Responses:
     *  - 200: Obtain information about stake pool retirements within a specific transaction. 
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param hash Hash of the requested transaction 
     * @return [kotlin.collections.List<TxContentPoolRetire>]
     */
    @GET("txs/{hash}/pool_retires")
    suspend fun getTransactionPoolRetires(@Path("hash") hash: kotlin.String): Response<kotlin.collections.List<TxContentPoolRetire>>

    /**
     * Transaction stake pool registration and update certificates
     * Obtain information about stake pool registration and update certificates of a specific transaction. 
     * Responses:
     *  - 200: Obtain information about stake pool certificates of a specific transaction
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param hash Hash of the requested transaction 
     * @return [kotlin.collections.List<TxContentPoolCert>]
     */
    @GET("txs/{hash}/pool_updates")
    suspend fun getTransactionPoolUpdates(@Path("hash") hash: kotlin.String): Response<kotlin.collections.List<TxContentPoolCert>>

    /**
     * Transaction redeemers
     * Obtain the transaction redeemers.
     * Responses:
     *  - 200: Obtain information about redeemers within a specific transaction.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param hash Hash of the requested transaction 
     * @return [kotlin.collections.List<TxContentRedeemer>]
     */
    @GET("txs/{hash}/redeemers")
    suspend fun getTransactionRedeemers(@Path("hash") hash: kotlin.String): Response<kotlin.collections.List<TxContentRedeemer>>

    /**
     * Transaction stake addresses certificates
     * Obtain information about (de)registration of stake addresses within a transaction. 
     * Responses:
     *  - 200: Obtain information about (de)registration of stake addresses within a transaction. 
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param hash Hash of the requested transaction. 
     * @return [kotlin.collections.List<TxContentStakeAddr>]
     */
    @GET("txs/{hash}/stakes")
    suspend fun getTransactionStakes(@Path("hash") hash: kotlin.String): Response<kotlin.collections.List<TxContentStakeAddr>>

    /**
     * Transaction UTXOs
     * Return the inputs and UTXOs of the specific transaction.
     * Responses:
     *  - 200: Return the contents of the transaction.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param hash Hash of the requested transaction 
     * @return [TxContentUtxo]
     */
    @GET("txs/{hash}/utxos")
    suspend fun getTransactionUtxos(@Path("hash") hash: kotlin.String): Response<TxContentUtxo>

    /**
     * Transaction withdrawal
     * Obtain information about withdrawals of a specific transaction.
     * Responses:
     *  - 200: Obtain information about withdrawals of a specific transaction.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param hash Hash of the requested transaction. 
     * @return [kotlin.collections.List<TxContentWithdrawal>]
     */
    @GET("txs/{hash}/withdrawals")
    suspend fun getTransactionWithdrawals(@Path("hash") hash: kotlin.String): Response<kotlin.collections.List<TxContentWithdrawal>>

    /**
     * Submit a transaction
     * Submit an already serialized transaction to the network.
     * Responses:
     *  - 200: Return the ID of the submitted transaction.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param contentType  
     * @return [kotlin.String]
     */
    @POST("tx/submit")
    suspend fun submitTransaction(@Header("Content-Type") contentType: kotlin.String? = null, @Body data: ByteArray): Response<kotlin.String>

}
