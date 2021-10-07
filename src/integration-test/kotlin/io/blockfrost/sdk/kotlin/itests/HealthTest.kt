package io.blockfrost.sdk.kotlin.itests

import io.blockfrost.sdk.kotlin.api.HealthApi
import io.blockfrost.sdk.kotlin.infrastructure.BlockfrostConfig
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import kotlin.properties.Delegates
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class HealthTest : DescribeSpec({
    var api: HealthApi by Delegates.notNull()
    System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "INFO")

    describe("health"){
        beforeTest {
            api = HealthApi(config = BlockfrostConfig.defaulMainNetConfig)
        }

        it("root").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getApiRoot()
            r.shouldNotBeNull()
        }

        it("getHealth").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getHealth()
            r.shouldNotBeNull()
            r.isHealthy.shouldBe(true)
        }

        it("clock").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getCurrentBackendTime()
            r.shouldNotBeNull()
        }
    }
})