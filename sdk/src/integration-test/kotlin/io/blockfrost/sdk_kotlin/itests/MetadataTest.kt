package io.blockfrost.sdk_kotlin.itests

import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import io.blockfrost.sdk_kotlin.api.CardanoMetadataApi
import io.blockfrost.sdk_kotlin.infrastructure.BlockfrostConfig
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.maps.shouldContainKeys
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldNotBeBlank
import kotlin.properties.Delegates
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class MetadataTest : DescribeSpec({
    var api: CardanoMetadataApi by Delegates.notNull()
    System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "INFO")

    describe("metadata"){
        beforeTest {
            api = CardanoMetadataApi(config = BlockfrostConfig.defaulMainNetConfig)
        }

        it("labels").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getTransactionMetadataLabels()
            r.shouldNotBeNull()
            r.forEach { it.shouldNotBeNull() }
        }

        it("txsLabelCbor").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getTransactionMetadataCborForLabel("1968")
            r.shouldNotBeNull()
            r.first().cborMetadata.shouldNotBeNull().shouldNotBeBlank()
        }

        it("txsLabel").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getTransactionMetadataJsonForLabel("1968")
            r.shouldNotBeNull()
            val f = r.first()
            f.shouldNotBeNull()
            f.jsonMetadata.shouldNotBeNull()
            f.txHash.shouldBe("473a6f5ef23c8f9ea10e6d17372ee90031f44273fb2be6700673269bdd04eb19")

            val js = f.jsonMetadata as? JsonObject
            js.shouldNotBeNull()
            js.shouldContainKeys("TSLA", "ADAEUR", "ADAUSD")

            val res = javaClass.classLoader.getResource("metadataTxsLabel1968.json")
            val sb = kotlin.text.StringBuilder(res?.readText() ?: throw RuntimeException("Could not read expected response"))
            val jsExcp = Parser.default().parse(sb) as JsonArray<*>
            jsExcp.shouldNotBeNull()

            r.size.shouldBe(jsExcp.size)
            r.forEachIndexed { idx, srcEl ->
                val expEl = jsExcp[idx] as JsonObject
                srcEl.txHash.shouldBe(expEl.string("tx_hash"))
                srcEl.jsonMetadata.shouldBe(expEl.obj("json_metadata"))
            }
        }
    }
})