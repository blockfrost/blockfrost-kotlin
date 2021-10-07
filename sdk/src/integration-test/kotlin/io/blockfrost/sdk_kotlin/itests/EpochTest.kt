package io.blockfrost.sdk_kotlin.itests

import io.blockfrost.sdk_kotlin.api.CardanoEpochsApi
import io.blockfrost.sdk_kotlin.infrastructure.BlockfrostConfig
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.floats.plusOrMinus
import io.kotest.matchers.ints.shouldBeLessThan
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import kotlin.properties.Delegates
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class EpochTest : DescribeSpec({
    var api: CardanoEpochsApi by Delegates.notNull()
    System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "INFO")

    describe("epochs"){
        beforeTest {
            api = CardanoEpochsApi(config = BlockfrostConfig.defaulMainNetConfig)
        }

        it("getLatest").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getLatestEpoch()
            r.shouldNotBeNull()
        }

        it("epoch0").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getEpoch(0)
            r.shouldNotBeNull()
            r.epoch.shouldBe(0)
            r.startTime.shouldBe(1506203091)
            r.endTime.shouldBe(1506635091)
            r.firstBlockTime.shouldBe(1506203091)
            r.lastBlockTime.shouldBe(1506635071)
            r.blockCount.shouldBe(21587)
            r.txCount.shouldBe(33)
            r.output.shouldBe("10378568796482912")
            r.fees.shouldBe("3458053")
            r.activeStake.shouldBeNull()
        }

        it("epoch242").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getEpoch(242)
            r.shouldNotBeNull()
            r.epoch.shouldBe(242)
            r.startTime.shouldBe(1610747091)
            r.endTime.shouldBe(1611179091)
            r.firstBlockTime.shouldBe(1610747091)
            r.lastBlockTime.shouldBe(1611179076)
            r.blockCount.shouldBe(21418)
            r.txCount.shouldBe(74057)
            r.output.shouldBe("63148817438049616")
            r.fees.shouldBe("16905060417")
            r.activeStake.shouldNotBeNull().shouldBe("21755094259019945")
        }

        it("stakes242").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getActiveStakesForEpoch(242)
            r.shouldNotBeNull()
        }

        it("parameters267").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getEpochParam(267)
            r.shouldNotBeNull()
            r.minFeeA.shouldBe(44)
            r.minFeeB.shouldBe(155381)
            r.maxBlockSize.shouldBe(65536)
            r.maxTxSize.shouldBe(16384)
            r.maxBlockHeaderSize.shouldBe(1100)
            r.keyDeposit.shouldBe("2000000")
            r.poolDeposit.shouldBe("500000000")
            r.eMax.shouldBe(18)
            r.nOpt.shouldBe(500)
            r.a0.shouldBe(0.3f.plusOrMinus(0.00001f))
            r.rho.shouldBe(0.003f.plusOrMinus(0.00001f))
            r.tau.shouldBe(0.2f.plusOrMinus(0.00001f))
            r.decentralisationParam.shouldBe(0.0f.plusOrMinus(0.00001f))
            r.extraEntropy.shouldBeNull()
            r.protocolMajorVer.shouldBe(4)
            r.protocolMinorVer.shouldBe(0)
            r.minUtxo.shouldBe("1000000")
            r.minPoolCost.shouldBe("340000000")
        }

        it("next").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getNextEpochs(242)
            r.shouldNotBeEmpty()
            r.first().epoch.shouldBe(243)
        }

        it("prev").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getPreviousEpochs(242)
            r.shouldNotBeEmpty()
            r.first().epoch.shouldBeLessThan(242)
        }

        it("blocks").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getBlocksForEpoch(242, count = 2)
            r.shouldNotBeEmpty()
        }

        it("blocksAndPool").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getBlocksForEpochAndPool(242, "pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy")
            r.shouldNotBeEmpty()
        }
    }
})