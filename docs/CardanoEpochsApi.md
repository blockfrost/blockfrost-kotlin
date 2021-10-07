# CardanoEpochsApi

All URIs are relative to *https://cardano-mainnet.blockfrost.io/api/v0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getActiveStakesForEpoch**](CardanoEpochsApi.md#getActiveStakesForEpoch) | **GET** /epochs/{number}/stakes | Stake distribution
[**getActiveStakesForEpochAndPool**](CardanoEpochsApi.md#getActiveStakesForEpochAndPool) | **GET** /epochs/{number}/stakes/{pool_id} | Stake distribution by pool
[**getBlocksForEpoch**](CardanoEpochsApi.md#getBlocksForEpoch) | **GET** /epochs/{number}/blocks | Block distribution
[**getBlocksForEpochAndPool**](CardanoEpochsApi.md#getBlocksForEpochAndPool) | **GET** /epochs/{number}/blocks/{pool_id} | Block distribution by pool
[**getEpoch**](CardanoEpochsApi.md#getEpoch) | **GET** /epochs/{number} | Specific epoch
[**getEpochParam**](CardanoEpochsApi.md#getEpochParam) | **GET** /epochs/{number}/parameters | Protocol parameters
[**getLatestEpoch**](CardanoEpochsApi.md#getLatestEpoch) | **GET** /epochs/latest | Latest epoch
[**getLatestEpochParam**](CardanoEpochsApi.md#getLatestEpochParam) | **GET** /epochs/latest/parameters | Latest epoch protocol parameters
[**getNextEpochs**](CardanoEpochsApi.md#getNextEpochs) | **GET** /epochs/{number}/next | Listing of next epochs
[**getPreviousEpochs**](CardanoEpochsApi.md#getPreviousEpochs) | **GET** /epochs/{number}/previous | Listing of previous epochs


<a name="getActiveStakesForEpoch"></a>
# **getActiveStakesForEpoch**
> kotlin.collections.List&lt;EpochStakeContent&gt; getActiveStakesForEpoch(number, count, page)

Stake distribution

Return the active stake distribution for the specified epoch.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoEpochsApi()
val number : kotlin.Int = 225 // kotlin.Int | Number of the epoch
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
try {
    val result : kotlin.collections.List<EpochStakeContent> = apiInstance.getActiveStakesForEpoch(number, count, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoEpochsApi#getActiveStakesForEpoch")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoEpochsApi#getActiveStakesForEpoch")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **number** | **kotlin.Int**| Number of the epoch |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]

### Return type

[**kotlin.collections.List&lt;EpochStakeContent&gt;**](EpochStakeContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getActiveStakesForEpochAndPool"></a>
# **getActiveStakesForEpochAndPool**
> kotlin.collections.List&lt;EpochStakePoolContent&gt; getActiveStakesForEpochAndPool(number, poolId, count, page)

Stake distribution by pool

Return the active stake distribution for the epoch specified by stake pool.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoEpochsApi()
val number : kotlin.Int = 225 // kotlin.Int | Number of the epoch
val poolId : kotlin.String = pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy // kotlin.String | Stake pool ID to filter
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
try {
    val result : kotlin.collections.List<EpochStakePoolContent> = apiInstance.getActiveStakesForEpochAndPool(number, poolId, count, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoEpochsApi#getActiveStakesForEpochAndPool")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoEpochsApi#getActiveStakesForEpochAndPool")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **number** | **kotlin.Int**| Number of the epoch |
 **poolId** | **kotlin.String**| Stake pool ID to filter |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]

### Return type

[**kotlin.collections.List&lt;EpochStakePoolContent&gt;**](EpochStakePoolContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getBlocksForEpoch"></a>
# **getBlocksForEpoch**
> kotlin.collections.List&lt;kotlin.String&gt; getBlocksForEpoch(number, count, page, order)

Block distribution

Return the blocks minted for the epoch specified.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoEpochsApi()
val number : kotlin.Int = 225 // kotlin.Int | Number of the epoch
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.String> = apiInstance.getBlocksForEpoch(number, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoEpochsApi#getBlocksForEpoch")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoEpochsApi#getBlocksForEpoch")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **number** | **kotlin.Int**| Number of the epoch |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]
 **order** | **SortOrder**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to null] [enum: asc, desc]

### Return type

**kotlin.collections.List&lt;kotlin.String&gt;**

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getBlocksForEpochAndPool"></a>
# **getBlocksForEpochAndPool**
> kotlin.collections.List&lt;kotlin.String&gt; getBlocksForEpochAndPool(number, poolId, count, page, order)

Block distribution by pool

Return the block minted for the epoch specified by stake pool.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoEpochsApi()
val number : kotlin.Int = 225 // kotlin.Int | Number of the epoch
val poolId : kotlin.String = pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy // kotlin.String | Stake pool ID to filter
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.String> = apiInstance.getBlocksForEpochAndPool(number, poolId, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoEpochsApi#getBlocksForEpochAndPool")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoEpochsApi#getBlocksForEpochAndPool")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **number** | **kotlin.Int**| Number of the epoch |
 **poolId** | **kotlin.String**| Stake pool ID to filter |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]
 **order** | **SortOrder**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to null] [enum: asc, desc]

### Return type

**kotlin.collections.List&lt;kotlin.String&gt;**

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getEpoch"></a>
# **getEpoch**
> EpochContent getEpoch(number)

Specific epoch

Return the content of the requested epoch.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoEpochsApi()
val number : kotlin.Int = 225 // kotlin.Int | Number of the epoch
try {
    val result : EpochContent = apiInstance.getEpoch(number)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoEpochsApi#getEpoch")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoEpochsApi#getEpoch")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **number** | **kotlin.Int**| Number of the epoch |

### Return type

[**EpochContent**](EpochContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getEpochParam"></a>
# **getEpochParam**
> EpochParamContent getEpochParam(number)

Protocol parameters

Return the protocol parameters for the epoch specified.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoEpochsApi()
val number : kotlin.Int = 225 // kotlin.Int | Number of the epoch
try {
    val result : EpochParamContent = apiInstance.getEpochParam(number)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoEpochsApi#getEpochParam")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoEpochsApi#getEpochParam")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **number** | **kotlin.Int**| Number of the epoch |

### Return type

[**EpochParamContent**](EpochParamContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getLatestEpoch"></a>
# **getLatestEpoch**
> EpochContent getLatestEpoch()

Latest epoch

Return the information about the latest, therefore current, epoch.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoEpochsApi()
try {
    val result : EpochContent = apiInstance.getLatestEpoch()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoEpochsApi#getLatestEpoch")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoEpochsApi#getLatestEpoch")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**EpochContent**](EpochContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getLatestEpochParam"></a>
# **getLatestEpochParam**
> EpochParamContent getLatestEpochParam()

Latest epoch protocol parameters

Return the protocol parameters for the latest epoch.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoEpochsApi()
try {
    val result : EpochParamContent = apiInstance.getLatestEpochParam()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoEpochsApi#getLatestEpochParam")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoEpochsApi#getLatestEpochParam")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**EpochParamContent**](EpochParamContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getNextEpochs"></a>
# **getNextEpochs**
> kotlin.collections.List&lt;EpochContent&gt; getNextEpochs(number, count, page)

Listing of next epochs

Return the list of epochs following a specific epoch.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoEpochsApi()
val number : kotlin.Int = 225 // kotlin.Int | Number of the requested epoch.
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
try {
    val result : kotlin.collections.List<EpochContent> = apiInstance.getNextEpochs(number, count, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoEpochsApi#getNextEpochs")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoEpochsApi#getNextEpochs")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **number** | **kotlin.Int**| Number of the requested epoch. |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]

### Return type

[**kotlin.collections.List&lt;EpochContent&gt;**](EpochContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPreviousEpochs"></a>
# **getPreviousEpochs**
> kotlin.collections.List&lt;EpochContent&gt; getPreviousEpochs(number, count, page)

Listing of previous epochs

Return the list of epochs preceding a specific epoch.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoEpochsApi()
val number : kotlin.Int = 225 // kotlin.Int | Number of the epoch
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results
try {
    val result : kotlin.collections.List<EpochContent> = apiInstance.getPreviousEpochs(number, count, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoEpochsApi#getPreviousEpochs")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoEpochsApi#getPreviousEpochs")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **number** | **kotlin.Int**| Number of the epoch |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results | [optional] [default to null]

### Return type

[**kotlin.collections.List&lt;EpochContent&gt;**](EpochContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

