package org.openapitools.client.models.nutlink

import com.squareup.moshi.Json

data class Ticker(
    /* Name of the ticker */
    @Json(name = "name")
    val name: String? = null,

    /* Number of ticker records */
    @Json(name = "count")
    val count: Long? = null,

    /* Block height of the latest record */
    @Json(name = "latest_block")
    val latestBlock: Long? = null,
)