# CardanoNetworkApi

All URIs are relative to *https://cardano-mainnet.blockfrost.io/api/v0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getNetwork**](CardanoNetworkApi.md#getNetwork) | **GET** /network | Network information


<a name="getNetwork"></a>
# **getNetwork**
> Network getNetwork()

Network information

Return detailed network information.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoNetworkApi()
try {
    val result : Network = apiInstance.getNetwork()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoNetworkApi#getNetwork")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoNetworkApi#getNetwork")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Network**](Network.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

