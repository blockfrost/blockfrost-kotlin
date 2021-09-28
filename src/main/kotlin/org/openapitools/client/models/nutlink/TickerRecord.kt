package org.openapitools.client.models.nutlink

import com.squareup.moshi.Json

data class TickerRecord(
    /* Address of a metadata oracle */
    @Json(name = "address")
    val address: String? = null,

     /* Hash of the transaction */
    @Json(name = "tx_hash")
    val txHash: String? = null,

     /* Block height of the record */
    @Json(name = "block_height")
    val blockHeight: Long? = null,

    /* Transaction index within the block */
    @Json(name = "tx_index")
    val txIndex: Int? = null,

    /* Content of the ticker */
    @Json(name = "payload")
    val payload: Object? = null,
)