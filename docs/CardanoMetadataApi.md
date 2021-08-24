# CardanoMetadataApi

All URIs are relative to *https://cardano-mainnet.blockfrost.io/api/v0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**metadataTxsLabelsGet**](CardanoMetadataApi.md#metadataTxsLabelsGet) | **GET** /metadata/txs/labels | Transaction metadata labels
[**metadataTxsLabelsLabelCborGet**](CardanoMetadataApi.md#metadataTxsLabelsLabelCborGet) | **GET** /metadata/txs/labels/{label}/cbor | Transaction metadata content in CBOR
[**metadataTxsLabelsLabelGet**](CardanoMetadataApi.md#metadataTxsLabelsLabelGet) | **GET** /metadata/txs/labels/{label} | Transaction metadata content in JSON


<a name="metadataTxsLabelsGet"></a>
# **metadataTxsLabelsGet**
> kotlin.collections.List&lt;kotlin.Any&gt; metadataTxsLabelsGet(count, page, order)

Transaction metadata labels

List of all used transaction metadata labels. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoMetadataApi()
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.metadataTxsLabelsGet(count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoMetadataApi#metadataTxsLabelsGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoMetadataApi#metadataTxsLabelsGet")
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

[**kotlin.collections.List&lt;kotlin.Any&gt;**](kotlin.Any.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="metadataTxsLabelsLabelCborGet"></a>
# **metadataTxsLabelsLabelCborGet**
> kotlin.collections.List&lt;kotlin.Any&gt; metadataTxsLabelsLabelCborGet(label, count, page, order)

Transaction metadata content in CBOR

Transaction metadata per label.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoMetadataApi()
val label : kotlin.String = 1990 // kotlin.String | Metadata label
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.metadataTxsLabelsLabelCborGet(label, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoMetadataApi#metadataTxsLabelsLabelCborGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoMetadataApi#metadataTxsLabelsLabelCborGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **label** | **kotlin.String**| Metadata label |
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

<a name="metadataTxsLabelsLabelGet"></a>
# **metadataTxsLabelsLabelGet**
> kotlin.collections.List&lt;kotlin.Any&gt; metadataTxsLabelsLabelGet(label, count, page, order)

Transaction metadata content in JSON

Transaction metadata per label.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoMetadataApi()
val label : kotlin.String = 1990 // kotlin.String | Metadata label
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.metadataTxsLabelsLabelGet(label, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoMetadataApi#metadataTxsLabelsLabelGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoMetadataApi#metadataTxsLabelsLabelGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **label** | **kotlin.String**| Metadata label |
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

