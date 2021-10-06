
# InlineResponse2005

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**timeCreated** | **kotlin.Int** | Creation time of the IPFS object on our backends | 
**timePinned** | **kotlin.Int** | Pin time of the IPFS object on our backends | 
**ipfsHash** | **kotlin.String** | IPFS hash of the pinned object | 
**size** | **kotlin.String** | Size of the object in Bytes | 
**state** | [**inline**](#StateEnum) | State of the pinned object, which is &#x60;queued&#x60; when we are retriving object. If this is successful the state is changed to &#x60;pinned&#x60; or &#x60;failed&#x60; if not. The state &#x60;gc&#x60; means the pinned item has been garbage collected due to account being over storage quota or after it has been moved to &#x60;unpinned&#x60; state by removing the object pin.  | 


<a name="StateEnum"></a>
## Enum: state
Name | Value
---- | -----
state | queued|pinned|unpinned|failed|gc



