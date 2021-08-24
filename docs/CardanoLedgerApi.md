# CardanoLedgerApi

All URIs are relative to *https://cardano-mainnet.blockfrost.io/api/v0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**genesisGet**](CardanoLedgerApi.md#genesisGet) | **GET** /genesis | Blockchain genesis


<a name="genesisGet"></a>
# **genesisGet**
> GenesisContent genesisGet()

Blockchain genesis

Return the information about blockchain genesis.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = CardanoLedgerApi()
try {
    val result : GenesisContent = apiInstance.genesisGet()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling CardanoLedgerApi#genesisGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling CardanoLedgerApi#genesisGet")
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

