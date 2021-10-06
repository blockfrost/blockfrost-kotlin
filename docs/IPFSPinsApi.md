# IPFSPinsApi

All URIs are relative to *https://cardano-mainnet.blockfrost.io/api/v0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**ipfsPinAddIPFSPathPost**](IPFSPinsApi.md#ipfsPinAddIPFSPathPost) | **POST** /ipfs/pin/add/{IPFS_path} | Pin an object
[**ipfsPinListGet**](IPFSPinsApi.md#ipfsPinListGet) | **GET** /ipfs/pin/list/ | 
[**ipfsPinListIPFSPathGet**](IPFSPinsApi.md#ipfsPinListIPFSPathGet) | **GET** /ipfs/pin/list/{IPFS_path} | 
[**ipfsPinRemoveIPFSPathPost**](IPFSPinsApi.md#ipfsPinRemoveIPFSPathPost) | **POST** /ipfs/pin/remove/{IPFS_path} | 


<a name="ipfsPinAddIPFSPathPost"></a>
# **ipfsPinAddIPFSPathPost**
> InlineResponse2004 ipfsPinAddIPFSPathPost(ipFSPath)

Pin an object

Pinned objects are counted in your user storage quota.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = IPFSPinsApi()
val ipFSPath : kotlin.String = ipFSPath_example // kotlin.String | 
try {
    val result : InlineResponse2004 = apiInstance.ipfsPinAddIPFSPathPost(ipFSPath)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling IPFSPinsApi#ipfsPinAddIPFSPathPost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling IPFSPinsApi#ipfsPinAddIPFSPathPost")
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

<a name="ipfsPinListGet"></a>
# **ipfsPinListGet**
> kotlin.collections.List&lt;InlineResponse2005&gt; ipfsPinListGet(count, page, order)



List objects pinned to local storage

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = IPFSPinsApi()
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<InlineResponse2005> = apiInstance.ipfsPinListGet(count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling IPFSPinsApi#ipfsPinListGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling IPFSPinsApi#ipfsPinListGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to 100]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to 1]
 **order** | **kotlin.String**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to asc] [enum: asc, desc]

### Return type

[**kotlin.collections.List&lt;InlineResponse2005&gt;**](InlineResponse2005.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="ipfsPinListIPFSPathGet"></a>
# **ipfsPinListIPFSPathGet**
> InlineResponse2006 ipfsPinListIPFSPathGet(ipFSPath)



List objects pinned to local storage

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = IPFSPinsApi()
val ipFSPath : kotlin.String = ipFSPath_example // kotlin.String | 
try {
    val result : InlineResponse2006 = apiInstance.ipfsPinListIPFSPathGet(ipFSPath)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling IPFSPinsApi#ipfsPinListIPFSPathGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling IPFSPinsApi#ipfsPinListIPFSPathGet")
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

<a name="ipfsPinRemoveIPFSPathPost"></a>
# **ipfsPinRemoveIPFSPathPost**
> InlineResponse2007 ipfsPinRemoveIPFSPathPost(ipFSPath)



Remove pinned objects from local storage

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = IPFSPinsApi()
val ipFSPath : kotlin.String = ipFSPath_example // kotlin.String | 
try {
    val result : InlineResponse2007 = apiInstance.ipfsPinRemoveIPFSPathPost(ipFSPath)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling IPFSPinsApi#ipfsPinRemoveIPFSPathPost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling IPFSPinsApi#ipfsPinRemoveIPFSPathPost")
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

