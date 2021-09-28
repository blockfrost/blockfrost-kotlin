package org.openapitools.client.models

import com.squareup.moshi.Json

data class AccountAddress(
    /* Address associated with the stake key */
    @Json(name = "address")
    val address: String? = null,
)