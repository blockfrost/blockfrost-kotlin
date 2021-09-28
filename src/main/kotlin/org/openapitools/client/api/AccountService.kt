package org.openapitools.client.api

import org.openapitools.client.exception.APIException
import org.openapitools.client.infrastructure.PaginationSetting
import org.openapitools.client.infrastructure.SortOrder
import org.openapitools.client.models.*

/**
 * Get account specific information
 */
interface AccountService {
    /**
     * Obtain information about a specific networkStake account.
     *
     * @param stakeAddress Bech32 networkStake address. (required)
     * @return Account
     */
    @Throws(APIException::class)
    fun getAccountByStakeAddress(stakeAddress: String?): Account?

    /**
     * Account history
     * Obtain information about the history of a specific account.
     *
     * @param stakeAddress Bech32 stake address. (required)
     * @param count        The number of results displayed on one page.
     * @param page         The page number for listing the results.
     * @param order        The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.
     * @return List&lt;AccountHistory&gt;
     */
    @Throws(APIException::class)
    fun getAccountHistory(stakeAddress: String?, paging: PaginationSetting? = null): List<AccountHistory?>?

    /**
     * Account history
     * Obtain information about the entire history of a specific account.
     *
     * @param stakeAddress Bech32 stake address. (required)
     * @param order        The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.
     * @return List&lt;AccountHistory&gt;
     */
    @Throws(APIException::class)
    fun getEntireAccountHistory(stakeAddress: String?, order: SortOrder? = null): List<AccountHistory?>?

    /**
     * Account reward history
     * Obtain information about the history of a specific account.
     *
     * @param stakeAddress Bech32 stake address. (required)
     * @param count        The number of results displayed on one page. (optional, default to 100)
     * @param page         The page number for listing the results. (optional, default to 1)
     * @param order        The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return List&lt;AccountRewardHistory&gt;
     */
    @Throws(APIException::class)
    fun getAccountRewardHistory(
        stakeAddress: String?,
        paging: PaginationSetting? = null
    ): List<AccountRewardHistory?>?

    /**
     * Account reward history
     * Obtain information about the entire history of a specific account.
     *
     * @param stakeAddress Bech32 stake address. (required)
     * @param order        The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.
     * @return List&lt;AccountRewardHistory&gt;
     */
    @Throws(APIException::class)
    fun getEntireAccountRewardHistory(stakeAddress: String?, order: SortOrder? = null): List<AccountRewardHistory?>?

    /**
     * Account delegation history
     * Obtain information about the delegation of a specific account.
     *
     * @param stakeAddress Bech32 stake address. (required)
     * @param count        The number of results displayed on one page. (optional, default to 100)
     * @param page         The page number for listing the results. (optional, default to 1)
     * @param order        The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return List&lt;AccountDelegationHistory&gt;
     */
    @Throws(APIException::class)
    fun getAccountDelegationHistory(
        stakeAddress: String?,
        paging: PaginationSetting? = null
    ): List<AccountDelegationHistory?>?

    /**
     * Account delegation history
     * Obtain information about the delegation of a specific account.
     *
     * @param stakeAddress Bech32 stake address. (required)
     * @param order        The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.
     * @return List&lt;AccountDelegationHistory&gt;
     */
    @Throws(APIException::class)
    fun getEntireAccountDelegationHistory(stakeAddress: String?, order: SortOrder? = null): List<AccountDelegationHistory?>?

    /**
     * Account registration history
     * Obtain information about the registrations and deregistrations of a specific account.
     *
     * @param stakeAddress Bech32 stake address. (required)
     * @param count        The number of results displayed on one page. (optional, default to 100)
     * @param page         The page number for listing the results. (optional, default to 1)
     * @param order        The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return List&lt;AccountRegistrationHistory&gt;
     */
    @Throws(APIException::class)
    fun getAccountRegistrationHistory(
        stakeAddress: String?,
        paging: PaginationSetting? = null
    ): List<AccountRegistrationHistory?>?

    /**
     * Account registration history
     * Obtain information about all the registrations and deregistrations of a specific account.
     *
     * @param stakeAddress Bech32 stake address. (required)
     * @param order        The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.
     * @return List&lt;AccountRegistrationHistory&gt;
     */
    @Throws(APIException::class)
    fun getEntireAccountRegistrationHistory(
        stakeAddress: String?,
        order: SortOrder? = null
    ): List<AccountRegistrationHistory?>?

    /**
     * Account registration history
     * Obtain information about all the registrations and deregistrations of a specific account in ascending order from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.
     *
     * @param stakeAddress Bech32 stake address. (required)
     * @return List&lt;AccountRegistrationHistory&gt;
     */
    @Throws(APIException::class)
    fun getEntireAccountRegistrationHistory(stakeAddress: String?): List<AccountRegistrationHistory?>?

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
    @Throws(APIException::class)
    fun getAccountWithdrawalHistory(
        stakeAddress: String?,
        paging: PaginationSetting? = null
    ): List<AccountWithdrawalHistory?>?

    /**
     * Account withdrawal history
     * Obtain information about all the withdrawals of a specific account.
     *
     * @param stakeAddress Bech32 stake address. (required)
     * @param order        The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.
     * @return List&lt;AccountWithdrawalHistory&gt;
     */
    @Throws(APIException::class)
    fun getEntireAccountWithdrawalHistory(stakeAddress: String?, order: SortOrder? = null): List<AccountWithdrawalHistory?>?

    /**
     * Account withdrawal history
     * Obtain information about all the withdrawals of a specific account in ascending order from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.
     *
     * @param stakeAddress Bech32 stake address. (required)
     * @return List&lt;AccountWithdrawalHistory&gt;
     */
    @Throws(APIException::class)
    fun getEntireAccountWithdrawalHistory(stakeAddress: String?): List<AccountWithdrawalHistory?>?

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
    @Throws(APIException::class)
    fun getAccountMirHistory(stakeAddress: String?, paging: PaginationSetting? = null): List<AccountMirHistory?>?

    /**
     * Account MIR history
     * Obtain information about all the MIRs of a specific account.
     *
     * @param stakeAddress Bech32 stake address. (required)
     * @param order        The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.
     * @return List&lt;AccountMirHistory&gt;
     */
    @Throws(APIException::class)
    fun getEntireAccountMirHistory(stakeAddress: String?, order: SortOrder? = null): List<AccountMirHistory?>?

    /**
     * Account MIR history
     * Obtain information about all the MIRs of a specific account in ascending order from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.
     *
     * @param stakeAddress Bech32 stake address. (required)
     * @return List&lt;AccountMirHistory&gt;
     */
    @Throws(APIException::class)
    fun getEntireAccountMirHistory(stakeAddress: String?): List<AccountMirHistory?>?

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
    @Throws(APIException::class)
    fun getAccountAddresses(stakeAddress: String?, paging: PaginationSetting? = null): List<AccountAddress?>?

    /**
     * Account associated addresses
     * Obtain information about the addresses of a specific account.
     *
     * @param stakeAddress Bech32 stake address. (required)
     * @param order        The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.
     * @return List&lt;AccountAddress&gt;
     */
    @Throws(APIException::class)
    fun getAllAccountAddresses(stakeAddress: String?, order: SortOrder? = null): List<AccountAddress?>?

    /**
     * Account associated addresses
     * Obtain information about the addresses of a specific account in ascending order from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.
     *
     * @param stakeAddress Bech32 stake address. (required)
     * @return List&lt;AccountAddress&gt;
     */
    @Throws(APIException::class)
    fun getAllAccountAddresses(stakeAddress: String?): List<AccountAddress?>?

    /**
     * Assets associated with the account addresses
     * Obtain information about assets associated with addresses of a specific account.
     * &lt;b&gt;Be careful&lt;/b&gt;, as an account could be part of a mangled address and does not necessarily mean the addresses are owned by user as the account.
     *
     * @param stakeAddress Bech32 stake address. (required)
     * @param count        The number of results displayed on one page. (optional, default to 100)
     * @param page         The page number for listing the results. (optional, default to 1)
     * @param order        The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  (optional, default to asc)
     * @return List&lt;AccountAsset&gt;
     */
    @Throws(APIException::class)
    fun getAccountAssets(stakeAddress: String?, paging: PaginationSetting? = null): List<AccountAsset?>?

    /**
     * Assets associated with the account addresses
     * Obtain information about assets associated with addresses of a specific account.
     * &lt;b&gt;Be careful&lt;/b&gt;, as an account could be part of a mangled address and does not necessarily mean the addresses are owned by user as the account.
     *
     * @param stakeAddress Bech32 stake address. (required)
     * @param order        The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.
     * @return List&lt;AccountAsset&gt;
     */
    @Throws(APIException::class)
    fun getAllAccountAssets(stakeAddress: String?, order: SortOrder? = null): List<AccountAsset?>?

}