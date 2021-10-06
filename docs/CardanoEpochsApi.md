# CardanoEpochsApi

All URIs are relative to *https://cardano-mainnet.blockfrost.io/api/v0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**epochsLatestGet**](CardanoEpochsApi.md#epochsLatestGet) | **GET** /epochs/latest | Latest epoch
[**epochsLatestParametersGet**](CardanoEpochsApi.md#epochsLatestParametersGet) | **GET** /epochs/latest/parameters | Latest epoch protocol parameters
[**epochsNumberBlocksGet**](CardanoEpochsApi.md#epochsNumberBlocksGet) | **GET** /epochs/{number}/blocks | Block distribution
[**epochsNumberBlocksPoolIdGet**](CardanoEpochsApi.md#epochsNumberBlocksPoolIdGet) | **GET** /epochs/{number}/blocks/{pool_id} | Block distribution
[**epochsNumberGet**](CardanoEpochsApi.md#epochsNumberGet) | **GET** /epochs/{number} | Specific epoch
[**epochsNumberNextGet**](CardanoEpochsApi.md#epochsNumberNextGet) | **GET** /epochs/{number}/next | Listing of next epochs
[**epochsNumberParametersGet**](CardanoEpochsApi.md#epochsNumberParametersGet) | **GET** /epochs/{number}/parameters | Protocol parameters
[**epochsNumberPreviousGet**](CardanoEpochsApi.md#epochsNumberPreviousGet) | **GET** /epochs/{number}/previous | Listing of previous epochs
[**epochsNumberStakesGet**](CardanoEpochsApi.md#epochsNumberStakesGet) | **GET** /epochs/{number}/stakes | Stake distribution
[**epochsNumberStakesPoolIdGet**](CardanoEpochsApi.md#epochsNumberStakesPoolIdGet) | **GET** /epochs/{number}/stakes/{pool_id} | Stake distribution by pool


<a name="epochsLatestGet"></a>
# **epochsLatestGet**
> EpochContent epochsLatestGet()

Latest epoch

Return the information about the latest, therefore current, epoch.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = CardanoEpochsApi()
try {
    val result : EpochContent = apiInstance.epochsLatestGet()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoEpochsApi#epochsLatestGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoEpochsApi#epochsLatestGet")
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

<a name="epochsLatestParametersGet"></a>
# **epochsLatestParametersGet**
> EpochParamContent epochsLatestParametersGet()

Latest epoch protocol parameters

Return the protocol parameters for the latest epoch.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = CardanoEpochsApi()
try {
    val result : EpochParamContent = apiInstance.epochsLatestParametersGet()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoEpochsApi#epochsLatestParametersGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoEpochsApi#epochsLatestParametersGet")
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

<a name="epochsNumberBlocksGet"></a>
# **epochsNumberBlocksGet**
> kotlin.collections.List&lt;kotlin.String&gt; epochsNumberBlocksGet(number, count, page, order)

Block distribution

Return the blocks minted for the epoch specified.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = CardanoEpochsApi()
val number : kotlin.Int = 225 // kotlin.Int | Number of the epoch
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.String> = apiInstance.epochsNumberBlocksGet(number, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoEpochsApi#epochsNumberBlocksGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoEpochsApi#epochsNumberBlocksGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **number** | **kotlin.Int**| Number of the epoch |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to 100]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to 1]
 **order** | **kotlin.String**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to asc] [enum: asc, desc]

### Return type

**kotlin.collections.List&lt;kotlin.String&gt;**

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="epochsNumberBlocksPoolIdGet"></a>
# **epochsNumberBlocksPoolIdGet**
> kotlin.collections.List&lt;kotlin.String&gt; epochsNumberBlocksPoolIdGet(number, poolId, count, page, order)

Block distribution

Return the block minted for the epoch specified by stake pool.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = CardanoEpochsApi()
val number : kotlin.Int = 225 // kotlin.Int | Number of the epoch
val poolId : kotlin.String = pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy // kotlin.String | Stake pool ID to filter
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.String> = apiInstance.epochsNumberBlocksPoolIdGet(number, poolId, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoEpochsApi#epochsNumberBlocksPoolIdGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoEpochsApi#epochsNumberBlocksPoolIdGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **number** | **kotlin.Int**| Number of the epoch |
 **poolId** | **kotlin.String**| Stake pool ID to filter |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to 100]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to 1]
 **order** | **kotlin.String**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to asc] [enum: asc, desc]

### Return type

**kotlin.collections.List&lt;kotlin.String&gt;**

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="epochsNumberGet"></a>
# **epochsNumberGet**
> EpochContent epochsNumberGet(number)

Specific epoch

Return the content of the requested epoch.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = CardanoEpochsApi()
val number : kotlin.Int = 225 // kotlin.Int | Number of the epoch
try {
    val result : EpochContent = apiInstance.epochsNumberGet(number)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoEpochsApi#epochsNumberGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoEpochsApi#epochsNumberGet")
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

<a name="epochsNumberNextGet"></a>
# **epochsNumberNextGet**
> kotlin.collections.List&lt;EpochContent&gt; epochsNumberNextGet(number, count, page)

Listing of next epochs

Return the list of epochs following a specific epoch.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = CardanoEpochsApi()
val number : kotlin.Int = 225 // kotlin.Int | Number of the requested epoch.
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
try {
    val result : kotlin.collections.List<EpochContent> = apiInstance.epochsNumberNextGet(number, count, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoEpochsApi#epochsNumberNextGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoEpochsApi#epochsNumberNextGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **number** | **kotlin.Int**| Number of the requested epoch. |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to 100]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to 1]

### Return type

[**kotlin.collections.List&lt;EpochContent&gt;**](EpochContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="epochsNumberParametersGet"></a>
# **epochsNumberParametersGet**
> EpochParamContent epochsNumberParametersGet(number)

Protocol parameters

Return the protocol parameters for the epoch specified.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = CardanoEpochsApi()
val number : kotlin.Int = 225 // kotlin.Int | Number of the epoch
try {
    val result : EpochParamContent = apiInstance.epochsNumberParametersGet(number)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoEpochsApi#epochsNumberParametersGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoEpochsApi#epochsNumberParametersGet")
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

<a name="epochsNumberPreviousGet"></a>
# **epochsNumberPreviousGet**
> kotlin.collections.List&lt;EpochContent&gt; epochsNumberPreviousGet(number, count, page)

Listing of previous epochs

Return the list of epochs preceding a specific epoch.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = CardanoEpochsApi()
val number : kotlin.Int = 225 // kotlin.Int | Number of the epoch
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results
try {
    val result : kotlin.collections.List<EpochContent> = apiInstance.epochsNumberPreviousGet(number, count, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoEpochsApi#epochsNumberPreviousGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoEpochsApi#epochsNumberPreviousGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **number** | **kotlin.Int**| Number of the epoch |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to 100]
 **page** | **kotlin.Int**| The page number for listing the results | [optional] [default to 1]

### Return type

[**kotlin.collections.List&lt;EpochContent&gt;**](EpochContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="epochsNumberStakesGet"></a>
# **epochsNumberStakesGet**
> kotlin.collections.List&lt;kotlin.Any&gt; epochsNumberStakesGet(number, count, page)

Stake distribution

Return the active stake distribution for the specified epoch.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = CardanoEpochsApi()
val number : kotlin.Int = 225 // kotlin.Int | Number of the epoch
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.epochsNumberStakesGet(number, count, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoEpochsApi#epochsNumberStakesGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoEpochsApi#epochsNumberStakesGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **number** | **kotlin.Int**| Number of the epoch |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to 100]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to 1]

### Return type

[**kotlin.collections.List&lt;kotlin.Any&gt;**](kotlin.Any.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="epochsNumberStakesPoolIdGet"></a>
# **epochsNumberStakesPoolIdGet**
> kotlin.collections.List&lt;kotlin.Any&gt; epochsNumberStakesPoolIdGet(number, poolId, count, page)

Stake distribution by pool

Return the active stake distribution for the epoch specified by stake pool.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = CardanoEpochsApi()
val number : kotlin.Int = 225 // kotlin.Int | Number of the epoch
val poolId : kotlin.String = pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy // kotlin.String | Stake pool ID to filter
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.epochsNumberStakesPoolIdGet(number, poolId, count, page)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoEpochsApi#epochsNumberStakesPoolIdGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoEpochsApi#epochsNumberStakesPoolIdGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **number** | **kotlin.Int**| Number of the epoch |
 **poolId** | **kotlin.String**| Stake pool ID to filter |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to 100]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to 1]

### Return type

[**kotlin.collections.List&lt;kotlin.Any&gt;**](kotlin.Any.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

