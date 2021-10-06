# NutLinkApi

All URIs are relative to *https://cardano-mainnet.blockfrost.io/api/v0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**nutlinkAddressGet**](NutLinkApi.md#nutlinkAddressGet) | **GET** /nutlink/{address} | 
[**nutlinkAddressTickersGet**](NutLinkApi.md#nutlinkAddressTickersGet) | **GET** /nutlink/{address}/tickers | 
[**nutlinkAddressTickersTickerGet**](NutLinkApi.md#nutlinkAddressTickersTickerGet) | **GET** /nutlink/{address}/tickers/{ticker} | 
[**nutlinkTickersTickerGet**](NutLinkApi.md#nutlinkTickersTickerGet) | **GET** /nutlink/tickers/{ticker} | 


<a name="nutlinkAddressGet"></a>
# **nutlinkAddressGet**
> NutlinkAddress nutlinkAddressGet(address)



List metadata about specific address

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = NutLinkApi()
val address : kotlin.String = address_example // kotlin.String | 
try {
    val result : NutlinkAddress = apiInstance.nutlinkAddressGet(address)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NutLinkApi#nutlinkAddressGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutLinkApi#nutlinkAddressGet")
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

<a name="nutlinkAddressTickersGet"></a>
# **nutlinkAddressTickersGet**
> kotlin.collections.List&lt;kotlin.Any&gt; nutlinkAddressTickersGet(address, count, page, order)



List tickers for a specific metadata oracle

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = NutLinkApi()
val address : kotlin.String = address_example // kotlin.String | 
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.nutlinkAddressTickersGet(address, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NutLinkApi#nutlinkAddressTickersGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutLinkApi#nutlinkAddressTickersGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **address** | **kotlin.String**|  |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to 100]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to 1]
 **order** | **kotlin.String**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to asc] [enum: asc, desc]

### Return type

[**kotlin.collections.List&lt;kotlin.Any&gt;**](kotlin.Any.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="nutlinkAddressTickersTickerGet"></a>
# **nutlinkAddressTickersTickerGet**
> kotlin.collections.List&lt;kotlin.Any&gt; nutlinkAddressTickersTickerGet(address, ticker, count, page, order)



List of records of a specific ticker

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = NutLinkApi()
val address : kotlin.String = address_example // kotlin.String | 
val ticker : kotlin.String = ticker_example // kotlin.String | 
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.nutlinkAddressTickersTickerGet(address, ticker, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NutLinkApi#nutlinkAddressTickersTickerGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutLinkApi#nutlinkAddressTickersTickerGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **address** | **kotlin.String**|  |
 **ticker** | **kotlin.String**|  |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to 100]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to 1]
 **order** | **kotlin.String**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to asc] [enum: asc, desc]

### Return type

[**kotlin.collections.List&lt;kotlin.Any&gt;**](kotlin.Any.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="nutlinkTickersTickerGet"></a>
# **nutlinkTickersTickerGet**
> kotlin.collections.List&lt;kotlin.Any&gt; nutlinkTickersTickerGet(ticker, count, page, order)



List of records of a specific ticker

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = NutLinkApi()
val ticker : kotlin.String = ticker_example // kotlin.String | 
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.nutlinkTickersTickerGet(ticker, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NutLinkApi#nutlinkTickersTickerGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NutLinkApi#nutlinkTickersTickerGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ticker** | **kotlin.String**|  |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to 100]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to 1]
 **order** | **kotlin.String**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to asc] [enum: asc, desc]

### Return type

[**kotlin.collections.List&lt;kotlin.Any&gt;**](kotlin.Any.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

