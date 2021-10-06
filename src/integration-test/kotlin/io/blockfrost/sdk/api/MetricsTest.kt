package io.blockfrost.sdk.api

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.doubles.plusOrMinus
import io.kotest.matchers.floats.plusOrMinus
import io.kotest.matchers.ints.shouldBeLessThan
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import org.openapitools.client.api.*
import org.openapitools.client.infrastructure.BlockfrostConfig
import org.openapitools.client.models.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.properties.Delegates
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class MetricsTest : DescribeSpec({
    val logger: Logger = LoggerFactory.getLogger(javaClass)
    var api: MetricsApi by Delegates.notNull()
    System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "TRACE")

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