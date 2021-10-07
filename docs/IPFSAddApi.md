# IPFSAddApi

All URIs are relative to *https://cardano-mainnet.blockfrost.io/api/v0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**add**](IPFSAddApi.md#add) | **POST** /ipfs/add | Add a file to IPFS


<a name="add"></a>
# **add**
> InlineResponse2003 add()

Add a file to IPFS

You need to &#x60;/ipfs/pin/add&#x60; an object to avoid it being garbage collected. This usage is being counted in your user account quota. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = IPFSAddApi()
try {
    val result : InlineResponse2003 = apiInstance.add()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling IPFSAddApi#add")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling IPFSAddApi#add")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**InlineResponse2003**](InlineResponse2003.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

