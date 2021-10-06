# CardanoAssetsApi

All URIs are relative to *https://cardano-mainnet.blockfrost.io/api/v0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**assetsAssetAddressesGet**](CardanoAssetsApi.md#assetsAssetAddressesGet) | **GET** /assets/{asset}/addresses | Asset addresses
[**assetsAssetGet**](CardanoAssetsApi.md#assetsAssetGet) | **GET** /assets/{asset} | Specific asset
[**assetsAssetHistoryGet**](CardanoAssetsApi.md#assetsAssetHistoryGet) | **GET** /assets/{asset}/history | Asset history
[**assetsAssetTransactionsGet**](CardanoAssetsApi.md#assetsAssetTransactionsGet) | **GET** /assets/{asset}/transactions | Asset transactions
[**assetsAssetTxsGet**](CardanoAssetsApi.md#assetsAssetTxsGet) | **GET** /assets/{asset}/txs | Asset transactions
[**assetsGet**](CardanoAssetsApi.md#assetsGet) | **GET** /assets | Assets
[**assetsPolicyPolicyIdGet**](CardanoAssetsApi.md#assetsPolicyPolicyIdGet) | **GET** /assets/policy/{policy_id} | Assets of a specific policy


<a name="assetsAssetAddressesGet"></a>
# **assetsAssetAddressesGet**
> kotlin.collections.List&lt;kotlin.Any&gt; assetsAssetAddressesGet(asset, count, page, order)

Asset addresses

List of a addresses containing a specific asset

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = CardanoAssetsApi()
val asset : kotlin.String = b0d07d45fe9514f80213f4020e5a61241458be626841cde717cb38a76e7574636f696e // kotlin.String | Concatenation of the policy_id and hex-encoded asset_name
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.assetsAssetAddressesGet(asset, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAssetsApi#assetsAssetAddressesGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAssetsApi#assetsAssetAddressesGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **asset** | **kotlin.String**| Concatenation of the policy_id and hex-encoded asset_name |
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

<a name="assetsAssetGet"></a>
# **assetsAssetGet**
> Asset assetsAssetGet(asset)

Specific asset

Information about a specific asset

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = CardanoAssetsApi()
val asset : kotlin.String = b0d07d45fe9514f80213f4020e5a61241458be626841cde717cb38a76e7574636f696e // kotlin.String | Concatenation of the policy_id and hex-encoded asset_name
try {
    val result : Asset = apiInstance.assetsAssetGet(asset)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAssetsApi#assetsAssetGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAssetsApi#assetsAssetGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **asset** | **kotlin.String**| Concatenation of the policy_id and hex-encoded asset_name |

### Return type

[**Asset**](Asset.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="assetsAssetHistoryGet"></a>
# **assetsAssetHistoryGet**
> kotlin.collections.List&lt;kotlin.Any&gt; assetsAssetHistoryGet(asset, count, page, order)

Asset history

History of a specific asset

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = CardanoAssetsApi()
val asset : kotlin.String = b0d07d45fe9514f80213f4020e5a61241458be626841cde717cb38a76e7574636f696e // kotlin.String | Concatenation of the policy_id and hex-encoded asset_name
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.assetsAssetHistoryGet(asset, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAssetsApi#assetsAssetHistoryGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAssetsApi#assetsAssetHistoryGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **asset** | **kotlin.String**| Concatenation of the policy_id and hex-encoded asset_name |
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

<a name="assetsAssetTransactionsGet"></a>
# **assetsAssetTransactionsGet**
> kotlin.collections.List&lt;kotlin.Any&gt; assetsAssetTransactionsGet(asset, count, page, order)

Asset transactions

List of a specific asset transactions

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = CardanoAssetsApi()
val asset : kotlin.String = b0d07d45fe9514f80213f4020e5a61241458be626841cde717cb38a76e7574636f696e // kotlin.String | Concatenation of the policy_id and hex-encoded asset_name
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.assetsAssetTransactionsGet(asset, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAssetsApi#assetsAssetTransactionsGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAssetsApi#assetsAssetTransactionsGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **asset** | **kotlin.String**| Concatenation of the policy_id and hex-encoded asset_name |
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

<a name="assetsAssetTxsGet"></a>
# **assetsAssetTxsGet**
> kotlin.collections.List&lt;kotlin.String&gt; assetsAssetTxsGet(asset, count, page, order)

Asset transactions

List of a specific asset transactions

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = CardanoAssetsApi()
val asset : kotlin.String = b0d07d45fe9514f80213f4020e5a61241458be626841cde717cb38a76e7574636f696e // kotlin.String | Concatenation of the policy_id and hex-encoded asset_name
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.String> = apiInstance.assetsAssetTxsGet(asset, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAssetsApi#assetsAssetTxsGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAssetsApi#assetsAssetTxsGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **asset** | **kotlin.String**| Concatenation of the policy_id and hex-encoded asset_name |
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

<a name="assetsGet"></a>
# **assetsGet**
> kotlin.collections.List&lt;kotlin.Any&gt; assetsGet(count, page, order)

Assets

List of assets.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = CardanoAssetsApi()
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.assetsGet(count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAssetsApi#assetsGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAssetsApi#assetsGet")
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

<a name="assetsPolicyPolicyIdGet"></a>
# **assetsPolicyPolicyIdGet**
> kotlin.collections.List&lt;kotlin.Any&gt; assetsPolicyPolicyIdGet(policyId, count, page, order)

Assets of a specific policy

List of asset minted under a specific policy

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models2.*

val apiInstance = CardanoAssetsApi()
val policyId : kotlin.String = 476039a0949cf0b22f6a800f56780184c44533887ca6e821007840c3 // kotlin.String | Specific policy_id
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.assetsPolicyPolicyIdGet(policyId, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAssetsApi#assetsPolicyPolicyIdGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAssetsApi#assetsPolicyPolicyIdGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **policyId** | **kotlin.String**| Specific policy_id |
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

