# CardanoMetadataApi

All URIs are relative to *https://cardano-mainnet.blockfrost.io/api/v0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getTransactionMetadataCborForLabel**](CardanoMetadataApi.md#getTransactionMetadataCborForLabel) | **GET** /metadata/txs/labels/{label}/cbor | Transaction metadata content in CBOR
[**getTransactionMetadataJsonForLabel**](CardanoMetadataApi.md#getTransactionMetadataJsonForLabel) | **GET** /metadata/txs/labels/{label} | Transaction metadata content in JSON
[**getTransactionMetadataLabels**](CardanoMetadataApi.md#getTransactionMetadataLabels) | **GET** /metadata/txs/labels | Transaction metadata labels


<a name="getTransactionMetadataCborForLabel"></a>
# **getTransactionMetadataCborForLabel**
> kotlin.collections.List&lt;TxMetadataLabelCbor&gt; getTransactionMetadataCborForLabel(label, count, page, order)

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
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<TxMetadataLabelCbor> = apiInstance.getTransactionMetadataCborForLabel(label, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoMetadataApi#getTransactionMetadataCborForLabel")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoMetadataApi#getTransactionMetadataCborForLabel")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **label** | **kotlin.String**| Metadata label |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]
 **order** | **SortOrder**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to null] [enum: asc, desc]

### Return type

[**kotlin.collections.List&lt;TxMetadataLabelCbor&gt;**](TxMetadataLabelCbor.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTransactionMetadataJsonForLabel"></a>
# **getTransactionMetadataJsonForLabel**
> kotlin.collections.List&lt;TxMetadataLabelJson&gt; getTransactionMetadataJsonForLabel(label, count, page, order)

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
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<TxMetadataLabelJson> = apiInstance.getTransactionMetadataJsonForLabel(label, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoMetadataApi#getTransactionMetadataJsonForLabel")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoMetadataApi#getTransactionMetadataJsonForLabel")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **label** | **kotlin.String**| Metadata label |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]
 **order** | **SortOrder**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to null] [enum: asc, desc]

### Return type

[**kotlin.collections.List&lt;TxMetadataLabelJson&gt;**](TxMetadataLabelJson.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTransactionMetadataLabels"></a>
# **getTransactionMetadataLabels**
> kotlin.collections.List&lt;TxMetadataLabel&gt; getTransactionMetadataLabels(count, page, order)

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
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<TxMetadataLabel> = apiInstance.getTransactionMetadataLabels(count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoMetadataApi#getTransactionMetadataLabels")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoMetadataApi#getTransactionMetadataLabels")
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

[**kotlin.collections.List&lt;TxMetadataLabel&gt;**](TxMetadataLabel.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

