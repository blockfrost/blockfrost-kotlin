
# Asset

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**asset** | **kotlin.String** | Hex-encoded asset full name | 
**policyId** | **kotlin.String** | Policy ID of the asset | 
**assetName** | **kotlin.String** | Hex-encoded asset name of the asset | 
**fingerprint** | **kotlin.String** | CIP14 based user-facing fingerprint | 
**quantity** | **kotlin.String** | Current asset quantity | 
**initialMintTxHash** | **kotlin.String** | ID of the initial minting transaction | 
**mintOrBurnCount** | **kotlin.Int** | Count of mint and burn transactions | 
**onchainMetadata** | [**kotlin.collections.Map&lt;kotlin.String, kotlin.Any&gt;**](kotlin.Any.md) | On-chain metadata stored in the minting transaction under label 721, community discussion around the standard ongoing at https://github.com/cardano-foundation/CIPs/pull/85  | 
**metadata** | [**AssetMetadata**](AssetMetadata.md) |  | 



