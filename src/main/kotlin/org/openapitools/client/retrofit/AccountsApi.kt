package org.openapitools.client.retrofit

import org.openapitools.client.models.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface AccountsApi {
    /**
     * Specific account address
     * Obtain information about a specific networkStake account.
     *
     * @param stakeAddress Bech32 networkStake address. (required)
     * @return Call&lt;Account&gt;
     */
    @GET("accounts/{stake_address}")
    suspend fun accountsStakeAddressGet(
        @Header("project_id") projectId: String?,
        @Path("stake_address") stakeAddress: String?
    ): Account?

    /**
     * Assets associated with the account addresses
     * Obtain information about assets associated with addresses of a specific account.  &lt;b&gt;Be careful&lt;/b&gt;, as an account could be part of a mangled address and does not necessarily mean the addresses are owned by user as the account.
     *
     * @param stakeAddress Bech32 stake address. (required)
     * @param count        The number of results displayed on one page. (optional, default to 100)
     * @param page         The page number for listing the results. (optional, default to 1)
     * @param order        The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return List&lt;AccountAsset&gt;
     */ // Response<>
    @GET("accounts/{stake_address}/addresses/assets")
    suspend fun accountsStakeAddressAddressesAssetsGet(
        @Header("project_id") projectId: String?,
        @Path("stake_address") stakeAddress: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?,
        @Query("order") order: String?
    ): Response<List<Asset?>>

    /**
     * Account associated addresses
     * Obtain information about the addresses of a specific account.
     *
     * @param stakeAddress Bech32 stake address. (required)
     * @param count        The number of results displayed on one page. (optional, default to 100)
     * @param page         The page number for listing the results. (optional, default to 1)
     * @param order        The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return List&lt;AccountAddress&gt;
     */
    @GET("accounts/{stake_address}/addresses")
    suspend fun accountsStakeAddressAddressesGet(
        @Header("project_id") projectId: String?,
        @Path("stake_address") stakeAddress: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?,
        @Query("order") order: String?
    ): Response<List<AddressRaw?>?>

    /**
     * Account delegation history
     * Obtain information about the delegation of a specific account.
     *
     * @param stakeAddress Bech32 stake address. (required)
     * @param count        The number of results displayed on one page. (optional, default to 100)
     * @param page         The page number for listing the results. (optional, default to 1)
     * @param order        The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return Call&lt;List&lt;Object&gt;&gt;
     */
    @GET("accounts/{stake_address}/delegations")
    suspend fun accountsStakeAddressDelegationsGet(
        @Header("project_id") projectId: String?,
        @Path("stake_address") stakeAddress: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?,
        @Query("order") order: String?
    ): Response<List<AccountDelegationHistory?>?>?

    /**
     * Account history
     * Obtain information about the history of a specific account.
     *
     * @param stakeAddress Bech32 stake address. (required)
     * @param count        The number of results displayed on one page. (optional, default to 100)
     * @param page         The page number for listing the results. (optional, default to 1)
     * @param order        The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return List&lt;AccountHistory&gt;
     */
    @GET("accounts/{stake_address}/history")
    suspend fun accountsStakeAddressHistoryGet(
        @Header("project_id") projectId: String?,
        @Path("stake_address") stakeAddress: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?,
        @Query("order") order: String?
    ): Response<List<AccountHistory?>?>?

    /**
     * Account MIR history
     * Obtain information about the MIRs of a specific account.
     *
     * @param stakeAddress Bech32 stake address. (required)
     * @param count        The number of results displayed on one page. (optional, default to 100)
     * @param page         The page number for listing the results. (optional, default to 1)
     * @param order        The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return List&lt;AccountMirHistory&gt;
     */
    @GET("accounts/{stake_address}/mirs")
    suspend fun accountsStakeAddressMirsGet(
        @Header("project_id") projectId: String?,
        @Path("stake_address") stakeAddress: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?,
        @Query("order") order: String?
    ): Response<List<AccountMirHistory?>?>?

    /**
     * Account registration history
     * Obtain information about the registrations and deregistrations of a specific account.
     *
     * @param stakeAddress Bech32 stake address. (required)
     * @param count        The number of results displayed on one page. (optional, default to 100)
     * @param page         The page number for listing the results. (optional, default to 1)
     * @param order        The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return Call&lt;List&lt;AccountRegistrationHistory&gt;&gt;
     */
    @GET("accounts/{stake_address}/registrations")
    suspend fun accountsStakeAddressRegistrationsGet(
        @Header("project_id") projectId: String?,
        @Path("stake_address") stakeAddress: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?,
        @Query("order") order: String?
    ): Response<List<AccountRegistrationHistory?>?>?

    /**
     * Account reward history
     * Obtain information about the history of a specific account.
     *
     * @param stakeAddress Bech32 stake address. (required)
     * @param count        The number of results displayed on one page. (optional, default to 100)
     * @param page         The page number for listing the results. (optional, default to 1)
     * @param order        The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return Call&lt;List&lt;Object&gt;&gt;
     */
    @GET("accounts/{stake_address}/rewards")
    suspend fun accountsStakeAddressRewardsGet(
        @Header("project_id") projectId: String?,
        @Path("stake_address") stakeAddress: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?,
        @Query("order") order: String?
    ): Response<List<AccountRewardHistory?>?>?

    /**
     * Account withdrawal history
     * Obtain information about the withdrawals of a specific account.
     *
     * @param stakeAddress Bech32 stake address. (required)
     * @param count        The number of results displayed on one page. (optional, default to 100)
     * @param page         The page number for listing the results. (optional, default to 1)
     * @param order        The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return List&lt;AccountWithdrawalHistory&gt;
     */
    @GET("accounts/{stake_address}/withdrawals")
    suspend fun accountsStakeAddressWithdrawalsGet(
        @Header("project_id") projectId: String?,
        @Path("stake_address") stakeAddress: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?,
        @Query("order") order: String?
    ): Response<List<AccountWithdrawalHistory?>?>?
}