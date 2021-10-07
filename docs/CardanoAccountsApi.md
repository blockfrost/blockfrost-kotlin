# CardanoAccountsApi

All URIs are relative to *https://cardano-mainnet.blockfrost.io/api/v0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAccountAddresses**](CardanoAccountsApi.md#getAccountAddresses) | **GET** /accounts/{stake_address}/addresses | Account associated addresses
[**getAccountAssets**](CardanoAccountsApi.md#getAccountAssets) | **GET** /accounts/{stake_address}/addresses/assets | Assets associated with the account addresses
[**getAccountByStakeAddress**](CardanoAccountsApi.md#getAccountByStakeAddress) | **GET** /accounts/{stake_address} | Specific account address
[**getAccountDelegationHistory**](CardanoAccountsApi.md#getAccountDelegationHistory) | **GET** /accounts/{stake_address}/delegations | Account delegation history
[**getAccountHistory**](CardanoAccountsApi.md#getAccountHistory) | **GET** /accounts/{stake_address}/history | Account history
[**getAccountMirHistory**](CardanoAccountsApi.md#getAccountMirHistory) | **GET** /accounts/{stake_address}/mirs | Account MIR history
[**getAccountRegistrationHistory**](CardanoAccountsApi.md#getAccountRegistrationHistory) | **GET** /accounts/{stake_address}/registrations | Account registration history
[**getAccountRewardHistory**](CardanoAccountsApi.md#getAccountRewardHistory) | **GET** /accounts/{stake_address}/rewards | Account reward history
[**getAccountWithdrawalHistory**](CardanoAccountsApi.md#getAccountWithdrawalHistory) | **GET** /accounts/{stake_address}/withdrawals | Account withdrawal history


<a name="getAccountAddresses"></a>
# **getAccountAddresses**
> kotlin.collections.List&lt;AccountAddressesContent&gt; getAccountAddresses(stakeAddress, count, page, order)

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
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<AccountAddressesContent> = apiInstance.getAccountAddresses(stakeAddress, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAccountsApi#getAccountAddresses")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAccountsApi#getAccountAddresses")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **stakeAddress** | **kotlin.String**| Bech32 stake address. |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]
 **order** | **SortOrder**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to null] [enum: asc, desc]

### Return type

[**kotlin.collections.List&lt;AccountAddressesContent&gt;**](AccountAddressesContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountAssets"></a>
# **getAccountAssets**
> kotlin.collections.List&lt;AccountAddressesAsset&gt; getAccountAssets(stakeAddress, count, page, order)

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
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<AccountAddressesAsset> = apiInstance.getAccountAssets(stakeAddress, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAccountsApi#getAccountAssets")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAccountsApi#getAccountAssets")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **stakeAddress** | **kotlin.String**| Bech32 stake address. |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]
 **order** | **SortOrder**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to null] [enum: asc, desc]

### Return type

[**kotlin.collections.List&lt;AccountAddressesAsset&gt;**](AccountAddressesAsset.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountByStakeAddress"></a>
# **getAccountByStakeAddress**
> AccountContent getAccountByStakeAddress(stakeAddress)

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
    val result : AccountContent = apiInstance.getAccountByStakeAddress(stakeAddress)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAccountsApi#getAccountByStakeAddress")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAccountsApi#getAccountByStakeAddress")
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

<a name="getAccountDelegationHistory"></a>
# **getAccountDelegationHistory**
> kotlin.collections.List&lt;AccountDelegationContent&gt; getAccountDelegationHistory(stakeAddress, count, page, order)

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
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<AccountDelegationContent> = apiInstance.getAccountDelegationHistory(stakeAddress, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAccountsApi#getAccountDelegationHistory")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAccountsApi#getAccountDelegationHistory")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **stakeAddress** | **kotlin.String**| Bech32 stake address. |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]
 **order** | **SortOrder**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to null] [enum: asc, desc]

### Return type

[**kotlin.collections.List&lt;AccountDelegationContent&gt;**](AccountDelegationContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountHistory"></a>
# **getAccountHistory**
> kotlin.collections.List&lt;AccountHistoryContent&gt; getAccountHistory(stakeAddress, count, page, order)

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
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<AccountHistoryContent> = apiInstance.getAccountHistory(stakeAddress, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAccountsApi#getAccountHistory")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAccountsApi#getAccountHistory")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **stakeAddress** | **kotlin.String**| Bech32 stake address. |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]
 **order** | **SortOrder**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to null] [enum: asc, desc]

### Return type

[**kotlin.collections.List&lt;AccountHistoryContent&gt;**](AccountHistoryContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountMirHistory"></a>
# **getAccountMirHistory**
> kotlin.collections.List&lt;AccountMirContent&gt; getAccountMirHistory(stakeAddress, count, page, order)

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
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<AccountMirContent> = apiInstance.getAccountMirHistory(stakeAddress, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAccountsApi#getAccountMirHistory")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAccountsApi#getAccountMirHistory")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **stakeAddress** | **kotlin.String**| Bech32 stake address. |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]
 **order** | **SortOrder**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to null] [enum: asc, desc]

### Return type

[**kotlin.collections.List&lt;AccountMirContent&gt;**](AccountMirContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountRegistrationHistory"></a>
# **getAccountRegistrationHistory**
> kotlin.collections.List&lt;AccountRegistrationContent&gt; getAccountRegistrationHistory(stakeAddress, count, page, order)

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
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<AccountRegistrationContent> = apiInstance.getAccountRegistrationHistory(stakeAddress, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAccountsApi#getAccountRegistrationHistory")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAccountsApi#getAccountRegistrationHistory")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **stakeAddress** | **kotlin.String**| Bech32 stake address. |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]
 **order** | **SortOrder**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to null] [enum: asc, desc]

### Return type

[**kotlin.collections.List&lt;AccountRegistrationContent&gt;**](AccountRegistrationContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountRewardHistory"></a>
# **getAccountRewardHistory**
> kotlin.collections.List&lt;AccountRewardContent&gt; getAccountRewardHistory(stakeAddress, count, page, order)

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
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<AccountRewardContent> = apiInstance.getAccountRewardHistory(stakeAddress, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAccountsApi#getAccountRewardHistory")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAccountsApi#getAccountRewardHistory")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **stakeAddress** | **kotlin.String**| Bech32 stake address. |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]
 **order** | **SortOrder**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to null] [enum: asc, desc]

### Return type

[**kotlin.collections.List&lt;AccountRewardContent&gt;**](AccountRewardContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccountWithdrawalHistory"></a>
# **getAccountWithdrawalHistory**
> kotlin.collections.List&lt;AccountWithdrawalContent&gt; getAccountWithdrawalHistory(stakeAddress, count, page, order)

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
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<AccountWithdrawalContent> = apiInstance.getAccountWithdrawalHistory(stakeAddress, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAccountsApi#getAccountWithdrawalHistory")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAccountsApi#getAccountWithdrawalHistory")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **stakeAddress** | **kotlin.String**| Bech32 stake address. |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]
 **order** | **SortOrder**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to null] [enum: asc, desc]

### Return type

[**kotlin.collections.List&lt;AccountWithdrawalContent&gt;**](AccountWithdrawalContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

