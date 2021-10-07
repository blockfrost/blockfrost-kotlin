package io.blockfrost.sdk.api

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import org.openapitools.client.api.CardanoAccountsApi
import org.openapitools.client.infrastructure.BlockfrostConfig
import org.openapitools.client.models.*
import kotlin.properties.Delegates
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class AccountsTest : DescribeSpec({
    var api: CardanoAccountsApi by Delegates.notNull()
    System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "TRACE")

    describe("load accounts"){
        beforeTest {
            api = CardanoAccountsApi(config = BlockfrostConfig.defaulMainNetConfig)
        }

        it("loads accounts for stake address").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getAccountByStakeAddress("stake1u8zu4smzyf2r2mfqjd6tc6vxf2p8rccdfk82ye3eut2udkgs46q0w")
            r.shouldNotBeNull()
            r.stakeAddress.shouldBe("stake1u8zu4smzyf2r2mfqjd6tc6vxf2p8rccdfk82ye3eut2udkgs46q0w")
            r.poolId.shouldBeNull()
        }

        it("rewards").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getAccountRewardHistory("stake1u9fzg77vrgfqlplkjqe9hntdcvsurpvxd60yp2fhn73002qsv9pdk", count = 3, page = 2)
            r.shouldNotBeEmpty()
            r.shouldContainExactly(
                AccountRewardContent(epoch = 229, amount = "171419599", poolId = "pool1vx9tzlkgafernd9vpjpxkenutx2gncj4yn88fpq69823qlwcqrt"),
                AccountRewardContent(epoch = 230, amount = "160736772", poolId = "pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy"),
                AccountRewardContent(epoch = 231, amount = "210662173", poolId = "pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy"),
            )
        }

        it("history").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getAccountHistory("stake1u9fzg77vrgfqlplkjqe9hntdcvsurpvxd60yp2fhn73002qsv9pdk", count = 3, page = 2)
            r.shouldNotBeEmpty()
            r.shouldContainExactly(
                AccountHistoryContent(activeEpoch = 229, amount = "220098162468", poolId = "pool1vx9tzlkgafernd9vpjpxkenutx2gncj4yn88fpq69823qlwcqrt"),
                AccountHistoryContent(activeEpoch = 230, amount = "220268640006", poolId = "pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy"),
                AccountHistoryContent(activeEpoch = 231, amount = "220428767042", poolId = "pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy"),
            )
        }

        it("delegations").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getAccountDelegationHistory("stake1u9a3t4rgddm4expj0ucyxhxg3ft9ugk2ry6r9w69h04ea6cfj887f")
            r.shouldNotBeEmpty()
            r.shouldContainExactly(
                AccountDelegationContent(activeEpoch = 220, txHash = "0bcdf4f6378b2183d738b17c8a2daa6a94f0ddf78133b73fccea0eece3ab1b56", amount = "2653774", poolId = "pool16kus5xvdysgmtjp0hhlwt72tsm0yn2zcn0a8wg9emc6c75lxvmc"),
            )
        }

        it("withdrawals").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getAccountWithdrawalHistory("stake1u88xakeptjw9jwsytkjal76d07an4thvvrfx3w2kt77pw4sc5rr8k", count = 4, page = 2)
            r.shouldNotBeEmpty()
            r.shouldContainExactly(
                AccountWithdrawalContent(txHash = "4c8f16ba4730fe0e84d1d79b38a6198b0283b0b87e36388cb3e6c5f07f99bfb0", amount = "1862857028"),
                AccountWithdrawalContent(txHash = "6072dc5a1688418f0da70427b32c49fb6c494170c7988a105ccc33a95a1b0370", amount = "1779916664"),
                AccountWithdrawalContent(txHash = "3926bcc6b726394dee99c681d0768849214ca0b02f728690fcafba6c22c3e19c", amount = "821097437"),
                AccountWithdrawalContent(txHash = "3a277898a5789c433f556672903b3bf260d074efadaf1f0128c4de663a501192", amount = "3602325039"),
            )
        }

        it("MIRs").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getAccountMirHistory("stake1uyq7039vutuw8v7femqtktdu9zlhnqh3mkvvhdazft9ga2q8zdfkp", count = 1, page = 1)
            r.shouldNotBeEmpty()
            r.shouldContainExactly(
                AccountMirContent(txHash = "7b57f2cf1c442c563647ab29669c88b9116c2668d31d42526ff27ed614da1252", amount = "19296735"),
            )
        }

        it("addreses").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getAccountAddresses("stake1u9a3t4rgddm4expj0ucyxhxg3ft9ugk2ry6r9w69h04ea6cfj887f")
            r.shouldNotBeEmpty()
            r.forEach { it.address.shouldNotBeNull() }
        }

        it("assets").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getAccountAssets("stake1u9e45fvvd4ujpc0kka0pnx9zqdvh9wl96nsg6sje0f5hmfq45lrja")
            r.shouldNotBeEmpty()
            r.forEach {
                it.quantity.shouldNotBeNull()
                it.unit.shouldNotBeNull()
            }
        }

        it("assetsAll").config(timeout = Duration.Companion.seconds(10)){
            val r = api.getAccountAssetsAllList("stake1u9e45fvvd4ujpc0kka0pnx9zqdvh9wl96nsg6sje0f5hmfq45lrja")
            r.shouldNotBeEmpty()
            r.forEach {
                it.quantity.shouldNotBeNull()
                it.unit.shouldNotBeNull()
            }
        }
    }
})