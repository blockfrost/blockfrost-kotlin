package io.blockfrost.sdk.api

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldNotBeBlank
import org.openapitools.client.api.CardanoBlocksApi
import org.openapitools.client.infrastructure.BlockfrostConfig
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.properties.Delegates
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class BlockTest : DescribeSpec({
    val logger: Logger = LoggerFactory.getLogger(javaClass)
    var api: CardanoBlocksApi by Delegates.notNull()
    System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "TRACE")

    describe("blocks"){
        beforeTest {
            api = CardanoBlocksApi(config = BlockfrostConfig.defaulMainNetConfig)
        }

        it("getLatest").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getLatestBlock()
            r.shouldNotBeNull()
            r.height.shouldNotBeNull().shouldBeGreaterThan(6276800)
            r.time.shouldNotBeNull().shouldBeGreaterThan(1632309616)
            r.epoch.shouldNotBeNull().shouldBeGreaterThan(291)
            r.hash.shouldNotBeBlank()
        }

        it("slot").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getBlockInSlot(1)
            r.shouldNotBeNull()
            r.height.shouldNotBeNull().shouldBe(2)
            r.slot.shouldNotBeNull().shouldBe(1)
        }

        it("epochSlot").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getBlockInEpochInSlot(0, 1031)
            r.shouldNotBeNull()
            r.height.shouldNotBeNull().shouldBe(1032)
            r.slot.shouldNotBeNull().shouldBe(1031)
            r.epoch.shouldNotBeNull().shouldBe(0)
            r.epochSlot.shouldNotBeNull().shouldBe(1031)
        }

        it("getLatestTxs").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getTransactionsInLatestBlock()
            r.shouldNotBeNull()
            r.forEach { it.shouldNotBeNull() }
        }

        it("getLatestTxsAll").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getTransactionsInLatestBlockAllList()
            r.shouldNotBeNull()
            r.forEach { it.shouldNotBeNull() }
        }

        it("genesis").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getBlock("5f20df933584822601f9e3f8c024eb5eb252fe8cefb24d1317dc3d432e940ebb")
            r.shouldNotBeNull()
            r.time.shouldNotBeNull().shouldBe(1506203091)
            r.height.shouldBeNull()
            r.hash.shouldNotBeNull().shouldBe("5f20df933584822601f9e3f8c024eb5eb252fe8cefb24d1317dc3d432e940ebb")
            r.slot.shouldBeNull()
            r.epoch.shouldBeNull()
            r.epochSlot.shouldBeNull()
            r.slotLeader.shouldBe("Genesis slot leader")
            r.propertySize.shouldBe(0)
            r.txCount.shouldBe(14505)
            r.output.shouldNotBeNull().shouldBe("31112484745000000")
            r.fees.shouldNotBeNull().shouldBe("0")
            r.blockVrf.shouldBeNull()
            r.previousBlock.shouldBeNull()
            r.nextBlock.shouldNotBeNull().shouldBe("89d9b5a5b8ddc8d7e5a6795e9774d97faf1efea59b2caf7eaf9f8c5b32059df4")
        }

        it("previous").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getPreviousBlocks("5360435", count = 1)
            r.shouldNotBeNull()
            val r0 = r.first()

            r0.time.shouldNotBeNull().shouldBe(1613692790)
            r0.height.shouldNotBeNull().shouldBe(5360434)
            r0.hash.shouldNotBeNull().shouldBe("e8b8fd03492a0d2eeb19481e3a46080af271bf7f34a9d29a1fac44ee35414d7e")
            r0.slot.shouldNotBeNull().shouldBe(22126499)
            r0.epoch.shouldNotBeNull().shouldBe(248)
            r0.epochSlot.shouldNotBeNull().shouldBe(353699)
            r0.propertySize.shouldBe(355)
            r0.txCount.shouldBe(1)
            r0.output.shouldNotBeNull().shouldBe("7104352417")
            r0.fees.shouldNotBeNull().shouldBe("172101")
            r0.blockVrf.shouldNotBeNull().shouldBe("vrf_vk1s3hssxtpjdjc9amqn9wqn6dfyzujsv8jrk6pkl4esfpp99v48ujsflsn70")
            r0.previousBlock.shouldNotBeNull().shouldBe("ca74257598fec490fac4303d0e243ee0b4e17c7a0f291597e4a35a89a7624d09")
            r0.nextBlock.shouldNotBeNull().shouldBe("c6e3901b2cd95598b0bf5dc55cb62d682ea369298be9825b4b58d891b844b320")
        }

        it("next").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getNextBlocks("2828500")
            r.shouldNotBeNull()
            val r0 = r.first()
            val r10 = r.get(10)

            r0.time.shouldNotBeNull().shouldBe(1562803711)
            r0.height.shouldNotBeNull().shouldBe(2828501)
            r0.hash.shouldNotBeNull().shouldBe("cf1ef63c5655e1f883f1d3f7a79adc0823434c2a394ed7436e58412a75ed8d01")
            r0.slot.shouldNotBeNull().shouldBe(2830031)
            r0.epoch.shouldNotBeNull().shouldBe(131)
            r0.epochSlot.shouldNotBeNull().shouldBe(431)
            r0.propertySize.shouldBe(1575)
            r0.txCount.shouldBe(2)
            r0.output.shouldNotBeNull().shouldBe("2772474536329")
            r0.fees.shouldNotBeNull().shouldBe("352996")
            r0.previousBlock.shouldNotBeNull().shouldBe("89ee431a3591ea083a4d2c0c29e2f0569a2a63680fbe7fb5ecc4cd53254dcac2")
            r0.nextBlock.shouldNotBeNull().shouldBe("ea4142ae8425eb68bbeaed133f5b80f697d80a56b32fa4f506a1db69c6fd73c5")

            r10.fees.shouldBeNull()
            r10.output.shouldBeNull()
        }

        it("txs").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getBlockTransactions("5360435")
            r.shouldNotBeNull()
            r.shouldContainExactly(
                "055f9d4c86733997a9b8b12e3422feee8ef95d79ccbde20abdb6ff9222bb79c6",
                "e66077bac8d32cf16aa991d793a3e5840d3eee1ad3dfd04f1ee609d46a936dff",
                "70cf3046cd12879a9c36cafeddec17b3b22da619d7998b64c556fd9c70c62903",
                "79993d55b7e49bb588c83d9f19bf03c10fe18e6b52c5684766c436e870921e88",
                "d49776db1423a229fee5403dfc1fc0c6512a1cb0cbc01c4fcd040db82329c125",
                "0672c94a748c8ab06d99496bba73007871eb8d43766dc0c74ed326e0cc3f473c",
                "a14476ee69f5ec35331200e94da50ccad1529aa8ba22d5793f3d0f4fa31e8352",
                "b3ce7f3a4f9d680fc5de83200f436792ed0aec02e8e39bca4c255c5a50100906",
                "2cf6eb3c194d9deb93e5219d4371f2f09fa90af5393b814f939f9b8f393a6889",
                "08ae724058cd840350417153a432ff3d2fad5f8f8469f64742019b36794df519",
                "8ed65e234e2db82a6b67e1982fd6e627b44e9abdce8cfea6d1d05f8bb786d8f5",
                "783aefd86ba442d0574beb81b5d1db6b5c0dca40fa464d893aa5f849403842ba",
                "0f750962b3a039ec1ea5065c98cf083fb737decfb54ba04bdfa2b107fef65b45",
                "4f45923f709234b52b5ddb75f70b37b039519623dbb55da0916773912391fd32",
                "eb27af616f701cdf7ad81b4e9c503b2e26059859fff8b37c0f267272028c24fb",
                "86f77e854e485135878eef867cf98469dc1c5a90ceb9dda33a981ac1dc183b85",
                "8e7cd4e261631ca6b5b0ae588cf7c07617657e3ed563896e8e2c0226b7b7d152",
                "849e2475ec8f2a35bf62d3a8cc70b87326f5509987bbb7e7fc36fb8e9b5c59d5",
                "3f98fca4978cc2ac86380453538b1ab020dfa8aa34506827c7032540d9dc30b2",
                "cfe0a45709522edc07a0725cd7a99d65d5ce8f5b62365d9a3f9660bc79d25202",
                "2a6bb221aac6192e3fdb05a1c82c1c2236fc6b226363021ec8036ff6f9475ed0",
                "b29bd7a9e79345639d359f549bbf0b668d6177c90a105c66186d8b98835d187f",
                "9a5bdc512e9df8b20f486b38a190168c1b84fa250005eac35038019f1fd47039",
                "3e7721720db366599ae5ce53dc3a48b56e1ffaaa2572ae0ad66eb6c8467b8eb7",
            )
        }

        it("txsAll").config(timeout = Duration.Companion.seconds(30)){
            val r = api.getBlockTransactionsAllList("5549919")
            r.shouldNotBeNull()
            r.shouldContainExactly(
                "b54de54c3b5421cb000cfa12f936a1febb83d0bfb6de2a97a752cb21357896c1",
                "eb717eb012577af85b529817e0409483d706aca2834ccc934cd7c7099fa8ee41",
                "1d2f5b17b2251b0fdd76d99ce0bba5b05956e6d0ac75bbc489d307ac9b4c642c",
                "5ac8ed1e71c5cc216f1da4da53afff78288681bcbc34d779b01f20c2f84c356c",
                "db7ac0cdac1f194d712d8a7f6e1f83522ad92bfd3afffffe2548025e4413da1a",
                "29268a05a162f3a4a6ac1e193c82b7e03bcc1e00804958d7eb7f230b337d625e",
                "ae9741624848e99494d6466a357a627fccd11b5964549dcefd0ba4716ab441ef",
                "a79577db384b317eb60313672b065b4c206e013d7f5030ae99b0733296abcb32",
                "a5af74bf313564746f3bd86b33f94af2231bc779df0dab315953b584085fa92a",
                "ed8ea09e499078bfc8b358f55e4a3d3ccf3bc98b641b0471e15810d07ab05750",
                "d6d299d5d77942d38c98d81e701bf08aec6fc99b864506da4403c0c308f69166",
                "cb4341fce46bcb1e4ded6d0e1e8157ea20e2a8fc417f566958a226da76fc3b8f",
                "8d8d97cf550a3b5fde76d0aab9e5e17a55f6107018645ca36c0b5fd3e1f97d96",
                "15e0d7e168e2096521d907a7d2e9d879d53154c830bdbe4e1f6e595d504faeef",
                "7e38ef995eaa784f4760d210b9fe0b118744b3c7f18314b8623c47adbe250579",
                "e1629de172d99becd22853764407d66ae713d568dd05cc741cb4c22b559f0628",
                "3ee63c46ae485e2e7d86acb3ceea3c6c84cfba21dc72ff2db33653f4ce26fee1",
                "341f8d32a94b2c39d753d13412e4d9afe6a9b67f48dbf454505cedd54e812661",
                "d33be5001644240ad830696903c0a8ecf2e1429392236eb89aeff5d85d29f40d",
                "4934e0e36b176caca1132f4a01c73d59626d269d70c38a36b3a4e2e560008b7a",
                "c513557464d95a03ea3d18fd9eaf1f125e9cbe6b1419dfd3588a5c5ab980dc48",
                "ddfccdb0c21f9700ade762f07d1d7433f6ec1abe24060668c7a0f7c28e973f55",
                "30d6957c39b63c1773d62000077f858b7cdbe000e96a940d323fc87cef946e61",
                "d9ee8568e29018ab2ffb202fd9d63a6730f8d477948ca10b25fa4489acee3c5b",
                "c5f5c242014427efff4ba1322afe559434d6c07b40d19e02888161c4ca24a942",
                "88245b60408f708c07bde8e6611747bc7acd3aca689f3450f556c6ac63cdf299",
                "98e79d4d3f314d8e1437457d3896af66b87be77a2cd42703f511291866a278b7",
                "ea231c7c5b5dd4c583c8f0c6f962d35a0b4434ff5ad03d5774fe3f89017b090a",
                "3a6bfa9a6755e4fffb7e09178948ad0b3fc833898ae52c4653a31ab93ec419d0",
                "13cda2e45ee7fd8eb372fe8b8008f4ea7841dc470687f48939ae5e209a534848",
                "efc155ce5b8ea782f4945a3a42836f24761c99b1c0bb41ab47d4eda144de26c6",
                "7a1bf22944b4d7f92c2351024c7d70a9637a3a3e1b9be421437718e556bc0d7c",
                "99ae0d38068ca08f547d37a7ca0f4da69f187800ba5286f7bd5bfa2b1593b615",
                "cd71cbb30f032ec3a415f209bea17460458506f4672638f8ddaab2ff0014a593",
                "93615759a010b9414e8b81315fa782dd15c8965e61f86637b408d8ef84d698fa",
                "c7832a4f68705660d65bef03ec4b4a60a4eba47206258e5bb83c79aa09acca8a",
                "c9b45ec6bd0251a0afee8817acc091a04e3cd191ff7caf6be55bfa0e415fc871",
                "9a710b820d0e27ce66c50b547811bfd46373748aa4678728c35efcc7ffa61fee",
                "e366e96ae5b229e246c81247899bc1d0f1b7fa9c28cca711aeaba322ed95f551",
                "69b3e26dfc1ffcdc1d52de38cef03b8b00ce33e389d2b2054f7d7eb7e083dcf0",
                "adaa9e5587a4b7c9cc2ef60c0829de40c6b701f41c0ca488f13872733e1daed0",
                "177dc590e9dcf0b2f6cfc21112bb0fc6d4e5c15b5f2d1eb87178824a92ad5396",
                "06afa1a1bd3a0e6376ed43691f598f52c397df28ad7ffadb75a8e991584183f6",
                "3a35f6ec0eeff5a39ea726e9b5a0ed03af98b2d4ee19bee64ce4f657b4af6f4b",
                "7bb81893ed18cc464578be864fb3c1862a55ce5db76fa33e3e9b153d6903cbc8",
                "6e0c63b073b5a2669520ae8753d1f4a978c49b3d47d51438fc3505bab0aeda65",
                "f849765c5fec8ba9711458038526dab4fb05522f1d65cd17af6cb3a125aa9619",
                "4132c1420d66f9751dd0dc867bed4ad8b05017f3c64b95ac549bd1333288f591",
                "0fd4139234c002b4f9c601428f47293170f09b7cba2ca287b0ea8185e8013511",
                "98b9b0802b353ff9489b82982429cb703eb79c9d91069977b4e5db07c894f7ad",
                "1ca990a1545da7bd555b68d9172f16eb842469e00dc9140d2755ba9256054643",
                "7a85f3e878cc7a8055d0258b9c03f3236761095be393fac8fad0e0e676382aba",
                "fd1ac5be7d9bab003117f2340c476ec60882608b042f914672743567ca852c8c",
                "86d2628ffe193a2bd987d60073a95da10996bd2b7fba5e04e16d895d4bfc146a",
                "00301ea3ef002ca571a84b4bef3f4d176e171b6353804211a7f21ec55d8d1779",
                "f058bc626829b0f58fb3b4274a8917aed97e24526dce4afa26981601dee3b88c",
                "303e8e7b386be066aa1904f4a6de7a8720d05b08549cd4a80f07b90d5dcb08a2",
                "d4d430a7b98384ae7eabdcfe31ad4cd8214b067a11b83a232ac0d8f8592c89e4",
                "6363dc34213edfe05e84d6573e0c7f535192c95ab49bbc6dd03ec4f4e4bb0cd6",
                "b858cc80aeb928412e51a8393299843cdb28e1d708874982eb8f8a042756e9dd",
                "a37c119ccc43c9a01cd6b76d9008b70e62873e73a9e5c37d09d6463f5977b2a1",
                "e8ca4fcc63771949ad4004713c7501f107232fd2ad1872af4f81c6e4d9f12d33",
                "2a88ef240b4d22d263cae98aeac7be05ae6b112e9d42b83822a986724df8db94",
                "e79187a93c45c6b30bd19643368f399cafd3efcca447c0be421fd1abab468c78",
                "4143388343261c5b8d6ebed410ce50b5f2f444db7811e71b96ddfa86afcb03be",
                "1d595b0990ed9dba1eb05d7160c08d90f22ae8dde74b77e4d47d8c6fd0a73942",
                "a3e50be15d437920583827951bc0ab31f6616aeb5563fab84929a15087661865",
                "7d28f183473fad5147fc3d4322e4303667fbc2a291c9119640dfa1e84263c373",
                "db3fdbd6ea9fd9042b7949b5f5947b19c8f24239182e4986e4fdacca3b03adf8",
                "5674f66ea2c16929a387f1e5fef8f39d67f452897e51644aa1a25091b7d5376f",
                "ffa201e639fa290f6ebb62f5feb831aba3c41ff2d8d4ad8b707db2624da3c864",
                "49218c2b8a83622a0a6f1d55646f9a36acaa8dd858f998f96a30fdd5d85970a4",
                "2c9fac4a9dc805f38774c6bac77cf2f698f65b7b2582da5d0f167692bbaebfd2",
                "a57687348860501b28cd8e7bb1f2948decc7e988f76cc69ee8f3be5e1d6f8d97",
                "3f612a776ddb342c1f0e72ebad793fc80af16bf1bf139ead164d5c23edc8a77b",
                "9764f50fc13c2c8f2ffed9cc654caa96c1fa7d866815952edba1dedb7524ad0e",
                "61974a9ee742a7896adac121cfaa1653ca4a0467865413d56061578233015582",
                "25c6c5084c9988b7d0f83f2ad2de17c9d78024b10d4a1b4f1cc21e92b8e8a3fb",
                "552047fc1ede314ede2e40548d05ac0a17c262b4d4e94e68d71d963882c7a8f8",
                "75b8e06e5a2de600470a437c0a56c0ec85b61674027056ab065cc072621741b3",
                "01ec7b9b63fdbdd4bd38087ccdda18c893a77e37b75fec21e83d55d03ce4da84",
                "06bb6bfcd50607012b6cc9064825bf16a315ff41c6c6ec1f073c00dfa0d2963d",
                "ab32ae25bc07ccb7cfa5a0cfd842206ec4e40bda65e7fb0a23e7d00d6877b201",
                "6d4bef29c6303b49d5082c42f44ff8ddf6f4dac980b6179961006e56274e6f83",
                "ed29b5e255f26c8fae92483eb452059546552bb6461b68b742fffaef279cf37d",
                "f223271b438e052bf565e43a908b8efa7ee59e1aa20683f63fb5373bb5a3db48",
                "084d59e21fe71119248eb94c0b426a76cde76e1bbfcf8802bb4d5e2884215ad2",
                "5262b6be9a52319ebc8688bea3b09cbb2d272fc227316ce5d77497c68325dee7",
                "b2f27c9fb3167b90377844e6b5b3e4ad243994def9c832cacef4804da2aded64",
                "80822d860534923c8d75dc0320fd11b1d728f16776127b17a0c1ca1a9336f8dc",
                "54450e7ee1f678fd10515748ea6d6e6810538d6b44edc7efd8254b0c08cad359",
                "4958dad8389096fc2595d33675db3642b8b71ca52def4313a1da003a6fa5d8d6",
                "cb8647bff424a3f209a0941478df9f15d4c93394152afebe3569ef25da7dc5ab",
                "45e3e676610d0e2530ad8b78bf11f2a891692d86240accae61fbb430818eead9",
                "2866681466a9654ffb8e7c3b1fa411c306b400d178633e62f6504890121e6f5c",
                "3069fd1dc8dc71f6a6e9bcf9f472dd2c85a50451519132ff593c1a0601301958",
                "07ccf5e80b85f088a7412a2ed6472585860b42f81d4a35693e8e4200e64c1dc3",
                "3df0a1cae19ba3b33194b39c5265f0cbf51517b9e9e377e66149985f44aae332",
                "1d97bba3e3c36f9d0cafedfcb9c5a2c90a47baa76722177d3a423353a69910e4",
                "9d21809eae0c147e333e3a846f3ab4a253381b47f6aafef6c5c6c9a777370243",
                "9f8fb43ce094baac2c9e54f89d1ab6a845b456b6098dcc24c112fc6236f61aa2",
                "6bdfcfea25ab569d6878a9c12692df386cd152cd6b3180630e5c9635a29c81bb",
                "442be73d4d8551d85cbf223d36116fc8eaf8ba27e7609396fd21a9e7b443951f",
                "7c58a26a0556329a02637f4f3f0850eb4ddc3cf33accfc331bcef3762b093d29",
                "e8e3d69af908e03aa9234f3e4e844bd7eff5a5a9f8f7c5bdc4e46794c930e061",
                "e11f6c90634f7c0c15831b29d3a278dd00bd00a505d2c8130111e41b804d0284",
                "b68478539c2ca6d269912451e18ec53a58f9375a183e220c509c5ca2b9c49423",
                "52bf72a37f33d0fc9c73258d4bdac07f38882de359ebead8118d41b631b56237",
                "0c2aeab646c96ba653ba06c76eb0d10ad99892481388ccb0a51a8a62739f901f",
                "c58a8001db037c9b88b29f773587d180687db71515018bbfb5e0af2f64850d3d",
                "c3112f2bb7f12ce21df773538edd7cb45676c59f6ce9908147b29347ed4b4ac6",
                "7e628212c7bbc6ac011ccdff86bf08148c753051e100f50ea7af80088a8650e4",
                "433720c596e4fc5097d5f6b86d8f65b238ed24b12ca3c9054dd76ce77c29ab1c",
                "1dbc11b822739e39ac1d2fc641a64731890e26923f024cfb66b6e6dce4532844",
                "b5ad488af58c2daf66ee17106e3e98abeb7ee0070d8ec0c8bf39aa31d3e2c6b0",
                "2baf17578a9c54abf9eacd246bc53f8e5fd9f1694153d6a7f6fd0b32d47f615f",
                "f9e2c1f37c88027fdf99023e54a010f7a9323728bd06163f3ef800fb589fcb55",
                "74b2bc9f38d65059a271596d649831a6512225728a7e6fcbd09fbb0c67fa868a",
                "328dcc84e945b94b868d9e152ae3d3c5a5d88be0b375a8c47891b851e3f14a3c",
                "5132b99988c0b7ec97b7d97b580b910d46649375dd5d0fa36decb92eceb8cff4",
                "f217920eb8f3eb866134ccd270c10cda608541b51e65b61324f9370ba16f2065",
                "f86223533236ea68b242cd62ef02bec5c1c476e78404c0f841231ad84e53d978",
                "4ebe84624e20e2f690ca2fb7b0fd41100312fba8aab05ccd876be060f87f6ca6",
                "7d4b564757230cab577cb9548cfe3948e2449ae44f89e2b8ce3134dc8385d93d",
                "fb61836bc418ea8b7a13d63f8d8feb2d1a8440dff4b3caa8fac837807061f308",
                "656a7f8e1f2eccee2d2861afa2042333109faa3d120df3f280cb27246898682a",
                "63823f180557db7da19ecace835ee357812eef35013fcd43e9f54bfc96305b40",
                "1e303061d31263ca73b576e86864007dbc440988662801755d6a05f4ae31368e",
                "53bf2aeeaa64b376102f8c67e9aaded235c61f92e467ae1cafe1901eb3de0b06",
                "81721b7b0b1d2f676ff33460ca38c646fefbf6ac1c0ab348ee57f18778196406",
                "9ed174535f863abe63a6cf51e6c0a55e82406164599e5f79ce343b1788d4cdd1",
                "54b32a56739576ae5fd9d13754c1382ba309e851adb55a912afcb2796890030c",
                "f0893cd84b1f79c4a6d551ceb8b431aeaeb8dc7f6faa845eaa5a75bdfc868b13",
                "394c143d2582aea948917a6aefa7054c987df52e11e025ed3965dbbd03225991",
                "e03902eb5d5657ca43b0c1cfc991e2f8662261765333f1971a67c98073f132ee",
                "a58db37335145f9e55bf66605e4c3906625dd74cad997a78bd31f2cbbe800d78",
                "86fb6fa936cb0724d44ba3df204be03ea94a37b4c7db9561b6c3129c88204aff",
                "092fc322fa0a4d7b1977664124eb898abbc0a8d9005246b41803dadbfcab6d56",
                "1b00ec1c37b76683ce83d80cbd3298381342cd78386073cfefda587eee115192",
                "7c3efd2f18c078d0c1bf69a189aa01f0f0b772d1973a7fca0507ba1f62fea7d3",
                "1088d078e83b3e4c57fa71e045da07bcb21eef3f9ff035354363e23a31b4c2d9",
                "ecc4b8f671db30ab1db02fc7bded1f23557db33fb233f243d5a23e0778084c83",
                "c857e8a9ba8e5ea1bfb8e1bfdeeb8aab03a2cbd573e32627dd45f5602da1de3a",
                "35ef05a9d3d23f95a43cf8a01b41147e57b5e9de4179ca964a75923fe5d77a71",
                "77dc85113f119838d54de2b15e11109673e3647c872df4601b37cb0f6d56c509",
                "d9317628ea64eb3f66dfd7aa2a25c4f541ea3628bf308658638793bc900afc77",
                "af355be62aec204ef21f86fd71bdc19cf4a870cc7f73c02ae4cbe970c6165808",
                "0a17b77e249653bf92c49480362a86767914910442a6febde55db337aea5eb4c",
                "2cf25e224f7239bba48c5e15db8d1aee1828c087b8e8ea9c57637fb2021eaf4f",
                "05f4231ba758a988937c47f31fdbeac90919931ff26b36b123626cf492650da1",
                "8121b6bb6e36c4c4322702038f4d5d2a52bc24ee36c396ca861a9bab6ee8c178",
                "be4ab2980e745fc06c42eefd98d2f446a07206a6eb16af9d81d1afef7678b8d6",
                "21b1a3ba64ec42aa384e3c9ed38a9f0c0c8b4e4ce6afd8052dca818e652e1936",
                "6a26ffdaf9f515ac941b669beafaa54ad94acd6482f8307735767eda14aa069c",
                "a2e06f74c09948f2530740d06d190a926140b90f0cd912276bab9f03a569fa7d",
                "60eeeb1339d893e660f971d419d30d1ed5241b8901b92e809e1956ed4737500c",
                "2b2201d07125f498ff2298fafa7ba275a7e95c0fb2ccaecd0d2ce356db04b329",
                "a859ee0d178209426d3871bc447ad031bacb73faae88b7e76cb229faa2e85a38",
                "eee0f34a381e60638405ff766269dfd6f74601274482ae1f6e50bf93baec36b2",
                "0ff0a6d982e86bf2eea58eb31a44c888bd32b626649d9f1e74432cc156a981ae",
                "3c4894db9dcd1e2bc3afe79d38aafb76e3341f8f9721f92437c44a315d52f847",
                "87f77bcbbd77d274a7e16b56086617da24df07d8a3c9b8f4491d79a9fd2f2d29",
                "8cd71fd776d9c869cd70735eef1b20c10bc0c543139815b55e1cc0962ccb1a44",
                "9ee32994768132bb296a42856aeac9c1ad88f8b520fda0addfddda735b120222",
                "552adf5c221fcb1a47607cacdf4de8cacd4e28e85d2f2726351bd175b04c1217",
                "695289e24945704ad7ddd96578e718e3754a49d923abe66d0da87e8f9e7ff58d",
                "ca7affb41bdfa594ecf73a5bbd515ba0ad1ba0dd7e45997c82c588da364c59b4",
                "d7abe6716fa6b718e4df3fc658aa02bedd5821db92872da2843aa0d584e82c85",
                "332ff7a1ee70a80b67370dbfbb4f384498ec02d55d1df8d146b0aad2ac61789d",
                "9d67b5a8993bf5d39a7c11ae00b9612a83690909ce728b126c31eac80b88c73d",
                "4ea011e4985355cca481d39ae6778a004e62ac5a52c1175fb3ec96ac5288cad8",
                "8b0326f4515eaddc9ea339306dba268acead29dfbb74d8709a542fabb3c00528",
                "bbfc95b366ce0be8503ea5fa49ab0c5ff09633676aec36b6ae5b13a443212e35",
                "85311cd27424645f225ff55549274d93eb821375d86786bd90b956f173e06a99",
                "aea730d46f285e5e77418c831c21915e6c779ed8faecf35e9621dab58c6c6175",
                "893e30e121b98c8e4854f1bcd44faf61859cab8e138b89c2c1586df33a50db03",
                "6f9e119a31a85218f017de9a0d4c51a9a4fb314221d74ff7b299afd07520f97c",
                "30d54b2dfeaf90474d7dbed84513a47e6707e85ea030ccc52adbaa3ac676bab3",
                "e2ac36b2636d4cd5975e39a47657120a873575f9ce2f0761848bb104399122f9",
                "a7c62a982f31929484ce176409f04699ccc210e620c9ba6764d10e5ff7bc7ed6",
                "8e0e3d2b071955ea20c5d5ce60a6c10e1b62bd5ad34a21eb9ce86cf51e5bc7f5",
                "aa97cb51e28987e11b2936505dab15bcb2f9a5a9c6f7044f5b1515c30a761270",
                "a1c47585eb613a0ef80c7a9e4b0cf295722430ef3c1e62b6a3b46183110d930a",
                "c1b6acc4440f65a4c7475f6da805f6bc8818e04d7b33ea550e61e765e8c7c367",
                "c8a4985b2078e5926a47aa9264e49853c478d911116c112c46992d4f118832cb",
                "f2e5710f916953ac47310ef10d27e7cae72484735701c5db33a1044b6513f3c7",
                "9707a9e48f0f29528b86f1e413644ab59bd5c9d8836c3c3f3e2302cab2c20334",
                "b49989ed7e600f00925f3ad5d1d48e21a58ebc61f8ae23c093969b5bd0ad1b34",
                "98de148518b8082387cdbcc3d8224b53a61e04231b34739866c54e39c4cd941c",
                "6ef40c02ddc15bbaa88f3e56fd126863584b179031e56bae278fcc61eca1f864",
                "af338baa33675eea6ee56c3c0c72771957b148cad98e5d917cc1d79bf6b9ea3a",
                "d761b249d6f5e27f3a0d512d85cf8cb09a1bed504fa8569c98abdda9748a1524",
                "a4fe3074359edc0782343caa3ac1db9b35c4e472d2774ae24f1491d282f95c18",
                "473074298d76df6bf4fd47d4be2618e3b7cbea9030f0ca095beedb0f784e3089",
                "80f0357e91042b6ca4f301c2af1c577f38c957678880c5da475dd1b2ae7ff0fa",
                "a781aed5c24369696f5ebb3e692c63292c2849ad396c55c82648a185457449f1",
                "41fca81831e8b670bd784a7a5fa9675e12f3600f8a436a752bdca70c0082872a",
                "a673018b8cf87d26d701ade7f453b750abb371c6dfb53628a060f74a902a6321",
                "c6296be14993fb92c25a2a7087577a533d85c1c6fe718395b64e0970eec27186",
                "8a68183347ba2ab7c11bb972870dd13285ffb7e40f1ce5a3885990631178a6d4",
                "8deb2c8c14cf86535ba187679bbfed77f56da359090b49959871875301b13c8e",
            )
        }
    }
})