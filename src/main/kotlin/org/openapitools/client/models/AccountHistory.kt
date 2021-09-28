package org.openapitools.client.models

import com.squareup.moshi.Json

data class AccountHistory(
    /* Epoch in which the stake was active. */
    @Json(name = "active_epoch")
    val activeEpoch: Int? = null,

    /* Stake amount in Lovelaces */
    @Json(name = "amount")
    val amount: String? = null,

    /* Bech32 ID of pool being delegated to */
    @Json(name = "pool_id")
    val poolId: String? = null
)