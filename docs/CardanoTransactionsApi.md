# CardanoTransactionsApi

All URIs are relative to *https://cardano-mainnet.blockfrost.io/api/v0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**txSubmitPost**](CardanoTransactionsApi.md#txSubmitPost) | **POST** /tx/submit | Submit a transaction
[**txsHashDelegationsGet**](CardanoTransactionsApi.md#txsHashDelegationsGet) | **GET** /txs/{hash}/delegations | Transaction delegation certificates
[**txsHashGet**](CardanoTransactionsApi.md#txsHashGet) | **GET** /txs/{hash} | Specific transaction
[**txsHashMetadataCborGet**](CardanoTransactionsApi.md#txsHashMetadataCborGet) | **GET** /txs/{hash}/metadata/cbor | Transaction metadata in CBOR
[**txsHashMetadataGet**](CardanoTransactionsApi.md#txsHashMetadataGet) | **GET** /txs/{hash}/metadata | Transaction metadata
[**txsHashMirsGet**](CardanoTransactionsApi.md#txsHashMirsGet) | **GET** /txs/{hash}/mirs | Transaction MIRs
[**txsHashPoolRetiresGet**](CardanoTransactionsApi.md#txsHashPoolRetiresGet) | **GET** /txs/{hash}/pool_retires | Transaction stake pool retirement certificates
[**txsHashPoolUpdatesGet**](CardanoTransactionsApi.md#txsHashPoolUpdatesGet) | **GET** /txs/{hash}/pool_updates | Transaction stake pool registration and update certificates
[**txsHashStakesGet**](CardanoTransactionsApi.md#txsHashStakesGet) | **GET** /txs/{hash}/stakes | Transaction stake addresses certificates
[**txsHashUtxosGet**](CardanoTransactionsApi.md#txsHashUtxosGet) | **GET** /txs/{hash}/utxos | Transaction UTXOs
[**txsHashWithdrawalsGet**](CardanoTransactionsApi.md#txsHashWithdrawalsGet) | **GET** /txs/{hash}/withdrawals | Transaction withdrawal


<a name="txSubmitPost"></a>
# **txSubmitPost**
> kotlin.String txSubmitPost(contentType)

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
    val result : kotlin.String = apiInstance.txSubmitPost(contentType)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoTransactionsApi#txSubmitPost")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoTransactionsApi#txSubmitPost")
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

<a name="txsHashDelegationsGet"></a>
# **txsHashDelegationsGet**
> kotlin.collections.List&lt;kotlin.Any&gt; txsHashDelegationsGet(hash)

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
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.txsHashDelegationsGet(hash)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoTransactionsApi#txsHashDelegationsGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoTransactionsApi#txsHashDelegationsGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hash** | **kotlin.String**| Hash of the requested transaction. |

### Return type

[**kotlin.collections.List&lt;kotlin.Any&gt;**](kotlin.Any.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="txsHashGet"></a>
# **txsHashGet**
> TxContent txsHashGet(hash)

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
    val result : TxContent = apiInstance.txsHashGet(hash)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoTransactionsApi#txsHashGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoTransactionsApi#txsHashGet")
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

<a name="txsHashMetadataCborGet"></a>
# **txsHashMetadataCborGet**
> kotlin.collections.List&lt;kotlin.Any&gt; txsHashMetadataCborGet(hash)

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
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.txsHashMetadataCborGet(hash)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoTransactionsApi#txsHashMetadataCborGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoTransactionsApi#txsHashMetadataCborGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hash** | **kotlin.String**| Hash of the requested transaction |

### Return type

[**kotlin.collections.List&lt;kotlin.Any&gt;**](kotlin.Any.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="txsHashMetadataGet"></a>
# **txsHashMetadataGet**
> kotlin.collections.List&lt;kotlin.Any&gt; txsHashMetadataGet(hash)

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
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.txsHashMetadataGet(hash)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoTransactionsApi#txsHashMetadataGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoTransactionsApi#txsHashMetadataGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hash** | **kotlin.String**| Hash of the requested transaction |

### Return type

[**kotlin.collections.List&lt;kotlin.Any&gt;**](kotlin.Any.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="txsHashMirsGet"></a>
# **txsHashMirsGet**
> kotlin.collections.List&lt;kotlin.Any&gt; txsHashMirsGet(hash)

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
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.txsHashMirsGet(hash)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoTransactionsApi#txsHashMirsGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoTransactionsApi#txsHashMirsGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hash** | **kotlin.String**| Hash of the requested transaction. |

### Return type

[**kotlin.collections.List&lt;kotlin.Any&gt;**](kotlin.Any.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="txsHashPoolRetiresGet"></a>
# **txsHashPoolRetiresGet**
> kotlin.collections.List&lt;kotlin.Any&gt; txsHashPoolRetiresGet(hash)

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
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.txsHashPoolRetiresGet(hash)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoTransactionsApi#txsHashPoolRetiresGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoTransactionsApi#txsHashPoolRetiresGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hash** | **kotlin.String**| Hash of the requested transaction |

### Return type

[**kotlin.collections.List&lt;kotlin.Any&gt;**](kotlin.Any.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="txsHashPoolUpdatesGet"></a>
# **txsHashPoolUpdatesGet**
> kotlin.collections.List&lt;kotlin.Any&gt; txsHashPoolUpdatesGet(hash)

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
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.txsHashPoolUpdatesGet(hash)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoTransactionsApi#txsHashPoolUpdatesGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoTransactionsApi#txsHashPoolUpdatesGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hash** | **kotlin.String**| Hash of the requested transaction |

### Return type

[**kotlin.collections.List&lt;kotlin.Any&gt;**](kotlin.Any.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="txsHashStakesGet"></a>
# **txsHashStakesGet**
> kotlin.collections.List&lt;kotlin.Any&gt; txsHashStakesGet(hash)

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
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.txsHashStakesGet(hash)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoTransactionsApi#txsHashStakesGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoTransactionsApi#txsHashStakesGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hash** | **kotlin.String**| Hash of the requested transaction. |

### Return type

[**kotlin.collections.List&lt;kotlin.Any&gt;**](kotlin.Any.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="txsHashUtxosGet"></a>
# **txsHashUtxosGet**
> TxContentUtxo txsHashUtxosGet(hash)

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
    val result : TxContentUtxo = apiInstance.txsHashUtxosGet(hash)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoTransactionsApi#txsHashUtxosGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoTransactionsApi#txsHashUtxosGet")
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

<a name="txsHashWithdrawalsGet"></a>
# **txsHashWithdrawalsGet**
> kotlin.collections.List&lt;kotlin.Any&gt; txsHashWithdrawalsGet(hash)

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
    val result : kotlin.collections.List<kotlin.Any> = apiInstance.txsHashWithdrawalsGet(hash)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoTransactionsApi#txsHashWithdrawalsGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoTransactionsApi#txsHashWithdrawalsGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hash** | **kotlin.String**| Hash of the requested transaction. |

### Return type

[**kotlin.collections.List&lt;kotlin.Any&gt;**](kotlin.Any.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

