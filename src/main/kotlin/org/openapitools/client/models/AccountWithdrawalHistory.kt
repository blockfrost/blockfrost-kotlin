package org.openapitools.client.models

import com.squareup.moshi.Json

data class AccountWithdrawalHistory(
    /* Hash of the transaction containing the withdrawal */
    @Json(name = "tx_hash")
    val txHash: String? = null,

    /* Withdrawal amount in Lovelaces */
    @Json(name = "amount")
    val amount: String? = null,
)