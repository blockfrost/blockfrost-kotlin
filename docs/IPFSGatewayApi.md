# IPFSGatewayApi

All URIs are relative to *https://cardano-mainnet.blockfrost.io/api/v0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**ipfsGatewayIPFSPathGet**](IPFSGatewayApi.md#ipfsGatewayIPFSPathGet) | **GET** /ipfs/gateway/{IPFS_path} | Relay to an IPFS gateway


<a name="ipfsGatewayIPFSPathGet"></a>
# **ipfsGatewayIPFSPathGet**
> ipfsGatewayIPFSPathGet(ipFSPath)

Relay to an IPFS gateway

Retrieve an object from the IFPS gateway (useful if you do not want to rely on a public gateway, such as &#x60;ipfs.blockfrost.dev&#x60;).

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = IPFSGatewayApi()
val ipFSPath : kotlin.String = ipFSPath_example // kotlin.String | 
try {
    apiInstance.ipfsGatewayIPFSPathGet(ipFSPath)
} catch (e: ClientException) {
    println("4xx response calling IPFSGatewayApi#ipfsGatewayIPFSPathGet")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling IPFSGatewayApi#ipfsGatewayIPFSPathGet")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ipFSPath** | **kotlin.String**|  |

### Return type

null (empty response body)

### Authorization


Configure ApiKeyAuth:
    ApiClient.apiKey["project_id"] = ""
    ApiClient.apiKeyPrefix["project_id"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

