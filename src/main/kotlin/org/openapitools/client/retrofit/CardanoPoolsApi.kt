package org.openapitools.client.retrofit

import org.openapitools.client.infrastructure.CollectionFormats.*
import org.openapitools.client.models.*
import retrofit2.Response
import retrofit2.http.*

interface CardanoPoolsApi {
    /**
     * Specific stake pool
     * Pool information.
     * Responses:
     *  - 200: Return the pool information content
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param poolId Bech32 or hexadecimal pool ID. 
     * @return [Pool]
     */
    @GET("pools/{pool_id}")
    suspend fun getPool(@Path("pool_id") poolId: kotlin.String): Response<Pool>

    /**
     * Stake pool blocks
     * List of stake pools blocks.
     * Responses:
     *  - 200: Return the pool block list
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param poolId Bech32 or hexadecimal pool ID. 
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<kotlin.String>]
     */
    @GET("pools/{pool_id}/blocks")
    suspend fun getPoolBlocks(@Path("pool_id") poolId: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<kotlin.String>>

    /**
     * Stake pool delegators
     * List of current stake pools delegators.
     * Responses:
     *  - 200: Return the pool delegations.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param poolId Bech32 or hexadecimal pool ID. 
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<PoolDelegator>]
     */
    @GET("pools/{pool_id}/delegators")
    suspend fun getPoolDelegators(@Path("pool_id") poolId: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<PoolDelegator>>

    /**
     * Stake pool history
     * History of stake pool parameters over epochs. 
     * Responses:
     *  - 200: Return the pool information content.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param poolId Bech32 or hexadecimal pool ID. 
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<PoolHistory>]
     */
    @GET("pools/{pool_id}/history")
    suspend fun getPoolHistory(@Path("pool_id") poolId: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<PoolHistory>>

    /**
     * Stake pool metadata
     * Stake pool registration metadata. 
     * Responses:
     *  - 200: Return the pool metadata content.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param poolId Bech32 or hexadecimal pool ID. 
     * @return [AnyOfLessThanPoolMetadataCommaObjectGreaterThan]
     */
    @GET("pools/{pool_id}/metadata")
    suspend fun getPoolMetadata(@Path("pool_id") poolId: kotlin.String): Response<PoolMetadata>

    /**
     * Stake pool relays
     * Relays of a stake pool.
     * Responses:
     *  - 200: Return the pool relays information content.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param poolId Bech32 or hexadecimal pool ID. 
     * @return [kotlin.collections.List<PoolRelay>]
     */
    @GET("pools/{pool_id}/relays")
    suspend fun getPoolRelays(@Path("pool_id") poolId: kotlin.String): Response<kotlin.collections.List<PoolRelay>>

    /**
     * Stake pool updates
     * List of certificate updates to the stake pool.
     * Responses:
     *  - 200: Return the pool updates history
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param poolId Bech32 or hexadecimal pool ID. 
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<PoolUpdate>]
     */
    @GET("pools/{pool_id}/updates")
    suspend fun getPoolUpdates(@Path("pool_id") poolId: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<PoolUpdate>>

    /**
     * List of stake pools
     * List of registered stake pools.
     * Responses:
     *  - 200: Return the list of pools.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param count The numbers of pools per page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<kotlin.String>]
     */
    @GET("pools")
    suspend fun getPools(@Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<kotlin.String>>

    /**
     * List of retired stake pools
     * List of already retired pools.
     * Responses:
     *  - 200: Return the pool information content
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param count The numbers of pools per page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<PoolListRetire>]
     */
    @GET("pools/retired")
    suspend fun getRetiredPools(@Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<PoolListRetire>>

    /**
     * List of retiring stake pools
     * List of stake pools retiring in the upcoming epochs
     * Responses:
     *  - 200: Return the pool information content
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<PoolListRetire>]
     */
    @GET("pools/retiring")
    suspend fun getRetiringPools(@Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<PoolListRetire>>

}
