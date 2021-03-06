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

package io.blockfrost.sdk_kotlin.models


import com.squareup.moshi.Json

/**
 * 
 *
 * @param epoch Epoch number
 * @param minFeeA The linear factor for the minimum fee calculation for given epoch
 * @param minFeeB The constant factor for the minimum fee calculation
 * @param maxBlockSize Maximum block body size in Bytes
 * @param maxTxSize Maximum transaction size
 * @param maxBlockHeaderSize Maximum block header size
 * @param keyDeposit The amount of a key registration deposit in Lovelaces
 * @param poolDeposit The amount of a pool registration deposit in Lovelaces
 * @param eMax Epoch bound on pool retirement
 * @param nOpt Desired number of pools
 * @param a0 Pool pledge influence
 * @param rho Monetary expansion
 * @param tau Treasury expansion
 * @param decentralisationParam Percentage of blocks produced by federated nodes
 * @param extraEntropy Seed for extra entropy
 * @param protocolMajorVer Accepted protocol major version
 * @param protocolMinorVer Accepted protocol minor version
 * @param minUtxo Minimum UTXO value
 * @param minPoolCost Minimum stake cost forced on the pool
 * @param nonce Epoch number only used once
 * @param priceMem The per word cost of script memory usage
 * @param priceStep The cost of script execution step usage
 * @param maxTxExMem The maximum number of execution memory allowed to be used in a single transaction
 * @param maxTxExSteps The maximum number of execution steps allowed to be used in a single transaction
 * @param maxBlockExMem The maximum number of execution memory allowed to be used in a single block
 * @param maxBlockExSteps The maximum number of execution steps allowed to be used in a single block
 * @param maxValSize The maximum Val size
 * @param collateralPercent The percentage of the transactions fee which must be provided as collateral when including non-native scripts
 * @param maxCollateralInputs The maximum number of collateral inputs allowed in a transaction
 * @param coinsPerUtxoWord The cost per UTxO word
 */

data class EpochParamContent (

    /* Epoch number */
    @Json(name = "epoch")
    var epoch: kotlin.Int,

    /* The linear factor for the minimum fee calculation for given epoch */
    @Json(name = "min_fee_a")
    var minFeeA: kotlin.Int,

    /* The constant factor for the minimum fee calculation */
    @Json(name = "min_fee_b")
    var minFeeB: kotlin.Int,

    /* Maximum block body size in Bytes */
    @Json(name = "max_block_size")
    var maxBlockSize: kotlin.Int,

    /* Maximum transaction size */
    @Json(name = "max_tx_size")
    var maxTxSize: kotlin.Int,

    /* Maximum block header size */
    @Json(name = "max_block_header_size")
    var maxBlockHeaderSize: kotlin.Int,

    /* The amount of a key registration deposit in Lovelaces */
    @Json(name = "key_deposit")
    var keyDeposit: kotlin.String,

    /* The amount of a pool registration deposit in Lovelaces */
    @Json(name = "pool_deposit")
    var poolDeposit: kotlin.String,

    /* Epoch bound on pool retirement */
    @Json(name = "e_max")
    var eMax: kotlin.Int,

    /* Desired number of pools */
    @Json(name = "n_opt")
    var nOpt: kotlin.Int,

    /* Pool pledge influence */
    @Json(name = "a0")
    var a0: java.math.BigDecimal,

    /* Monetary expansion */
    @Json(name = "rho")
    var rho: java.math.BigDecimal,

    /* Treasury expansion */
    @Json(name = "tau")
    var tau: java.math.BigDecimal,

    /* Percentage of blocks produced by federated nodes */
    @Json(name = "decentralisation_param")
    var decentralisationParam: java.math.BigDecimal,

    /* Seed for extra entropy */
    @Json(name = "extra_entropy")
    var extraEntropy: kotlin.Any?,

    /* Accepted protocol major version */
    @Json(name = "protocol_major_ver")
    var protocolMajorVer: kotlin.Int,

    /* Accepted protocol minor version */
    @Json(name = "protocol_minor_ver")
    var protocolMinorVer: kotlin.Int,

    /* Minimum UTXO value */
    @Json(name = "min_utxo")
    var minUtxo: kotlin.String,

    /* Minimum stake cost forced on the pool */
    @Json(name = "min_pool_cost")
    var minPoolCost: kotlin.String,

    /* Epoch number only used once */
    @Json(name = "nonce")
    var nonce: kotlin.String,

    /* The per word cost of script memory usage */
    @Json(name = "price_mem")
    var priceMem: java.math.BigDecimal?,

    /* The cost of script execution step usage */
    @Json(name = "price_step")
    var priceStep: java.math.BigDecimal?,

    /* The maximum number of execution memory allowed to be used in a single transaction */
    @Json(name = "max_tx_ex_mem")
    var maxTxExMem: kotlin.String?,

    /* The maximum number of execution steps allowed to be used in a single transaction */
    @Json(name = "max_tx_ex_steps")
    var maxTxExSteps: kotlin.String?,

    /* The maximum number of execution memory allowed to be used in a single block */
    @Json(name = "max_block_ex_mem")
    var maxBlockExMem: kotlin.String?,

    /* The maximum number of execution steps allowed to be used in a single block */
    @Json(name = "max_block_ex_steps")
    var maxBlockExSteps: kotlin.String?,

    /* The maximum Val size */
    @Json(name = "max_val_size")
    var maxValSize: kotlin.String?,

    /* The percentage of the transactions fee which must be provided as collateral when including non-native scripts */
    @Json(name = "collateral_percent")
    var collateralPercent: java.math.BigDecimal?,

    /* The maximum number of collateral inputs allowed in a transaction */
    @Json(name = "max_collateral_inputs")
    var maxCollateralInputs: kotlin.Int?,

    /* The cost per UTxO word */
    @Json(name = "coins_per_utxo_word")
    var coinsPerUtxoWord: kotlin.String?

)

