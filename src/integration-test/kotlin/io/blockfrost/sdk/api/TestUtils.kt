package io.blockfrost.sdk.api

import com.beust.klaxon.Parser

object TestUtils {
    fun parseJson(input: String): Any {
        val sb = kotlin.text.StringBuilder(input)
        return Parser.default().parse(sb)
    }
}