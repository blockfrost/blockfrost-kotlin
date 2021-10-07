# HealthApi

All URIs are relative to *https://cardano-mainnet.blockfrost.io/api/v0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getApiRoot**](HealthApi.md#getApiRoot) | **GET** / | Root endpoint
[**getCurrentBackendTime**](HealthApi.md#getCurrentBackendTime) | **GET** /health/clock | Current backend time
[**getHealth**](HealthApi.md#getHealth) | **GET** /health | Backend health status


<a name="getApiRoot"></a>
# **getApiRoot**
> InlineResponse200 getApiRoot()

Root endpoint

Root endpoint has no other function than to point end users to documentation. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = HealthApi()
try {
    val result : InlineResponse200 = apiInstance.getApiRoot()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HealthApi#getApiRoot")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HealthApi#getApiRoot")
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

<a name="getCurrentBackendTime"></a>
# **getCurrentBackendTime**
> InlineResponse2002 getCurrentBackendTime()

Current backend time

This endpoint provides the current UNIX time. Your application might use this to verify if the client clock is not out of sync. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = HealthApi()
try {
    val result : InlineResponse2002 = apiInstance.getCurrentBackendTime()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HealthApi#getCurrentBackendTime")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HealthApi#getCurrentBackendTime")
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

<a name="getHealth"></a>
# **getHealth**
> InlineResponse2001 getHealth()

Backend health status

Return backend status as a boolean. Your application     should handle situations when backend for the given chain is unavailable. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = HealthApi()
try {
    val result : InlineResponse2001 = apiInstance.getHealth()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HealthApi#getHealth")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HealthApi#getHealth")
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

