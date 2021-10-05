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

package org.openapitools.client.models

import org.openapitools.client.models.TxContentOutputAmount

import com.squareup.moshi.Json

/**
 * 
 *
 * @param hash Transaction hash
 * @param block Block hash
 * @param blockHeight Block number
 * @param slot Slot number
 * @param index Transaction index within the block
 * @param outputAmount 
 * @param fees Fees of the transaction in Lovelaces
 * @param deposit Deposit within the transaction in Lovelaces
 * @param propertySize Size of the transaction in Bytes
 * @param invalidBefore Left (included) endpoint of the timelock validity intervals
 * @param invalidHereafter Right (excluded) endpoint of the timelock validity intervals
 * @param utxoCount Count of UTXOs within the transaction
 * @param withdrawalCount Count of the withdrawals within the transaction
 * @param mirCertCount Count of the MIR certificates within the transaction
 * @param delegationCount Count of the delegations within the transaction
 * @param stakeCertCount Count of the stake keys (de)registration and delegation certificates within the transaction
 * @param poolUpdateCount Count of the stake pool registration and update certificates within the transaction
 * @param poolRetireCount Count of the stake pool retirement certificates within the transaction
 * @param assetMintOrBurnCount Count of asset mints and burns within the transaction
 * @param redeemerCount Count of redeemers within the transaction
 */

data class TxContent (

    /* Transaction hash */
    @Json(name = "hash")
    var hash: kotlin.String,

    /* Block hash */
    @Json(name = "block")
    var block: kotlin.String,

    /* Block number */
    @Json(name = "block_height")
    var blockHeight: kotlin.Int,

    /* Slot number */
    @Json(name = "slot")
    var slot: kotlin.Int,

    /* Transaction index within the block */
    @Json(name = "index")
    var index: kotlin.Int,

    @Json(name = "output_amount")
    var outputAmount: kotlin.collections.List<TxContentOutputAmount>,

    /* Fees of the transaction in Lovelaces */
    @Json(name = "fees")
    var fees: kotlin.String,

    /* Deposit within the transaction in Lovelaces */
    @Json(name = "deposit")
    var deposit: kotlin.String,

    /* Size of the transaction in Bytes */
    @Json(name = "size")
    var propertySize: kotlin.Int,

    /* Left (included) endpoint of the timelock validity intervals */
    @Json(name = "invalid_before")
    var invalidBefore: kotlin.String?,

    /* Right (excluded) endpoint of the timelock validity intervals */
    @Json(name = "invalid_hereafter")
    var invalidHereafter: kotlin.String?,

    /* Count of UTXOs within the transaction */
    @Json(name = "utxo_count")
    var utxoCount: kotlin.Int,

    /* Count of the withdrawals within the transaction */
    @Json(name = "withdrawal_count")
    var withdrawalCount: kotlin.Int,

    /* Count of the MIR certificates within the transaction */
    @Json(name = "mir_cert_count")
    var mirCertCount: kotlin.Int,

    /* Count of the delegations within the transaction */
    @Json(name = "delegation_count")
    var delegationCount: kotlin.Int,

    /* Count of the stake keys (de)registration and delegation certificates within the transaction */
    @Json(name = "stake_cert_count")
    var stakeCertCount: kotlin.Int,

    /* Count of the stake pool registration and update certificates within the transaction */
    @Json(name = "pool_update_count")
    var poolUpdateCount: kotlin.Int,

    /* Count of the stake pool retirement certificates within the transaction */
    @Json(name = "pool_retire_count")
    var poolRetireCount: kotlin.Int,

    /* Count of asset mints and burns within the transaction */
    @Json(name = "asset_mint_or_burn_count")
    var assetMintOrBurnCount: kotlin.Int,

    /* Count of redeemers within the transaction */
    @Json(name = "redeemer_count")
    var redeemerCount: kotlin.Int

)

