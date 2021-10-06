package io.blockfrost.sdk.api

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import org.openapitools.client.api.CardanoAccountsApi
import org.openapitools.client.api.CardanoAddressesApi
import org.openapitools.client.infrastructure.BlockfrostConfig
import org.openapitools.client.models.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.properties.Delegates
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class AddressesTest : DescribeSpec({
    val logger: Logger = LoggerFactory.getLogger(javaClass)
    var api: CardanoAddressesApi by Delegates.notNull()
    System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "TRACE")

    describe("load address"){
        beforeTest {
            api = CardanoAddressesApi(config = BlockfrostConfig.defaulMainNetConfig)
        }

        it("addresses").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getAddress("addr1q8zu4smzyf2r2mfqjd6tc6vxf2p8rccdfk82ye3eut2udkw9etpkygj5x4kjpym5h35cvj5zw83s6nvw5fnrnck4cmvshkfm4y")
            r.shouldNotBeNull()
            r.address.shouldBe("addr1q8zu4smzyf2r2mfqjd6tc6vxf2p8rccdfk82ye3eut2udkw9etpkygj5x4kjpym5h35cvj5zw83s6nvw5fnrnck4cmvshkfm4y")
            r.type.shouldBe(AddressContent.Type.shelley)
            r.amount.shouldNotBeEmpty()
            r.amount.first().unit.shouldBe("lovelace")
        }

        it("details").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getAddressDetails("addr1q8zu4smzyf2r2mfqjd6tc6vxf2p8rccdfk82ye3eut2udkw9etpkygj5x4kjpym5h35cvj5zw83s6nvw5fnrnck4cmvshkfm4y")
            r.shouldNotBeNull()
            r.address.shouldBe("addr1q8zu4smzyf2r2mfqjd6tc6vxf2p8rccdfk82ye3eut2udkw9etpkygj5x4kjpym5h35cvj5zw83s6nvw5fnrnck4cmvshkfm4y")
        }

        it("utxos").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getAddressUtxos("addr1q8zu4smzyf2r2mfqjd6tc6vxf2p8rccdfk82ye3eut2udkw9etpkygj5x4kjpym5h35cvj5zw83s6nvw5fnrnck4cmvshkfm4y")
            r.shouldBeEmpty()
        }

        it("txs").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getAddressTransactions("addr1q8zu4smzyf2r2mfqjd6tc6vxf2p8rccdfk82ye3eut2udkw9etpkygj5x4kjpym5h35cvj5zw83s6nvw5fnrnck4cmvshkfm4y")
            r.shouldNotBeEmpty()
        }
    }
})