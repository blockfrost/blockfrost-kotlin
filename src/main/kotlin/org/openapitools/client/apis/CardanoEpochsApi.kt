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

import org.openapitools.client.models.EpochContent
import org.openapitools.client.models.EpochParamContent
import org.openapitools.client.models.InlineResponse400
import org.openapitools.client.models.InlineResponse403
import org.openapitools.client.models.InlineResponse404
import org.openapitools.client.models.InlineResponse418
import org.openapitools.client.models.InlineResponse429
import org.openapitools.client.models.InlineResponse500

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

class CardanoEpochsApi(basePath: kotlin.String = defaultBasePath) : ApiClient(basePath) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty("org.openapitools.client.baseUrl", "https://cardano-mainnet.blockfrost.io/api/v0")
        }
    }

    /**
    * Latest epoch
    * Return the information about the latest, therefore current, epoch.
    * @return EpochContent
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun epochsLatestGet() : EpochContent {
        val localVariableConfig = epochsLatestGetRequestConfig()

        val localVarResponse = request<Unit, EpochContent>(
            localVariableConfig
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as EpochContent
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
    * To obtain the request config of the operation epochsLatestGet
    *
    * @return RequestConfig
    */
    fun epochsLatestGetRequestConfig() : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/epochs/latest",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Latest epoch protocol parameters
    * Return the protocol parameters for the latest epoch.
    * @return EpochParamContent
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun epochsLatestParametersGet() : EpochParamContent {
        val localVariableConfig = epochsLatestParametersGetRequestConfig()

        val localVarResponse = request<Unit, EpochParamContent>(
            localVariableConfig
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as EpochParamContent
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
    * To obtain the request config of the operation epochsLatestParametersGet
    *
    * @return RequestConfig
    */
    fun epochsLatestParametersGetRequestConfig() : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/epochs/latest/parameters",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Block distribution
    * Return the blocks minted for the epoch specified.
    * @param number Number of the epoch 
    * @param count The number of results displayed on one page. (optional, default to 100)
    * @param page The page number for listing the results. (optional, default to 1)
    * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
    * @return kotlin.collections.List<kotlin.String>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun epochsNumberBlocksGet(number: kotlin.Int, count: kotlin.Int?, page: kotlin.Int?, order: kotlin.String?) : kotlin.collections.List<kotlin.String> {
        val localVariableConfig = epochsNumberBlocksGetRequestConfig(number = number, count = count, page = page, order = order)

        val localVarResponse = request<Unit, kotlin.collections.List<kotlin.String>>(
            localVariableConfig
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.collections.List<kotlin.String>
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
    * To obtain the request config of the operation epochsNumberBlocksGet
    *
    * @param number Number of the epoch 
    * @param count The number of results displayed on one page. (optional, default to 100)
    * @param page The page number for listing the results. (optional, default to 1)
    * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
    * @return RequestConfig
    */
    fun epochsNumberBlocksGetRequestConfig(number: kotlin.Int, count: kotlin.Int?, page: kotlin.Int?, order: kotlin.String?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (count != null) {
                    put("count", listOf(count.toString()))
                }
                if (page != null) {
                    put("page", listOf(page.toString()))
                }
                if (order != null) {
                    put("order", listOf(order.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/epochs/{number}/blocks".replace("{"+"number"+"}", "$number"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Block distribution
    * Return the block minted for the epoch specified by stake pool.
    * @param number Number of the epoch 
    * @param poolId Stake pool ID to filter 
    * @param count The number of results displayed on one page. (optional, default to 100)
    * @param page The page number for listing the results. (optional, default to 1)
    * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
    * @return kotlin.collections.List<kotlin.String>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun epochsNumberBlocksPoolIdGet(number: kotlin.Int, poolId: kotlin.String, count: kotlin.Int?, page: kotlin.Int?, order: kotlin.String?) : kotlin.collections.List<kotlin.String> {
        val localVariableConfig = epochsNumberBlocksPoolIdGetRequestConfig(number = number, poolId = poolId, count = count, page = page, order = order)

        val localVarResponse = request<Unit, kotlin.collections.List<kotlin.String>>(
            localVariableConfig
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.collections.List<kotlin.String>
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
    * To obtain the request config of the operation epochsNumberBlocksPoolIdGet
    *
    * @param number Number of the epoch 
    * @param poolId Stake pool ID to filter 
    * @param count The number of results displayed on one page. (optional, default to 100)
    * @param page The page number for listing the results. (optional, default to 1)
    * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
    * @return RequestConfig
    */
    fun epochsNumberBlocksPoolIdGetRequestConfig(number: kotlin.Int, poolId: kotlin.String, count: kotlin.Int?, page: kotlin.Int?, order: kotlin.String?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (count != null) {
                    put("count", listOf(count.toString()))
                }
                if (page != null) {
                    put("page", listOf(page.toString()))
                }
                if (order != null) {
                    put("order", listOf(order.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/epochs/{number}/blocks/{pool_id}".replace("{"+"number"+"}", "$number").replace("{"+"pool_id"+"}", "$poolId"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Specific epoch
    * Return the content of the requested epoch.
    * @param number Number of the epoch 
    * @return EpochContent
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun epochsNumberGet(number: kotlin.Int) : EpochContent {
        val localVariableConfig = epochsNumberGetRequestConfig(number = number)

        val localVarResponse = request<Unit, EpochContent>(
            localVariableConfig
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as EpochContent
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
    * To obtain the request config of the operation epochsNumberGet
    *
    * @param number Number of the epoch 
    * @return RequestConfig
    */
    fun epochsNumberGetRequestConfig(number: kotlin.Int) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/epochs/{number}".replace("{"+"number"+"}", "$number"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Listing of next epochs
    * Return the list of epochs following a specific epoch.
    * @param number Number of the requested epoch. 
    * @param count The number of results displayed on one page. (optional, default to 100)
    * @param page The page number for listing the results. (optional, default to 1)
    * @return kotlin.collections.List<EpochContent>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun epochsNumberNextGet(number: kotlin.Int, count: kotlin.Int?, page: kotlin.Int?) : kotlin.collections.List<EpochContent> {
        val localVariableConfig = epochsNumberNextGetRequestConfig(number = number, count = count, page = page)

        val localVarResponse = request<Unit, kotlin.collections.List<EpochContent>>(
            localVariableConfig
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.collections.List<EpochContent>
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
    * To obtain the request config of the operation epochsNumberNextGet
    *
    * @param number Number of the requested epoch. 
    * @param count The number of results displayed on one page. (optional, default to 100)
    * @param page The page number for listing the results. (optional, default to 1)
    * @return RequestConfig
    */
    fun epochsNumberNextGetRequestConfig(number: kotlin.Int, count: kotlin.Int?, page: kotlin.Int?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (count != null) {
                    put("count", listOf(count.toString()))
                }
                if (page != null) {
                    put("page", listOf(page.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/epochs/{number}/next".replace("{"+"number"+"}", "$number"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Protocol parameters
    * Return the protocol parameters for the epoch specified.
    * @param number Number of the epoch 
    * @return EpochParamContent
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun epochsNumberParametersGet(number: kotlin.Int) : EpochParamContent {
        val localVariableConfig = epochsNumberParametersGetRequestConfig(number = number)

        val localVarResponse = request<Unit, EpochParamContent>(
            localVariableConfig
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as EpochParamContent
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
    * To obtain the request config of the operation epochsNumberParametersGet
    *
    * @param number Number of the epoch 
    * @return RequestConfig
    */
    fun epochsNumberParametersGetRequestConfig(number: kotlin.Int) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/epochs/{number}/parameters".replace("{"+"number"+"}", "$number"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Listing of previous epochs
    * Return the list of epochs preceding a specific epoch.
    * @param number Number of the epoch 
    * @param count The number of results displayed on one page. (optional, default to 100)
    * @param page The page number for listing the results (optional, default to 1)
    * @return kotlin.collections.List<EpochContent>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun epochsNumberPreviousGet(number: kotlin.Int, count: kotlin.Int?, page: kotlin.Int?) : kotlin.collections.List<EpochContent> {
        val localVariableConfig = epochsNumberPreviousGetRequestConfig(number = number, count = count, page = page)

        val localVarResponse = request<Unit, kotlin.collections.List<EpochContent>>(
            localVariableConfig
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.collections.List<EpochContent>
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
    * To obtain the request config of the operation epochsNumberPreviousGet
    *
    * @param number Number of the epoch 
    * @param count The number of results displayed on one page. (optional, default to 100)
    * @param page The page number for listing the results (optional, default to 1)
    * @return RequestConfig
    */
    fun epochsNumberPreviousGetRequestConfig(number: kotlin.Int, count: kotlin.Int?, page: kotlin.Int?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (count != null) {
                    put("count", listOf(count.toString()))
                }
                if (page != null) {
                    put("page", listOf(page.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/epochs/{number}/previous".replace("{"+"number"+"}", "$number"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Stake distribution
    * Return the active stake distribution for the specified epoch.
    * @param number Number of the epoch 
    * @param count The number of results displayed on one page. (optional, default to 100)
    * @param page The page number for listing the results. (optional, default to 1)
    * @return kotlin.collections.List<kotlin.Any>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun epochsNumberStakesGet(number: kotlin.Int, count: kotlin.Int?, page: kotlin.Int?) : kotlin.collections.List<kotlin.Any> {
        val localVariableConfig = epochsNumberStakesGetRequestConfig(number = number, count = count, page = page)

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
    * To obtain the request config of the operation epochsNumberStakesGet
    *
    * @param number Number of the epoch 
    * @param count The number of results displayed on one page. (optional, default to 100)
    * @param page The page number for listing the results. (optional, default to 1)
    * @return RequestConfig
    */
    fun epochsNumberStakesGetRequestConfig(number: kotlin.Int, count: kotlin.Int?, page: kotlin.Int?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (count != null) {
                    put("count", listOf(count.toString()))
                }
                if (page != null) {
                    put("page", listOf(page.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/epochs/{number}/stakes".replace("{"+"number"+"}", "$number"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
    * Stake distribution by pool
    * Return the active stake distribution for the epoch specified by stake pool.
    * @param number Number of the epoch 
    * @param poolId Stake pool ID to filter 
    * @param count The number of results displayed on one page. (optional, default to 100)
    * @param page The page number for listing the results. (optional, default to 1)
    * @return kotlin.collections.List<kotlin.Any>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun epochsNumberStakesPoolIdGet(number: kotlin.Int, poolId: kotlin.String, count: kotlin.Int?, page: kotlin.Int?) : kotlin.collections.List<kotlin.Any> {
        val localVariableConfig = epochsNumberStakesPoolIdGetRequestConfig(number = number, poolId = poolId, count = count, page = page)

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
    * To obtain the request config of the operation epochsNumberStakesPoolIdGet
    *
    * @param number Number of the epoch 
    * @param poolId Stake pool ID to filter 
    * @param count The number of results displayed on one page. (optional, default to 100)
    * @param page The page number for listing the results. (optional, default to 1)
    * @return RequestConfig
    */
    fun epochsNumberStakesPoolIdGetRequestConfig(number: kotlin.Int, poolId: kotlin.String, count: kotlin.Int?, page: kotlin.Int?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (count != null) {
                    put("count", listOf(count.toString()))
                }
                if (page != null) {
                    put("page", listOf(page.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/epochs/{number}/stakes/{pool_id}".replace("{"+"number"+"}", "$number").replace("{"+"pool_id"+"}", "$poolId"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

}
