package org.openapitools.client.models

import com.squareup.moshi.Json

data class AccountAsset(
    /* The unit of the value; Concatenation of asset policy_id and hex-encoded asset_name */
    @Json(name = "unit")
    val unit: String? = null,

    /* The quantity of the unit */
    @Json(name = "quantity")
    val quantity: String? = null,
)