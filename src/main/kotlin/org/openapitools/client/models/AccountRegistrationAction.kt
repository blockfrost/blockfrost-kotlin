package org.openapitools.client.models

import com.squareup.moshi.Json

enum class AccountRegistrationAction(val value: kotlin.String) {
    @Json(name = "registered") registered("registered"),
    @Json(name = "deregistered") deregistered("deregistered");
}