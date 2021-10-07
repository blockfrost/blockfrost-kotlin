
# TxContentPoolCert

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**certIndex** | **kotlin.Int** | Index of the certificate within the transaction | 
**poolId** | **kotlin.String** | Bech32 encoded pool ID | 
**vrfKey** | **kotlin.String** | VRF key hash | 
**pledge** | **kotlin.String** | Stake pool certificate pledge in Lovelaces | 
**marginCost** | [**java.math.BigDecimal**](java.math.BigDecimal.md) | Margin tax cost of the stake pool | 
**fixedCost** | **kotlin.String** | Fixed tax cost of the stake pool in Lovelaces | 
**rewardAccount** | **kotlin.String** | Bech32 reward account of the stake pool | 
**owners** | **kotlin.collections.List&lt;kotlin.String&gt;** |  | 
**metadata** | [**kotlin.Any**](kotlin.Any.md) |  | 
**relays** | [**kotlin.collections.List&lt;kotlin.Any&gt;**](kotlin.Any.md) |  | 
**activeEpoch** | **kotlin.Int** | Epoch that the delegation becomes active | 



