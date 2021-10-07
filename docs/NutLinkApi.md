# NutLinkApi

All URIs are relative to *https://cardano-mainnet.blockfrost.io/api/v0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAddress**](NutLinkApi.md#getAddress) | **GET** /nutlink/{address} | 
[**getAddressTickers**](NutLinkApi.md#getAddressTickers) | **GET** /nutlink/{address}/tickers | 
[**getTickerRecordsByAddressAndTicker**](NutLinkApi.md#getTickerRecordsByAddressAndTicker) | **GET** /nutlink/{address}/tickers/{ticker} | 
[**getTickerRecordsByTicker**](NutLinkApi.md#getTickerRecordsByTicker) | **GET** /nutlink/tickers/{ticker} | 


<a name="getAddress"></a>
# **getAddress**
> NutlinkAddress getAddress(address)



List metadata about specific address

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = NutLinkApi()
val address : kotlin.String = address_example // kotlin.String | 
try {
    val result : NutlinkAddress = apiInstance.getAddress(address)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NutLinkApi#getAddress")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutLinkApi#getAddress")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **address** | **kotlin.String**|  |

### Return type

[**NutlinkAddress**](NutlinkAddress.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAddressTickers"></a>
# **getAddressTickers**
> kotlin.collections.List&lt;NutlinkAddressTickers&gt; getAddressTickers(address, count, page, order)



List tickers for a specific metadata oracle

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = NutLinkApi()
val address : kotlin.String = address_example // kotlin.String | 
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<NutlinkAddressTickers> = apiInstance.getAddressTickers(address, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NutLinkApi#getAddressTickers")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutLinkApi#getAddressTickers")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **address** | **kotlin.String**|  |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]
 **order** | **SortOrder**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to null] [enum: asc, desc]

### Return type

[**kotlin.collections.List&lt;NutlinkAddressTickers&gt;**](NutlinkAddressTickers.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTickerRecordsByAddressAndTicker"></a>
# **getTickerRecordsByAddressAndTicker**
> kotlin.collections.List&lt;NutlinkAddressTicker&gt; getTickerRecordsByAddressAndTicker(address, ticker, count, page, order)



List of records of a specific ticker

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = NutLinkApi()
val address : kotlin.String = address_example // kotlin.String | 
val ticker : kotlin.String = ticker_example // kotlin.String | 
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<NutlinkAddressTicker> = apiInstance.getTickerRecordsByAddressAndTicker(address, ticker, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NutLinkApi#getTickerRecordsByAddressAndTicker")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutLinkApi#getTickerRecordsByAddressAndTicker")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **address** | **kotlin.String**|  |
 **ticker** | **kotlin.String**|  |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]
 **order** | **SortOrder**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to null] [enum: asc, desc]

### Return type

[**kotlin.collections.List&lt;NutlinkAddressTicker&gt;**](NutlinkAddressTicker.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTickerRecordsByTicker"></a>
# **getTickerRecordsByTicker**
> kotlin.collections.List&lt;NutlinkTickersTicker&gt; getTickerRecordsByTicker(ticker, count, page, order)



List of records of a specific ticker

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = NutLinkApi()
val ticker : kotlin.String = ticker_example // kotlin.String | 
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<NutlinkTickersTicker> = apiInstance.getTickerRecordsByTicker(ticker, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NutLinkApi#getTickerRecordsByTicker")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutLinkApi#getTickerRecordsByTicker")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ticker** | **kotlin.String**|  |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]
 **order** | **SortOrder**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to null] [enum: asc, desc]

### Return type

[**kotlin.collections.List&lt;NutlinkTickersTicker&gt;**](NutlinkTickersTicker.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

