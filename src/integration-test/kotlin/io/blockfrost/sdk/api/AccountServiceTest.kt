package io.blockfrost.sdk.api

import io.github.resilience4j.circuitbreaker.CircuitBreaker
import io.github.resilience4j.core.IntervalFunction
import io.github.resilience4j.retrofit.CircuitBreakerCallAdapter
import io.github.resilience4j.retrofit.RetryCallAdapter
import io.github.resilience4j.retry.Retry
import io.github.resilience4j.retry.RetryConfig
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import okhttp3.OkHttpClient
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openapitools.client.api.CardanoAccountsApi
import org.openapitools.client.infrastructure.BlockfrostConfig
import org.openapitools.client.infrastructure.Serializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException
import java.util.concurrent.TimeoutException
import java.util.concurrent.atomic.AtomicInteger


//import io.blockfrost.sdk.api.exception.APIException;
//import io.blockfrost.sdk.api.model.*;
//import io.blockfrost.sdk.api.util.Constants;
//import io.blockfrost.sdk.api.util.OrderEnum;
//import io.blockfrost.sdk.impl.AccountServiceImpl;
class AccountServiceTest : TestBase() {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)
    val testDispatcher = TestCoroutineDispatcher()

    //AccountService accountService;
    @BeforeEach
    fun setup() {
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "TRACE")
//        accountService = new AccountServiceImpl(Constants.BLOCKFROST_TESTNET_URL, projectId);
    }

    fun getRetrofit(): Retrofit {
        // Create a Retry with default configuration
        val circuitBreaker = CircuitBreaker.ofDefaults("testName")

        val intervalFn = IntervalFunction.ofExponentialBackoff()

        // Create a Retry with custom configuration
        val retry: Retry = Retry.of(
            "apiRetry", RetryConfig.custom<Response<String>>()
                .maxAttempts(2)
                .intervalFunction(intervalFn)
                .retryOnResult { response: Response<String> -> setOf(429, 500).contains(response.code())  }
                //.retryOnException { e: Throwable? -> e is WebServiceException }
                .retryExceptions(IOException::class.java, TimeoutException::class.java)
                //.ignoreExceptions(BusinessException::class.java, OtherBusinessException::class.java)
                .failAfterMaxAttempts(false)  // important, do not throw, otherwise callback is missed
                .build()
        )

        // Add the interceptor to OkHttpClient
        val builder = OkHttpClient.Builder().apply {
            retryOnConnectionFailure(true)

        }
        //builder.interceptors().add(interceptor)
        val client: OkHttpClient = builder.build()

        return Retrofit.Builder()
            .baseUrl("https://cardano-testnet.blockfrost.io/api/v0/")
            .addConverterFactory(MoshiConverterFactory.create(Serializer.moshi))
            .addCallAdapterFactory(RetryCallAdapter.of(retry))
            .addCallAdapterFactory(CircuitBreakerCallAdapter.of(circuitBreaker))
            .client(client)
            .build()
    }

    fun ensureMinAndGet(atomic: AtomicInteger, value: Int): Int {
        var tmpLastReturned: Int
        do {
            tmpLastReturned = atomic.get()
            if (tmpLastReturned <= value) {
                return tmpLastReturned
            }

            // Here, value < tmpLastReturned,
            // so we will try to set it as new value.
        } while (!atomic.compareAndSet(tmpLastReturned, value))
        return value
    }

    fun ensureMaxAndGet(atomic: AtomicInteger, value: Int): Int {
        var tmpLastReturned: Int
        do {
            tmpLastReturned = atomic.get()
            if (tmpLastReturned >= value) {
                return tmpLastReturned
            }

            // Here, value < tmpLastReturned,
            // so we will try to set it as new value.
        } while (!atomic.compareAndSet(tmpLastReturned, value))
        return value
    }

    @Test
    fun getAccountByStakeAddress_willReturn_Account(): Unit = runBlocking {
//        val api = getRetrofit().create(AccountsApi::class.java)
//        val apiAddr = getRetrofit().create(AddressesApi::class.java)
//        val apiBlock = getRetrofit().create(BlocksApi::class.java)
        val stakeAddress = "stake_test1upwlsqc3m9629dsf2vw3ycuqv5jhd023xtjh3ax42nvj03gwy2cha"
        val projId = "PXCu29tM3mTm3ZK503IAgfJo23s9eLlF"
//        val r = api.accountsStakeAddressGet(projId, stakeAddress)
//        logger.info("$r")

        val stakeAddr = "stake1u9a3t4rgddm4expj0ucyxhxg3ft9ugk2ry6r9w69h04ea6cfj887f"
        val config = BlockfrostConfig.defaulMainNetConfig
        val api4 = CardanoAccountsApi(config)
        val r1 = api4.getAccountAddresses(stakeAddr)

        try {
            api4.getAccountAddressesAll(stakeAddr).collect {
                logger.info("Addr: $it")
            }
        } catch(e: Exception){
            logger.error("Error in flow collection", e)
            throw e
        }

//        val pager = PageLister<Block>(concurrentPages = 5)
//        val flow = pager.load { count, page ->
//            apiBlock.blocksHashOrNumberNextGet(projId, "2828500", count, page)
//        }
//
//        try {
//            flow.collect {
//                logger.info("Block: $it")
//            }
//        } catch(e: Exception){
//            logger.error("Error in flow collection", e)
//            throw e
//        }

//        val rr = apiBlock.blocksHashOrNumberNextGet(projId, "2829000", countPerPage, page)
//        val rr = apiAddr.addressesAddressTransactionsGet(
//            projId,
//            "DdzFFzCqrhstmqBkaU98vdHu6PdqjqotmgudToWYEeRmQKDrn4cAgGv9EZKtu1DevLrMA1pdVazufUCK4zhFkUcQZ5Gm88mVHnrwmXvT",
//            countPerPage,
//            page, "asc", null, null
//        )

//        val r2 = api.accountsStakeAddressAddressesAssetsGet(projId, "stake_test1upwlsqc3m9629dsf2vw3ycuqv5jhd023xtjh3ax42nvj03gwy2cha", 3, 1, "asc")
//        logger.info("$r2")

//        val r2 = api.accountsStakeAddressAddressesGet(projId, "stake_test1upwlsqc3m9629dsf2vw3ycuqv5jhd023xtjh3ax42nvj03gwy2cha", 1, 1, "asc")
//        logger.info("$r2")

//        val account: Account = accountService.getAccountByStakeAddress(stakeAddress)
//        assertThat(
//            account.getStakeAddress(),
//            Matchers.`is`("stake_test1upwlsqc3m9629dsf2vw3ycuqv5jhd023xtjh3ax42nvj03gwy2cha")
//        )
//        assertTrue(account.getActive())
//        Assertions.assertNotNull(account.getPoolId())
    }


    //    public void getAccountByStakeAddress_willThrowAPIException_onNullPoolId() {
    //
    //        Exception exception = assertThrows(APIException.class, () -> accountService.getAccountByStakeAddress(null));
    //        assertThat(exception.getMessage(), is("Stake address cannot be null or empty"));
    //    }
    //
    //    @Nested
    //    @DisplayName("GetAccountHistory Tests")
    //    class GetAccountHistory {
    //
    //        @Test
    //        public void history_willReturn_historyForCountPageAndAscendingOrder() throws APIException {
    //
    //            List<AccountHistory> historyList = accountService.getAccountHistory("stake_test1upwlsqc3m9629dsf2vw3ycuqv5jhd023xtjh3ax42nvj03gwy2cha", 3, 1, OrderEnum.asc);
    //
    //            assertThat(historyList, hasSize(lessThanOrEqualTo(3)));
    //            assertThat(historyList, hasItem(allOf(hasProperty("poolId", is(notNullValue())))));
    //        }
    //
    //        @Test
    //        public void history_willReturn_historyForCountAndPage() throws APIException {
    //
    //            List<AccountHistory> historyList = accountService.getAccountHistory("stake_test1upwlsqc3m9629dsf2vw3ycuqv5jhd023xtjh3ax42nvj03gwy2cha", 3, 1);
    //
    //            assertThat(historyList, hasSize(lessThanOrEqualTo(3)));
    //            assertThat(historyList, hasItem(allOf(hasProperty("poolId", is(notNullValue())))));
    //        }
    //
    //        @Test
    //        public void history_willThrowAPIException_onNullPoolId() {
    //
    //            Exception exception = assertThrows(APIException.class, () -> accountService.getAccountHistory(null, 3, 1));
    //            assertThat(exception.getMessage(), is("Stake address cannot be null or empty"));
    //        }
    //
    //    }
    //
    //    @Nested
    //    @DisplayName("GetAccountRewardHistory Tests")
    //    class GetAccountRewardHistory {
    //
    //        @Test
    //        public void rewardHistory_willReturn_rewardHistoryForCountPageAndAscendingOrder() throws APIException {
    //
    //            List<AccountRewardHistory> rewardHistoryList = accountService.getAccountRewardHistory("stake_test1upwlsqc3m9629dsf2vw3ycuqv5jhd023xtjh3ax42nvj03gwy2cha", 3, 1, OrderEnum.asc);
    //
    //            assertThat(rewardHistoryList, hasSize(lessThanOrEqualTo(3)));
    //        }
    //
    //        @Test
    //        public void rewardHistory_willReturn_rewardHistoryForCountAndPage() throws APIException {
    //
    //            List<AccountRewardHistory> rewardHistoryList = accountService.getAccountRewardHistory("stake_test1upwlsqc3m9629dsf2vw3ycuqv5jhd023xtjh3ax42nvj03gwy2cha", 3, 1);
    //
    //            assertThat(rewardHistoryList, hasSize(lessThanOrEqualTo(3)));
    //        }
    //
    //        @Test
    //        public void rewardHistory_willThrowAPIException_onNullPoolId() {
    //
    //            Exception exception = assertThrows(APIException.class, () -> accountService.getAccountRewardHistory(null, 3, 1));
    //            assertThat(exception.getMessage(), is("Stake address cannot be null or empty"));
    //        }
    //
    //    }
    //
    //    @Nested
    //    @DisplayName("GetAccountDelegationHistory Tests")
    //    class GetAccountDelegationHistory {
    //
    //        @Test
    //        public void delegationHistory_willReturn_delegationHistoryForCountPageAndAscendingOrder() throws APIException {
    //
    //            List<AccountDelegationHistory> delegationHistoryList = accountService.getAccountDelegationHistory("stake_test1upwlsqc3m9629dsf2vw3ycuqv5jhd023xtjh3ax42nvj03gwy2cha", 3, 1, OrderEnum.asc);
    //
    //            assertThat(delegationHistoryList, hasSize(lessThanOrEqualTo(3)));
    //        }
    //
    //        @Test
    //        public void delegationHistory_willReturn_delegationHistoryForCountAndPage() throws APIException {
    //
    //            List<AccountDelegationHistory> delegationHistoryList = accountService.getAccountDelegationHistory("stake_test1upwlsqc3m9629dsf2vw3ycuqv5jhd023xtjh3ax42nvj03gwy2cha", 3, 1);
    //
    //            assertThat(delegationHistoryList, hasSize(lessThanOrEqualTo(3)));
    //        }
    //
    //        @Test
    //        public void delegationHistory_willThrowAPIException_onNullPoolId() {
    //
    //            Exception exception = assertThrows(APIException.class, () -> accountService.getAccountDelegationHistory(null, 3, 1));
    //            assertThat(exception.getMessage(), is("Stake address cannot be null or empty"));
    //        }
    //
    //    }
    //
    //    @Nested
    //    @DisplayName("GetAccountRegistrationHistory Tests")
    //    class GetAccountRegistrationHistory {
    //
    //        @Test
    //        public void registrationHistory_willReturn_registrationHistoryForCountPageAndAscendingOrder() throws APIException {
    //
    //            List<AccountRegistrationHistory> registrationHistoryList = accountService.getAccountRegistrationHistory("stake_test1upwlsqc3m9629dsf2vw3ycuqv5jhd023xtjh3ax42nvj03gwy2cha", 3, 1, OrderEnum.asc);
    //
    //            assertThat(registrationHistoryList, hasSize(lessThanOrEqualTo(3)));
    //        }
    //
    //        @Test
    //        public void registrationHistory_willReturn_registrationHistoryForCountAndPage() throws APIException {
    //
    //            List<AccountRegistrationHistory> registrationHistoryList = accountService.getAccountRegistrationHistory("stake_test1upwlsqc3m9629dsf2vw3ycuqv5jhd023xtjh3ax42nvj03gwy2cha", 3, 1);
    //
    //            assertThat(registrationHistoryList, hasSize(lessThanOrEqualTo(3)));
    //        }
    //
    //        @Test
    //        public void registrationHistory_willThrowAPIException_onNullPoolId() {
    //
    //            Exception exception = assertThrows(APIException.class, () -> accountService.getAccountRegistrationHistory(null, 3, 1));
    //            assertThat(exception.getMessage(), is("Stake address cannot be null or empty"));
    //        }
    //
    //    }
    //
    //    @Nested
    //    @DisplayName("GetAccountWithdrawalHistory Tests")
    //    class GetAccountWithdrawalHistory {
    //
    //        @Test
    //        public void withdrawalHistory_willReturn_withdrawalHistoryForCountPageAndAscendingOrder() throws APIException {
    //
    //            List<AccountWithdrawalHistory> withdrawalHistoryList = accountService.getAccountWithdrawalHistory("stake_test1upwlsqc3m9629dsf2vw3ycuqv5jhd023xtjh3ax42nvj03gwy2cha", 3, 1, OrderEnum.asc);
    //
    //            assertThat(withdrawalHistoryList, hasSize(lessThanOrEqualTo(3)));
    //        }
    //
    //        @Test
    //        public void withdrawalHistory_willReturn_withdrawalHistoryForCountAndPage() throws APIException {
    //
    //            List<AccountWithdrawalHistory> withdrawalHistoryList = accountService.getAccountWithdrawalHistory("stake_test1upwlsqc3m9629dsf2vw3ycuqv5jhd023xtjh3ax42nvj03gwy2cha", 3, 1);
    //
    //            assertThat(withdrawalHistoryList, hasSize(lessThanOrEqualTo(3)));
    //        }
    //
    //        @Test
    //        public void withdrawalHistory_willThrowAPIException_onNullPoolId() {
    //
    //            Exception exception = assertThrows(APIException.class, () -> accountService.getAccountWithdrawalHistory(null, 3, 1));
    //            assertThat(exception.getMessage(), is("Stake address cannot be null or empty"));
    //        }
    //
    //    }
    //
    //    @Nested
    //    @DisplayName("GetAccountMirHistory Tests")
    //    class GetAccountMirHistory {
    //
    //        @Test
    //        public void mirHistory_willReturn_mirHistoryForCountPageAndAscendingOrder() throws APIException {
    //
    //            List<AccountMirHistory> mirHistoryList = accountService.getAccountMirHistory("stake_test1upwlsqc3m9629dsf2vw3ycuqv5jhd023xtjh3ax42nvj03gwy2cha", 3, 1, OrderEnum.asc);
    //
    //            assertThat(mirHistoryList, hasSize(lessThanOrEqualTo(3)));
    //        }
    //
    //        @Test
    //        public void mirHistory_willReturn_mirHistoryForCountAndPage() throws APIException {
    //
    //            List<AccountMirHistory> mirHistoryList = accountService.getAccountMirHistory("stake_test1upwlsqc3m9629dsf2vw3ycuqv5jhd023xtjh3ax42nvj03gwy2cha", 3, 1);
    //
    //            assertThat(mirHistoryList, hasSize(lessThanOrEqualTo(3)));
    //        }
    //
    //        @Test
    //        public void mirHistory_willThrowAPIException_onNullPoolId() {
    //
    //            Exception exception = assertThrows(APIException.class, () -> accountService.getAccountMirHistory(null, 3, 1));
    //            assertThat(exception.getMessage(), is("Stake address cannot be null or empty"));
    //        }
    //
    //    }
    //
    //    @Nested
    //    @DisplayName("GetAccountAddresses Tests")
    //    class GetAccountAddresses {
    //
    //        @Test
    //        public void addresses_willReturn_addressesForCountPageAndAscendingOrder() throws APIException {
    //
    //            List<AccountAddress> addressesList = accountService.getAccountAddresses("stake_test1upwlsqc3m9629dsf2vw3ycuqv5jhd023xtjh3ax42nvj03gwy2cha", 3, 1, OrderEnum.asc);
    //
    //            assertThat(addressesList, hasSize(lessThanOrEqualTo(3)));
    //        }
    //
    //        @Test
    //        public void addresses_willReturn_addressesForCountAndPage() throws APIException {
    //
    //            List<AccountAddress> addressesList = accountService.getAccountAddresses("stake_test1upwlsqc3m9629dsf2vw3ycuqv5jhd023xtjh3ax42nvj03gwy2cha", 3, 1);
    //
    //            assertThat(addressesList, hasSize(lessThanOrEqualTo(3)));
    //        }
    //
    //        @Test
    //        public void addresses_willThrowAPIException_onNullPoolId() {
    //
    //            Exception exception = assertThrows(APIException.class, () -> accountService.getAccountAddresses(null, 3, 1));
    //            assertThat(exception.getMessage(), is("Stake address cannot be null or empty"));
    //        }
    //
    //    }
    //
    //    @Nested
    //    @DisplayName("GetAccountAssets Tests")
    //    class GetAccountAssets {
    //
    //        @Test
    //        public void assets_willReturn_assetsForCountPageAndAscendingOrder() throws APIException {
    //
    //            List<AccountAsset> assetsList = accountService.getAccountAssets("stake_test1upwlsqc3m9629dsf2vw3ycuqv5jhd023xtjh3ax42nvj03gwy2cha", 3, 1, OrderEnum.asc);
    //
    //            assertThat(assetsList, hasSize(lessThanOrEqualTo(3)));
    //        }
    //
    //        @Test
    //        public void assets_willReturn_assetsForCountAndPage() throws APIException {
    //
    //            List<AccountAsset> assetsList = accountService.getAccountAssets("stake_test1upwlsqc3m9629dsf2vw3ycuqv5jhd023xtjh3ax42nvj03gwy2cha", 3, 1);
    //
    //            assertThat(assetsList, hasSize(lessThanOrEqualTo(3)));
    //        }
    //
    //        @Test
    //        public void assets_willThrowAPIException_onNullPoolId() {
    //
    //            Exception exception = assertThrows(APIException.class, () -> accountService.getAccountAssets(null, 3, 1));
    //            assertThat(exception.getMessage(), is("Stake address cannot be null or empty"));
    //        }
    //
    //    }
}