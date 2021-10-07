# CardanoAddressesApi

All URIs are relative to *https://cardano-mainnet.blockfrost.io/api/v0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAddress**](CardanoAddressesApi.md#getAddress) | **GET** /addresses/{address} | Specific address
[**getAddressDetails**](CardanoAddressesApi.md#getAddressDetails) | **GET** /addresses/{address}/total | Address details
[**getAddressTransactions**](CardanoAddressesApi.md#getAddressTransactions) | **GET** /addresses/{address}/transactions | Address transactions
[**getAddressTxs**](CardanoAddressesApi.md#getAddressTxs) | **GET** /addresses/{address}/txs | Address transactions
[**getAddressUtxos**](CardanoAddressesApi.md#getAddressUtxos) | **GET** /addresses/{address}/utxos | Address UTXOs


<a name="getAddress"></a>
# **getAddress**
> AddressContent getAddress(address)

Specific address

Obtain information about a specific address.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoAddressesApi()
val address : kotlin.String = addr1qxqs59lphg8g6qndelq8xwqn60ag3aeyfcp33c2kdp46a09re5df3pzwwmyq946axfcejy5n4x0y99wqpgtp2gd0k09qsgy6pz // kotlin.String | Bech32 address.
try {
    val result : AddressContent = apiInstance.getAddress(address)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAddressesApi#getAddress")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAddressesApi#getAddress")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **address** | **kotlin.String**| Bech32 address. |

### Return type

[**AddressContent**](AddressContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAddressDetails"></a>
# **getAddressDetails**
> AddressContentTotal getAddressDetails(address)

Address details

Obtain details about an address.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoAddressesApi()
val address : kotlin.String = addr1qxqs59lphg8g6qndelq8xwqn60ag3aeyfcp33c2kdp46a09re5df3pzwwmyq946axfcejy5n4x0y99wqpgtp2gd0k09qsgy6pz // kotlin.String | Bech32 address.
try {
    val result : AddressContentTotal = apiInstance.getAddressDetails(address)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAddressesApi#getAddressDetails")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAddressesApi#getAddressDetails")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **address** | **kotlin.String**| Bech32 address. |

### Return type

[**AddressContentTotal**](AddressContentTotal.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAddressTransactions"></a>
# **getAddressTransactions**
> kotlin.collections.List&lt;AddressTransactionsContent&gt; getAddressTransactions(address, count, page, order, from, to)

Address transactions

Transactions on the address.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoAddressesApi()
val address : kotlin.String = addr1qxqs59lphg8g6qndelq8xwqn60ag3aeyfcp33c2kdp46a09re5df3pzwwmyq946axfcejy5n4x0y99wqpgtp2gd0k09qsgy6pz // kotlin.String | Bech32 address.
val count : kotlin.Int = 56 // kotlin.Int | The numbers of pools per page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
val from : kotlin.String = 8929261 // kotlin.String | The block number and optionally also index from which (inclusive) to start search for results, concatenated using colon. Has to be lower than or equal to `to` parameter. 
val to : kotlin.String = 9999269:10 // kotlin.String | The block number and optionally also index where (inclusive) to end the search for results, concatenated using colon. Has to be higher than or equal to `from` parameter. 
try {
    val result : kotlin.collections.List<AddressTransactionsContent> = apiInstance.getAddressTransactions(address, count, page, order, from, to)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAddressesApi#getAddressTransactions")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAddressesApi#getAddressTransactions")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **address** | **kotlin.String**| Bech32 address. |
 **count** | **kotlin.Int**| The numbers of pools per page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]
 **order** | **SortOrder**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to null] [enum: asc, desc]
 **from** | **kotlin.String**| The block number and optionally also index from which (inclusive) to start search for results, concatenated using colon. Has to be lower than or equal to &#x60;to&#x60; parameter.  | [optional]
 **to** | **kotlin.String**| The block number and optionally also index where (inclusive) to end the search for results, concatenated using colon. Has to be higher than or equal to &#x60;from&#x60; parameter.  | [optional]

### Return type

[**kotlin.collections.List&lt;AddressTransactionsContent&gt;**](AddressTransactionsContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAddressTxs"></a>
# **getAddressTxs**
> kotlin.collections.List&lt;kotlin.String&gt; getAddressTxs(address, count, page, order)

Address transactions

Transactions on the address.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoAddressesApi()
val address : kotlin.String = addr1qxqs59lphg8g6qndelq8xwqn60ag3aeyfcp33c2kdp46a09re5df3pzwwmyq946axfcejy5n4x0y99wqpgtp2gd0k09qsgy6pz // kotlin.String | Bech32 address.
val count : kotlin.Int = 56 // kotlin.Int | The number of transactions per page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : SortOrder = order_example // SortOrder | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.String> = apiInstance.getAddressTxs(address, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAddressesApi#getAddressTxs")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAddressesApi#getAddressTxs")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **address** | **kotlin.String**| Bech32 address. |
 **count** | **kotlin.Int**| The number of transactions per page. | [optional] [default to null]
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

<a name="getAddressUtxos"></a>
# **getAddressUtxos**
> kotlin.collections.List&lt;AddressUtxoContent&gt; getAddressUtxos(address, count, page, order)

Address UTXOs

UTXOs of the address.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoAddressesApi()
val address : kotlin.String = addr1qxqs59lphg8g6qndelq8xwqn60ag3aeyfcp33c2kdp46a09re5df3pzwwmyq946axfcejy5n4x0y99wqpgtp2gd0k09qsgy6pz // kotlin.String | Bech32 address.
val count : kotlin.Int = 56 // kotlin.Int | The number of results displayed on one page.
val page : kotlin.Int = 56 // kotlin.Int | The page number for listing the results.
val order : SortOrder = order_example // SortOrder | Ordered by tx index in the block. The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<AddressUtxoContent> = apiInstance.getAddressUtxos(address, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAddressesApi#getAddressUtxos")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAddressesApi#getAddressUtxos")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **address** | **kotlin.String**| Bech32 address. |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to null]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to null]
 **order** | **SortOrder**| Ordered by tx index in the block. The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to null] [enum: asc, desc]

### Return type

[**kotlin.collections.List&lt;AddressUtxoContent&gt;**](AddressUtxoContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

