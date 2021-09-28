package org.openapitools.client.models

import com.squareup.moshi.Json

data class AccountMirHistory(
    /* Hash of the transaction containing the MIR */
    @Json(name = "tx_hash")
    val txHash: String? = null,

    /* MIR amount in Lovelaces */
    @Json(name = "amount")
    val amount: String? = null,
)