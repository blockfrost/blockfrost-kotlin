package io.blockfrost.sdk_kotlin.tests

import com.beust.klaxon.JsonArray
import io.blockfrost.sdk_kotlin.api.CardanoAccountsApi
import io.blockfrost.sdk_kotlin.api.NutLinkApi
import io.blockfrost.sdk_kotlin.infrastructure.BadRequestException
import io.blockfrost.sdk_kotlin.infrastructure.BlockfrostConfig
import io.blockfrost.sdk_kotlin.infrastructure.ForbiddenException
import io.blockfrost.sdk_kotlin.infrastructure.RateLimitedException
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.*
import retrofit2.Retrofit
import retrofit2.mock.BehaviorDelegate
import retrofit2.mock.MockRetrofit
import retrofit2.mock.NetworkBehavior
import kotlin.properties.Delegates
import kotlin.time.Duration
import kotlin.time.ExperimentalTime


@OptIn(ExperimentalTime::class)
class BasicApiTests : DescribeSpec({
    var api: CardanoAccountsApi by Delegates.notNull()
    var server: MockWebServer by Delegates.notNull()
    var config: BlockfrostConfig by Delegates.notNull()

    val retryCount = 2
    val projectId = "abcdef"
    val expResponseAccount = """{"stake_address":"stake1u8zu4smzyf2r2mfqjd6tc6vxf2p8rccdfk82ye3eut2udkgs46q0w","active":false,"active_epoch":249,"controlled_amount":"0","rewards_sum":"0","withdrawals_sum":"0","reserves_sum":"0","treasury_sum":"0","withdrawable_amount":"0","pool_id":null}"""
    System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "INFO")

    describe("load accounts"){
        beforeTest {
            server = MockWebServer()
            server.start()
            config = object : BlockfrostConfig(
                baseUrl = server.url("/").toString(),
                projectId = projectId,
                maxRetryAttempts = retryCount
            ) {}
            api = CardanoAccountsApi(config)
        }

        afterTest {
            server.shutdown()
        }

        it("loads accounts for stake address").config(timeout = Duration.Companion.seconds(10)){
            server.enqueue(MockResponse().setBody(expResponseAccount))

            val r = api.getAccountByStakeAddress("stake1u8zu4smzyf2r2mfqjd6tc6vxf2p8rccdfk82ye3eut2udkgs46q0w")
            r.shouldNotBeNull()
            r.stakeAddress.shouldBe("stake1u8zu4smzyf2r2mfqjd6tc6vxf2p8rccdfk82ye3eut2udkgs46q0w")
            r.poolId.shouldBeNull()
        }

        it("loads accounts - invalid address").config(timeout = Duration.Companion.seconds(10)){
            server.enqueue(MockResponse().setResponseCode(400))
            shouldThrowExactly<BadRequestException> {
                api.getAccountByStakeAddress("stake1u9zu4smzyf2r2mfqjd6tc6vxf2p8rccdfk82ye3eut2udkgs46q0w")
            }
        }

        it("forbidden").config(timeout = Duration.Companion.seconds(10)){
            server.enqueue(MockResponse().setResponseCode(403))
            shouldThrowExactly<ForbiddenException> {
                api.getAccountByStakeAddress("stake1u9zu4smzyf2r2mfqjd6tc6vxf2p8rccdfk82ye3eut2udkgs46q0w")
            }
        }

        it("rate limit - should work").config(timeout = Duration.Companion.seconds(10)){
            for (i in 0 until retryCount - 1) {
                server.enqueue(MockResponse().setResponseCode(429))
            }
            server.enqueue(MockResponse().setBody(expResponseAccount))
            api.getAccountByStakeAddress("stake1u8zu4smzyf2r2mfqjd6tc6vxf2p8rccdfk82ye3eut2udkgs46q0w")
        }

        it("rate limit - should fail").config(timeout = Duration.Companion.seconds(10)){
            for (i in 0 until retryCount) {
                server.enqueue(MockResponse().setResponseCode(429))
            }
            server.enqueue(MockResponse().setBody(expResponseAccount))
            shouldThrowExactly<RateLimitedException> {
                api.getAccountByStakeAddress("stake1u8zu4smzyf2r2mfqjd6tc6vxf2p8rccdfk82ye3eut2udkgs46q0w")
            }
        }

        it("nutlink parse").config(timeout = Duration.Companion.seconds(10)){
            server.enqueue(MockResponse().setBody("""[{"address":"addr1q85yx2w7ragn5sx6umgmtjpc3865s9sg59sz4rrh6f90kgwfwlzu3w8ttacqg89mkdgwshwnplj5c5n9f8dhp0h55q2q7qm63t","tx_hash":"473a6f5ef23c8f9ea10e6d17372ee90031f44273fb2be6700673269bdd04eb19","block_height":4925385,"tx_index":0,"payload":[{"value":"0.107006","source":"coinGecko"},{"value":"0.10698550057606343","source":"ergoOracles"}]},{"address":"addr1q85yx2w7ragn5sx6umgmtjpc3865s9sg59sz4rrh6f90kgwfwlzu3w8ttacqg89mkdgwshwnplj5c5n9f8dhp0h55q2q7qm63t","tx_hash":"4117841140cb0c7ca5c2bd820a3e448806ec3588e99043230fac52a40509bccb","block_height":4925582,"tx_index":2,"payload":[{"value":"0.10671","source":"coinGecko"},{"value":"0.10618100888947407","source":"ergoOracles"}]}]"""))
            val napi = NutLinkApi(config)
            val r = napi.getTickerRecordsByTicker("ADAUSD")
            r.shouldNotBeNull()
            r.shouldNotBeEmpty()
            r.size.shouldBe(2)
            r.forEach { it.shouldNotBeNull() }
            r[0].payload.shouldBe(TestUtils.parseJson("""[{"value":"0.107006","source":"coinGecko"},{"value":"0.10698550057606343","source":"ergoOracles"}]""") as JsonArray<*>)
        }

        it("project id").config(timeout = Duration.Companion.seconds(10)){
            server.dispatcher = (object : Dispatcher() {
                override fun dispatch(request: RecordedRequest): MockResponse {
                    return if (projectId != request.headers["project_id"]){
                        MockResponse().setResponseCode(403)
                    } else {
                        MockResponse().setBody(expResponseAccount)
                    }

                }
            })

            api.getAccountByStakeAddress("stake1u8zu4smzyf2r2mfqjd6tc6vxf2p8rccdfk82ye3eut2udkgs46q0w")

            // Config without project id
            val invConfig = BlockfrostConfig(baseUrl = server.url("/").toString(), projectId = "")
            val api2 = CardanoAccountsApi(invConfig)
            shouldThrowExactly<ForbiddenException> {
                api2.getAccountByStakeAddress("stake1u9zu4smzyf2r2mfqjd6tc6vxf2p8rccdfk82ye3eut2udkgs46q0w")
            }
        }




    }
})