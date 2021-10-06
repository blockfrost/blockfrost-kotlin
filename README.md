# blockfrost-kotlin
*WIP* Kotlin SDK for Blockfrost.io API

## Requires

* Kotlin 1.4.30
* Gradle 7.2

## Build

First, create the gradle wrapper script:

```
gradle wrapper
```

Then, run:

```
./gradlew check assemble
```

This runs all tests and packages the library.

## Features/Implementation Notes

* Supports JSON inputs/outputs, File inputs, and Form inputs.
* Supports collection formats for query parameters: csv, tsv, ssv, pipes.
* Some Kotlin and Java types are fully qualified to avoid conflicts with types defined in OpenAPI definitions.
* Implementation of ApiClient is intended to reduce method counts, specifically to benefit Android targets.

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *https://cardano-mainnet.blockfrost.io/api/v0*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*CardanoAccountsApi* | [**accountsStakeAddressAddressesAssetsGet**](docs/CardanoAccountsApi.md#accountsstakeaddressaddressesassetsget) | **GET** /accounts/{stake_address}/addresses/assets | Assets associated with the account addresses
*CardanoAccountsApi* | [**accountsStakeAddressAddressesGet**](docs/CardanoAccountsApi.md#accountsstakeaddressaddressesget) | **GET** /accounts/{stake_address}/addresses | Account associated addresses
*CardanoAccountsApi* | [**accountsStakeAddressDelegationsGet**](docs/CardanoAccountsApi.md#accountsstakeaddressdelegationsget) | **GET** /accounts/{stake_address}/delegations | Account delegation history
*CardanoAccountsApi* | [**accountsStakeAddressGet**](docs/CardanoAccountsApi.md#accountsstakeaddressget) | **GET** /accounts/{stake_address} | Specific account address
*CardanoAccountsApi* | [**accountsStakeAddressHistoryGet**](docs/CardanoAccountsApi.md#accountsstakeaddresshistoryget) | **GET** /accounts/{stake_address}/history | Account history
*CardanoAccountsApi* | [**accountsStakeAddressMirsGet**](docs/CardanoAccountsApi.md#accountsstakeaddressmirsget) | **GET** /accounts/{stake_address}/mirs | Account MIR history
*CardanoAccountsApi* | [**accountsStakeAddressRegistrationsGet**](docs/CardanoAccountsApi.md#accountsstakeaddressregistrationsget) | **GET** /accounts/{stake_address}/registrations | Account registration history
*CardanoAccountsApi* | [**accountsStakeAddressRewardsGet**](docs/CardanoAccountsApi.md#accountsstakeaddressrewardsget) | **GET** /accounts/{stake_address}/rewards | Account reward history
*CardanoAccountsApi* | [**accountsStakeAddressWithdrawalsGet**](docs/CardanoAccountsApi.md#accountsstakeaddresswithdrawalsget) | **GET** /accounts/{stake_address}/withdrawals | Account withdrawal history
*CardanoAddressesApi* | [**addressesAddressGet**](docs/CardanoAddressesApi.md#addressesaddressget) | **GET** /addresses/{address} | Specific address
*CardanoAddressesApi* | [**addressesAddressTotalGet**](docs/CardanoAddressesApi.md#addressesaddresstotalget) | **GET** /addresses/{address}/total | Address details
*CardanoAddressesApi* | [**addressesAddressTransactionsGet**](docs/CardanoAddressesApi.md#addressesaddresstransactionsget) | **GET** /addresses/{address}/transactions | Address transactions
*CardanoAddressesApi* | [**addressesAddressTxsGet**](docs/CardanoAddressesApi.md#addressesaddresstxsget) | **GET** /addresses/{address}/txs | Address transactions
*CardanoAddressesApi* | [**addressesAddressUtxosGet**](docs/CardanoAddressesApi.md#addressesaddressutxosget) | **GET** /addresses/{address}/utxos | Address UTXOs
*CardanoAssetsApi* | [**assetsAssetAddressesGet**](docs/CardanoAssetsApi.md#assetsassetaddressesget) | **GET** /assets/{asset}/addresses | Asset addresses
*CardanoAssetsApi* | [**assetsAssetGet**](docs/CardanoAssetsApi.md#assetsassetget) | **GET** /assets/{asset} | Specific asset
*CardanoAssetsApi* | [**assetsAssetHistoryGet**](docs/CardanoAssetsApi.md#assetsassethistoryget) | **GET** /assets/{asset}/history | Asset history
*CardanoAssetsApi* | [**assetsAssetTransactionsGet**](docs/CardanoAssetsApi.md#assetsassettransactionsget) | **GET** /assets/{asset}/transactions | Asset transactions
*CardanoAssetsApi* | [**assetsAssetTxsGet**](docs/CardanoAssetsApi.md#assetsassettxsget) | **GET** /assets/{asset}/txs | Asset transactions
*CardanoAssetsApi* | [**assetsGet**](docs/CardanoAssetsApi.md#assetsget) | **GET** /assets | Assets
*CardanoAssetsApi* | [**assetsPolicyPolicyIdGet**](docs/CardanoAssetsApi.md#assetspolicypolicyidget) | **GET** /assets/policy/{policy_id} | Assets of a specific policy
*CardanoBlocksApi* | [**blocksEpochEpochNumberSlotSlotNumberGet**](docs/CardanoBlocksApi.md#blocksepochepochnumberslotslotnumberget) | **GET** /blocks/epoch/{epoch_number}/slot/{slot_number} | Specific block in a slot in an epoch
*CardanoBlocksApi* | [**blocksHashOrNumberGet**](docs/CardanoBlocksApi.md#blockshashornumberget) | **GET** /blocks/{hash_or_number} | Specific block
*CardanoBlocksApi* | [**blocksHashOrNumberNextGet**](docs/CardanoBlocksApi.md#blockshashornumbernextget) | **GET** /blocks/{hash_or_number}/next | Listing of next blocks
*CardanoBlocksApi* | [**blocksHashOrNumberPreviousGet**](docs/CardanoBlocksApi.md#blockshashornumberpreviousget) | **GET** /blocks/{hash_or_number}/previous | Listing of previous blocks
*CardanoBlocksApi* | [**blocksHashOrNumberTxsGet**](docs/CardanoBlocksApi.md#blockshashornumbertxsget) | **GET** /blocks/{hash_or_number}/txs | Block transactions
*CardanoBlocksApi* | [**blocksLatestGet**](docs/CardanoBlocksApi.md#blockslatestget) | **GET** /blocks/latest | Latest block
*CardanoBlocksApi* | [**blocksLatestTxsGet**](docs/CardanoBlocksApi.md#blockslatesttxsget) | **GET** /blocks/latest/txs | Latest block transactions
*CardanoBlocksApi* | [**blocksSlotSlotNumberGet**](docs/CardanoBlocksApi.md#blocksslotslotnumberget) | **GET** /blocks/slot/{slot_number} | Specific block in a slot
*CardanoEpochsApi* | [**epochsLatestGet**](docs/CardanoEpochsApi.md#epochslatestget) | **GET** /epochs/latest | Latest epoch
*CardanoEpochsApi* | [**epochsLatestParametersGet**](docs/CardanoEpochsApi.md#epochslatestparametersget) | **GET** /epochs/latest/parameters | Latest epoch protocol parameters
*CardanoEpochsApi* | [**epochsNumberBlocksGet**](docs/CardanoEpochsApi.md#epochsnumberblocksget) | **GET** /epochs/{number}/blocks | Block distribution
*CardanoEpochsApi* | [**epochsNumberBlocksPoolIdGet**](docs/CardanoEpochsApi.md#epochsnumberblockspoolidget) | **GET** /epochs/{number}/blocks/{pool_id} | Block distribution
*CardanoEpochsApi* | [**epochsNumberGet**](docs/CardanoEpochsApi.md#epochsnumberget) | **GET** /epochs/{number} | Specific epoch
*CardanoEpochsApi* | [**epochsNumberNextGet**](docs/CardanoEpochsApi.md#epochsnumbernextget) | **GET** /epochs/{number}/next | Listing of next epochs
*CardanoEpochsApi* | [**epochsNumberParametersGet**](docs/CardanoEpochsApi.md#epochsnumberparametersget) | **GET** /epochs/{number}/parameters | Protocol parameters
*CardanoEpochsApi* | [**epochsNumberPreviousGet**](docs/CardanoEpochsApi.md#epochsnumberpreviousget) | **GET** /epochs/{number}/previous | Listing of previous epochs
*CardanoEpochsApi* | [**epochsNumberStakesGet**](docs/CardanoEpochsApi.md#epochsnumberstakesget) | **GET** /epochs/{number}/stakes | Stake distribution
*CardanoEpochsApi* | [**epochsNumberStakesPoolIdGet**](docs/CardanoEpochsApi.md#epochsnumberstakespoolidget) | **GET** /epochs/{number}/stakes/{pool_id} | Stake distribution by pool
*CardanoLedgerApi* | [**genesisGet**](docs/CardanoLedgerApi.md#genesisget) | **GET** /genesis | Blockchain genesis
*CardanoMetadataApi* | [**metadataTxsLabelsGet**](docs/CardanoMetadataApi.md#metadatatxslabelsget) | **GET** /metadata/txs/labels | Transaction metadata labels
*CardanoMetadataApi* | [**metadataTxsLabelsLabelCborGet**](docs/CardanoMetadataApi.md#metadatatxslabelslabelcborget) | **GET** /metadata/txs/labels/{label}/cbor | Transaction metadata content in CBOR
*CardanoMetadataApi* | [**metadataTxsLabelsLabelGet**](docs/CardanoMetadataApi.md#metadatatxslabelslabelget) | **GET** /metadata/txs/labels/{label} | Transaction metadata content in JSON
*CardanoNetworkApi* | [**networkGet**](docs/CardanoNetworkApi.md#networkget) | **GET** /network | Network information
*CardanoPoolsApi* | [**poolsGet**](docs/CardanoPoolsApi.md#poolsget) | **GET** /pools | List of stake pools
*CardanoPoolsApi* | [**poolsPoolIdBlocksGet**](docs/CardanoPoolsApi.md#poolspoolidblocksget) | **GET** /pools/{pool_id}/blocks | Stake pool blocks
*CardanoPoolsApi* | [**poolsPoolIdDelegatorsGet**](docs/CardanoPoolsApi.md#poolspooliddelegatorsget) | **GET** /pools/{pool_id}/delegators | Stake pool delegators
*CardanoPoolsApi* | [**poolsPoolIdGet**](docs/CardanoPoolsApi.md#poolspoolidget) | **GET** /pools/{pool_id} | Specific stake pool
*CardanoPoolsApi* | [**poolsPoolIdHistoryGet**](docs/CardanoPoolsApi.md#poolspoolidhistoryget) | **GET** /pools/{pool_id}/history | Stake pool history
*CardanoPoolsApi* | [**poolsPoolIdMetadataGet**](docs/CardanoPoolsApi.md#poolspoolidmetadataget) | **GET** /pools/{pool_id}/metadata | Stake pool metadata
*CardanoPoolsApi* | [**poolsPoolIdRelaysGet**](docs/CardanoPoolsApi.md#poolspoolidrelaysget) | **GET** /pools/{pool_id}/relays | Stake pool relays
*CardanoPoolsApi* | [**poolsPoolIdUpdatesGet**](docs/CardanoPoolsApi.md#poolspoolidupdatesget) | **GET** /pools/{pool_id}/updates | Stake pool updates
*CardanoPoolsApi* | [**poolsRetiredGet**](docs/CardanoPoolsApi.md#poolsretiredget) | **GET** /pools/retired | List of retired stake pools
*CardanoPoolsApi* | [**poolsRetiringGet**](docs/CardanoPoolsApi.md#poolsretiringget) | **GET** /pools/retiring | List of retiring stake pools
*CardanoTransactionsApi* | [**txSubmitPost**](docs/CardanoTransactionsApi.md#txsubmitpost) | **POST** /tx/submit | Submit a transaction
*CardanoTransactionsApi* | [**txsHashDelegationsGet**](docs/CardanoTransactionsApi.md#txshashdelegationsget) | **GET** /txs/{hash}/delegations | Transaction delegation certificates
*CardanoTransactionsApi* | [**txsHashGet**](docs/CardanoTransactionsApi.md#txshashget) | **GET** /txs/{hash} | Specific transaction
*CardanoTransactionsApi* | [**txsHashMetadataCborGet**](docs/CardanoTransactionsApi.md#txshashmetadatacborget) | **GET** /txs/{hash}/metadata/cbor | Transaction metadata in CBOR
*CardanoTransactionsApi* | [**txsHashMetadataGet**](docs/CardanoTransactionsApi.md#txshashmetadataget) | **GET** /txs/{hash}/metadata | Transaction metadata
*CardanoTransactionsApi* | [**txsHashMirsGet**](docs/CardanoTransactionsApi.md#txshashmirsget) | **GET** /txs/{hash}/mirs | Transaction MIRs
*CardanoTransactionsApi* | [**txsHashPoolRetiresGet**](docs/CardanoTransactionsApi.md#txshashpoolretiresget) | **GET** /txs/{hash}/pool_retires | Transaction stake pool retirement certificates
*CardanoTransactionsApi* | [**txsHashPoolUpdatesGet**](docs/CardanoTransactionsApi.md#txshashpoolupdatesget) | **GET** /txs/{hash}/pool_updates | Transaction stake pool registration and update certificates
*CardanoTransactionsApi* | [**txsHashStakesGet**](docs/CardanoTransactionsApi.md#txshashstakesget) | **GET** /txs/{hash}/stakes | Transaction stake addresses certificates
*CardanoTransactionsApi* | [**txsHashUtxosGet**](docs/CardanoTransactionsApi.md#txshashutxosget) | **GET** /txs/{hash}/utxos | Transaction UTXOs
*CardanoTransactionsApi* | [**txsHashWithdrawalsGet**](docs/CardanoTransactionsApi.md#txshashwithdrawalsget) | **GET** /txs/{hash}/withdrawals | Transaction withdrawal
*HealthApi* | [**healthClockGet**](docs/HealthApi.md#healthclockget) | **GET** /health/clock | Current backend time
*HealthApi* | [**healthGet**](docs/HealthApi.md#healthget) | **GET** /health | Backend health status
*HealthApi* | [**rootGet**](docs/HealthApi.md#rootget) | **GET** / | Root endpoint
*IPFSAddApi* | [**ipfsAddPost**](docs/IPFSAddApi.md#ipfsaddpost) | **POST** /ipfs/add | Add a file or directory to IPFS
*IPFSGatewayApi* | [**ipfsGatewayIPFSPathGet**](docs/IPFSGatewayApi.md#ipfsgatewayipfspathget) | **GET** /ipfs/gateway/{IPFS_path} | Relay to an IPFS gateway
*IPFSPinsApi* | [**ipfsPinAddIPFSPathPost**](docs/IPFSPinsApi.md#ipfspinaddipfspathpost) | **POST** /ipfs/pin/add/{IPFS_path} | Pin an object
*IPFSPinsApi* | [**ipfsPinListGet**](docs/IPFSPinsApi.md#ipfspinlistget) | **GET** /ipfs/pin/list/ | 
*IPFSPinsApi* | [**ipfsPinListIPFSPathGet**](docs/IPFSPinsApi.md#ipfspinlistipfspathget) | **GET** /ipfs/pin/list/{IPFS_path} | 
*IPFSPinsApi* | [**ipfsPinRemoveIPFSPathPost**](docs/IPFSPinsApi.md#ipfspinremoveipfspathpost) | **POST** /ipfs/pin/remove/{IPFS_path} | 
*MetricsApi* | [**metricsEndpointsGet**](docs/MetricsApi.md#metricsendpointsget) | **GET** /metrics/endpoints | Blockfrost endpoint usage metrics
*MetricsApi* | [**metricsGet**](docs/MetricsApi.md#metricsget) | **GET** /metrics/ | Blockfrost usage metrics
*NutLinkApi* | [**nutlinkAddressGet**](docs/NutLinkApi.md#nutlinkaddressget) | **GET** /nutlink/{address} | 
*NutLinkApi* | [**nutlinkAddressTickersGet**](docs/NutLinkApi.md#nutlinkaddresstickersget) | **GET** /nutlink/{address}/tickers | 
*NutLinkApi* | [**nutlinkAddressTickersTickerGet**](docs/NutLinkApi.md#nutlinkaddresstickerstickerget) | **GET** /nutlink/{address}/tickers/{ticker} | 
*NutLinkApi* | [**nutlinkTickersTickerGet**](docs/NutLinkApi.md#nutlinktickerstickerget) | **GET** /nutlink/tickers/{ticker} | 


<a name="documentation-for-models"></a>
## Documentation for Models

 - [org.openapitools.client.models2.AccountContent](docs/AccountContent.md)
 - [org.openapitools.client.models2.AddressContent](docs/AddressContent.md)
 - [org.openapitools.client.models2.AddressContentTotal](docs/AddressContentTotal.md)
 - [org.openapitools.client.models2.Asset](docs/Asset.md)
 - [org.openapitools.client.models2.AssetMetadata](docs/AssetMetadata.md)
 - [org.openapitools.client.models2.BlockContent](docs/BlockContent.md)
 - [org.openapitools.client.models2.EpochContent](docs/EpochContent.md)
 - [org.openapitools.client.models2.EpochParamContent](docs/EpochParamContent.md)
 - [org.openapitools.client.models2.GenesisContent](docs/GenesisContent.md)
 - [org.openapitools.client.models2.InlineResponse200](docs/InlineResponse200.md)
 - [org.openapitools.client.models2.InlineResponse2001](docs/InlineResponse2001.md)
 - [org.openapitools.client.models2.InlineResponse2002](docs/InlineResponse2002.md)
 - [org.openapitools.client.models2.InlineResponse2003](docs/InlineResponse2003.md)
 - [org.openapitools.client.models2.InlineResponse2004](docs/InlineResponse2004.md)
 - [org.openapitools.client.models2.InlineResponse2005](docs/InlineResponse2005.md)
 - [org.openapitools.client.models2.InlineResponse2006](docs/InlineResponse2006.md)
 - [org.openapitools.client.models2.InlineResponse2007](docs/InlineResponse2007.md)
 - [org.openapitools.client.models2.InlineResponse400](docs/InlineResponse400.md)
 - [org.openapitools.client.models2.InlineResponse403](docs/InlineResponse403.md)
 - [org.openapitools.client.models2.InlineResponse404](docs/InlineResponse404.md)
 - [org.openapitools.client.models2.InlineResponse418](docs/InlineResponse418.md)
 - [org.openapitools.client.models2.InlineResponse429](docs/InlineResponse429.md)
 - [org.openapitools.client.models2.InlineResponse500](docs/InlineResponse500.md)
 - [org.openapitools.client.models2.Network](docs/Network.md)
 - [org.openapitools.client.models2.NetworkStake](docs/NetworkStake.md)
 - [org.openapitools.client.models2.NetworkSupply](docs/NetworkSupply.md)
 - [org.openapitools.client.models2.NutlinkAddress](docs/NutlinkAddress.md)
 - [org.openapitools.client.models2.Pool](docs/Pool.md)
 - [org.openapitools.client.models2.PoolMetadata](docs/PoolMetadata.md)
 - [org.openapitools.client.models2.TxContent](docs/TxContent.md)
 - [org.openapitools.client.models2.TxContentOutputAmount](docs/TxContentOutputAmount.md)
 - [org.openapitools.client.models2.TxContentUtxo](docs/TxContentUtxo.md)
 - [org.openapitools.client.models2.TxContentUtxoInputs](docs/TxContentUtxoInputs.md)
 - [org.openapitools.client.models2.TxContentUtxoOutputs](docs/TxContentUtxoOutputs.md)


<a name="documentation-for-authorization"></a>
## Documentation for Authorization

- **Type**: API key
- **API key parameter name**: project_id
- **Location**: HTTP header

>>>>>>> master
