# CardanoScriptsApi

All URIs are relative to *https://cardano-mainnet.blockfrost.io/api/v0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getScript**](CardanoScriptsApi.md#getScript) | **GET** /scripts/{script_hash} | Specific script
[**getScriptRedeemers**](CardanoScriptsApi.md#getScriptRedeemers) | **GET** /scripts/{script_hash}/redeemers | Redeemers of a specific script
[**getScripts**](CardanoScriptsApi.md#getScripts) | **GET** /scripts | Scripts


<a name="getScript"></a>
# **getScript**
> Script getScript(scriptHash)

Specific script

Information about a specific script

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoScriptsApi()
val scriptHash : kotlin.String = e1457a0c47dfb7a2f6b8fbb059bdceab163c05d34f195b87b9f2b30e // kotlin.String | Hash of the script
try {
    val result : Script = apiInstance.getScript(scriptHash)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoScriptsApi#getScript")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoScriptsApi#getScript")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **scriptHash** | **kotlin.String**| Hash of the script |

### Return type

[**Script**](Script.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getScriptRedeemers"></a>
# **getScriptRedeemers**
> kotlin.collections.List&lt;ScriptRedeemer&gt; getScriptRedeemers(scriptHash, count, page, order)

Redeemers of a specific script

List of redeemers of a specific script

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoScriptsApi()
val scriptHash : kotlin.String = e1457a0c47dfb7a2f6b8fbb059bdceab163c05d34f195b87b9f2b30e // kotlin.String | Hash of the script
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<ScriptRedeemer> = apiInstance.getScriptRedeemers(scriptHash, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoScriptsApi#getScriptRedeemers")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoScriptsApi#getScriptRedeemers")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **scriptHash** | **kotlin.String**| Hash of the script |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]
 **order** | **SortOrder**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to null] [enum: asc, desc]

### Return type

[**kotlin.collections.List&lt;ScriptRedeemer&gt;**](ScriptRedeemer.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getScripts"></a>
# **getScripts**
> kotlin.collections.List&lt;Scripts&gt; getScripts(count, page, order)

Scripts

List of scripts.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoScriptsApi()
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<Scripts> = apiInstance.getScripts(count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoScriptsApi#getScripts")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoScriptsApi#getScripts")
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

[**kotlin.collections.List&lt;Scripts&gt;**](Scripts.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

