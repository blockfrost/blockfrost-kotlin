package io.blockfrost.sdk.kotlin.itests

import com.beust.klaxon.JsonObject
import io.blockfrost.sdk.kotlin.api.CardanoTransactionsApi
import io.blockfrost.sdk.kotlin.infrastructure.BadRequestException
import io.blockfrost.sdk.kotlin.infrastructure.BlockfrostConfig
import io.blockfrost.sdk.kotlin.models.TxContentOutputAmount
import io.blockfrost.sdk.kotlin.models.TxContentUtxoAmount
import io.blockfrost.sdk.kotlin.models.TxContentUtxoOutputs
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.floats.plusOrMinus
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import kotlin.properties.Delegates
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class TransactionsTest : DescribeSpec({
    var api: CardanoTransactionsApi by Delegates.notNull()
    System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "INFO")

    describe("transactions"){
        beforeTest {
            api = CardanoTransactionsApi(config = BlockfrostConfig.defaulMainNetConfig)
        }

        it("byHash").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getTransaction("28172ea876c3d1e691284e5179fae2feb3e69d7d41e43f8023dc380115741026")
            r.shouldNotBeNull()
            r.block.shouldBe("e6369fee087d31192016b1659f1c381e9fc4925339278a4eef6f340c96c1947f")
            r.blockHeight.shouldBe(5040611)
            r.index.shouldBe(0)
            r.outputAmount.shouldBe(listOf(TxContentOutputAmount("lovelace", "701374004958")))
            r.fees.shouldBe("874781")
            r.deposit.shouldBe("0")
            r.propertySize.shouldBe(16346)
            r.invalidBefore.shouldBe(null)
            r.invalidHereafter.shouldBe("15657684")
            r.utxoCount.shouldBe(80)
            r.withdrawalCount.shouldBe(0)
            r.delegationCount.shouldBe(0)
            r.stakeCertCount.shouldBe(0)
            r.poolUpdateCount.shouldBe(0)
            r.poolRetireCount.shouldBe(0)
        }

        it("utxos").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getTransactionUtxos("927edb96f3386ab91b5f5d85d84cb4253c65b1c2f65fa7df25f81fab1d62987a")
            r.shouldNotBeNull()
            r.hash.shouldBe("927edb96f3386ab91b5f5d85d84cb4253c65b1c2f65fa7df25f81fab1d62987a")
            r.inputs.shouldBe(emptyList())
            r.outputs.shouldBe(listOf(
                TxContentUtxoOutputs("Ae2tdPwUPEZ9vtyppa1FdJzvqJZkEcXgdHxVYAzTWcPaoNycVq5rc36LC1S", listOf(
                    TxContentUtxoAmount("lovelace", "538861000000")
                ))
            ))
        }

        it("withdrawals").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getTransactionWithdrawals("9f811b021492a5544207f7b566b4e67c87f0918b9e7055ab3074d552ab18e895")
            r.shouldNotBeNull()
            r.shouldNotBeEmpty()
            r.size.shouldBe(1)
            r.forEach { it.shouldNotBeNull() }
            r[0].address.shouldBe("stake1ux77thpfertrfhkq3tlmssucn30ddvvn3s9fhvkvx7dd3msgmxve0")
            r[0].amount.shouldBe("7911187966")
        }

        it("mirs").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getTransactionMirs("7b57f2cf1c442c563647ab29669c88b9116c2668d31d42526ff27ed614da1252")
            r.shouldNotBeNull()
            r.shouldNotBeEmpty()
            r.forEach { it.shouldNotBeNull() }
        }

        it("delegations").config(timeout = Duration.Companion.seconds(30)) {
            val r = api.getTransactionDelegations("c2120581050a1116ab38a5ac8a62d64df4cf12cf3370d22337201d36eb65fcc4")
            r.shouldNotBeNull()
            r.shouldNotBeEmpty()
            r.forEach { it.shouldNotBeNull() }
            r.size.shouldBe(1)
            r[0].certIndex.shouldBe(1)
            r[0].address.shouldBe("stake1uyhk4jwrrp683w8n9hutkddr0nns4nuun04m2x3a6v0s9cck0z4k9")
            r[0].poolId.shouldBe("pool1zgxvcqf0dvh0ze56ev2ayjvuex3zdd3hgxzdrcezkx497mv3l7s")
        }

        it("pool updates").config(timeout = Duration.Companion.seconds(30)) {
            val r = api.getTransactionPoolUpdates("28bd5e8c342ab89d6642e446cb299058ea36256af1718e4af9326898ce4192d7")
            r.shouldNotBeNull()
            r.shouldNotBeEmpty()
            r.forEach { it.shouldNotBeNull() }
            r.size.shouldBe(2)

            r[0].certIndex.shouldBe(0)
            r[0].poolId.shouldBe("pool1kchver88u3kygsak8wgll7htr8uxn5v35lfrsyy842nkscrzyvj")
            r[0].vrfKey.shouldBe("b4506cbdf5faeeb7bc771d0c17eea2e7e94749ec5a63e78a42d9ed8aad6baae5")
            r[0].pledge.shouldBe("100000000000")
            r[0].marginCost.shouldBe(0.018f.plusOrMinus(0.00001f))
            r[0].fixedCost.shouldBe("340000000")
            r[0].rewardAccount.shouldBe("stake1u97v0sjx96u5lydjfe2g5qdwkj6plm87h80q5vc0ma6wjpq22mh4c")
            r[0].owners.shouldBe(listOf("stake1ux69nctlngdhx99a6w8hrtexu89p9prqk8vmseg9qmmquyqhuns53"))

            @Suppress("UNCHECKED_CAST")
            val meta0: Map<String, Any?> = r[0].metadata as? Map<String, Any?> ?: throw RuntimeException("Could not get metadata")
            (meta0.getOrDefault("url", null) as? String?).shouldNotBeNull().shouldBe("https://stakhanovite.io/cardano/stkh-1.json")
            (meta0.getOrDefault("hash", null) as? String?).shouldNotBeNull().shouldBe("0f519c0478527c6fd05556ecb31fafe9e5a6b9861fac96f5935381b3e328ee5d")
            (meta0.getOrDefault("ticker", null) as? String?).shouldNotBeNull()
            (meta0.getOrDefault("description", null) as? String?).shouldNotBeNull()
            (meta0.getOrDefault("homepage", null) as? String?).shouldNotBeNull()

            r[0].relays.shouldNotBeNull()
            r[0].relays.shouldNotBeEmpty()

            @Suppress("UNCHECKED_CAST")
            val r0 = r[0].relays[0] as? Map<String, Any?> ?: throw RuntimeException("Could not get relays")
            (r0.getOrDefault("ipv4", null) as? String?).shouldBeNull()
            (r0.getOrDefault("ipv6", null) as? String?).shouldBeNull()
            (r0.getOrDefault("dns", null) as? String?).shouldNotBeNull().shouldBe("cardano-relay.stakhanovite.io")
            (r0.getOrDefault("dns_srv", null) as? String?).shouldBeNull()
            (r0.getOrDefault("port", null) as? Number?)?.toInt().shouldNotBeNull().shouldBe(7001)

            r[1].certIndex.shouldBe(1)
            r[1].poolId.shouldBe("pool1s7t7mfc89syw93h07aammaccnua66yn6d4l0mqt7zqurz2mczvq")
            r[1].vrfKey.shouldBe("f399304ca66731d66b739e4df6a94f32ab10b34450fb21b03720d2c1d45d59d2")
            r[1].pledge.shouldBe("10000000000")
            r[1].marginCost.shouldBe(0.018f.plusOrMinus(0.00001f))
            r[1].fixedCost.shouldBe("340000000")
            r[1].rewardAccount.shouldBe("stake1u97v0sjx96u5lydjfe2g5qdwkj6plm87h80q5vc0ma6wjpq22mh4c")
            r[1].owners.shouldBe(listOf("stake1uxclfpuwmmsdxjtqy7ee845246xlk6k4r5rxj6sexsh8caqf2z5dm"))

            @Suppress("UNCHECKED_CAST")
            val meta1: Map<String, Any?> = r[1].metadata as? Map<String, Any?> ?: throw RuntimeException("Could not get metadata")
            (meta1.getOrDefault("url", null) as? String?).shouldNotBeNull().shouldBe("https://stakhanovite.io/cardano/stkh-2.json")
            (meta1.getOrDefault("hash", null) as? String?).shouldNotBeNull().shouldBe("11171d873f8f5b704552111d75b629f840b1c3399b49d9642cf12970031583b7")
            (meta1.getOrDefault("ticker", null) as? String?).shouldBeNull()
            (meta1.getOrDefault("description", null) as? String?).shouldBeNull()
            (meta1.getOrDefault("homepage", null) as? String?).shouldBeNull()

            @Suppress("UNCHECKED_CAST")
            val r1 = r[1].relays[0] as? Map<String, Any?> ?: throw RuntimeException("Could not get relays")
            (r1.getOrDefault("ipv4", null) as? String?).shouldBeNull()
            (r1.getOrDefault("ipv6", null) as? String?).shouldBeNull()
            (r1.getOrDefault("dns", null) as? String?).shouldNotBeNull().shouldBe("cardano-relay.stakhanovite.io")
            (r1.getOrDefault("dns_srv", null) as? String?).shouldBeNull()
            (r1.getOrDefault("port", null) as? Number?)?.toInt().shouldNotBeNull().shouldBe(7001)
        }

        it("stakes").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getTransactionStakes("c2120581050a1116ab38a5ac8a62d64df4cf12cf3370d22337201d36eb65fcc4")
            r.shouldNotBeNull()
            r.shouldNotBeEmpty()
            r.size.shouldBe(1)
            r.forEach { it.shouldNotBeNull() }
            r[0].certIndex.shouldBe(0)
            r[0].address.shouldBe("stake1uyhk4jwrrp683w8n9hutkddr0nns4nuun04m2x3a6v0s9cck0z4k9")
            r[0].registration.shouldBe(true)
        }

        it("pool retires").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getTransactionPoolRetires("33770d42c7bc8a9a0bc9830ffb97941574dc61dc534796dd8614b99b6aadace4")
            r.shouldNotBeNull()
            r.shouldNotBeEmpty()
            r.size.shouldBe(1)
            r.forEach { it.shouldNotBeNull() }
            r[0].certIndex.shouldBe(0)
            r[0].poolId.shouldBe("pool1g36eg8e6tr6sur6y3cfpd8lglny3axh6pgka3acpnfyh22svdth")
            r[0].retiringEpoch.shouldBe(236)
        }

        it("metadata").config(timeout = Duration.Companion.seconds(40)){
            val r = api.getTransactionMetadata("e641005803337a553a03cf3c11a1819491a629bd7d0a3c39e4866a01b5dac36d")
            r.shouldNotBeNull()
            r.shouldNotBeEmpty()
            r.size.shouldBe(1)
            r.forEach { it.shouldNotBeNull() }
            r[0].label.shouldBe("1968")

            r[0].jsonMetadata.shouldBe(TestUtils.parseJson("""{"TSLA": [{"value": "865.85", "source": "investorsExchange"}], "DRAND": {"round": 492700, "randomness": "22966996b523a4726c3df9d7b8bae50230ef08a7452c53d64eacc2dad632afc5"}, "ADABTC": [{"value": "7.96e-06", "source": "coinGecko"}], "ADAEUR": [{"value": "0.260806", "source": "coinGecko"}], "ADAUSD": [{"value": "0.318835", "source": "coinGecko"}, {"value": "0.32190816861292343", "source": "ergoOracles"}], "AGIBTC": [{"value": "0.077643", "source": "coinGecko"}], "BTCUSD": [{"value": "40088", "source": "coinGecko"}], "ERGUSD": [{"value": "0.573205", "source": "coinGecko"}, {"value": "0.5728722202262749", "source": "ergoOracles"}], "BTCDIFF": [{"value": "20607418304385.63", "source": "blockBook"}]}""".trimIndent()) as JsonObject)
            r[0].jsonMetadata.shouldNotBe(TestUtils.parseJson("""{"TSLA": [{"value": "865.85", "source": "investxrsExchange"}], "DRAND": {"round": 492700, "randomness": "22966996b523a4726c3df9d7b8bae50230ef08a7452c53d64eacc2dad632afc5"}, "ADABTC": [{"value": "7.96e-06", "source": "coinGecko"}], "ADAEUR": [{"value": "0.260806", "source": "coinGecko"}], "ADAUSD": [{"value": "0.318835", "source": "coinGecko"}, {"value": "0.32190816861292343", "source": "ergoOracles"}], "AGIBTC": [{"value": "0.077643", "source": "coinGecko"}], "BTCUSD": [{"value": "40088", "source": "coinGecko"}], "ERGUSD": [{"value": "0.573205", "source": "coinGecko"}, {"value": "0.5728722202262749", "source": "ergoOracles"}], "BTCDIFF": [{"value": "20607418304385.63", "source": "blockBook"}]}""".trimIndent()) as JsonObject)
        }

        it("submit").config(timeout = Duration.Companion.seconds(10)){
            val dummyTx = "33770d42c7bc8a9a0bc9830ffb97941574dc61dc534796dd8614b99b6aadace4"
            shouldThrowExactly<BadRequestException> {
                api.submitTransaction(dummyTx.toByteArray())
            }
        }
    }
})