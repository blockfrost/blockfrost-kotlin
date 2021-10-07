package io.blockfrost.sdk.kotlin.models.ipfs

import com.squareup.moshi.Json

enum class PinState(val value: String) {
    @Json(name = "queued") queued("queued"),
    @Json(name = "pinned") pinned("pinned"),
    @Json(name = "unpinned") unpinned("unpinned"),
    @Json(name = "failed") failed("failed"),
    @Json(name = "gc") gc("gc"),
}