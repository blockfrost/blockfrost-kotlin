package io.blockfrost.sdk.kotlin.itests

import io.blockfrost.sdk.kotlin.api.CardanoPoolsApi
import io.blockfrost.sdk.kotlin.infrastructure.BlockfrostConfig
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.floats.plusOrMinus
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import kotlin.properties.Delegates
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class PoolsTest : DescribeSpec({
    var api: CardanoPoolsApi by Delegates.notNull()
    System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "INFO")

    describe("pools"){
        beforeTest {
            api = CardanoPoolsApi(config = BlockfrostConfig.defaulMainNetConfig)
        }

        it("retiring").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getRetiringPools()
            r.shouldNotBeNull()
            r.shouldNotBeEmpty()
            r.forEach { it.shouldNotBeNull() }
        }

        it("retired").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getRetiredPools()
            r.shouldNotBeNull()
            r.shouldNotBeEmpty()
            r.forEach { it.shouldNotBeNull() }
        }

        it("all").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getPools()
            r.shouldNotBeNull()
            r.shouldNotBeEmpty()
            r.forEach { it.shouldNotBeNull() }
        }

        it("byId").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getPool("pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy")
            r.shouldNotBeNull()
            r.declaredPledge.shouldBe("510000000000")
            r.fixedCost.shouldBe("340000000")
            r.hex.shouldBe("0f292fcaa02b8b2f9b3c8f9fd8e0bb21abedb692a6d5058df3ef2735")
            r.marginCost.shouldBe(0.049f.plusOrMinus(0.0001f))
            r.owners.shouldBe(listOf("stake1u98nnlkvkk23vtvf9273uq7cph5ww6u2yq2389psuqet90sv4xv9v"))
            r.poolId.shouldBe("pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy")
            r.registration.shouldBe(listOf("a96c79773b7506211eb56bf94886a2face17657d1009f52fb5ea05f19cc8823e"))
            r.retirement.shouldBeEmpty()
            r.rewardAccount.shouldBe("stake1u98nnlkvkk23vtvf9273uq7cph5ww6u2yq2389psuqet90sv4xv9v")
            r.vrfKey.shouldBe("b512cc7c1a8ba689c2d8fd27adfdbac2049a3f8f95c8b85e8298f14d7d8dc4e6")
        }

        it("history").config(timeout = Duration.Companion.seconds(30)) {
            val r = api.getPoolHistory("pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy")
            r.shouldNotBeNull()
            r.shouldNotBeEmpty()
            r.forEach { it.shouldNotBeNull() }
        }

        it("metadata").config(timeout = Duration.Companion.seconds(10)) {
            val r = api.getPoolMetadata("pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy")
            r.shouldNotBeNull()
            r.poolId.shouldBe("pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy")
        }

        it("delegators").config(timeout = Duration.Companion.seconds(30)) {
            val r = api.getPoolDelegators("pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy")
            r.shouldNotBeNull()
            r.shouldNotBeEmpty()
            r.forEach { it.shouldNotBeNull() }
        }

        it("relays").config(timeout = Duration.Companion.seconds(10)) {
            val r = api.getPoolRelays("pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy")
            r.shouldNotBeNull()
            r.shouldNotBeEmpty()
            r.forEach { it.shouldNotBeNull() }
        }

        it("blocks").config(timeout = Duration.Companion.seconds(10)) {
            val r = api.getPoolBlocks("pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy", count=10)
            r.shouldNotBeNull()
            r.shouldNotBeEmpty()
            r.size.shouldBe(10)
            r.forEach { it.shouldNotBeNull() }
        }

        it("updates").config(timeout = Duration.Companion.seconds(10)) {
            val r = api.getPoolUpdates("pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy", count=10)
            r.shouldNotBeNull()
            r.shouldNotBeEmpty()
            r.forEach { it.shouldNotBeNull() }
        }
    }
})