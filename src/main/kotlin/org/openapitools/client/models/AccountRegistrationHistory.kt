package org.openapitools.client.models

import com.squareup.moshi.Json

data class AccountRegistrationHistory(
    /* Hash of the transaction containing the (de)registration certificate */
    @Json(name = "tx_hash")
    val txHash: String? = null,

    /* Enum: "registered" "deregistered", Action in the certificate */
    @Json(name = "action")
    val action: AccountRegistrationAction? = null,
)