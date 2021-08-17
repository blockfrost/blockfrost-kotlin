/**
* Blockfrost.io ~ API Documentation
* Blockfrost is an API as a service that allows users to interact with the Cardano blockchain and parts of its ecosystem.  ## Tokens  After signing up on https://blockfrost.io, a `project_id` token is automatically generated for each project. HTTP header of your request MUST include this `project_id` in order to authenticate against Blockfrost servers.  ## Available networks  At the moment, you can use the following networks. Please, note that each network has its own `project_id`.  <table>   <tr><td><b>Network</b></td><td><b>Endpoint</b></td></tr>   <tr><td>Cardano mainnet</td><td><tt>https://cardano-mainnet.blockfrost.io/api/v0</td></tt></tr>   <tr><td>Cardano testnet</td><td><tt>https://cardano-testnet.blockfrost.io/api/v0</tt></td></tr>   <tr><td>InterPlanetary File System</td><td><tt>https://ipfs.blockfrost.io/api/v0</tt></td></tr> </table>  ## Concepts  * All endpoints return either a JSON object or an array. * Data is returned in *ascending* (oldest first, newest last) order.   * You might use the `?order=desc` query parameter to reverse this order. * By default, we return 100 results at a time. You have to use `?page=2` to list through the results. * All time and timestamp related fields (except `server_time`) are in seconds of UNIX time. * All amounts are returned in Lovelaces, where 1 ADA = 1 000 000 Lovelaces. * Addresses, accounts and pool IDs are in Bech32 format. * All values are case sensitive. * All hex encoded values are lower case. * Examples are not based on real data. Any resemblance to actual events is purely coincidental. * We allow to upload files up to 100MB of size to IPFS. This might increase in the future.  ## Errors  ### HTTP Status codes  The following are HTTP status code your application might receive when reaching Blockfrost endpoints and it should handle all of these cases.  * HTTP `400` return code is used when the request is not valid. * HTTP `402` return code is used when the projects exceed their daily request limit. * HTTP `403` return code is used when the request is not authenticated. * HTTP `404` return code is used when the resource doesn't exist. * HTTP `418` return code is used when the user has been auto-banned for flooding too much after previously receiving error code `402` or `429`. * HTTP `429` return code is used when the user has sent too many requests in a given amount of time and therefore has been rate-limited. * HTTP `500` return code is used when our endpoints are having a problem.  ### Error codes  An internal error code number is used for better indication of the error in question. It is passed using the following payload.  ```json {   \"status_code\": 403,   \"error\": \"Forbidden\",   \"message\": \"Invalid project token.\" } ``` ## Limits   There are two types of limits we are enforcing:   The first depends on your plan and is the number of request we allow per day. We defined the day from midnight to midnight of UTC time.   The second is rate limiting. We limit an end user, distinguished by IP address, to 10 requests per second. On top of that, we allow  each user to send burst of 500 requests, which cools off at rate of 10 requests per second. In essence, a user is allowed to make another  whole burst after (currently) 500/10 = 50 seconds. E.g. if a user attemtps to make a call 3 seconds after whole burst, 30 requests will be processed.  We believe this should be sufficient for most of the use cases. If it is not and you have a specific use case, please get in touch with us, and  we will make sure to take it into account as much as we can.   ## SDKs  We support a number of SDKs that will help you in developing your application on top of Blockfrost.  <table>   <tr><td><b>Programming language</b></td><td><b>SDK</b></td></tr>   <tr><td>JavaScript</td><td><a href=\"https://github.com/blockfrost/blockfrost-js\">blockfrost-js</a></tr> </table> 
*
* The version of the OpenAPI document: 0.1.26
* Contact: contact@blockfrost.io
*
* NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
* https://openapi-generator.tech
* Do not edit the class manually.
*/
package org.openapitools.client.apis

import org.openapitools.client.models.InlineResponse400
import org.openapitools.client.models.InlineResponse403
import org.openapitools.client.models.InlineResponse404
import org.openapitools.client.models.InlineResponse418
import org.openapitools.client.models.InlineResponse429
import org.openapitools.client.models.InlineResponse500
import org.openapitools.client.models.TxContent
import org.openapitools.client.models.TxContentUtxo

import org.openapitools.client.infrastructure.ApiClient
import org.openapitools.client.infrastructure.ClientException
import org.openapitools.client.infrastructure.ClientError
import org.openapitools.client.infrastructure.ServerException
import org.openapitools.client.infrastructure.ServerError
import org.openapitools.client.infrastructure.MultiValueMap
import org.openapitools.client.infrastructure.RequestConfig
import org.openapitools.client.infrastructure.RequestMethod
import org.openapitools.client.infrastructure.ResponseType
import org.openapitools.client.infrastructure.Success
import org.openapitools.client.infrastructure.toMultiValue

class CardanoTransactionsApi(basePath: kotlin.String = defaultBasePath) : ApiClient(basePath) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty("org.openapitools.client.baseUrl", "https://cardano-mainnet.blockfrost.io/api/v0")
        }
    }

    /**
    * Submit a transaction
    * Submit an already serialized transaction to the network.
    * @param contentType  
    * @return kotlin.String
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun txSubmitPost(contentType: kotlin.String) : kotlin.String {
        val localVariableConfig = txSubmitPostRequestConfig(contentType = contentType)

        val localVarResponse = request<Unit, kotlin.String>(
            localVariableConfig
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.String
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
    * To obtain the request config of the operation txSubmitPost
    *
    * @param contentType  
    * @return RequestConfig
    */
    fun txSubmitPostRequestConfig(contentType: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        contentType.apply { localVariableHeaders["Content-Type"] = this.toString() }

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/tx/submit",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Transaction delegation certificates
    * Obtain information about delegation certificates of a specific transaction. 
    * @param hash Hash of the requested transaction. 
    * @return kotlin.collections.List<kotlin.Any>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun txsHashDelegationsGet(hash: kotlin.String) : kotlin.collections.List<kotlin.Any> {
        val localVariableConfig = txsHashDelegationsGetRequestConfig(hash = hash)

        val localVarResponse = request<Unit, kotlin.collections.List<kotlin.Any>>(
            localVariableConfig
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.collections.List<kotlin.Any>
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
    * To obtain the request config of the operation txsHashDelegationsGet
    *
    * @param hash Hash of the requested transaction. 
    * @return RequestConfig
    */
    fun txsHashDelegationsGetRequestConfig(hash: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/txs/{hash}/delegations".replace("{"+"hash"+"}", "$hash"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Specific transaction
    * Return content of the requested transaction.
    * @param hash Hash of the requested transaction 
    * @return TxContent
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun txsHashGet(hash: kotlin.String) : TxContent {
        val localVariableConfig = txsHashGetRequestConfig(hash = hash)

        val localVarResponse = request<Unit, TxContent>(
            localVariableConfig
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as TxContent
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
    * To obtain the request config of the operation txsHashGet
    *
    * @param hash Hash of the requested transaction 
    * @return RequestConfig
    */
    fun txsHashGetRequestConfig(hash: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/txs/{hash}".replace("{"+"hash"+"}", "$hash"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Transaction metadata in CBOR
    * Obtain the transaction metadata in CBOR.
    * @param hash Hash of the requested transaction 
    * @return kotlin.collections.List<kotlin.Any>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun txsHashMetadataCborGet(hash: kotlin.String) : kotlin.collections.List<kotlin.Any> {
        val localVariableConfig = txsHashMetadataCborGetRequestConfig(hash = hash)

        val localVarResponse = request<Unit, kotlin.collections.List<kotlin.Any>>(
            localVariableConfig
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.collections.List<kotlin.Any>
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
    * To obtain the request config of the operation txsHashMetadataCborGet
    *
    * @param hash Hash of the requested transaction 
    * @return RequestConfig
    */
    fun txsHashMetadataCborGetRequestConfig(hash: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/txs/{hash}/metadata/cbor".replace("{"+"hash"+"}", "$hash"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Transaction metadata
    * Obtain the transaction metadata.
    * @param hash Hash of the requested transaction 
    * @return kotlin.collections.List<kotlin.Any>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun txsHashMetadataGet(hash: kotlin.String) : kotlin.collections.List<kotlin.Any> {
        val localVariableConfig = txsHashMetadataGetRequestConfig(hash = hash)

        val localVarResponse = request<Unit, kotlin.collections.List<kotlin.Any>>(
            localVariableConfig
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.collections.List<kotlin.Any>
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
    * To obtain the request config of the operation txsHashMetadataGet
    *
    * @param hash Hash of the requested transaction 
    * @return RequestConfig
    */
    fun txsHashMetadataGetRequestConfig(hash: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/txs/{hash}/metadata".replace("{"+"hash"+"}", "$hash"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Transaction MIRs
    * Obtain information about Move Instantaneous Rewards (MIRs) of a specific transaction.
    * @param hash Hash of the requested transaction. 
    * @return kotlin.collections.List<kotlin.Any>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun txsHashMirsGet(hash: kotlin.String) : kotlin.collections.List<kotlin.Any> {
        val localVariableConfig = txsHashMirsGetRequestConfig(hash = hash)

        val localVarResponse = request<Unit, kotlin.collections.List<kotlin.Any>>(
            localVariableConfig
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.collections.List<kotlin.Any>
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
    * To obtain the request config of the operation txsHashMirsGet
    *
    * @param hash Hash of the requested transaction. 
    * @return RequestConfig
    */
    fun txsHashMirsGetRequestConfig(hash: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/txs/{hash}/mirs".replace("{"+"hash"+"}", "$hash"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Transaction stake pool retirement certificates
    * Obtain information about stake pool retirements within a specific transaction. 
    * @param hash Hash of the requested transaction 
    * @return kotlin.collections.List<kotlin.Any>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun txsHashPoolRetiresGet(hash: kotlin.String) : kotlin.collections.List<kotlin.Any> {
        val localVariableConfig = txsHashPoolRetiresGetRequestConfig(hash = hash)

        val localVarResponse = request<Unit, kotlin.collections.List<kotlin.Any>>(
            localVariableConfig
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.collections.List<kotlin.Any>
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
    * To obtain the request config of the operation txsHashPoolRetiresGet
    *
    * @param hash Hash of the requested transaction 
    * @return RequestConfig
    */
    fun txsHashPoolRetiresGetRequestConfig(hash: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/txs/{hash}/pool_retires".replace("{"+"hash"+"}", "$hash"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Transaction stake pool registration and update certificates
    * Obtain information about stake pool registration and update certificates of a specific transaction. 
    * @param hash Hash of the requested transaction 
    * @return kotlin.collections.List<kotlin.Any>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun txsHashPoolUpdatesGet(hash: kotlin.String) : kotlin.collections.List<kotlin.Any> {
        val localVariableConfig = txsHashPoolUpdatesGetRequestConfig(hash = hash)

        val localVarResponse = request<Unit, kotlin.collections.List<kotlin.Any>>(
            localVariableConfig
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.collections.List<kotlin.Any>
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
    * To obtain the request config of the operation txsHashPoolUpdatesGet
    *
    * @param hash Hash of the requested transaction 
    * @return RequestConfig
    */
    fun txsHashPoolUpdatesGetRequestConfig(hash: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/txs/{hash}/pool_updates".replace("{"+"hash"+"}", "$hash"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Transaction stake addresses certificates
    * Obtain information about (de)registration of stake addresses within a transaction. 
    * @param hash Hash of the requested transaction. 
    * @return kotlin.collections.List<kotlin.Any>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun txsHashStakesGet(hash: kotlin.String) : kotlin.collections.List<kotlin.Any> {
        val localVariableConfig = txsHashStakesGetRequestConfig(hash = hash)

        val localVarResponse = request<Unit, kotlin.collections.List<kotlin.Any>>(
            localVariableConfig
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.collections.List<kotlin.Any>
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
    * To obtain the request config of the operation txsHashStakesGet
    *
    * @param hash Hash of the requested transaction. 
    * @return RequestConfig
    */
    fun txsHashStakesGetRequestConfig(hash: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/txs/{hash}/stakes".replace("{"+"hash"+"}", "$hash"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Transaction UTXOs
    * Return the inputs and UTXOs of the specific transaction.
    * @param hash Hash of the requested transaction 
    * @return TxContentUtxo
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun txsHashUtxosGet(hash: kotlin.String) : TxContentUtxo {
        val localVariableConfig = txsHashUtxosGetRequestConfig(hash = hash)

        val localVarResponse = request<Unit, TxContentUtxo>(
            localVariableConfig
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as TxContentUtxo
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
    * To obtain the request config of the operation txsHashUtxosGet
    *
    * @param hash Hash of the requested transaction 
    * @return RequestConfig
    */
    fun txsHashUtxosGetRequestConfig(hash: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/txs/{hash}/utxos".replace("{"+"hash"+"}", "$hash"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Transaction withdrawal
    * Obtain information about withdrawals of a specific transaction.
    * @param hash Hash of the requested transaction. 
    * @return kotlin.collections.List<kotlin.Any>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun txsHashWithdrawalsGet(hash: kotlin.String) : kotlin.collections.List<kotlin.Any> {
        val localVariableConfig = txsHashWithdrawalsGetRequestConfig(hash = hash)

        val localVarResponse = request<Unit, kotlin.collections.List<kotlin.Any>>(
            localVariableConfig
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.collections.List<kotlin.Any>
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
    * To obtain the request config of the operation txsHashWithdrawalsGet
    *
    * @param hash Hash of the requested transaction. 
    * @return RequestConfig
    */
    fun txsHashWithdrawalsGetRequestConfig(hash: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/txs/{hash}/withdrawals".replace("{"+"hash"+"}", "$hash"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

}
