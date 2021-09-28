package org.openapitools.client.models

import com.squareup.moshi.Json

enum class AssetAction(val value: String) {
    @Json(name = "minted") minted("minted"),
    @Json(name = "burnt") burnt("burnt");
}