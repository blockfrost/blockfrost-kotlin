package io.blockfrost.sdk_kotlin.models.ipfs

import com.squareup.moshi.Json

data class IPFSObject(
    @Json(name = "name")
    val name: String? = null,

    @Json(name = "ipfs_hash")
    val ipfsHash: String? = null,

    @Json(name = "size")
    val size: Int? = null
)