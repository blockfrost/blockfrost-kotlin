# CardanoAccountsApi

All URIs are relative to *https://cardano-mainnet.blockfrost.io/api/v0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**accountsStakeAddressAddressesAssetsGet**](CardanoAccountsApi.md#accountsStakeAddressAddressesAssetsGet) | **GET** /accounts/{stake_address}/addresses/assets | Assets associated with the account addresses
[**accountsStakeAddressAddressesGet**](CardanoAccountsApi.md#accountsStakeAddressAddressesGet) | **GET** /accounts/{stake_address}/addresses | Account associated addresses
[**accountsStakeAddressDelegationsGet**](CardanoAccountsApi.md#accountsStakeAddressDelegationsGet) | **GET** /accounts/{stake_address}/delegations | Account delegation history
[**accountsStakeAddressGet**](CardanoAccountsApi.md#accountsStakeAddressGet) | **GET** /accounts/{stake_address} | Specific account address
[**accountsStakeAddressHistoryGet**](CardanoAccountsApi.md#accountsStakeAddressHistoryGet) | **GET** /accounts/{stake_address}/history | Account history
[**accountsStakeAddressMirsGet**](CardanoAccountsApi.md#accountsStakeAddressMirsGet) | **GET** /accounts/{stake_address}/mirs | Account MIR history
[**accountsStakeAddressRegistrationsGet**](CardanoAccountsApi.md#accountsStakeAddressRegistrationsGet) | **GET** /accounts/{stake_address}/registrations | Account registration history
[**accountsStakeAddressRewardsGet**](CardanoAccountsApi.md#accountsStakeAddressRewardsGet) | **GET** /accounts/{stake_address}/rewards | Account reward history
[**accountsStakeAddressWithdrawalsGet**](CardanoAccountsApi.md#accountsStakeAddressWithdrawalsGet) | **GET** /accounts/{stake_address}/withdrawals | Account withdrawal history


<a name="accountsStakeAddressAddressesAssetsGet"></a>
# **accountsStakeAddressAddressesAssetsGet**
> kotlin.collections.List&lt;kotlin.Any&gt; accountsStakeAddressAddressesAssetsGet(stakeAddress, count, page, order)

Assets associated with the account addresses

Obtain information about assets associated with addresses of a specific account.  &lt;b&gt;Be careful&lt;/b&gt;, as an account could be part of a mangled address and does not necessarily mean the addresses are owned by user as the account. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoAccountsApi()
val stakeAddress : kotlin.String = stake1u9ylzsgxaa6xctf4juup682ar3juj85n8tx3hthnljg47zctvm3rc // kotlin.String | Bech32 stake address.
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.accountsStakeAddressAddressesAssetsGet(stakeAddress, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAccountsApi#accountsStakeAddressAddressesAssetsGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAccountsApi#accountsStakeAddressAddressesAssetsGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **stakeAddress** | **kotlin.String**| Bech32 stake address. |
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

<a name="accountsStakeAddressAddressesGet"></a>
# **accountsStakeAddressAddressesGet**
> kotlin.collections.List&lt;kotlin.Any&gt; accountsStakeAddressAddressesGet(stakeAddress, count, page, order)

Account associated addresses

Obtain information about the addresses of a specific account.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoAccountsApi()
val stakeAddress : kotlin.String = stake1u9ylzsgxaa6xctf4juup682ar3juj85n8tx3hthnljg47zctvm3rc // kotlin.String | Bech32 stake address.
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.accountsStakeAddressAddressesGet(stakeAddress, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAccountsApi#accountsStakeAddressAddressesGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAccountsApi#accountsStakeAddressAddressesGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **stakeAddress** | **kotlin.String**| Bech32 stake address. |
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

<a name="accountsStakeAddressDelegationsGet"></a>
# **accountsStakeAddressDelegationsGet**
> kotlin.collections.List&lt;kotlin.Any&gt; accountsStakeAddressDelegationsGet(stakeAddress, count, page, order)

Account delegation history

Obtain information about the delegation of a specific account.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoAccountsApi()
val stakeAddress : kotlin.String = stake1u9ylzsgxaa6xctf4juup682ar3juj85n8tx3hthnljg47zctvm3rc // kotlin.String | Bech32 stake address.
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.accountsStakeAddressDelegationsGet(stakeAddress, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAccountsApi#accountsStakeAddressDelegationsGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAccountsApi#accountsStakeAddressDelegationsGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **stakeAddress** | **kotlin.String**| Bech32 stake address. |
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

<a name="accountsStakeAddressGet"></a>
# **accountsStakeAddressGet**
> AccountContent accountsStakeAddressGet(stakeAddress)

Specific account address

Obtain information about a specific stake account. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoAccountsApi()
val stakeAddress : kotlin.String = stake1u9ylzsgxaa6xctf4juup682ar3juj85n8tx3hthnljg47zctvm3rc // kotlin.String | Bech32 stake address.
try {
    val result : AccountContent = apiInstance.accountsStakeAddressGet(stakeAddress)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAccountsApi#accountsStakeAddressGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAccountsApi#accountsStakeAddressGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **stakeAddress** | **kotlin.String**| Bech32 stake address. |

### Return type

[**AccountContent**](AccountContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="accountsStakeAddressHistoryGet"></a>
# **accountsStakeAddressHistoryGet**
> kotlin.collections.List&lt;kotlin.Any&gt; accountsStakeAddressHistoryGet(stakeAddress, count, page, order)

Account history

Obtain information about the history of a specific account. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoAccountsApi()
val stakeAddress : kotlin.String = stake1u9ylzsgxaa6xctf4juup682ar3juj85n8tx3hthnljg47zctvm3rc // kotlin.String | Bech32 stake address.
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.accountsStakeAddressHistoryGet(stakeAddress, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAccountsApi#accountsStakeAddressHistoryGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAccountsApi#accountsStakeAddressHistoryGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **stakeAddress** | **kotlin.String**| Bech32 stake address. |
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

<a name="accountsStakeAddressMirsGet"></a>
# **accountsStakeAddressMirsGet**
> kotlin.collections.List&lt;kotlin.Any&gt; accountsStakeAddressMirsGet(stakeAddress, count, page, order)

Account MIR history

Obtain information about the MIRs of a specific account. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoAccountsApi()
val stakeAddress : kotlin.String = stake1u9ylzsgxaa6xctf4juup682ar3juj85n8tx3hthnljg47zctvm3rc // kotlin.String | Bech32 stake address.
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.accountsStakeAddressMirsGet(stakeAddress, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAccountsApi#accountsStakeAddressMirsGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAccountsApi#accountsStakeAddressMirsGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **stakeAddress** | **kotlin.String**| Bech32 stake address. |
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

<a name="accountsStakeAddressRegistrationsGet"></a>
# **accountsStakeAddressRegistrationsGet**
> kotlin.collections.List&lt;kotlin.Any&gt; accountsStakeAddressRegistrationsGet(stakeAddress, count, page, order)

Account registration history

Obtain information about the registrations and deregistrations of a specific account. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoAccountsApi()
val stakeAddress : kotlin.String = stake1u9ylzsgxaa6xctf4juup682ar3juj85n8tx3hthnljg47zctvm3rc // kotlin.String | Bech32 stake address.
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.accountsStakeAddressRegistrationsGet(stakeAddress, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAccountsApi#accountsStakeAddressRegistrationsGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAccountsApi#accountsStakeAddressRegistrationsGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **stakeAddress** | **kotlin.String**| Bech32 stake address. |
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

<a name="accountsStakeAddressRewardsGet"></a>
# **accountsStakeAddressRewardsGet**
> kotlin.collections.List&lt;kotlin.Any&gt; accountsStakeAddressRewardsGet(stakeAddress, count, page, order)

Account reward history

Obtain information about the reward history of a specific account. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoAccountsApi()
val stakeAddress : kotlin.String = stake1u9ylzsgxaa6xctf4juup682ar3juj85n8tx3hthnljg47zctvm3rc // kotlin.String | Bech32 stake address.
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.accountsStakeAddressRewardsGet(stakeAddress, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAccountsApi#accountsStakeAddressRewardsGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAccountsApi#accountsStakeAddressRewardsGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **stakeAddress** | **kotlin.String**| Bech32 stake address. |
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

<a name="accountsStakeAddressWithdrawalsGet"></a>
# **accountsStakeAddressWithdrawalsGet**
> kotlin.collections.List&lt;kotlin.Any&gt; accountsStakeAddressWithdrawalsGet(stakeAddress, count, page, order)

Account withdrawal history

Obtain information about the withdrawals of a specific account. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoAccountsApi()
val stakeAddress : kotlin.String = stake1u9ylzsgxaa6xctf4juup682ar3juj85n8tx3hthnljg47zctvm3rc // kotlin.String | Bech32 stake address.
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.accountsStakeAddressWithdrawalsGet(stakeAddress, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAccountsApi#accountsStakeAddressWithdrawalsGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAccountsApi#accountsStakeAddressWithdrawalsGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **stakeAddress** | **kotlin.String**| Bech32 stake address. |
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

