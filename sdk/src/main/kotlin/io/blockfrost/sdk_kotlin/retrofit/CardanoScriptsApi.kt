package io.blockfrost.sdk_kotlin.retrofit

import io.blockfrost.sdk_kotlin.models.Script
import io.blockfrost.sdk_kotlin.models.ScriptRedeemer
import io.blockfrost.sdk_kotlin.models.Scripts
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CardanoScriptsApi {
    /**
     * Specific script
     * Information about a specific script
     * Responses:
     *  - 200: Return the information about a specific script
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param scriptHash Hash of the script 
     * @return [Script]
     */
    @GET("scripts/{script_hash}")
    suspend fun getScript(@Path("script_hash") scriptHash: kotlin.String): Response<Script>

    /**
     * Redeemers of a specific script
     * List of redeemers of a specific script
     * Responses:
     *  - 200: Return the information about redeemers of a specific script
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param scriptHash Hash of the script 
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<ScriptRedeemer>]
     */
    @GET("scripts/{script_hash}/redeemers")
    suspend fun getScriptRedeemers(@Path("script_hash") scriptHash: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<ScriptRedeemer>>

    /**
     * Scripts
     * List of scripts.
     * Responses:
     *  - 200: Return list of scripts
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
     * @return [kotlin.collections.List<Scripts>]
     */
    @GET("scripts")
    suspend fun getScripts(@Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<Scripts>>

}
