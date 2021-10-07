# CardanoAssetsApi

All URIs are relative to *https://cardano-mainnet.blockfrost.io/api/v0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAsset**](CardanoAssetsApi.md#getAsset) | **GET** /assets/{asset} | Specific asset
[**getAssetAddresses**](CardanoAssetsApi.md#getAssetAddresses) | **GET** /assets/{asset}/addresses | Asset addresses
[**getAssetHistory**](CardanoAssetsApi.md#getAssetHistory) | **GET** /assets/{asset}/history | Asset history
[**getAssetTransactions**](CardanoAssetsApi.md#getAssetTransactions) | **GET** /assets/{asset}/transactions | Asset transactions
[**getAssetTxs**](CardanoAssetsApi.md#getAssetTxs) | **GET** /assets/{asset}/txs | Asset transactions
[**getAssets**](CardanoAssetsApi.md#getAssets) | **GET** /assets | Assets
[**getPolicyAssets**](CardanoAssetsApi.md#getPolicyAssets) | **GET** /assets/policy/{policy_id} | Assets of a specific policy


<a name="getAsset"></a>
# **getAsset**
> Asset getAsset(asset)

Specific asset

Information about a specific asset

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoAssetsApi()
val asset : kotlin.String = b0d07d45fe9514f80213f4020e5a61241458be626841cde717cb38a76e7574636f696e // kotlin.String | Concatenation of the policy_id and hex-encoded asset_name
try {
    val result : Asset = apiInstance.getAsset(asset)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAssetsApi#getAsset")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAssetsApi#getAsset")
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

<a name="getAssetAddresses"></a>
# **getAssetAddresses**
> kotlin.collections.List&lt;AssetAddress&gt; getAssetAddresses(asset, count, page, order)

Asset addresses

List of a addresses containing a specific asset

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoAssetsApi()
val asset : kotlin.String = b0d07d45fe9514f80213f4020e5a61241458be626841cde717cb38a76e7574636f696e // kotlin.String | Concatenation of the policy_id and hex-encoded asset_name
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<AssetAddress> = apiInstance.getAssetAddresses(asset, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAssetsApi#getAssetAddresses")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAssetsApi#getAssetAddresses")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **asset** | **kotlin.String**| Concatenation of the policy_id and hex-encoded asset_name |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]
 **order** | **SortOrder**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to null] [enum: asc, desc]

### Return type

[**kotlin.collections.List&lt;AssetAddress&gt;**](AssetAddress.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAssetHistory"></a>
# **getAssetHistory**
> kotlin.collections.List&lt;AssetHistory&gt; getAssetHistory(asset, count, page, order)

Asset history

History of a specific asset

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoAssetsApi()
val asset : kotlin.String = b0d07d45fe9514f80213f4020e5a61241458be626841cde717cb38a76e7574636f696e // kotlin.String | Concatenation of the policy_id and hex-encoded asset_name
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<AssetHistory> = apiInstance.getAssetHistory(asset, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAssetsApi#getAssetHistory")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAssetsApi#getAssetHistory")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **asset** | **kotlin.String**| Concatenation of the policy_id and hex-encoded asset_name |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]
 **order** | **SortOrder**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to null] [enum: asc, desc]

### Return type

[**kotlin.collections.List&lt;AssetHistory&gt;**](AssetHistory.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAssetTransactions"></a>
# **getAssetTransactions**
> kotlin.collections.List&lt;AssetTransaction&gt; getAssetTransactions(asset, count, page, order)

Asset transactions

List of a specific asset transactions

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoAssetsApi()
val asset : kotlin.String = b0d07d45fe9514f80213f4020e5a61241458be626841cde717cb38a76e7574636f696e // kotlin.String | Concatenation of the policy_id and hex-encoded asset_name
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<AssetTransaction> = apiInstance.getAssetTransactions(asset, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAssetsApi#getAssetTransactions")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAssetsApi#getAssetTransactions")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **asset** | **kotlin.String**| Concatenation of the policy_id and hex-encoded asset_name |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]
 **order** | **SortOrder**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to null] [enum: asc, desc]

### Return type

[**kotlin.collections.List&lt;AssetTransaction&gt;**](AssetTransaction.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAssetTxs"></a>
# **getAssetTxs**
> kotlin.collections.List&lt;kotlin.String&gt; getAssetTxs(asset, count, page, order)

Asset transactions

List of a specific asset transactions

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoAssetsApi()
val asset : kotlin.String = b0d07d45fe9514f80213f4020e5a61241458be626841cde717cb38a76e7574636f696e // kotlin.String | Concatenation of the policy_id and hex-encoded asset_name
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.String> = apiInstance.getAssetTxs(asset, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAssetsApi#getAssetTxs")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAssetsApi#getAssetTxs")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **asset** | **kotlin.String**| Concatenation of the policy_id and hex-encoded asset_name |
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

<a name="getAssets"></a>
# **getAssets**
> kotlin.collections.List&lt;Assets&gt; getAssets(count, page, order)

Assets

List of assets.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoAssetsApi()
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<Assets> = apiInstance.getAssets(count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAssetsApi#getAssets")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAssetsApi#getAssets")
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

[**kotlin.collections.List&lt;Assets&gt;**](Assets.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPolicyAssets"></a>
# **getPolicyAssets**
> kotlin.collections.List&lt;AssetPolicy&gt; getPolicyAssets(policyId, count, page, order)

Assets of a specific policy

List of asset minted under a specific policy

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoAssetsApi()
val policyId : kotlin.String = 476039a0949cf0b22f6a800f56780184c44533887ca6e821007840c3 // kotlin.String | Specific policy_id
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<AssetPolicy> = apiInstance.getPolicyAssets(policyId, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAssetsApi#getPolicyAssets")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAssetsApi#getPolicyAssets")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **policyId** | **kotlin.String**| Specific policy_id |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]
 **order** | **SortOrder**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to null] [enum: asc, desc]

### Return type

[**kotlin.collections.List&lt;AssetPolicy&gt;**](AssetPolicy.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

