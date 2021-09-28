package org.openapitools.client.models.ipfs

import com.squareup.moshi.Json

data class PinItem(
    @Json(name = "time_created")
    val timeCreated: Long? = null,

    @Json(name = "time_pinned")
    val timePinned: Long? = null,

    @Json(name = "ipfs_hash")
    val ipfsHash: String? = null,

    @Json(name = "size")
    val size: Int? = null,

    @Json(name = "state")
    val state: PinState? = null,
)