# MetricsApi

All URIs are relative to *https://cardano-mainnet.blockfrost.io/api/v0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**metricsEndpointsGet**](MetricsApi.md#metricsEndpointsGet) | **GET** /metrics/endpoints | Blockfrost endpoint usage metrics
[**metricsGet**](MetricsApi.md#metricsGet) | **GET** /metrics/ | Blockfrost usage metrics


<a name="metricsEndpointsGet"></a>
# **metricsEndpointsGet**
> kotlin.collections.List&lt;kotlin.Any&gt; metricsEndpointsGet()

Blockfrost endpoint usage metrics

History of your Blockfrost usage metrics per endpoint in the past 30 days. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = MetricsApi()
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.metricsEndpointsGet()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MetricsApi#metricsEndpointsGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MetricsApi#metricsEndpointsGet")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;kotlin.Any&gt;**](kotlin.Any.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="metricsGet"></a>
# **metricsGet**
> kotlin.collections.List&lt;kotlin.Any&gt; metricsGet()

Blockfrost usage metrics

History of your Blockfrost usage metrics in the past 30 days.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = MetricsApi()
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.metricsGet()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MetricsApi#metricsGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MetricsApi#metricsGet")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;kotlin.Any&gt;**](kotlin.Any.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

