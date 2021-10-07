
# BlockContent

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**time** | **kotlin.Int** | Block creation time in UNIX time | 
**height** | **kotlin.Int** | Block number | 
**hash** | **kotlin.String** | Hash of the block | 
**slot** | **kotlin.Int** | Slot number | 
**epoch** | **kotlin.Int** | Epoch number | 
**epochSlot** | **kotlin.Int** | Slot within the epoch | 
**slotLeader** | **kotlin.String** | Bech32 ID of the slot leader or specific block description in case there is no slot leader | 
**propertySize** | **kotlin.Int** | Block size in Bytes | 
**txCount** | **kotlin.Int** | Number of transactions in the block | 
**output** | **kotlin.String** | Total output within the block in Lovelaces | 
**fees** | **kotlin.String** | Total fees within the block in Lovelaces | 
**blockVrf** | **kotlin.String** | VRF key of the block | 
**previousBlock** | **kotlin.String** | Hash of the previous block | 
**nextBlock** | **kotlin.String** | Hash of the next block | 
**confirmations** | **kotlin.Int** | Number of block confirmations | 



