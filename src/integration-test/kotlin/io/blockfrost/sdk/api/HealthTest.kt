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
import org.openapitools.client.api.CardanoAccountsApi
import org.openapitools.client.api.CardanoAddressesApi
import org.openapitools.client.api.CardanoEpochsApi
import org.openapitools.client.api.HealthApi
import org.openapitools.client.infrastructure.BlockfrostConfig
import org.openapitools.client.models.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.properties.Delegates
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class HealthTest : DescribeSpec({
    val logger: Logger = LoggerFactory.getLogger(javaClass)
    var api: HealthApi by Delegates.notNull()
    System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "TRACE")

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