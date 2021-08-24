# HealthApi

All URIs are relative to *https://cardano-mainnet.blockfrost.io/api/v0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**healthClockGet**](HealthApi.md#healthClockGet) | **GET** /health/clock | Current backend time
[**healthGet**](HealthApi.md#healthGet) | **GET** /health | Backend health status
[**rootGet**](HealthApi.md#rootGet) | **GET** / | Root endpoint


<a name="healthClockGet"></a>
# **healthClockGet**
> InlineResponse2002 healthClockGet()

Current backend time

This endpoint provides the current UNIX time. Your application might use this to verify if the client clock is not out of sync. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = HealthApi()
try {
    val result : InlineResponse2002 = apiInstance.healthClockGet()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HealthApi#healthClockGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HealthApi#healthClockGet")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**InlineResponse2002**](InlineResponse2002.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="healthGet"></a>
# **healthGet**
> InlineResponse2001 healthGet()

Backend health status

Return backend status as a boolean. Your application     should handle situations when backend for the given chain is unavailable. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = HealthApi()
try {
    val result : InlineResponse2001 = apiInstance.healthGet()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HealthApi#healthGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HealthApi#healthGet")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="rootGet"></a>
# **rootGet**
> InlineResponse200 rootGet()

Root endpoint

Root endpoint has no other function than to point end users to documentation. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = HealthApi()
try {
    val result : InlineResponse200 = apiInstance.rootGet()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HealthApi#rootGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HealthApi#rootGet")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

