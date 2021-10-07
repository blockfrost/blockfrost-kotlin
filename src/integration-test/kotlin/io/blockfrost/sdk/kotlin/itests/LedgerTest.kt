package io.blockfrost.sdk.kotlin.itests

import io.blockfrost.sdk.kotlin.api.CardanoLedgerApi
import io.blockfrost.sdk.kotlin.infrastructure.BlockfrostConfig
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.floats.plusOrMinus
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import kotlin.properties.Delegates
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class LedgerTest : DescribeSpec({
    var api: CardanoLedgerApi by Delegates.notNull()
    System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "INFO")

    describe("ledger"){
        beforeTest {
            api = CardanoLedgerApi(config = BlockfrostConfig.defaulMainNetConfig)
        }

        it("genesis").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getGenesis()
            r.shouldNotBeNull()
            r.activeSlotsCoefficient.shouldNotBeNull().shouldBe(0.05f.plusOrMinus(0.0001f))
            r.updateQuorum.shouldNotBeNull().shouldBe(5)
            r.maxLovelaceSupply.shouldNotBeNull().shouldBe("45000000000000000")
            r.networkMagic.shouldNotBeNull().shouldBe(764824073)
            r.epochLength.shouldNotBeNull().shouldBe(432000)
            r.systemStart.shouldNotBeNull().shouldBe(1506203091)
            r.slotsPerKesPeriod.shouldNotBeNull().shouldBe(129600)
            r.slotLength.shouldNotBeNull().shouldBe(1)
            r.maxKesEvolutions.shouldNotBeNull().shouldBe(62)
            r.securityParam.shouldNotBeNull().shouldBe(2160)

        }
    }
})