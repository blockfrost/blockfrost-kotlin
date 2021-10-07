package io.blockfrost.sdk.api

import com.beust.klaxon.JsonArray
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import org.openapitools.client.api.CardanoScriptsApi
import org.openapitools.client.api.NutLinkApi
import org.openapitools.client.infrastructure.BlockfrostConfig
import org.openapitools.client.models.NutlinkAddress
import kotlin.properties.Delegates
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class ScriptsTest : DescribeSpec({
    var api: CardanoScriptsApi by Delegates.notNull()
    System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "INFO")

    describe("scripts"){
        beforeTest {
            api = CardanoScriptsApi(config = BlockfrostConfig.defaulMainNetConfig)
        }

        var scriptHash: String = ""

        it("all").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getScripts(count = 10)
            r.shouldNotBeNull()
            r.forEach {
                it.shouldNotBeNull()
                it.scriptHash.shouldNotBeNull()
            }

            scriptHash = r.first().scriptHash
        }

        it("getByHash").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getScript(scriptHash)
            r.shouldNotBeNull()
        }

        it("getRedeemers").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getScriptRedeemers(scriptHash)
            r.shouldNotBeNull()
        }
    }
})