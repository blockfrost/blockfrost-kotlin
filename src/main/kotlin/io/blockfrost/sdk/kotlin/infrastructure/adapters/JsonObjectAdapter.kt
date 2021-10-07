package io.blockfrost.sdk.kotlin.infrastructure.adapters

import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonBase
import com.beust.klaxon.JsonObject
import com.beust.klaxon.JsonParsingException
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson


object JsonObjectAdapter {
    @FromJson
    fun fromJson(reader: JsonReader): JsonBase? {
        try {
            val jdata = reader.readJsonValue()
            @Suppress("UNCHECKED_CAST")
            (jdata as? Map<String, Any?>)?.let {
                return JsonObject(it)
            }

            (jdata as? Collection<*>)?.let {
                return JsonArray(jdata)
            }

            return null

        } catch (e: JsonParsingException) {
            throw e
        }
    }

    @ToJson
    fun toJson(writer: JsonWriter, value: JsonBase?) {
        value?.let {
            writer.value(value.toString())
        }
    }
}