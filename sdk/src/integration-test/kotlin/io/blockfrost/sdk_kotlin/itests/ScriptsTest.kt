package io.blockfrost.sdk_kotlin.itests

import io.blockfrost.sdk_kotlin.api.CardanoScriptsApi
import io.blockfrost.sdk_kotlin.infrastructure.BlockfrostConfig
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.nulls.shouldNotBeNull
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

        var scriptHash = ""

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