package org.openapitools.client.models.nutlink

import com.squareup.moshi.Json

data class NutLinkAddress(
    /* Bech32 encoded address */
    @Json(name = "address")
    val address: String? = null,

    /* URL do specific metadata file */
    @Json(name = "metadata_url")
    val metadataUrl: String? = null,

    /* Hash of the metadata file */
    @Json(name = "metadata_hash")
    val metadataHash: String? = null,

    /* The cached metadata of the metadata_url file */
    @Json(name = "metadata")
    val metadata: Map<String, Object>? = null,
)