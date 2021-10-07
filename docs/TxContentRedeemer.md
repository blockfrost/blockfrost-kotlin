
# TxContentRedeemer

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**txIndex** | **kotlin.Int** | Index of the redeemer within the transaction | 
**purpose** | [**inline**](#PurposeEnum) | Validation purpose | 
**unitMem** | **kotlin.String** | The budget in Memory to run a script | 
**unitSteps** | **kotlin.String** | The budget in CPU steps to run a script | 
**fee** | **kotlin.String** | The fee consumed to run the script | 


<a name="PurposeEnum"></a>
## Enum: purpose
Name | Value
---- | -----
purpose | spend, mint, cert, reward



