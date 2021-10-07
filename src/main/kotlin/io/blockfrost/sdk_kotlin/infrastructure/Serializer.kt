package io.blockfrost.sdk_kotlin.infrastructure

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.blockfrost.sdk_kotlin.infrastructure.adapters.*

object Serializer {
    @JvmStatic
    val moshiBuilder: Moshi.Builder = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .add(OffsetDateTimeAdapter())
        .add(LocalDateTimeAdapter())
        .add(LocalDateAdapter())
        .add(UUIDAdapter())
        .add(ByteArrayAdapter())
        .add(URIAdapter())
        .add(BigDecimalAdapter())
        .add(BigIntegerAdapter())
        .add(JsonObjectAdapter)

    @JvmStatic
    val moshi: Moshi by lazy {
        moshiBuilder.build()
    }
}
