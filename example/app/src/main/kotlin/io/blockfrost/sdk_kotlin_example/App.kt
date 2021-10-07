package io.blockfrost.sdk_kotlin_example

import io.blockfrost.sdk_kotlin.api.CardanoAddressesApi
import io.blockfrost.sdk_kotlin.api.HealthApi
import io.blockfrost.sdk_kotlin.infrastructure.BlockfrostConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlin.system.exitProcess

class App {
    fun test()  {
        try {
            runBlocking {
                // Use default configuration, mainnet, project_id loaded from BF_PROJECT_ID env var
                val config = BlockfrostConfig.defaulMainNetConfig
                val healthApi = HealthApi(config = config)
                val addressApi = CardanoAddressesApi(config = config)

                if (config.projectId.isNullOrBlank()){
                    println("Error, project ID is not defined, please set BF_PROJECT_ID env var.")
                    exitProcess(1)
                }

                println("API root endpoint: ${healthApi.getApiRoot()}")
                println("API health: ${healthApi.getHealth()}")
                println("API time: ${healthApi.getCurrentBackendTime()}")

                // coroutine call, returns model object
                val details = addressApi.getAddressDetails("addr1q8zu4smzyf2r2mfqjd6tc6vxf2p8rccdfk82ye3eut2udkw9etpkygj5x4kjpym5h35cvj5zw83s6nvw5fnrnck4cmvshkfm4y")
                println(details)
            }

        } catch(e: Exception){
            println("Exception: $e")
            e.printStackTrace()
            exitProcess(1)
        }
    }
}

fun main() {
    println(App().test())
}
