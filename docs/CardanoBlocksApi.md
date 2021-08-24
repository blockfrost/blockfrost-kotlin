# CardanoBlocksApi

All URIs are relative to *https://cardano-mainnet.blockfrost.io/api/v0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**blocksEpochEpochNumberSlotSlotNumberGet**](CardanoBlocksApi.md#blocksEpochEpochNumberSlotSlotNumberGet) | **GET** /blocks/epoch/{epoch_number}/slot/{slot_number} | Specific block in a slot in an epoch
[**blocksHashOrNumberGet**](CardanoBlocksApi.md#blocksHashOrNumberGet) | **GET** /blocks/{hash_or_number} | Specific block
[**blocksHashOrNumberNextGet**](CardanoBlocksApi.md#blocksHashOrNumberNextGet) | **GET** /blocks/{hash_or_number}/next | Listing of next blocks
[**blocksHashOrNumberPreviousGet**](CardanoBlocksApi.md#blocksHashOrNumberPreviousGet) | **GET** /blocks/{hash_or_number}/previous | Listing of previous blocks
[**blocksHashOrNumberTxsGet**](CardanoBlocksApi.md#blocksHashOrNumberTxsGet) | **GET** /blocks/{hash_or_number}/txs | Block transactions
[**blocksLatestGet**](CardanoBlocksApi.md#blocksLatestGet) | **GET** /blocks/latest | Latest block
[**blocksLatestTxsGet**](CardanoBlocksApi.md#blocksLatestTxsGet) | **GET** /blocks/latest/txs | Latest block transactions
[**blocksSlotSlotNumberGet**](CardanoBlocksApi.md#blocksSlotSlotNumberGet) | **GET** /blocks/slot/{slot_number} | Specific block in a slot


<a name="blocksEpochEpochNumberSlotSlotNumberGet"></a>
# **blocksEpochEpochNumberSlotSlotNumberGet**
> BlockContent blocksEpochEpochNumberSlotSlotNumberGet(epochNumber, slotNumber)

Specific block in a slot in an epoch

Return the content of a requested block for a specific slot in an epoch. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoBlocksApi()
val epochNumber : kotlin.Int = 219 // kotlin.Int | Epoch for specific epoch slot.
val slotNumber : kotlin.Int = 30895909 // kotlin.Int | Slot position for requested block.
try {
    val result : BlockContent = apiInstance.blocksEpochEpochNumberSlotSlotNumberGet(epochNumber, slotNumber)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoBlocksApi#blocksEpochEpochNumberSlotSlotNumberGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoBlocksApi#blocksEpochEpochNumberSlotSlotNumberGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **epochNumber** | **kotlin.Int**| Epoch for specific epoch slot. |
 **slotNumber** | **kotlin.Int**| Slot position for requested block. |

### Return type

[**BlockContent**](BlockContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="blocksHashOrNumberGet"></a>
# **blocksHashOrNumberGet**
> BlockContent blocksHashOrNumberGet(hashOrNumber)

Specific block

Return the content of a requested block. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoBlocksApi()
val hashOrNumber : kotlin.String = 4ea1ba291e8eef538635a53e59fddba7810d1679631cc3aed7c8e6c4091a516a // kotlin.String | Hash or number of the requested block.
try {
    val result : BlockContent = apiInstance.blocksHashOrNumberGet(hashOrNumber)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoBlocksApi#blocksHashOrNumberGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoBlocksApi#blocksHashOrNumberGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hashOrNumber** | **kotlin.String**| Hash or number of the requested block. |

### Return type

[**BlockContent**](BlockContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="blocksHashOrNumberNextGet"></a>
# **blocksHashOrNumberNextGet**
> kotlin.collections.List&lt;BlockContent&gt; blocksHashOrNumberNextGet(hashOrNumber, count, page)

Listing of next blocks

Return the list of blocks following a specific block. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoBlocksApi()
val hashOrNumber : kotlin.String = 5ea1ba291e8eef538635a53e59fddba7810d1679631cc3aed7c8e6c4091a516a // kotlin.String | Hash of the requested block.
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
try {
    val result : kotlin.collections.List<BlockContent> = apiInstance.blocksHashOrNumberNextGet(hashOrNumber, count, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoBlocksApi#blocksHashOrNumberNextGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoBlocksApi#blocksHashOrNumberNextGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hashOrNumber** | **kotlin.String**| Hash of the requested block. |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to 100]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to 1]

### Return type

[**kotlin.collections.List&lt;BlockContent&gt;**](BlockContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="blocksHashOrNumberPreviousGet"></a>
# **blocksHashOrNumberPreviousGet**
> kotlin.collections.List&lt;BlockContent&gt; blocksHashOrNumberPreviousGet(hashOrNumber, count, page)

Listing of previous blocks

Return the list of blocks preceding a specific block. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoBlocksApi()
val hashOrNumber : kotlin.String = 4873401 // kotlin.String | Hash of the requested block
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
try {
    val result : kotlin.collections.List<BlockContent> = apiInstance.blocksHashOrNumberPreviousGet(hashOrNumber, count, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoBlocksApi#blocksHashOrNumberPreviousGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoBlocksApi#blocksHashOrNumberPreviousGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hashOrNumber** | **kotlin.String**| Hash of the requested block |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to 100]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to 1]

### Return type

[**kotlin.collections.List&lt;BlockContent&gt;**](BlockContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="blocksHashOrNumberTxsGet"></a>
# **blocksHashOrNumberTxsGet**
> kotlin.collections.List&lt;kotlin.String&gt; blocksHashOrNumberTxsGet(hashOrNumber, count, page, order)

Block transactions

Return the transactions within the block.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoBlocksApi()
val hashOrNumber : kotlin.String = 4873401 // kotlin.String | Hash of the requested block.
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | Ordered by tx index in the block. The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.String> = apiInstance.blocksHashOrNumberTxsGet(hashOrNumber, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoBlocksApi#blocksHashOrNumberTxsGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoBlocksApi#blocksHashOrNumberTxsGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hashOrNumber** | **kotlin.String**| Hash of the requested block. |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to 100]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to 1]
 **order** | **kotlin.String**| Ordered by tx index in the block. The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to asc] [enum: asc, desc]

### Return type

**kotlin.collections.List&lt;kotlin.String&gt;**

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="blocksLatestGet"></a>
# **blocksLatestGet**
> BlockContent blocksLatestGet()

Latest block

Return the latest block available to the backends, also known as the tip of the blockchain. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoBlocksApi()
try {
    val result : BlockContent = apiInstance.blocksLatestGet()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoBlocksApi#blocksLatestGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoBlocksApi#blocksLatestGet")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**BlockContent**](BlockContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="blocksLatestTxsGet"></a>
# **blocksLatestTxsGet**
> kotlin.collections.List&lt;kotlin.String&gt; blocksLatestTxsGet(count, page, order)

Latest block transactions

Return the transactions within the latest block.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoBlocksApi()
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | Ordered by tx index in the block. The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.String> = apiInstance.blocksLatestTxsGet(count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoBlocksApi#blocksLatestTxsGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoBlocksApi#blocksLatestTxsGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to 100]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to 1]
 **order** | **kotlin.String**| Ordered by tx index in the block. The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to asc] [enum: asc, desc]

### Return type

**kotlin.collections.List&lt;kotlin.String&gt;**

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="blocksSlotSlotNumberGet"></a>
# **blocksSlotSlotNumberGet**
> BlockContent blocksSlotSlotNumberGet(slotNumber)

Specific block in a slot

Return the content of a requested block for a specific slot. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoBlocksApi()
val slotNumber : kotlin.Int = 30895909 // kotlin.Int | Slot position for requested block.
try {
    val result : BlockContent = apiInstance.blocksSlotSlotNumberGet(slotNumber)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoBlocksApi#blocksSlotSlotNumberGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoBlocksApi#blocksSlotSlotNumberGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **slotNumber** | **kotlin.Int**| Slot position for requested block. |

### Return type

[**BlockContent**](BlockContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

