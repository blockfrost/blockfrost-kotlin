package io.blockfrost.sdk.kotlin.models.ipfs

import com.squareup.moshi.Json

data class PinResponse(
    @Json(name = "ipfs_hash")
    val ipfsHash: String? = null,

    @Json(name = "state")
    val state: PinState? = null,
)