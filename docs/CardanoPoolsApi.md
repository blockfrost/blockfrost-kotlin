# CardanoPoolsApi

All URIs are relative to *https://cardano-mainnet.blockfrost.io/api/v0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**poolsGet**](CardanoPoolsApi.md#poolsGet) | **GET** /pools | List of stake pools
[**poolsPoolIdBlocksGet**](CardanoPoolsApi.md#poolsPoolIdBlocksGet) | **GET** /pools/{pool_id}/blocks | Stake pool blocks
[**poolsPoolIdDelegatorsGet**](CardanoPoolsApi.md#poolsPoolIdDelegatorsGet) | **GET** /pools/{pool_id}/delegators | Stake pool delegators
[**poolsPoolIdGet**](CardanoPoolsApi.md#poolsPoolIdGet) | **GET** /pools/{pool_id} | Specific stake pool
[**poolsPoolIdHistoryGet**](CardanoPoolsApi.md#poolsPoolIdHistoryGet) | **GET** /pools/{pool_id}/history | Stake pool history
[**poolsPoolIdMetadataGet**](CardanoPoolsApi.md#poolsPoolIdMetadataGet) | **GET** /pools/{pool_id}/metadata | Stake pool metadata
[**poolsPoolIdRelaysGet**](CardanoPoolsApi.md#poolsPoolIdRelaysGet) | **GET** /pools/{pool_id}/relays | Stake pool relays
[**poolsPoolIdUpdatesGet**](CardanoPoolsApi.md#poolsPoolIdUpdatesGet) | **GET** /pools/{pool_id}/updates | Stake pool updates
[**poolsRetiredGet**](CardanoPoolsApi.md#poolsRetiredGet) | **GET** /pools/retired | List of retired stake pools
[**poolsRetiringGet**](CardanoPoolsApi.md#poolsRetiringGet) | **GET** /pools/retiring | List of retiring stake pools


<a name="poolsGet"></a>
# **poolsGet**
> kotlin.collections.List&lt;kotlin.String&gt; poolsGet(count, page, order)

List of stake pools

List of registered stake pools.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = CardanoPoolsApi()
val count : kotlin.Int = 56 // kotlin.Int | The numbers of pools per page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.String> = apiInstance.poolsGet(count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoPoolsApi#poolsGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoPoolsApi#poolsGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **count** | **kotlin.Int**| The numbers of pools per page. | [optional] [default to 100]
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

<a name="poolsPoolIdBlocksGet"></a>
# **poolsPoolIdBlocksGet**
> kotlin.collections.List&lt;kotlin.String&gt; poolsPoolIdBlocksGet(poolId, count, page, order)

Stake pool blocks

List of stake pools blocks.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = CardanoPoolsApi()
val poolId : kotlin.String = pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy // kotlin.String | Bech32 or hexadecimal pool ID.
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.String> = apiInstance.poolsPoolIdBlocksGet(poolId, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoPoolsApi#poolsPoolIdBlocksGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoPoolsApi#poolsPoolIdBlocksGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **poolId** | **kotlin.String**| Bech32 or hexadecimal pool ID. |
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

<a name="poolsPoolIdDelegatorsGet"></a>
# **poolsPoolIdDelegatorsGet**
> kotlin.collections.List&lt;kotlin.Any&gt; poolsPoolIdDelegatorsGet(poolId, count, page, order)

Stake pool delegators

List of current stake pools delegators.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = CardanoPoolsApi()
val poolId : kotlin.String = pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy // kotlin.String | Bech32 or hexadecimal pool ID.
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.poolsPoolIdDelegatorsGet(poolId, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoPoolsApi#poolsPoolIdDelegatorsGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoPoolsApi#poolsPoolIdDelegatorsGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **poolId** | **kotlin.String**| Bech32 or hexadecimal pool ID. |
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

<a name="poolsPoolIdGet"></a>
# **poolsPoolIdGet**
> Pool poolsPoolIdGet(poolId)

Specific stake pool

Pool information.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = CardanoPoolsApi()
val poolId : kotlin.String = pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy // kotlin.String | Bech32 or hexadecimal pool ID.
try {
    val result : Pool = apiInstance.poolsPoolIdGet(poolId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoPoolsApi#poolsPoolIdGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoPoolsApi#poolsPoolIdGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **poolId** | **kotlin.String**| Bech32 or hexadecimal pool ID. |

### Return type

[**Pool**](Pool.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="poolsPoolIdHistoryGet"></a>
# **poolsPoolIdHistoryGet**
> kotlin.collections.List&lt;kotlin.Any&gt; poolsPoolIdHistoryGet(poolId, count, page, order)

Stake pool history

History of stake pool parameters over epochs. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = CardanoPoolsApi()
val poolId : kotlin.String = pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy // kotlin.String | Bech32 or hexadecimal pool ID.
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.poolsPoolIdHistoryGet(poolId, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoPoolsApi#poolsPoolIdHistoryGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoPoolsApi#poolsPoolIdHistoryGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **poolId** | **kotlin.String**| Bech32 or hexadecimal pool ID. |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to 100]
 **page** | **kotlin.Int**| The page number for listing the results | [optional] [default to 1]
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

<a name="poolsPoolIdMetadataGet"></a>
# **poolsPoolIdMetadataGet**
> AnyOfLessThanPoolMetadataCommaObjectGreaterThan poolsPoolIdMetadataGet(poolId)

Stake pool metadata

Stake pool registration metadata. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = CardanoPoolsApi()
val poolId : kotlin.String = pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy // kotlin.String | Bech32 or hexadecimal pool ID.
try {
    val result : AnyOfLessThanPoolMetadataCommaObjectGreaterThan = apiInstance.poolsPoolIdMetadataGet(poolId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoPoolsApi#poolsPoolIdMetadataGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoPoolsApi#poolsPoolIdMetadataGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **poolId** | **kotlin.String**| Bech32 or hexadecimal pool ID. |

### Return type

[**AnyOfLessThanPoolMetadataCommaObjectGreaterThan**](AnyOfLessThanPoolMetadataCommaObjectGreaterThan.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="poolsPoolIdRelaysGet"></a>
# **poolsPoolIdRelaysGet**
> kotlin.collections.List&lt;kotlin.Any&gt; poolsPoolIdRelaysGet(poolId)

Stake pool relays

Relays of a stake pool.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = CardanoPoolsApi()
val poolId : kotlin.String = pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy // kotlin.String | Bech32 or hexadecimal pool ID.
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.poolsPoolIdRelaysGet(poolId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoPoolsApi#poolsPoolIdRelaysGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoPoolsApi#poolsPoolIdRelaysGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **poolId** | **kotlin.String**| Bech32 or hexadecimal pool ID. |

### Return type

[**kotlin.collections.List&lt;kotlin.Any&gt;**](kotlin.Any.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="poolsPoolIdUpdatesGet"></a>
# **poolsPoolIdUpdatesGet**
> kotlin.collections.List&lt;kotlin.Any&gt; poolsPoolIdUpdatesGet(poolId, count, page, order)

Stake pool updates

List of certificate updates to the stake pool.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = CardanoPoolsApi()
val poolId : kotlin.String = pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy // kotlin.String | Bech32 or hexadecimal pool ID.
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.poolsPoolIdUpdatesGet(poolId, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoPoolsApi#poolsPoolIdUpdatesGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoPoolsApi#poolsPoolIdUpdatesGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **poolId** | **kotlin.String**| Bech32 or hexadecimal pool ID. |
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

<a name="poolsRetiredGet"></a>
# **poolsRetiredGet**
> kotlin.collections.List&lt;kotlin.Any&gt; poolsRetiredGet(count, page, order)

List of retired stake pools

List of already retired pools.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = CardanoPoolsApi()
val count : kotlin.Int = 56 // kotlin.Int | The numbers of pools per page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.poolsRetiredGet(count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoPoolsApi#poolsRetiredGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoPoolsApi#poolsRetiredGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **count** | **kotlin.Int**| The numbers of pools per page. | [optional] [default to 100]
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

<a name="poolsRetiringGet"></a>
# **poolsRetiringGet**
> kotlin.collections.List&lt;kotlin.Any&gt; poolsRetiringGet(count, page, order)

List of retiring stake pools

List of stake pools retiring in the upcoming epochs

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = CardanoPoolsApi()
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.poolsRetiringGet(count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoPoolsApi#poolsRetiringGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoPoolsApi#poolsRetiringGet")
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

