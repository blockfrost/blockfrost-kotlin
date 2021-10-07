package io.blockfrost.sdk_kotlin

object BuildInfo {
    private const val defaultVersion = "0.0.1"
    val version by lazy { BuildInfo.javaClass.getPackage().implementationVersion ?: defaultVersion }
}

fun main() {
    println(BuildInfo.version)
}
