package io.blockfrost.sdk_kotlin.infrastructure

import com.squareup.moshi.Moshi
import io.blockfrost.sdk_kotlin.BuildInfo
import io.github.resilience4j.circuitbreaker.CircuitBreaker
import io.github.resilience4j.core.IntervalFunction
import io.github.resilience4j.retrofit.CircuitBreakerCallAdapter
import io.github.resilience4j.retrofit.RetryCallAdapter
import io.github.resilience4j.retry.Retry
import io.github.resilience4j.retry.RetryConfig
import okhttp3.Call
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException


open class BlockfrostConfig(
    var baseUrl: String = UrlMainnet,
    var projectId: String? = null,
    var batchSize: Int = DEFAULT_BATCH_SIZE,

    private val retryFunction: IntervalFunction? = null,
    private val circuitBreaker: CircuitBreaker? = null,
    private val maxRetryAttempts: Int = 2,
    private val retryConfigProvider: (() -> RetryConfig)? = null,
    private val retryProvider: (() -> Retry)? = null,
    private val connectTimeoutMilli: Long? = 10_000L,
    private val socketTimeoutMilli: Long? = 10_000L,

    private val okHttpClientBuilder: OkHttpClient.Builder? = null,
    private val serializerBuilder: Moshi.Builder = Serializer.moshiBuilder,
    private val callFactory : Call.Factory? = null,
    private val converterFactory: Converter.Factory? = null,
) : Cloneable {
    companion object {
        const val UserAgent = "BlockfrostKotlinSDK"
        const val UrlMainnet = "https://cardano-mainnet.blockfrost.io/api/v0"
        const val UrlTestnet = "https://cardano-testnet.blockfrost.io/api/v0"
        const val UrlIpfs = "https://ipfs.blockfrost.io/api/v0"

        var DEFAULT_COUNT = 100
        var DEFAULT_PAGE = 1
        var DEFAULT_SORT_ORDER = SortOrder.asc
        var DEFAULT_BATCH_SIZE = 10

        val defaultConfig: BlockfrostConfig by lazy {
            BlockfrostConfig(baseUrl = UrlMainnet, projectId = getEnvProjectId())
        }

        val defaulMainNetConfig: BlockfrostConfig by lazy {
            BlockfrostConfig(baseUrl = UrlMainnet, projectId = getEnvProjectIdMainnet())
        }

        val defaultTestNetConfig: BlockfrostConfig by lazy {
            BlockfrostConfig(baseUrl = UrlTestnet, projectId = getEnvProjectIdTestnet())
        }

        val defaultIpfsConfig: BlockfrostConfig by lazy {
            BlockfrostConfig(baseUrl = UrlIpfs, projectId = getEnvProjectIdIpfs())
        }

        fun getEnvProjectId(): String? {
            return System.getenv("BF_PROJECT_ID")
                ?: System.getProperties().getProperty("io.blockfrost.client.baseUrl")
        }

        fun getEnvProjectIdMainnet(): String? {
            return System.getenv("BF_MAINNET_PROJECT_ID")
                ?: System.getProperties().getProperty("io.blockfrost.client.baseUrl.mainNet")
                ?: getEnvProjectId()
        }

        fun getEnvProjectIdTestnet(): String? {
            return System.getenv("BF_TESTNET_PROJECT_ID")
                ?: System.getProperties().getProperty("io.blockfrost.client.baseUrl.testNet")
        }

        fun getEnvProjectIdIpfs(): String? {
            return System.getenv("BF_IPFS_PROJECT_ID")
                ?: System.getProperties().getProperty("io.blockfrost.client.baseUrl.ipfs")
        }
    }

    private val apiAuthorizations = mutableMapOf<String, Interceptor>()
    var logger: ((String) -> Unit)? = null

    private val clientBuilder: OkHttpClient.Builder by lazy {
        okHttpClientBuilder ?: defaultClientBuilder()
    }

    private val retrofitBuilder: Retrofit.Builder by lazy {
        defaultRetrofitBuilder()
    }

    init {
        normalizeBaseUrl()
        projectId?.let { addAuthorization("project_id", it) }
    }

    open fun retryConfigBuilder(): RetryConfig.Builder<Response<String>> {
        return RetryConfig.custom<Response<String>>()
                .maxAttempts(maxRetryAttempts)
                .intervalFunction(retryFunction ?: IntervalFunction.ofExponentialBackoff())
                .retryOnResult { response: Response<String> -> setOf(429, 500).contains(response.code())  }
                //.retryOnException { e: Throwable? -> e is WebServiceException }
                .retryExceptions(IOException::class.java, TimeoutException::class.java)
                //.ignoreExceptions(BusinessException::class.java, OtherBusinessException::class.java)
                .failAfterMaxAttempts(false)  // important, do not throw, otherwise callback is missed
    }

    open fun retryConfig(): RetryConfig {
        return retryConfigProvider?.let { it() } ?: retryConfigBuilder().build()
    }

    open fun defaultClientBuilder(): OkHttpClient.Builder {
        return okHttpClientBuilder ?: OkHttpClient()
            .newBuilder()
            .addInterceptor(HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
                override fun log(message: String) {
                    logger?.invoke(message)
                }
            }).apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).apply {
                retryOnConnectionFailure(true)
                connectTimeoutMilli?.let { connectTimeout(it, TimeUnit.MILLISECONDS) }
                socketTimeoutMilli?.let {
                    readTimeout(it, TimeUnit.MILLISECONDS)
                    writeTimeout(it, TimeUnit.MILLISECONDS)
                }
            }.addNetworkInterceptor { chain ->
                chain.proceed(
                    chain.request()
                        .newBuilder()
                        .header("User-Agent", "${UserAgent}-${BuildInfo.version}")
                        .build()
                )
            }
    }

    open fun defaultRetrofitBuilder(): Retrofit.Builder {
        // Create a Retry with custom configuration
        val retry: Retry = retryProvider?.let { it() } ?: Retry.of(
            "apiRetry", retryConfig()
        )

        //builder.interceptors().add(interceptor)
        val client = clientBuilder.build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(serializerBuilder.build()))
            .addConverterFactory(ScalarsConverterFactory.create())
            .addCallAdapterFactory(RetryCallAdapter.of(retry))
            .addCallAdapterFactory(CircuitBreakerCallAdapter.of(circuitBreaker ?: CircuitBreaker.ofDefaults("apiCircuitBreaker")))
            .client(client)
            .apply {
                if (converterFactory != null) {
                    addConverterFactory(converterFactory)
                }
            }
    }

    open fun getRetrofit(): Retrofit {
        return retrofitBuilder.build()
    }

    /**
     * Adds an authorization to be used by the client
     * @param authName Authentication name
     * @param authValue Authorization static value
     * @return ApiClient
     */
    open fun addAuthorization(authName: String, authValue: String): BlockfrostConfig {
        clientBuilder.addInterceptor(Interceptor { chain ->
            val request = chain.request()
            val authenticatedRequest = request.newBuilder()
                .header(authName, authValue).build()
            chain.proceed(authenticatedRequest)
        })
        return this
    }

    /**
     * Adds an authorization to be used by the client
     * @param authName Authentication name
     * @param authorization Authorization interceptor
     * @return ApiClient
     */
    open fun addAuthorization(authName: String, authorization: Interceptor): BlockfrostConfig {
        if (apiAuthorizations.containsKey(authName)) {
            throw RuntimeException("auth name $authName already in api authorizations")
        }
        apiAuthorizations[authName] = authorization
        clientBuilder.addInterceptor(authorization)
        return this
    }

    open fun setLogger(logger: (String) -> Unit): BlockfrostConfig {
        this.logger = logger
        return this
    }

    open fun <S> createService(serviceClass: Class<S>): S {
        val usedCallFactory = this.callFactory ?: clientBuilder.build()
        return retrofitBuilder.callFactory(usedCallFactory).build().create(serviceClass)
    }

    private fun normalizeBaseUrl() {
        if (!baseUrl.endsWith("/")) {
            baseUrl += "/"
        }
    }

    private inline fun <T, reified U> Iterable<T>.runOnFirst(callback: U.() -> Unit) {
        for (element in this) {
            if (element is U)  {
                callback.invoke(element)
                break
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BlockfrostConfig) return false

        if (baseUrl != other.baseUrl) return false
        if (projectId != other.projectId) return false
        if (batchSize != other.batchSize) return false
        if (maxRetryAttempts != other.maxRetryAttempts) return false

        return true
    }

    override fun hashCode(): Int {
        var result = baseUrl.hashCode()
        result = 31 * result + (projectId?.hashCode() ?: 0)
        result = 31 * result + batchSize
        result = 31 * result + maxRetryAttempts
        return result
    }

    override fun toString(): String {
        return "BlockfrostConfig(baseUrl='$baseUrl', batchSize=$batchSize, maxRetryAttempts=$maxRetryAttempts)"
    }

    override fun clone(): BlockfrostConfig {
        return super.clone() as BlockfrostConfig
    }
}
