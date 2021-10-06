
# TxContent

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**hash** | **kotlin.String** | Transaction hash | 
**block** | **kotlin.String** | Block hash | 
**blockHeight** | **kotlin.Int** | Block number | 
**slot** | **kotlin.Int** | Slot number | 
**index** | **kotlin.Int** | Transaction index within the block | 
**outputAmount** | [**kotlin.collections.List&lt;TxContentOutputAmount&gt;**](TxContentOutputAmount.md) |  | 
**fees** | **kotlin.String** | Fees of the transaction in Lovelaces | 
**deposit** | **kotlin.String** | Deposit within the transaction in Lovelaces | 
**size** | **kotlin.Int** | Size of the transaction in Bytes | 
**invalidBefore** | **kotlin.String** | Left (included) endpoint of the timelock validity intervals | 
**invalidHereafter** | **kotlin.String** | Right (excluded) endpoint of the timelock validity intervals | 
**utxoCount** | **kotlin.Int** | Count of UTXOs within the transaction | 
**withdrawalCount** | **kotlin.Int** | Count of the withdrawal within the transaction | 
**mirCertCount** | **kotlin.Int** | Count of the MIR certificates within the transaction | 
**delegationCount** | **kotlin.Int** | Count of the delegations within the transaction | 
**stakeCertCount** | **kotlin.Int** | Count of the stake keys (de)registration and delegation certificates within the transaction | 
**poolUpdateCount** | **kotlin.Int** | Count of the stake pool registration and update certificates within the transaction | 
**poolRetireCount** | **kotlin.Int** | Count of the stake pool retirement certificates within the transaction | 
**assetMintOrBurnCount** | **kotlin.Int** | Count of asset mints and burns within the transaction | 



