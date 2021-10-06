
# EpochParamContent

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**epoch** | **kotlin.Int** | Epoch number | 
**minFeeA** | **kotlin.Int** | The linear factor for the minimum fee calculation for given epoch | 
**minFeeB** | **kotlin.Int** | The constant factor for the minimum fee calculation | 
**maxBlockSize** | **kotlin.Int** | Maximum block body size in Bytes | 
**maxTxSize** | **kotlin.Int** | Maximum transaction size | 
**maxBlockHeaderSize** | **kotlin.Int** | Maximum block header size | 
**keyDeposit** | **kotlin.String** | The amount of a key registration deposit in Lovelaces | 
**poolDeposit** | **kotlin.String** | The amount of a pool registration deposit in Lovelaces | 
**eMax** | **kotlin.Int** | Epoch bound on pool retirement | 
**nOpt** | **kotlin.Int** | Desired number of pools | 
**a0** | [**java.math.BigDecimal**](java.math.BigDecimal.md) | Pool pledge influence | 
**rho** | [**java.math.BigDecimal**](java.math.BigDecimal.md) | Monetary expansion | 
**tau** | [**java.math.BigDecimal**](java.math.BigDecimal.md) | Treasury expansion | 
**decentralisationParam** | [**java.math.BigDecimal**](java.math.BigDecimal.md) | Percentage of blocks produced by federated nodes | 
**extraEntropy** | [**kotlin.Any**](.md) | Seed for extra entropy | 
**protocolMajorVer** | **kotlin.Int** | Accepted protocol major version | 
**protocolMinorVer** | **kotlin.Int** | Accepted protocol minor version | 
**minUtxo** | **kotlin.String** | Minimum UTXO value | 
**minPoolCost** | **kotlin.String** | Minimum stake cost forced on the pool | 
**nonce** | **kotlin.String** | Epoch number only used once | 



