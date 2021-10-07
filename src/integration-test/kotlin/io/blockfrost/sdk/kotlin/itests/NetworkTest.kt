package io.blockfrost.sdk.kotlin.itests

import io.blockfrost.sdk.kotlin.api.CardanoNetworkApi
import io.blockfrost.sdk.kotlin.infrastructure.BlockfrostConfig
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import kotlin.properties.Delegates
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class NetworkTest : DescribeSpec({
    var api: CardanoNetworkApi by Delegates.notNull()
    System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "INFO")

    describe("network"){
        beforeTest {
            api = CardanoNetworkApi(config = BlockfrostConfig.defaulMainNetConfig)
        }

        it("get").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getNetwork()
            r.shouldNotBeNull()
        }
    }
})