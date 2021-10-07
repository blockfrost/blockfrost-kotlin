package io.blockfrost.sdk_kotlin.itests

import io.blockfrost.sdk_kotlin.api.MetricsApi
import io.blockfrost.sdk_kotlin.infrastructure.BlockfrostConfig
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import kotlin.properties.Delegates
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class MetricsTest : DescribeSpec({
    var api: MetricsApi by Delegates.notNull()
    System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "INFO")

    describe("metrics"){
        beforeTest {
            api = MetricsApi(config = BlockfrostConfig.defaulMainNetConfig)
        }

        it("get").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getMetrics()
            r.shouldNotBeNull()
        }

        it("endpoints").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getMetricsEndpoints()
            r.shouldNotBeNull()
        }
    }
})