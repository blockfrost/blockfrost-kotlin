package org.openapitools.client.models

import com.squareup.moshi.Json

data class AccountDelegationHistory(
    /* Epoch in which the delegation becomes active */
    @Json(name = "active_epoch")
    val activeEpoch: Int? = null,

    /* Hash of the transaction containing the delegation */
    @Json(name = "tx_hash")
    val txHash: String? = null,

    /* Rewards for given epoch in Lovelaces */
    @Json(name = "amount")
    val amount: String? = null,

    /* Bech32 ID of pool being delegated to */
    @Json(name = "pool_id")
    val poolId: String? = null
)