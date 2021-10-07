package io.blockfrost.sdk_kotlin.models

import com.squareup.moshi.Json

data class ApiRoot(
    @Json(name = "url")
    val url: String? = null,

    @Json(name = "version")
    val version: String? = null
)