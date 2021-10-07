# CardanoBlocksApi

All URIs are relative to *https://cardano-mainnet.blockfrost.io/api/v0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getBlock**](CardanoBlocksApi.md#getBlock) | **GET** /blocks/{hash_or_number} | Specific block
[**getBlockInEpochInSlot**](CardanoBlocksApi.md#getBlockInEpochInSlot) | **GET** /blocks/epoch/{epoch_number}/slot/{slot_number} | Specific block in a slot in an epoch
[**getBlockInSlot**](CardanoBlocksApi.md#getBlockInSlot) | **GET** /blocks/slot/{slot_number} | Specific block in a slot
[**getBlockTransactions**](CardanoBlocksApi.md#getBlockTransactions) | **GET** /blocks/{hash_or_number}/txs | Block transactions
[**getLatestBlock**](CardanoBlocksApi.md#getLatestBlock) | **GET** /blocks/latest | Latest block
[**getNextBlocks**](CardanoBlocksApi.md#getNextBlocks) | **GET** /blocks/{hash_or_number}/next | Listing of next blocks
[**getPreviousBlocks**](CardanoBlocksApi.md#getPreviousBlocks) | **GET** /blocks/{hash_or_number}/previous | Listing of previous blocks
[**getTransactionsInLatestBlock**](CardanoBlocksApi.md#getTransactionsInLatestBlock) | **GET** /blocks/latest/txs | Latest block transactions


<a name="getBlock"></a>
# **getBlock**
> BlockContent getBlock(hashOrNumber)

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
    val result : BlockContent = apiInstance.getBlock(hashOrNumber)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoBlocksApi#getBlock")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoBlocksApi#getBlock")
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

<a name="getBlockInEpochInSlot"></a>
# **getBlockInEpochInSlot**
> BlockContent getBlockInEpochInSlot(epochNumber, slotNumber)

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
    val result : BlockContent = apiInstance.getBlockInEpochInSlot(epochNumber, slotNumber)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoBlocksApi#getBlockInEpochInSlot")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoBlocksApi#getBlockInEpochInSlot")
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

<a name="getBlockInSlot"></a>
# **getBlockInSlot**
> BlockContent getBlockInSlot(slotNumber)

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
    val result : BlockContent = apiInstance.getBlockInSlot(slotNumber)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoBlocksApi#getBlockInSlot")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoBlocksApi#getBlockInSlot")
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

<a name="getBlockTransactions"></a>
# **getBlockTransactions**
> kotlin.collections.List&lt;kotlin.String&gt; getBlockTransactions(hashOrNumber, count, page, order)

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
val order : SortOrder = order_example // SortOrder | Ordered by tx index in the block. The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.String> = apiInstance.getBlockTransactions(hashOrNumber, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoBlocksApi#getBlockTransactions")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoBlocksApi#getBlockTransactions")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hashOrNumber** | **kotlin.String**| Hash of the requested block. |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]
 **order** | **SortOrder**| Ordered by tx index in the block. The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to null] [enum: asc, desc]

### Return type

**kotlin.collections.List&lt;kotlin.String&gt;**

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getLatestBlock"></a>
# **getLatestBlock**
> BlockContent getLatestBlock()

Latest block

Return the latest block available to the backends, also known as the tip of the blockchain. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoBlocksApi()
try {
    val result : BlockContent = apiInstance.getLatestBlock()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoBlocksApi#getLatestBlock")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoBlocksApi#getLatestBlock")
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

<a name="getNextBlocks"></a>
# **getNextBlocks**
> kotlin.collections.List&lt;BlockContent&gt; getNextBlocks(hashOrNumber, count, page)

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
    val result : kotlin.collections.List<BlockContent> = apiInstance.getNextBlocks(hashOrNumber, count, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoBlocksApi#getNextBlocks")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoBlocksApi#getNextBlocks")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hashOrNumber** | **kotlin.String**| Hash of the requested block. |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]

### Return type

[**kotlin.collections.List&lt;BlockContent&gt;**](BlockContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPreviousBlocks"></a>
# **getPreviousBlocks**
> kotlin.collections.List&lt;BlockContent&gt; getPreviousBlocks(hashOrNumber, count, page)

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
    val result : kotlin.collections.List<BlockContent> = apiInstance.getPreviousBlocks(hashOrNumber, count, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoBlocksApi#getPreviousBlocks")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoBlocksApi#getPreviousBlocks")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hashOrNumber** | **kotlin.String**| Hash of the requested block |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]

### Return type

[**kotlin.collections.List&lt;BlockContent&gt;**](BlockContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTransactionsInLatestBlock"></a>
# **getTransactionsInLatestBlock**
> kotlin.collections.List&lt;kotlin.String&gt; getTransactionsInLatestBlock(count, page, order)

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
val order : SortOrder = order_example // SortOrder | Ordered by tx index in the block. The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.String> = apiInstance.getTransactionsInLatestBlock(count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoBlocksApi#getTransactionsInLatestBlock")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoBlocksApi#getTransactionsInLatestBlock")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]
 **order** | **SortOrder**| Ordered by tx index in the block. The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to null] [enum: asc, desc]

### Return type

**kotlin.collections.List&lt;kotlin.String&gt;**

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

