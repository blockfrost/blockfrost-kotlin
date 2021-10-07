# CardanoLedgerApi

All URIs are relative to *https://cardano-mainnet.blockfrost.io/api/v0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getGenesis**](CardanoLedgerApi.md#getGenesis) | **GET** /genesis | Blockchain genesis


<a name="getGenesis"></a>
# **getGenesis**
> GenesisContent getGenesis()

Blockchain genesis

Return the information about blockchain genesis.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoLedgerApi()
try {
    val result : GenesisContent = apiInstance.getGenesis()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoLedgerApi#getGenesis")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoLedgerApi#getGenesis")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GenesisContent**](GenesisContent.md)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

