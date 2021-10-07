package io.blockfrost.sdk_kotlin.itests

import io.blockfrost.sdk_kotlin.api.CardanoAssetsApi
import io.blockfrost.sdk_kotlin.infrastructure.BlockfrostConfig
import io.blockfrost.sdk_kotlin.models.AssetHistory
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.maps.shouldContainExactly
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldNotBeBlank
import kotlin.properties.Delegates
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class AssetsTest : DescribeSpec({
    var api: CardanoAssetsApi by Delegates.notNull()
    System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "INFO")

    describe("load assets"){
        beforeTest {
            api = CardanoAssetsApi(config = BlockfrostConfig.defaulMainNetConfig)
        }

        it("all").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getAssets()
            r.shouldNotBeNull()
        }

        it("by id").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getAsset("b863bc7369f46136ac1048adb2fa7dae3af944c3bbb2be2f216a8d4f42657272795361707068697265")
            r.shouldNotBeNull()
            r.asset.shouldBe("b863bc7369f46136ac1048adb2fa7dae3af944c3bbb2be2f216a8d4f42657272795361707068697265")
            r.assetName.shouldBe("42657272795361707068697265")
            r.fingerprint.shouldBe("asset1hwnpal5vap799t6kkjmjf6myhse4zl2vu4ahzz")
            r.initialMintTxHash.shouldBe("6556b532acf59835084f62d30675f3a55b78c61959bca44a86ea02c320fbf822")
            r.metadata.shouldBeNull()
            r.mintOrBurnCount.shouldBe(1)
            r.onchainMetadata.shouldNotBeNull()
            r.onchainMetadata!!.shouldContainExactly(mapOf(
                "color" to "#0F52BA",
                "image" to "ipfs://ipfs/QmWxK9BvEbLGFZuQHL8zbHXSv469JrqnX3kUcZafjsoka4",
                "name" to "Berry Sapphire",
            ))
            r.policyId.shouldBe("b863bc7369f46136ac1048adb2fa7dae3af944c3bbb2be2f216a8d4f")
            r.quantity.shouldBe("1")
        }

        it("history").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getAssetHistory("00000002df633853f6a47465c9496721d2d5b1291b8398016c0e87ae6e7574636f696e")
            r.shouldNotBeEmpty()
            r.shouldContainExactly(
                AssetHistory(txHash = "e252be4c7e40d35919f741c9649ff207c3e49d53bb819e5c1cb458055fd363ed", action = AssetHistory.Action.minted, amount = "1"),
            )
        }

        it("historyAll").config(timeout = Duration.Companion.seconds(120)){
            val r = api.getAssetHistoryAllList("d894897411707efa755a76deb66d26dfd50593f2e70863e1661e98a07370616365636f696e73")
            r.shouldNotBeEmpty()
            r.size.shouldBeGreaterThan(2320)
            r.forEach {
                it.txHash.shouldNotBeBlank()
                it.amount.shouldNotBeBlank()
            }
        }

        it("transactions").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getAssetTransactions("00000002df633853f6a47465c9496721d2d5b1291b8398016c0e87ae6e7574636f696e")
            r.shouldNotBeEmpty()
        }

        it("addresses").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getAssetAddresses("00000002df633853f6a47465c9496721d2d5b1291b8398016c0e87ae6e7574636f696e")
            r.shouldNotBeEmpty()
        }

        it("policy").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getPolicyAssets("b863bc7369f46136ac1048adb2fa7dae3af944c3bbb2be2f216a8d4f")
            r.shouldNotBeEmpty()
        }
    }
})