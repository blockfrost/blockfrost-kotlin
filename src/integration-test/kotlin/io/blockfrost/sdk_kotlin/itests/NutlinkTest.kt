package io.blockfrost.sdk_kotlin.itests

import com.beust.klaxon.JsonArray
import io.blockfrost.sdk_kotlin.api.NutLinkApi
import io.blockfrost.sdk_kotlin.infrastructure.BlockfrostConfig
import io.blockfrost.sdk_kotlin.models.NutlinkAddress
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import kotlin.properties.Delegates
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class NutlinkTest : DescribeSpec({
    var api: NutLinkApi by Delegates.notNull()
    System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "INFO")

    describe("nutlink"){
        beforeTest {
            api = NutLinkApi(config = BlockfrostConfig.defaulMainNetConfig)
        }

        it("address").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getAddress("addr1q85yx2w7ragn5sx6umgmtjpc3865s9sg59sz4rrh6f90kgwfwlzu3w8ttacqg89mkdgwshwnplj5c5n9f8dhp0h55q2q7qm63t")
            r.shouldNotBeNull()
            r.shouldBe(
                NutlinkAddress(
                    address = "addr1q85yx2w7ragn5sx6umgmtjpc3865s9sg59sz4rrh6f90kgwfwlzu3w8ttacqg89mkdgwshwnplj5c5n9f8dhp0h55q2q7qm63t",
                    metadataUrl = "https://nut.link/metadata.json",
                    metadataHash = "9586368825d39caf48bc64b2ca8a8db7bffa9227a5dad8464ce499be4516498f",
                    metadata = mapOf(
                        "ticker" to "NUTS",
                        "name" to "StakeNuts.com",
                        "description" to "StakeNuts nut.link oracle pool",
                        "homepage" to "https://stakenuts.com",
                        "address" to "addr1q85yx2w7ragn5sx6umgmtjpc3865s9sg59sz4rrh6f90kgwfwlzu3w8ttacqg89mkdgwshwnplj5c5n9f8dhp0h55q2q7qm63t"
                    ))
            )
        }

        it("addressTickers").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getAddressTickers("addr1q85yx2w7ragn5sx6umgmtjpc3865s9sg59sz4rrh6f90kgwfwlzu3w8ttacqg89mkdgwshwnplj5c5n9f8dhp0h55q2q7qm63t", count=3)
            r.shouldNotBeNull()
            r.size.shouldBe(3)
            r[0].name.shouldBe("ADABTC")
            r[1].name.shouldBe("ADACAD")
            r[2].name.shouldBe("ADAEUR")
        }

        it("addressTickersAll").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getAddressTickersAllList("addr1q85yx2w7ragn5sx6umgmtjpc3865s9sg59sz4rrh6f90kgwfwlzu3w8ttacqg89mkdgwshwnplj5c5n9f8dhp0h55q2q7qm63t")
            r.shouldNotBeNull()
            r.size.shouldBeGreaterThan(3)
        }

        it("addressTickersByTicker_page2count2").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getTickerRecordsByAddressAndTicker("addr1q85yx2w7ragn5sx6umgmtjpc3865s9sg59sz4rrh6f90kgwfwlzu3w8ttacqg89mkdgwshwnplj5c5n9f8dhp0h55q2q7qm63t", "ADAUSD", count=2, page=2)
            r.shouldNotBeNull()
            r.shouldNotBeEmpty()
            r.size.shouldBe(2)
            r.forEach { it.shouldNotBeNull() }

            r[0].txHash.shouldBe("1abe80dc1f101ff3b76659d32b532d53b21d76c98cfce0c0c3c45957680c54ff")
            r[0].blockHeight.shouldBe(4925818)
            r[0].txIndex.shouldBe(1)
            r[0].payload.shouldNotBeNull()
            r[0].payload.shouldBe(
                TestUtils.parseJson(
                    """[[
                { "value": "0.10547", "source": "coinGecko" },
                { "value": "0.10663800237162917", "source": "ergoOracles" }
            ]]"""
                ) as JsonArray<*>)

            r[1].txHash.shouldBe("b8cc8d75ca200555ca4efdf79599a06300c2a28ffbaa82fd23f22c8f95967bf9")
            r[1].blockHeight.shouldBe(4925982)
            r[1].txIndex.shouldBe(1)
            r[1].payload.shouldNotBeNull()
            r[1].payload.shouldBe(
                TestUtils.parseJson(
                    """[[
                { "value": "0.106359", "source": "coinGecko" },
                { "value": "0.10575249137006794", "source": "ergoOracles" }
            ]]"""
                ) as JsonArray<*>)
        }


        it("tickers_page2_count2").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getTickerRecordsByTicker("ADAUSD", count=2, page=2)
            r.shouldNotBeNull()
            r.shouldNotBeEmpty()
            r.size.shouldBe(2)
            r.forEach { it.shouldNotBeNull() }

            r[0].txHash.shouldBe("1abe80dc1f101ff3b76659d32b532d53b21d76c98cfce0c0c3c45957680c54ff")
            r[0].blockHeight.shouldBe(4925818)
            r[0].txIndex.shouldBe(1)
            r[0].payload.shouldNotBeNull()
            r[0].payload.shouldBe(
                TestUtils.parseJson(
                    """[[
                { "value": "0.10547", "source": "coinGecko" },
                { "value": "0.10663800237162917", "source": "ergoOracles" }
            ]]"""
                ) as JsonArray<*>)

            r[1].txHash.shouldBe("b8cc8d75ca200555ca4efdf79599a06300c2a28ffbaa82fd23f22c8f95967bf9")
            r[1].blockHeight.shouldBe(4925982)
            r[1].txIndex.shouldBe(1)
            r[1].payload.shouldNotBeNull()
            r[1].payload.shouldBe(
                TestUtils.parseJson(
                    """[[
                { "value": "0.106359", "source": "coinGecko" },
                { "value": "0.10575249137006794", "source": "ergoOracles" }
            ]]"""
                ) as JsonArray<*>)
        }
    }
})