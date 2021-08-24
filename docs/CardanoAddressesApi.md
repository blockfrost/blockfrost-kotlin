# CardanoAddressesApi

All URIs are relative to *https://cardano-mainnet.blockfrost.io/api/v0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addressesAddressGet**](CardanoAddressesApi.md#addressesAddressGet) | **GET** /addresses/{address} | Specific address
[**addressesAddressTotalGet**](CardanoAddressesApi.md#addressesAddressTotalGet) | **GET** /addresses/{address}/total | Address details
[**addressesAddressTransactionsGet**](CardanoAddressesApi.md#addressesAddressTransactionsGet) | **GET** /addresses/{address}/transactions | Address transactions
[**addressesAddressTxsGet**](CardanoAddressesApi.md#addressesAddressTxsGet) | **GET** /addresses/{address}/txs | Address transactions
[**addressesAddressUtxosGet**](CardanoAddressesApi.md#addressesAddressUtxosGet) | **GET** /addresses/{address}/utxos | Address UTXOs


<a name="addressesAddressGet"></a>
# **addressesAddressGet**
> AddressContent addressesAddressGet(address)

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
    val result : AddressContent = apiInstance.addressesAddressGet(address)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAddressesApi#addressesAddressGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAddressesApi#addressesAddressGet")
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

<a name="addressesAddressTotalGet"></a>
# **addressesAddressTotalGet**
> AddressContentTotal addressesAddressTotalGet(address)

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
    val result : AddressContentTotal = apiInstance.addressesAddressTotalGet(address)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAddressesApi#addressesAddressTotalGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAddressesApi#addressesAddressTotalGet")
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

<a name="addressesAddressTransactionsGet"></a>
# **addressesAddressTransactionsGet**
> kotlin.collections.List&lt;kotlin.Any&gt; addressesAddressTransactionsGet(address, count, page, order, from, to)

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
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
val from : kotlin.String = 8929261 // kotlin.String | The block number and optionally also index from which (inclusive) to start search for results, concatenated using colon. Has to be lower than or equal to `to` parameter. 
val to : kotlin.String = 9999269:10 // kotlin.String | The block number and optionally also index where (inclusive) to end the search for results, concatenated using colon. Has to be higher than or equal to `from` parameter. 
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.addressesAddressTransactionsGet(address, count, page, order, from, to)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAddressesApi#addressesAddressTransactionsGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAddressesApi#addressesAddressTransactionsGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **address** | **kotlin.String**| Bech32 address. |
 **count** | **kotlin.Int**| The numbers of pools per page. | [optional] [default to 100]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to 1]
 **order** | **kotlin.String**| The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to asc] [enum: asc, desc]
 **from** | **kotlin.String**| The block number and optionally also index from which (inclusive) to start search for results, concatenated using colon. Has to be lower than or equal to &#x60;to&#x60; parameter.  | [optional]
 **to** | **kotlin.String**| The block number and optionally also index where (inclusive) to end the search for results, concatenated using colon. Has to be higher than or equal to &#x60;from&#x60; parameter.  | [optional]

### Return type

[**kotlin.collections.List&lt;kotlin.Any&gt;**](kotlin.Any.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="addressesAddressTxsGet"></a>
# **addressesAddressTxsGet**
> kotlin.collections.List&lt;kotlin.String&gt; addressesAddressTxsGet(address, count, page, order)

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
val order : kotlin.String = order_example // kotlin.String | The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.String> = apiInstance.addressesAddressTxsGet(address, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAddressesApi#addressesAddressTxsGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAddressesApi#addressesAddressTxsGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **address** | **kotlin.String**| Bech32 address. |
 **count** | **kotlin.Int**| The number of transactions per page. | [optional] [default to 100]
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

<a name="addressesAddressUtxosGet"></a>
# **addressesAddressUtxosGet**
> kotlin.collections.List&lt;kotlin.Any&gt; addressesAddressUtxosGet(address, count, page, order)

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
val order : kotlin.String = order_example // kotlin.String | Ordered by tx index in the block. The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last. 
try {
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.addressesAddressUtxosGet(address, count, page, order)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoAddressesApi#addressesAddressUtxosGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoAddressesApi#addressesAddressUtxosGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **address** | **kotlin.String**| Bech32 address. |
 **count** | **kotlin.Int**| The number of results displayed on one page. | [optional] [default to 100]
 **page** | **kotlin.Int**| The page number for listing the results. | [optional] [default to 1]
 **order** | **kotlin.String**| Ordered by tx index in the block. The ordering of items from the point of view of the blockchain, not the page listing itself. By default, we return oldest first, newest last.  | [optional] [default to asc] [enum: asc, desc]

### Return type

[**kotlin.collections.List&lt;kotlin.Any&gt;**](kotlin.Any.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

