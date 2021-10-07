package io.blockfrost.sdk_kotlin.tests

import com.beust.klaxon.Parser

object TestUtils {
    fun parseJson(input: String): Any {
        val sb = kotlin.text.StringBuilder(input)
        return Parser.default().parse(sb)
    }
}