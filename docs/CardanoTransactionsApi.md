# CardanoTransactionsApi

All URIs are relative to *https://cardano-mainnet.blockfrost.io/api/v0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getTransaction**](CardanoTransactionsApi.md#getTransaction) | **GET** /txs/{hash} | Specific transaction
[**getTransactionDelegations**](CardanoTransactionsApi.md#getTransactionDelegations) | **GET** /txs/{hash}/delegations | Transaction delegation certificates
[**getTransactionMetadata**](CardanoTransactionsApi.md#getTransactionMetadata) | **GET** /txs/{hash}/metadata | Transaction metadata
[**getTransactionMetadataCbor**](CardanoTransactionsApi.md#getTransactionMetadataCbor) | **GET** /txs/{hash}/metadata/cbor | Transaction metadata in CBOR
[**getTransactionMirs**](CardanoTransactionsApi.md#getTransactionMirs) | **GET** /txs/{hash}/mirs | Transaction MIRs
[**getTransactionPoolRetires**](CardanoTransactionsApi.md#getTransactionPoolRetires) | **GET** /txs/{hash}/pool_retires | Transaction stake pool retirement certificates
[**getTransactionPoolUpdates**](CardanoTransactionsApi.md#getTransactionPoolUpdates) | **GET** /txs/{hash}/pool_updates | Transaction stake pool registration and update certificates
[**getTransactionRedeemers**](CardanoTransactionsApi.md#getTransactionRedeemers) | **GET** /txs/{hash}/redeemers | Transaction redeemers
[**getTransactionStakes**](CardanoTransactionsApi.md#getTransactionStakes) | **GET** /txs/{hash}/stakes | Transaction stake addresses certificates
[**getTransactionUtxos**](CardanoTransactionsApi.md#getTransactionUtxos) | **GET** /txs/{hash}/utxos | Transaction UTXOs
[**getTransactionWithdrawals**](CardanoTransactionsApi.md#getTransactionWithdrawals) | **GET** /txs/{hash}/withdrawals | Transaction withdrawal
[**submitTransaction**](CardanoTransactionsApi.md#submitTransaction) | **POST** /tx/submit | Submit a transaction


<a name="getTransaction"></a>
# **getTransaction**
> TxContent getTransaction(hash)

Specific transaction

Return content of the requested transaction.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoTransactionsApi()
val hash : kotlin.String = 6e5f825c42c1c6d6b77f2a14092f3b78c8f1b66db6f4cf8caec1555b6f967b3b // kotlin.String | Hash of the requested transaction
try {
    val result : TxContent = apiInstance.getTransaction(hash)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoTransactionsApi#getTransaction")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoTransactionsApi#getTransaction")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hash** | **kotlin.String**| Hash of the requested transaction |

### Return type

[**TxContent**](TxContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTransactionDelegations"></a>
# **getTransactionDelegations**
> kotlin.collections.List&lt;TxContentDelegation&gt; getTransactionDelegations(hash)

Transaction delegation certificates

Obtain information about delegation certificates of a specific transaction. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoTransactionsApi()
val hash : kotlin.String = 6e5f825c82c1c6d6b77f2a14092f3b78c8f1b66db6f4cf8caec1555b6f967b3b // kotlin.String | Hash of the requested transaction.
try {
    val result : kotlin.collections.List<TxContentDelegation> = apiInstance.getTransactionDelegations(hash)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoTransactionsApi#getTransactionDelegations")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoTransactionsApi#getTransactionDelegations")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hash** | **kotlin.String**| Hash of the requested transaction. |

### Return type

[**kotlin.collections.List&lt;TxContentDelegation&gt;**](TxContentDelegation.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTransactionMetadata"></a>
# **getTransactionMetadata**
> kotlin.collections.List&lt;TxContentMetadata&gt; getTransactionMetadata(hash)

Transaction metadata

Obtain the transaction metadata.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoTransactionsApi()
val hash : kotlin.String = 6e5f825c82c1c6d6b77f2a14092f3b78c8f1b66db6f4cf8caec1555b6f967b3b // kotlin.String | Hash of the requested transaction
try {
    val result : kotlin.collections.List<TxContentMetadata> = apiInstance.getTransactionMetadata(hash)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoTransactionsApi#getTransactionMetadata")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoTransactionsApi#getTransactionMetadata")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hash** | **kotlin.String**| Hash of the requested transaction |

### Return type

[**kotlin.collections.List&lt;TxContentMetadata&gt;**](TxContentMetadata.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTransactionMetadataCbor"></a>
# **getTransactionMetadataCbor**
> kotlin.collections.List&lt;TxContentMetadataCbor&gt; getTransactionMetadataCbor(hash)

Transaction metadata in CBOR

Obtain the transaction metadata in CBOR.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoTransactionsApi()
val hash : kotlin.String = 6e5f825c82c1c6d6b77f2a14092f3b78c8f1b66db6f4cf8caec1555b6f967b3b // kotlin.String | Hash of the requested transaction
try {
    val result : kotlin.collections.List<TxContentMetadataCbor> = apiInstance.getTransactionMetadataCbor(hash)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoTransactionsApi#getTransactionMetadataCbor")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoTransactionsApi#getTransactionMetadataCbor")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hash** | **kotlin.String**| Hash of the requested transaction |

### Return type

[**kotlin.collections.List&lt;TxContentMetadataCbor&gt;**](TxContentMetadataCbor.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTransactionMirs"></a>
# **getTransactionMirs**
> kotlin.collections.List&lt;TxContentMir&gt; getTransactionMirs(hash)

Transaction MIRs

Obtain information about Move Instantaneous Rewards (MIRs) of a specific transaction.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoTransactionsApi()
val hash : kotlin.String = 6e5f825c82c1c6d6b77f2a14092f3b78c8f1b66db6f4cf8caec1555b6f967b3b // kotlin.String | Hash of the requested transaction.
try {
    val result : kotlin.collections.List<TxContentMir> = apiInstance.getTransactionMirs(hash)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoTransactionsApi#getTransactionMirs")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoTransactionsApi#getTransactionMirs")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hash** | **kotlin.String**| Hash of the requested transaction. |

### Return type

[**kotlin.collections.List&lt;TxContentMir&gt;**](TxContentMir.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTransactionPoolRetires"></a>
# **getTransactionPoolRetires**
> kotlin.collections.List&lt;TxContentPoolRetire&gt; getTransactionPoolRetires(hash)

Transaction stake pool retirement certificates

Obtain information about stake pool retirements within a specific transaction. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoTransactionsApi()
val hash : kotlin.String = 6e5f825c82c1c6d6b77f2a14092f3b78c8f1b66db6f4cf8caec1555b6f967b3b // kotlin.String | Hash of the requested transaction
try {
    val result : kotlin.collections.List<TxContentPoolRetire> = apiInstance.getTransactionPoolRetires(hash)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoTransactionsApi#getTransactionPoolRetires")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoTransactionsApi#getTransactionPoolRetires")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hash** | **kotlin.String**| Hash of the requested transaction |

### Return type

[**kotlin.collections.List&lt;TxContentPoolRetire&gt;**](TxContentPoolRetire.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTransactionPoolUpdates"></a>
# **getTransactionPoolUpdates**
> kotlin.collections.List&lt;TxContentPoolCert&gt; getTransactionPoolUpdates(hash)

Transaction stake pool registration and update certificates

Obtain information about stake pool registration and update certificates of a specific transaction. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoTransactionsApi()
val hash : kotlin.String = 6e5f825c82c1c6d6b77f2a14092f3b78c8f1b66db6f4cf8caec1555b6f967b3b // kotlin.String | Hash of the requested transaction
try {
    val result : kotlin.collections.List<TxContentPoolCert> = apiInstance.getTransactionPoolUpdates(hash)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoTransactionsApi#getTransactionPoolUpdates")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoTransactionsApi#getTransactionPoolUpdates")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hash** | **kotlin.String**| Hash of the requested transaction |

### Return type

[**kotlin.collections.List&lt;TxContentPoolCert&gt;**](TxContentPoolCert.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTransactionRedeemers"></a>
# **getTransactionRedeemers**
> kotlin.collections.List&lt;TxContentRedeemer&gt; getTransactionRedeemers(hash)

Transaction redeemers

Obtain the transaction redeemers.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoTransactionsApi()
val hash : kotlin.String = 6e5f825c82c1c6d6b77f2a14092f3b78c8f1b66db6f4cf8caec1555b6f967b3b // kotlin.String | Hash of the requested transaction
try {
    val result : kotlin.collections.List<TxContentRedeemer> = apiInstance.getTransactionRedeemers(hash)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoTransactionsApi#getTransactionRedeemers")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoTransactionsApi#getTransactionRedeemers")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hash** | **kotlin.String**| Hash of the requested transaction |

### Return type

[**kotlin.collections.List&lt;TxContentRedeemer&gt;**](TxContentRedeemer.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTransactionStakes"></a>
# **getTransactionStakes**
> kotlin.collections.List&lt;TxContentStakeAddr&gt; getTransactionStakes(hash)

Transaction stake addresses certificates

Obtain information about (de)registration of stake addresses within a transaction. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoTransactionsApi()
val hash : kotlin.String = 6e5f825c82c1c6d6b77f2a14092f3b78c8f1b66db6f4cf8caec1555b6f967b3b // kotlin.String | Hash of the requested transaction.
try {
    val result : kotlin.collections.List<TxContentStakeAddr> = apiInstance.getTransactionStakes(hash)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoTransactionsApi#getTransactionStakes")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoTransactionsApi#getTransactionStakes")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hash** | **kotlin.String**| Hash of the requested transaction. |

### Return type

[**kotlin.collections.List&lt;TxContentStakeAddr&gt;**](TxContentStakeAddr.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTransactionUtxos"></a>
# **getTransactionUtxos**
> TxContentUtxo getTransactionUtxos(hash)

Transaction UTXOs

Return the inputs and UTXOs of the specific transaction.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoTransactionsApi()
val hash : kotlin.String = 6e5f825c82c1c6d6b77f2a14092f3b78c8f1b66db6f4cf8caec1555b6f967b3b // kotlin.String | Hash of the requested transaction
try {
    val result : TxContentUtxo = apiInstance.getTransactionUtxos(hash)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoTransactionsApi#getTransactionUtxos")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoTransactionsApi#getTransactionUtxos")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hash** | **kotlin.String**| Hash of the requested transaction |

### Return type

[**TxContentUtxo**](TxContentUtxo.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTransactionWithdrawals"></a>
# **getTransactionWithdrawals**
> kotlin.collections.List&lt;TxContentWithdrawal&gt; getTransactionWithdrawals(hash)

Transaction withdrawal

Obtain information about withdrawals of a specific transaction.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoTransactionsApi()
val hash : kotlin.String = 6e5f825c82c1c6d6b77f2a14092f3b78c8f1b66db6f4cf8caec1555b6f967b3b // kotlin.String | Hash of the requested transaction.
try {
    val result : kotlin.collections.List<TxContentWithdrawal> = apiInstance.getTransactionWithdrawals(hash)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoTransactionsApi#getTransactionWithdrawals")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoTransactionsApi#getTransactionWithdrawals")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hash** | **kotlin.String**| Hash of the requested transaction. |

### Return type

[**kotlin.collections.List&lt;TxContentWithdrawal&gt;**](TxContentWithdrawal.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="submitTransaction"></a>
# **submitTransaction**
> kotlin.String submitTransaction(contentType)

Submit a transaction

Submit an already serialized transaction to the network.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoTransactionsApi()
val contentType : kotlin.String = contentType_example // kotlin.String | 
try {
    val result : kotlin.String = apiInstance.submitTransaction(contentType)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoTransactionsApi#submitTransaction")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoTransactionsApi#submitTransaction")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contentType** | **kotlin.String**|  | [enum: application/cbor]

### Return type

**kotlin.String**

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

