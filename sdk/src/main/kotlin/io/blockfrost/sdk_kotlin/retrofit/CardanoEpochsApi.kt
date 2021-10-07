package io.blockfrost.sdk_kotlin.retrofit

import io.blockfrost.sdk_kotlin.models.EpochContent
import io.blockfrost.sdk_kotlin.models.EpochParamContent
import io.blockfrost.sdk_kotlin.models.EpochStakeContent
import io.blockfrost.sdk_kotlin.models.EpochStakePoolContent
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CardanoEpochsApi {
    /**
     * Stake distribution
     * Return the active stake distribution for the specified epoch.
     * Responses:
     *  - 200: Return the data about the epoch
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param number Number of the epoch 
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @return [kotlin.collections.List<EpochStakeContent>]
     */
    @GET("epochs/{number}/stakes")
    suspend fun getActiveStakesForEpoch(@Path("number") number: kotlin.Int, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null): Response<kotlin.collections.List<EpochStakeContent>>

    /**
     * Stake distribution by pool
     * Return the active stake distribution for the epoch specified by stake pool.
     * Responses:
     *  - 200: Return the data about the epoch
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param number Number of the epoch 
     * @param poolId Stake pool ID to filter 
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @return [kotlin.collections.List<EpochStakePoolContent>]
     */
    @GET("epochs/{number}/stakes/{pool_id}")
    suspend fun getActiveStakesForEpochAndPool(@Path("number") number: kotlin.Int, @Path("pool_id") poolId: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null): Response<kotlin.collections.List<EpochStakePoolContent>>

    /**
     * Block distribution
     * Return the blocks minted for the epoch specified.
     * Responses:
     *  - 200: Return the data about the epoch
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param number Number of the epoch 
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<kotlin.String>]
     */
    @GET("epochs/{number}/blocks")
    suspend fun getBlocksForEpoch(@Path("number") number: kotlin.Int, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<kotlin.String>>

    /**
     * Block distribution by pool
     * Return the block minted for the epoch specified by stake pool.
     * Responses:
     *  - 200: Return the data about the epoch
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param number Number of the epoch 
     * @param poolId Stake pool ID to filter 
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<kotlin.String>]
     */
    @GET("epochs/{number}/blocks/{pool_id}")
    suspend fun getBlocksForEpochAndPool(@Path("number") number: kotlin.Int, @Path("pool_id") poolId: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<kotlin.String>>

    /**
     * Specific epoch
     * Return the content of the requested epoch.
     * Responses:
     *  - 200: Return the epoch data.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param number Number of the epoch 
     * @return [EpochContent]
     */
    @GET("epochs/{number}")
    suspend fun getEpoch(@Path("number") number: kotlin.Int): Response<EpochContent>

    /**
     * Protocol parameters
     * Return the protocol parameters for the epoch specified.
     * Responses:
     *  - 200: Return the data about the epoch
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param number Number of the epoch 
     * @return [EpochParamContent]
     */
    @GET("epochs/{number}/parameters")
    suspend fun getEpochParam(@Path("number") number: kotlin.Int): Response<EpochParamContent>

    /**
     * Latest epoch
     * Return the information about the latest, therefore current, epoch.
     * Responses:
     *  - 200: Return the data about the epoch
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @return [EpochContent]
     */
    @GET("epochs/latest")
    suspend fun getLatestEpoch(): Response<EpochContent>

    /**
     * Latest epoch protocol parameters
     * Return the protocol parameters for the latest epoch.
     * Responses:
     *  - 200: Return the data about the epoch
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @return [EpochParamContent]
     */
    @GET("epochs/latest/parameters")
    suspend fun getLatestEpochParam(): Response<EpochParamContent>

    /**
     * Listing of next epochs
     * Return the list of epochs following a specific epoch.
     * Responses:
     *  - 200: Return the data about the epoch
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param number Number of the requested epoch. 
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @return [kotlin.collections.List<EpochContent>]
     */
    @GET("epochs/{number}/next")
    suspend fun getNextEpochs(@Path("number") number: kotlin.Int, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null): Response<kotlin.collections.List<EpochContent>>

    /**
     * Listing of previous epochs
     * Return the list of epochs preceding a specific epoch.
     * Responses:
     *  - 200: Return the epoch data
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param number Number of the epoch 
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results (optional, default to 1)
     * @return [kotlin.collections.List<EpochContent>]
     */
    @GET("epochs/{number}/previous")
    suspend fun getPreviousEpochs(@Path("number") number: kotlin.Int, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null): Response<kotlin.collections.List<EpochContent>>

}
