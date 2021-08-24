
# GenesisContent

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**activeSlotsCoefficient** | [**java.math.BigDecimal**](java.math.BigDecimal.md) | The proportion of slots in which blocks should be issued | 
**updateQuorum** | **kotlin.Int** | Determines the quorum needed for votes on the protocol parameter updates | 
**maxLovelaceSupply** | **kotlin.String** | The total number of lovelace in the system | 
**networkMagic** | **kotlin.Int** | Network identifier | 
**epochLength** | **kotlin.Int** | Number of slots in an epoch | 
**systemStart** | **kotlin.Int** | Time of slot 0 in UNIX time | 
**slotsPerKesPeriod** | **kotlin.Int** | Number of slots in an KES period | 
**slotLength** | **kotlin.Int** | Duration of one slot in seconds | 
**maxKesEvolutions** | **kotlin.Int** | The maximum number of time a KES key can be evolved before a pool operator must create a new operational certificate | 
**securityParam** | **kotlin.Int** | Security parameter k | 



