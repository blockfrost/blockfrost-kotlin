package org.openapitools.client.models

import com.squareup.moshi.Json

data class AccountRewardHistory(
    /* Epoch of the associated reward */
    @Json(name = "epoch")
    val activeEpoch: Int? = null,

    /* Rewards for given epoch in Lovelaces */
    @Json(name = "amount")
    val amount: String? = null,

    /* Bech32 ID of pool being delegated to */
    @Json(name = "pool_id")
    val poolId: String? = null
)