package io.blockfrost.sdk.api

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAtLeastOne
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import org.openapitools.client.api.IPFSAddApi
import org.openapitools.client.api.IPFSGatewayApi
import org.openapitools.client.api.IPFSPinsApi
import org.openapitools.client.infrastructure.BlockfrostConfig
import java.io.File
import kotlin.properties.Delegates
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class IpfsTest : DescribeSpec({
    var apiAdd: IPFSAddApi by Delegates.notNull()
    var apiPin: IPFSPinsApi by Delegates.notNull()
    var apiGw: IPFSGatewayApi by Delegates.notNull()
    val tmpFileData = "<svg id=\"Layer_1\" data-name=\"Layer 1\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 620.62 119.79\"><defs><style>.cls-1{fill:#51bcef;}.cls-2{fill:#0a60dd;}</style></defs><title>blockfrost logo</title><path class=\"cls-1\" d=\"M100.07,83a3.93,3.93,0,0,1-3.92,3.92H26a3.92,3.92,0,1,1,0-7.83h70.2A3.91,3.91,0,0,1,100.07,83Z\"/><path class=\"cls-1\" d=\"M80.49,96a3.93,3.93,0,0,1-3.92,3.91h-31a3.92,3.92,0,1,1,0-7.83h31A3.92,3.92,0,0,1,80.49,96Z\"/><path class=\"cls-1\" d=\"M65.08,53.89A3.91,3.91,0,0,1,61.51,56a3.83,3.83,0,0,1-1.67-.4l-22-10.93V74H30V40a7.66,7.66,0,0,1,.35-2.4A6.61,6.61,0,0,1,31,36.33,3.92,3.92,0,0,1,36,35.06l6.13,3L63.3,48.65A3.93,3.93,0,0,1,65.08,53.89Z\"/><path class=\"cls-2\" d=\"M91.34,36.63a.42.42,0,0,0,0-.1c0-.08-.09-.15-.14-.23s-.16-.28-.25-.42l0,0A7.64,7.64,0,0,0,88,33.26L63.38,21.08a5.15,5.15,0,0,0-4.59,0L34.24,33.26A7.5,7.5,0,0,0,31,36.33,3.91,3.91,0,0,1,36,35.07l6.13,3,19-9.42L79.6,37.87,59.42,47.79a3.92,3.92,0,0,0-2.24,3.54V74H65V54.15a.54.54,0,0,1,.31-.49l19-9.37V74h7.84V40A7.5,7.5,0,0,0,91.34,36.63Z\"/><path class=\"cls-2\" d=\"M157.55,68.07a9,9,0,0,1-2.92,3.3,13.44,13.44,0,0,1-4.57,2,24.57,24.57,0,0,1-5.91.66H125.82V35.43h17.89q5.94,0,9.32,2.7a8.84,8.84,0,0,1,3.39,7.28v.11a9.58,9.58,0,0,1-.41,2.92,9.16,9.16,0,0,1-1.1,2.29,8.53,8.53,0,0,1-1.59,1.79,10.07,10.07,0,0,1-1.94,1.32,13.09,13.09,0,0,1,5.27,3.45,8.81,8.81,0,0,1,1.92,6v.11A10,10,0,0,1,157.55,68.07ZM148,46.84a3.43,3.43,0,0,0-1.43-3,7.11,7.11,0,0,0-4.14-1h-8.38V51h7.83a8.87,8.87,0,0,0,4.46-1A3.32,3.32,0,0,0,148,47Zm2.15,15.44a3.64,3.64,0,0,0-1.49-3.06,8,8,0,0,0-4.8-1.13h-9.81v8.49h10.09a8.18,8.18,0,0,0,4.41-1,3.49,3.49,0,0,0,1.6-3.17Z\"/><path class=\"cls-2\" d=\"M173.89,74V35.43h8.49V66.36h19.24V74Z\"/><path class=\"cls-2\" d=\"M254,62.47a19.74,19.74,0,0,1-10.77,10.64A21.24,21.24,0,0,1,235,74.68a21,21,0,0,1-8.21-1.57,20.51,20.51,0,0,1-6.48-4.24,19,19,0,0,1-4.24-6.29,19.79,19.79,0,0,1-1.52-7.74v-.11A19.5,19.5,0,0,1,216.12,47a19.74,19.74,0,0,1,10.77-10.64,22.36,22.36,0,0,1,16.46,0,20.37,20.37,0,0,1,6.48,4.25,19,19,0,0,1,4.24,6.28,19.84,19.84,0,0,1,1.52,7.75v.11A19.45,19.45,0,0,1,254,62.47Zm-7.33-7.74a12.84,12.84,0,0,0-.85-4.69,11.71,11.71,0,0,0-2.43-3.86,11.87,11.87,0,0,0-3.72-2.62,12.1,12.1,0,0,0-9.4,0,10.66,10.66,0,0,0-3.64,2.59A12.21,12.21,0,0,0,224.3,50a12.61,12.61,0,0,0-.85,4.66v.11a12.83,12.83,0,0,0,.85,4.68,11.61,11.61,0,0,0,2.43,3.86,11.81,11.81,0,0,0,3.69,2.62,11.33,11.33,0,0,0,4.71,1,11.69,11.69,0,0,0,4.69-.93,11,11,0,0,0,3.67-2.59,12.26,12.26,0,0,0,2.37-3.84,12.59,12.59,0,0,0,.85-4.65Z\"/><path class=\"cls-2\" d=\"M302.22,70.66a18.33,18.33,0,0,1-3.5,2.17,17.83,17.83,0,0,1-4.16,1.38,25.28,25.28,0,0,1-5.07.47,20,20,0,0,1-7.89-1.54,19.45,19.45,0,0,1-6.28-4.22,19.24,19.24,0,0,1-4.13-6.31,20.21,20.21,0,0,1-1.49-7.77v-.11a20.08,20.08,0,0,1,5.62-14.09,19.18,19.18,0,0,1,6.34-4.3,20.58,20.58,0,0,1,8.16-1.57,25.82,25.82,0,0,1,4.93.44,20.49,20.49,0,0,1,4.05,1.22,16.93,16.93,0,0,1,3.37,1.87A23.75,23.75,0,0,1,305,40.72L299.63,47a20.41,20.41,0,0,0-4.6-3.19,11.79,11.79,0,0,0-5.27-1.16,10.69,10.69,0,0,0-4.49.94,10.54,10.54,0,0,0-3.56,2.59A12.06,12.06,0,0,0,279.4,50a13,13,0,0,0-.83,4.66v.11a13.25,13.25,0,0,0,.83,4.68,12.12,12.12,0,0,0,2.29,3.86,10.59,10.59,0,0,0,8.07,3.58,11.83,11.83,0,0,0,5.6-1.21,21.9,21.9,0,0,0,4.55-3.31l5.4,5.46A27.53,27.53,0,0,1,302.22,70.66Z\"/><path class=\"cls-2\" d=\"M345.27,74l-12-16.43-4.46,4.63V74h-8.49V35.43h8.49V52.3L344.5,35.43h10.25L339,51.8,355.47,74Z\"/><path class=\"cls-2\" d=\"M377.36,43.1v8.32h18.41v7.66H377.36V74h-8.49V35.43h29.38V43.1Z\"/><path class=\"cls-2\" d=\"M436.72,74l-8.26-12.35h-6.67V74H413.3V35.43h17.64q6.88,0,10.72,3.37t3.83,9.37v.11a12.05,12.05,0,0,1-2.29,7.63,13.22,13.22,0,0,1-6,4.33L446.65,74Zm.17-25.41a5,5,0,0,0-1.76-4.14,7.87,7.87,0,0,0-4.91-1.37h-8.43V54.18h8.6a7.06,7.06,0,0,0,4.82-1.49,5,5,0,0,0,1.68-4Z\"/><path class=\"cls-2\" d=\"M499.18,62.47A19.71,19.71,0,0,1,488.4,73.11a22.33,22.33,0,0,1-16.45,0,20.51,20.51,0,0,1-6.48-4.24,19,19,0,0,1-4.24-6.29,19.79,19.79,0,0,1-1.52-7.74v-.11A19.5,19.5,0,0,1,461.25,47a20.1,20.1,0,0,1,4.28-6.34,19.88,19.88,0,0,1,6.5-4.3,22.36,22.36,0,0,1,16.46,0A20.43,20.43,0,0,1,495,40.59a18.91,18.91,0,0,1,4.25,6.28,19.83,19.83,0,0,1,1.51,7.75v.11A19.45,19.45,0,0,1,499.18,62.47Zm-7.33-7.74A12.85,12.85,0,0,0,491,50a11.68,11.68,0,0,0-2.42-3.86,11.87,11.87,0,0,0-3.72-2.62,12.1,12.1,0,0,0-9.4,0,10.56,10.56,0,0,0-3.64,2.59A12.21,12.21,0,0,0,469.44,50a12.61,12.61,0,0,0-.85,4.66v.11a12.83,12.83,0,0,0,.85,4.68,11.68,11.68,0,0,0,6.12,6.48,11.3,11.3,0,0,0,4.71,1,11.72,11.72,0,0,0,4.69-.93,10.82,10.82,0,0,0,3.66-2.59A12.26,12.26,0,0,0,491,59.49a12.6,12.6,0,0,0,.86-4.65Z\"/><path class=\"cls-2\" d=\"M543.4,67.71a10.55,10.55,0,0,1-2.91,3.75,13,13,0,0,1-4.44,2.31,19.38,19.38,0,0,1-5.72.8,25.55,25.55,0,0,1-8.66-1.51A23,23,0,0,1,514,68.4l5-6a25.32,25.32,0,0,0,5.43,3.42,14.59,14.59,0,0,0,6.09,1.26,7.48,7.48,0,0,0,4.11-1,3,3,0,0,0,1.46-2.67v-.11a3.28,3.28,0,0,0-.31-1.47,3.08,3.08,0,0,0-1.16-1.18,12.16,12.16,0,0,0-2.37-1.1c-1-.37-2.33-.75-4-1.16a48.09,48.09,0,0,1-5.3-1.6,14.87,14.87,0,0,1-4-2.18,8.81,8.81,0,0,1-2.57-3.22,11.32,11.32,0,0,1-.91-4.8v-.11a11.18,11.18,0,0,1,1-4.77,10.87,10.87,0,0,1,2.76-3.66,12.48,12.48,0,0,1,4.25-2.37,17.16,17.16,0,0,1,5.45-.83,23,23,0,0,1,7.8,1.27,22.43,22.43,0,0,1,6.53,3.64l-4.41,6.39a27.84,27.84,0,0,0-5.07-2.78,13,13,0,0,0-5-1,6,6,0,0,0-3.72,1,2.94,2.94,0,0,0-1.24,2.4v.11a3.47,3.47,0,0,0,.36,1.63,3.25,3.25,0,0,0,1.3,1.24,12.38,12.38,0,0,0,2.57,1.05c1.09.33,2.46.71,4.12,1.15a40.86,40.86,0,0,1,5.22,1.74A14.75,14.75,0,0,1,541.26,55a9,9,0,0,1,2.38,3.17,10.88,10.88,0,0,1,.8,4.36v.11A12,12,0,0,1,543.4,67.71Z\"/><path class=\"cls-2\" d=\"M577.57,43.26V74h-8.49V43.26H557.34V35.43h32v7.83Z\"/></svg>"
    System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "TRACE")

    describe("ipfs-add"){
        beforeTest {
            apiAdd = IPFSAddApi(config = BlockfrostConfig(
                baseUrl = BlockfrostConfig.UrlIpfs,
                projectId = BlockfrostConfig.getEnvProjectIdIpfs(),
                socketTimeoutMilli = 90_000,
            ))
            apiPin = IPFSPinsApi(config = BlockfrostConfig.defaultIpfsConfig)
            apiGw = IPFSGatewayApi(config = BlockfrostConfig.defaultIpfsConfig)
        }

        it("flow").config(timeout = Duration.Companion.seconds(120)){
            val tempFile = createFileWithContent(tmpFileData.toByteArray())
            val expHash = "QmUCXMTcvuJpwHF3gABRr69ceQR2uEG2Fsik9CyWh8MUoQ"

            val r = apiAdd.add(tmpFileData.toByteArray())
            r.shouldNotBeNull()
            r.ipfsHash.shouldNotBeNull().shouldBe(expHash)
            r.name.shouldNotBeNull().shouldBe(expHash)
            r.size.shouldNotBeNull().shouldBe(5617)

            tempFile.inputStream().use { fis ->
                val r2 = apiAdd.add(tempFile)
                r2.shouldNotBeNull()
                r2.size.shouldNotBeNull().shouldBe(5617)
                r2.ipfsHash.shouldNotBeNull().shouldBe(expHash)
                r2.name.shouldNotBeNull().shouldBe(expHash)
            }

            run {
                val r2 = apiAdd.add(tempFile)
                r2.shouldNotBeNull()
                r2.size.shouldNotBeNull().shouldBe(5617)
                r2.ipfsHash.shouldNotBeNull().shouldBe(expHash)
                r2.name.shouldNotBeNull().shouldBe(expHash)
            }

            val pin = apiPin.pinAdd(r.ipfsHash!!)
            pin.shouldNotBeNull()
            pin.ipfsHash.shouldBe(expHash)

            val pins = apiPin.getPinListAllList()
            pins.shouldNotBeNull()
            pins.shouldNotBeEmpty()
            pins.forAtLeastOne { it.ipfsHash.shouldBe(expHash) }

            val rget = apiGw.get(expHash)
            rget.shouldNotBeNull()
            rget.bytes().shouldBe(tmpFileData.toByteArray())
        }
    }
}) {
    companion object {
        fun createFileWithContent(content: ByteArray): File {
            val tempFile = File.createTempFile("test", "svg")
            tempFile.writeBytes(content)
            return tempFile
        }
    }
}