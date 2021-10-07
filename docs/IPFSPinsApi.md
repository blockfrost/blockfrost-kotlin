# IPFSPinsApi

All URIs are relative to *https://cardano-mainnet.blockfrost.io/api/v0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getPinList**](IPFSPinsApi.md#getPinList) | **GET** /ipfs/pin/list/ | List pinned objects
[**getPinListByIpfsPath**](IPFSPinsApi.md#getPinListByIpfsPath) | **GET** /ipfs/pin/list/{IPFS_path} | Get details about pinned object
[**pinAdd**](IPFSPinsApi.md#pinAdd) | **POST** /ipfs/pin/add/{IPFS_path} | Pin an object
[**removePin**](IPFSPinsApi.md#removePin) | **POST** /ipfs/pin/remove/{IPFS_path} | 


<a name="getPinList"></a>
# **getPinList**
> kotlin.collections.List&lt;InlineResponse2005&gt; getPinList(count, page, order)

List pinned objects

List objects pinned to local storage

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = IPFSPinsApi()
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<InlineResponse2005> = apiInstance.getPinList(count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling IPFSPinsApi#getPinList")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling IPFSPinsApi#getPinList")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]
 **order** | **SortOrder**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to null] [enum: asc, desc]

### Return type

[**kotlin.collections.List&lt;InlineResponse2005&gt;**](InlineResponse2005.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPinListByIpfsPath"></a>
# **getPinListByIpfsPath**
> InlineResponse2006 getPinListByIpfsPath(ipFSPath)

Get details about pinned object

Get information about locally pinned IPFS object

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = IPFSPinsApi()
val ipFSPath : kotlin.String = ipFSPath_example // kotlin.String | 
try {
    val result : InlineResponse2006 = apiInstance.getPinListByIpfsPath(ipFSPath)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling IPFSPinsApi#getPinListByIpfsPath")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling IPFSPinsApi#getPinListByIpfsPath")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ipFSPath** | **kotlin.String**|  |

### Return type

[**InlineResponse2006**](InlineResponse2006.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="pinAdd"></a>
# **pinAdd**
> InlineResponse2004 pinAdd(ipFSPath)

Pin an object

Pinned objects are counted in your user storage quota.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = IPFSPinsApi()
val ipFSPath : kotlin.String = ipFSPath_example // kotlin.String | 
try {
    val result : InlineResponse2004 = apiInstance.pinAdd(ipFSPath)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling IPFSPinsApi#pinAdd")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling IPFSPinsApi#pinAdd")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ipFSPath** | **kotlin.String**|  |

### Return type

[**InlineResponse2004**](InlineResponse2004.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="removePin"></a>
# **removePin**
> InlineResponse2007 removePin(ipFSPath)



Remove pinned objects from local storage

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = IPFSPinsApi()
val ipFSPath : kotlin.String = ipFSPath_example // kotlin.String | 
try {
    val result : InlineResponse2007 = apiInstance.removePin(ipFSPath)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling IPFSPinsApi#removePin")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling IPFSPinsApi#removePin")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ipFSPath** | **kotlin.String**|  |

### Return type

[**InlineResponse2007**](InlineResponse2007.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

