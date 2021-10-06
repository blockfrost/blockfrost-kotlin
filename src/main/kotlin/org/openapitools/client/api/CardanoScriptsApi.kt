/**
 * Blockfrost.io ~ API Documentation
 *
 * Blockfrost is an API as a service that allows users to interact with the Cardano blockchain and parts of its ecosystem.  ## Tokens  After signing up on https://blockfrost.io, a `project_id` token is automatically generated for each project. HTTP header of your request MUST include this `project_id` in order to authenticate against Blockfrost servers.  ## Available networks  At the moment, you can use the following networks. Please, note that each network has its own `project_id`.  <table>   <tr><td><b>Network</b></td><td><b>Endpoint</b></td></tr>   <tr><td>Cardano mainnet</td><td><tt>https://cardano-mainnet.blockfrost.io/api/v0</td></tt></tr>   <tr><td>Cardano testnet</td><td><tt>https://cardano-testnet.blockfrost.io/api/v0</tt></td></tr>   <tr><td>InterPlanetary File System</td><td><tt>https://ipfs.blockfrost.io/api/v0</tt></td></tr> </table>  ## Concepts  * All endpoints return either a JSON object or an array. * Data is returned in *ascending* (oldest first, newest last) order.   * You might use the `?order=desc` query parameter to reverse this order. * By default, we return 100 results at a time. You have to use `?page=2` to list through the results. * All time and timestamp related fields (except `server_time`) are in seconds of UNIX time. * All amounts are returned in Lovelaces, where 1 ADA = 1 000 000 Lovelaces. * Addresses, accounts and pool IDs are in Bech32 format. * All values are case sensitive. * All hex encoded values are lower case. * Examples are not based on real data. Any resemblance to actual events is purely coincidental. * We allow to upload files up to 100MB of size to IPFS. This might increase in the future.  ## Errors  ### HTTP Status codes  The following are HTTP status code your application might receive when reaching Blockfrost endpoints and it should handle all of these cases.  * HTTP `400` return code is used when the request is not valid. * HTTP `402` return code is used when the projects exceed their daily request limit. * HTTP `403` return code is used when the request is not authenticated. * HTTP `404` return code is used when the resource doesn't exist. * HTTP `418` return code is used when the user has been auto-banned for flooding too much after previously receiving error code `402` or `429`. * HTTP `429` return code is used when the user has sent too many requests in a given amount of time and therefore has been rate-limited. * HTTP `500` return code is used when our endpoints are having a problem.  ### Error codes  An internal error code number is used for better indication of the error in question. It is passed using the following payload.  ```json {   \"status_code\": 403,   \"error\": \"Forbidden\",   \"message\": \"Invalid project token.\" } ``` ## Limits   There are two types of limits we are enforcing:   The first depends on your plan and is the number of request we allow per day. We defined the day from midnight to midnight of UTC time.   The second is rate limiting. We limit an end user, distinguished by IP address, to 10 requests per second. On top of that, we allow  each user to send burst of 500 requests, which cools off at rate of 10 requests per second. In essence, a user is allowed to make another  whole burst after (currently) 500/10 = 50 seconds. E.g. if a user attemtps to make a call 3 seconds after whole burst, 30 requests will be processed.  We believe this should be sufficient for most of the use cases. If it is not and you have a specific use case, please get in touch with us, and  we will make sure to take it into account as much as we can.   ## SDKs  We support a number of SDKs that will help you in developing your application on top of Blockfrost.  <table>   <tr><td><b>Programming language</b></td><td><b>SDK</b></td></tr>   <tr><td>JavaScript</td><td><a href=\"https://github.com/blockfrost/blockfrost-js\">blockfrost-js</a></tr>   <tr><td>Haskell</td><td><a href=\"https://github.com/blockfrost/blockfrost-haskell\">blockfrost-haskell</a></tr> </table> 
 *
 * The version of the OpenAPI document: 0.1.27
 * Contact: contact@blockfrost.io
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package org.openapitools.client.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.withContext
import org.openapitools.client.infrastructure.*
import org.openapitools.client.models.Script
import org.openapitools.client.models.ScriptRedeemer
import org.openapitools.client.models.Scripts
import org.openapitools.client.retrofit.CardanoScriptsApi as CardanoScriptsApiRetrofit

open class CardanoScriptsApi(config: BlockfrostConfig = BlockfrostConfig.defaultConfig) : ApiClient(config) {
    val api by lazy {
        createService(CardanoScriptsApiRetrofit::class.java)
    }

    /**
     * Specific script
     * Information about a specific script
     * @param scriptHash Hash of the script
     * @return Script
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    open suspend fun getScript(
        scriptHash: kotlin.String
    ): Script? = withContext(Dispatchers.IO) {
        handleResponse(api.getScript(scriptHash = scriptHash))
    }

    /**
     * Redeemers of a specific script
     * List of redeemers of a specific script
     * @param scriptHash Hash of the script
     * @param count The number of results displayed on one page. (optional, default to null)
     * @param page The page number for listing the results. (optional, default to null)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to null)
     * @return kotlin.collections.List<ScriptRedeemer>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    open suspend fun getScriptRedeemers(
        scriptHash: kotlin.String, count: kotlin.Int? = null, page: kotlin.Int? = null, order: SortOrder? = null
    ): kotlin.collections.List<ScriptRedeemer> = withContext(Dispatchers.IO) {
        handleListResponse(
            api.getScriptRedeemers(
                scriptHash = scriptHash,
                count = count,
                page = page,
                order = order?.toString()
            )
        )
    }

    /**
     * Redeemers of a specific script. Fetches all paged records, returns a Flow.
     * List of redeemers of a specific script
     * parameter scriptHash: (path) Hash of the script
     * parameter order: (query) The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to null)
     * parameter batchSize: Number of concurrent requests for page download. If null, config.batchSize is used.
     * @return Flow<kotlin.collections.List<ScriptRedeemer>>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(
        UnsupportedOperationException::class,
        ClientException::class,
        ServerException::class,
        PageListerException::class
    )
    open suspend fun getScriptRedeemersAll(
        scriptHash: kotlin.String, order: SortOrder? = null,
        batchSize: Int? = null,
    ): Flow<ScriptRedeemer> {
        val pager = PageLister<ScriptRedeemer>(concurrentPages = batchSize ?: config.batchSize)
        return pager.load { count, page ->
            getScriptRedeemers(scriptHash = scriptHash, count = count, page = page, order = order)
        }
    }

    /**
     * Redeemers of a specific script. Fetches all paged records, returns as a list.
     * List of redeemers of a specific script
     * parameter scriptHash: (path) Hash of the script
     * parameter order: (query) The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to null)
     * parameter batchSize: Number of concurrent requests for page download. If null, config.batchSize is used.
     * @return List<kotlin.collections.List<ScriptRedeemer>>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(
        UnsupportedOperationException::class,
        ClientException::class,
        ServerException::class,
        PageListerException::class
    )
    open suspend fun getScriptRedeemersAllList(
        scriptHash: kotlin.String, order: SortOrder? = null,
        batchSize: Int? = null,
    ): List<ScriptRedeemer> {
        return getScriptRedeemersAll(scriptHash = scriptHash, order = order, batchSize = batchSize).toList()
    }

    /**
     * Scripts
     * List of scripts.
     * @param count The number of results displayed on one page. (optional, default to null)
     * @param page The page number for listing the results. (optional, default to null)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to null)
     * @return kotlin.collections.List<Scripts>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    open suspend fun getScripts(
        count: kotlin.Int? = null, page: kotlin.Int? = null, order: SortOrder? = null
    ): kotlin.collections.List<Scripts> = withContext(Dispatchers.IO) {
        handleListResponse(api.getScripts(count = count, page = page, order = order?.toString()))
    }

    /**
     * Scripts. Fetches all paged records, returns a Flow.
     * List of scripts.
     * parameter order: (query) The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to null)
     * parameter batchSize: Number of concurrent requests for page download. If null, config.batchSize is used.
     * @return Flow<kotlin.collections.List<Scripts>>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(
        UnsupportedOperationException::class,
        ClientException::class,
        ServerException::class,
        PageListerException::class
    )
    open suspend fun getScriptsAll(
        order: SortOrder? = null,
        batchSize: Int? = null,
    ): Flow<Scripts> {
        val pager = PageLister<Scripts>(concurrentPages = batchSize ?: config.batchSize)
        return pager.load { count, page ->
            getScripts(count = count, page = page, order = order)
        }
    }

    /**
     * Scripts. Fetches all paged records, returns as a list.
     * List of scripts.
     * parameter order: (query) The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to null)
     * parameter batchSize: Number of concurrent requests for page download. If null, config.batchSize is used.
     * @return List<kotlin.collections.List<Scripts>>
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Throws(
        UnsupportedOperationException::class,
        ClientException::class,
        ServerException::class,
        PageListerException::class
    )
    open suspend fun getScriptsAllList(
        order: SortOrder? = null,
        batchSize: Int? = null,
    ): List<Scripts> {
        return getScriptsAll(order = order, batchSize = batchSize).toList()
    }

}