# CardanoPoolsApi

All URIs are relative to *https://cardano-mainnet.blockfrost.io/api/v0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getPool**](CardanoPoolsApi.md#getPool) | **GET** /pools/{pool_id} | Specific stake pool
[**getPoolBlocks**](CardanoPoolsApi.md#getPoolBlocks) | **GET** /pools/{pool_id}/blocks | Stake pool blocks
[**getPoolDelegators**](CardanoPoolsApi.md#getPoolDelegators) | **GET** /pools/{pool_id}/delegators | Stake pool delegators
[**getPoolHistory**](CardanoPoolsApi.md#getPoolHistory) | **GET** /pools/{pool_id}/history | Stake pool history
[**getPoolMetadata**](CardanoPoolsApi.md#getPoolMetadata) | **GET** /pools/{pool_id}/metadata | Stake pool metadata
[**getPoolRelays**](CardanoPoolsApi.md#getPoolRelays) | **GET** /pools/{pool_id}/relays | Stake pool relays
[**getPoolUpdates**](CardanoPoolsApi.md#getPoolUpdates) | **GET** /pools/{pool_id}/updates | Stake pool updates
[**getPools**](CardanoPoolsApi.md#getPools) | **GET** /pools | List of stake pools
[**getRetiredPools**](CardanoPoolsApi.md#getRetiredPools) | **GET** /pools/retired | List of retired stake pools
[**getRetiringPools**](CardanoPoolsApi.md#getRetiringPools) | **GET** /pools/retiring | List of retiring stake pools


<a name="getPool"></a>
# **getPool**
> Pool getPool(poolId)

Specific stake pool

Pool information.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoPoolsApi()
val poolId : kotlin.String = pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy // kotlin.String | Bech32 or hexadecimal pool ID.
try {
    val result : Pool = apiInstance.getPool(poolId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoPoolsApi#getPool")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoPoolsApi#getPool")
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

<a name="getPoolBlocks"></a>
# **getPoolBlocks**
> kotlin.collections.List&lt;kotlin.String&gt; getPoolBlocks(poolId, count, page, order)

Stake pool blocks

List of stake pools blocks.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoPoolsApi()
val poolId : kotlin.String = pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy // kotlin.String | Bech32 or hexadecimal pool ID.
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.String> = apiInstance.getPoolBlocks(poolId, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoPoolsApi#getPoolBlocks")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoPoolsApi#getPoolBlocks")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **poolId** | **kotlin.String**| Bech32 or hexadecimal pool ID. |
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

<a name="getPoolDelegators"></a>
# **getPoolDelegators**
> kotlin.collections.List&lt;PoolDelegator&gt; getPoolDelegators(poolId, count, page, order)

Stake pool delegators

List of current stake pools delegators.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoPoolsApi()
val poolId : kotlin.String = pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy // kotlin.String | Bech32 or hexadecimal pool ID.
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<PoolDelegator> = apiInstance.getPoolDelegators(poolId, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoPoolsApi#getPoolDelegators")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoPoolsApi#getPoolDelegators")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **poolId** | **kotlin.String**| Bech32 or hexadecimal pool ID. |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]
 **order** | **SortOrder**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to null] [enum: asc, desc]

### Return type

[**kotlin.collections.List&lt;PoolDelegator&gt;**](PoolDelegator.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPoolHistory"></a>
# **getPoolHistory**
> kotlin.collections.List&lt;PoolHistory&gt; getPoolHistory(poolId, count, page, order)

Stake pool history

History of stake pool parameters over epochs. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoPoolsApi()
val poolId : kotlin.String = pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy // kotlin.String | Bech32 or hexadecimal pool ID.
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<PoolHistory> = apiInstance.getPoolHistory(poolId, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoPoolsApi#getPoolHistory")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoPoolsApi#getPoolHistory")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **poolId** | **kotlin.String**| Bech32 or hexadecimal pool ID. |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results | [optional] [default to null]
 **order** | **SortOrder**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to null] [enum: asc, desc]

### Return type

[**kotlin.collections.List&lt;PoolHistory&gt;**](PoolHistory.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPoolMetadata"></a>
# **getPoolMetadata**
> AnyOfLessThanPoolMetadataCommaObjectGreaterThan getPoolMetadata(poolId)

Stake pool metadata

Stake pool registration metadata. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoPoolsApi()
val poolId : kotlin.String = pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy // kotlin.String | Bech32 or hexadecimal pool ID.
try {
    val result : AnyOfLessThanPoolMetadataCommaObjectGreaterThan = apiInstance.getPoolMetadata(poolId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoPoolsApi#getPoolMetadata")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoPoolsApi#getPoolMetadata")
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

<a name="getPoolRelays"></a>
# **getPoolRelays**
> kotlin.collections.List&lt;PoolRelay&gt; getPoolRelays(poolId)

Stake pool relays

Relays of a stake pool.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoPoolsApi()
val poolId : kotlin.String = pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy // kotlin.String | Bech32 or hexadecimal pool ID.
try {
    val result : kotlin.collections.List<PoolRelay> = apiInstance.getPoolRelays(poolId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoPoolsApi#getPoolRelays")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoPoolsApi#getPoolRelays")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **poolId** | **kotlin.String**| Bech32 or hexadecimal pool ID. |

### Return type

[**kotlin.collections.List&lt;PoolRelay&gt;**](PoolRelay.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPoolUpdates"></a>
# **getPoolUpdates**
> kotlin.collections.List&lt;PoolUpdate&gt; getPoolUpdates(poolId, count, page, order)

Stake pool updates

List of certificate updates to the stake pool.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoPoolsApi()
val poolId : kotlin.String = pool1pu5jlj4q9w9jlxeu370a3c9myx47md5j5m2str0naunn2q3lkdy // kotlin.String | Bech32 or hexadecimal pool ID.
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<PoolUpdate> = apiInstance.getPoolUpdates(poolId, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoPoolsApi#getPoolUpdates")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoPoolsApi#getPoolUpdates")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **poolId** | **kotlin.String**| Bech32 or hexadecimal pool ID. |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]
 **order** | **SortOrder**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to null] [enum: asc, desc]

### Return type

[**kotlin.collections.List&lt;PoolUpdate&gt;**](PoolUpdate.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPools"></a>
# **getPools**
> kotlin.collections.List&lt;kotlin.String&gt; getPools(count, page, order)

List of stake pools

List of registered stake pools.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoPoolsApi()
val count : kotlin.Int = 56 // kotlin.Int | The numbers of pools per page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.String> = apiInstance.getPools(count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoPoolsApi#getPools")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoPoolsApi#getPools")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **count** | **kotlin.Int**| The numbers of pools per page. | [optional] [default to null]
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

<a name="getRetiredPools"></a>
# **getRetiredPools**
> kotlin.collections.List&lt;PoolListRetire&gt; getRetiredPools(count, page, order)

List of retired stake pools

List of already retired pools.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoPoolsApi()
val count : kotlin.Int = 56 // kotlin.Int | The numbers of pools per page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<PoolListRetire> = apiInstance.getRetiredPools(count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoPoolsApi#getRetiredPools")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoPoolsApi#getRetiredPools")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **count** | **kotlin.Int**| The numbers of pools per page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]
 **order** | **SortOrder**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to null] [enum: asc, desc]

### Return type

[**kotlin.collections.List&lt;PoolListRetire&gt;**](PoolListRetire.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getRetiringPools"></a>
# **getRetiringPools**
> kotlin.collections.List&lt;PoolListRetire&gt; getRetiringPools(count, page, order)

List of retiring stake pools

List of stake pools retiring in the upcoming epochs

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoPoolsApi()
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<PoolListRetire> = apiInstance.getRetiringPools(count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoPoolsApi#getRetiringPools")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoPoolsApi#getRetiringPools")
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

[**kotlin.collections.List&lt;PoolListRetire&gt;**](PoolListRetire.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

