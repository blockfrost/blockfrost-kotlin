package io.blockfrost.sdk_kotlin.itests

import io.blockfrost.sdk_kotlin.api.CardanoAddressesApi
import io.blockfrost.sdk_kotlin.infrastructure.BlockfrostConfig
import io.blockfrost.sdk_kotlin.models.AddressContent
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import kotlin.properties.Delegates
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class AddressesTest : DescribeSpec({
    var api: CardanoAddressesApi by Delegates.notNull()
    System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "INFO")

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