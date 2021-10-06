package org.openapitools.client.retrofit

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody

import org.openapitools.client.models.AccountAddressesAsset
import org.openapitools.client.models.AccountAddressesContent
import org.openapitools.client.models.AccountContent
import org.openapitools.client.models.AccountDelegationContent
import org.openapitools.client.models.AccountHistoryContent
import org.openapitools.client.models.AccountMirContent
import org.openapitools.client.models.AccountRegistrationContent
import org.openapitools.client.models.AccountRewardContent
import org.openapitools.client.models.AccountWithdrawalContent
import org.openapitools.client.models.InlineResponse400
import org.openapitools.client.models.InlineResponse403
import org.openapitools.client.models.InlineResponse404
import org.openapitools.client.models.InlineResponse418
import org.openapitools.client.models.InlineResponse429
import org.openapitools.client.models.InlineResponse500

interface CardanoAccountsApi {
    /**
     * Account associated addresses
     * Obtain information about the addresses of a specific account.
     * Responses:
     *  - 200: Return the account addresses content
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param stakeAddress Bech32 stake address. 
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<AccountAddressesContent>]
     */
    @GET("accounts/{stake_address}/addresses")
    suspend fun getAccountAddresses(@Path("stake_address") stakeAddress: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<AccountAddressesContent>>

    /**
     * Assets associated with the account addresses
     * Obtain information about assets associated with addresses of a specific account.  &lt;b&gt;Be careful&lt;/b&gt;, as an account could be part of a mangled address and does not necessarily mean the addresses are owned by user as the account. 
     * Responses:
     *  - 200: Return the account addresses content
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param stakeAddress Bech32 stake address. 
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<AccountAddressesAsset>]
     */
    @GET("accounts/{stake_address}/addresses/assets")
    suspend fun getAccountAssets(@Path("stake_address") stakeAddress: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<AccountAddressesAsset>>

    /**
     * Specific account address
     * Obtain information about a specific stake account. 
     * Responses:
     *  - 200: Return the account content.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param stakeAddress Bech32 stake address. 
     * @return [AccountContent]
     */
    @GET("accounts/{stake_address}")
    suspend fun getAccountByStakeAddress(@Path("stake_address") stakeAddress: kotlin.String): Response<AccountContent>

    /**
     * Account delegation history
     * Obtain information about the delegation of a specific account.
     * Responses:
     *  - 200: Return the account delegations content
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param stakeAddress Bech32 stake address. 
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<AccountDelegationContent>]
     */
    @GET("accounts/{stake_address}/delegations")
    suspend fun getAccountDelegationHistory(@Path("stake_address") stakeAddress: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<AccountDelegationContent>>

    /**
     * Account history
     * Obtain information about the history of a specific account. 
     * Responses:
     *  - 200: Return the account content.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param stakeAddress Bech32 stake address. 
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<AccountHistoryContent>]
     */
    @GET("accounts/{stake_address}/history")
    suspend fun getAccountHistory(@Path("stake_address") stakeAddress: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<AccountHistoryContent>>

    /**
     * Account MIR history
     * Obtain information about the MIRs of a specific account. 
     * Responses:
     *  - 200: Return the account MIR content.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param stakeAddress Bech32 stake address. 
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<AccountMirContent>]
     */
    @GET("accounts/{stake_address}/mirs")
    suspend fun getAccountMirHistory(@Path("stake_address") stakeAddress: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<AccountMirContent>>

    /**
     * Account registration history
     * Obtain information about the registrations and deregistrations of a specific account. 
     * Responses:
     *  - 200: Return the account registration content.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param stakeAddress Bech32 stake address. 
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<AccountRegistrationContent>]
     */
    @GET("accounts/{stake_address}/registrations")
    suspend fun getAccountRegistrationHistory(@Path("stake_address") stakeAddress: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<AccountRegistrationContent>>

    /**
     * Account reward history
     * Obtain information about the reward history of a specific account. 
     * Responses:
     *  - 200: Return the account content.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param stakeAddress Bech32 stake address. 
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<AccountRewardContent>]
     */
    @GET("accounts/{stake_address}/rewards")
    suspend fun getAccountRewardHistory(@Path("stake_address") stakeAddress: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<AccountRewardContent>>

    /**
     * Account withdrawal history
     * Obtain information about the withdrawals of a specific account. 
     * Responses:
     *  - 200: Return the account withdrawal content.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @param stakeAddress Bech32 stake address. 
     * @param count The number of results displayed on one page. (optional, default to 100)
     * @param page The page number for listing the results. (optional, default to 1)
     * @param order The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return [kotlin.collections.List<AccountWithdrawalContent>]
     */
    @GET("accounts/{stake_address}/withdrawals")
    suspend fun getAccountWithdrawalHistory(@Path("stake_address") stakeAddress: kotlin.String, @Query("count") count: kotlin.Int? = null, @Query("page") page: kotlin.Int? = null, @Query("order") order: kotlin.String? = null): Response<kotlin.collections.List<AccountWithdrawalContent>>

}
