<img src="https://blockfrost.io/images/logo.svg" width="250" align="right" height="90">

# blockfrost-kotlin
![CI badge](https://github.com/blockfrost/blockfrost-kotlin/actions/workflows/integration-test.yml/badge.svg)
Kotlin SDK for Blockfrost.io API

## Requires

* Kotlin 1.5.30
* Gradle 7.2

## Usage

API is asynchronous, coroutine based.

```kotlin
// Use default configuration, mainnet, project_id loaded from BF_PROJECT_ID env var
val api = CardanoAddressesApi(config = BlockfrostConfig.defaulMainNetConfig)

// coroutine call, returns model object
val details = api.getAddressDetails("addr1q8zu4smzyf2r2mfqjd6tc6vxf2p8rccdfk82ye3eut2udkw9etpkygj5x4kjpym5h35cvj5zw83s6nvw5fnrnck4cmvshkfm4y")
```

Default configuration for IPFS, project ID is loaded from env var `BF_IPFS_PROJECT_ID`
```kotlin
val apiIpfsAdd = IPFSAddAPI(config = BlockfrostConfig.defaultIpfsConfig)
```

You can also define API-specific configuration
```kotlin
val config = BlockfrostConfig(
    baseUrl = BlockfrostConfig.UrlIpfs,
    projectId = BlockfrostConfig.getEnvProjectIdIpfs(),
    socketTimeoutMilli = 90_000,
)
val apiIpfsAdd = IPFSAddAPI(config = config)
```

### Fetch All methods
Methods with paging parameters (count, page, order) have paging methods enabling to load all results, iterating over all pages in the background.
For example 

```kotlin
val api = CardanoAddressesApi(config = BlockfrostConfig.defaulMainNetConfig)
val flow: Flow<AddressTransactionsContent> = api.getAddressTransactionsAll(address = "addr1q8zu4smzyf2r2mfqjd6tc6vxf2p8rccdfk82ye3eut2udkw9etpkygj5x4kjpym5h35cvj5zw83s6nvw5fnrnck4cmvshkfm4y")
flow.collect { 
    println("Transaction: $it")
}
```

OperationAll methods return a [Flow](https://kotlinlang.org/docs/flow.html) object enabling processing of individual results as they are produced by the loading method.
I.e., once first page is loaded with results, consumer can immediately start processing the results form the flow without need to wait for downloading all pages.
It is also possible to stop page download on a consumer side.

### Fetch AllList methods
Alternative to fetch All methods are fetch AllList methods. E.g., 

```kotlin
val api = CardanoAddressesApi(config = BlockfrostConfig.defaulMainNetConfig)
val res: List<AddressTransactionsContent> = api.getAddressTransactionsAllList(address = "addr1q8zu4smzyf2r2mfqjd6tc6vxf2p8rccdfk82ye3eut2udkw9etpkygj5x4kjpym5h35cvj5zw83s6nvw5fnrnck4cmvshkfm4y")
```

The method returns list once all pages are downloaded.

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
*CardanoAccountsApi* | [**getAccountAddresses**](docs/CardanoAccountsApi.md#getaccountaddresses) | **GET** /accounts/{stake_address}/addresses | Account associated addresses
*CardanoAccountsApi* | [**getAccountAssets**](docs/CardanoAccountsApi.md#getaccountassets) | **GET** /accounts/{stake_address}/addresses/assets | Assets associated with the account addresses
*CardanoAccountsApi* | [**getAccountByStakeAddress**](docs/CardanoAccountsApi.md#getaccountbystakeaddress) | **GET** /accounts/{stake_address} | Specific account address
*CardanoAccountsApi* | [**getAccountDelegationHistory**](docs/CardanoAccountsApi.md#getaccountdelegationhistory) | **GET** /accounts/{stake_address}/delegations | Account delegation history
*CardanoAccountsApi* | [**getAccountHistory**](docs/CardanoAccountsApi.md#getaccounthistory) | **GET** /accounts/{stake_address}/history | Account history
*CardanoAccountsApi* | [**getAccountMirHistory**](docs/CardanoAccountsApi.md#getaccountmirhistory) | **GET** /accounts/{stake_address}/mirs | Account MIR history
*CardanoAccountsApi* | [**getAccountRegistrationHistory**](docs/CardanoAccountsApi.md#getaccountregistrationhistory) | **GET** /accounts/{stake_address}/registrations | Account registration history
*CardanoAccountsApi* | [**getAccountRewardHistory**](docs/CardanoAccountsApi.md#getaccountrewardhistory) | **GET** /accounts/{stake_address}/rewards | Account reward history
*CardanoAccountsApi* | [**getAccountWithdrawalHistory**](docs/CardanoAccountsApi.md#getaccountwithdrawalhistory) | **GET** /accounts/{stake_address}/withdrawals | Account withdrawal history
*CardanoAddressesApi* | [**getAddress**](docs/CardanoAddressesApi.md#getaddress) | **GET** /addresses/{address} | Specific address
*CardanoAddressesApi* | [**getAddressDetails**](docs/CardanoAddressesApi.md#getaddressdetails) | **GET** /addresses/{address}/total | Address details
*CardanoAddressesApi* | [**getAddressTransactions**](docs/CardanoAddressesApi.md#getaddresstransactions) | **GET** /addresses/{address}/transactions | Address transactions
*CardanoAddressesApi* | [**getAddressTxs**](docs/CardanoAddressesApi.md#getaddresstxs) | **GET** /addresses/{address}/txs | Address transactions
*CardanoAddressesApi* | [**getAddressUtxos**](docs/CardanoAddressesApi.md#getaddressutxos) | **GET** /addresses/{address}/utxos | Address UTXOs
*CardanoAssetsApi* | [**getAsset**](docs/CardanoAssetsApi.md#getasset) | **GET** /assets/{asset} | Specific asset
*CardanoAssetsApi* | [**getAssetAddresses**](docs/CardanoAssetsApi.md#getassetaddresses) | **GET** /assets/{asset}/addresses | Asset addresses
*CardanoAssetsApi* | [**getAssetHistory**](docs/CardanoAssetsApi.md#getassethistory) | **GET** /assets/{asset}/history | Asset history
*CardanoAssetsApi* | [**getAssetTransactions**](docs/CardanoAssetsApi.md#getassettransactions) | **GET** /assets/{asset}/transactions | Asset transactions
*CardanoAssetsApi* | [**getAssetTxs**](docs/CardanoAssetsApi.md#getassettxs) | **GET** /assets/{asset}/txs | Asset transactions
*CardanoAssetsApi* | [**getAssets**](docs/CardanoAssetsApi.md#getassets) | **GET** /assets | Assets
*CardanoAssetsApi* | [**getPolicyAssets**](docs/CardanoAssetsApi.md#getpolicyassets) | **GET** /assets/policy/{policy_id} | Assets of a specific policy
*CardanoBlocksApi* | [**getBlock**](docs/CardanoBlocksApi.md#getblock) | **GET** /blocks/{hash_or_number} | Specific block
*CardanoBlocksApi* | [**getBlockInEpochInSlot**](docs/CardanoBlocksApi.md#getblockinepochinslot) | **GET** /blocks/epoch/{epoch_number}/slot/{slot_number} | Specific block in a slot in an epoch
*CardanoBlocksApi* | [**getBlockInSlot**](docs/CardanoBlocksApi.md#getblockinslot) | **GET** /blocks/slot/{slot_number} | Specific block in a slot
*CardanoBlocksApi* | [**getBlockTransactions**](docs/CardanoBlocksApi.md#getblocktransactions) | **GET** /blocks/{hash_or_number}/txs | Block transactions
*CardanoBlocksApi* | [**getLatestBlock**](docs/CardanoBlocksApi.md#getlatestblock) | **GET** /blocks/latest | Latest block
*CardanoBlocksApi* | [**getNextBlocks**](docs/CardanoBlocksApi.md#getnextblocks) | **GET** /blocks/{hash_or_number}/next | Listing of next blocks
*CardanoBlocksApi* | [**getPreviousBlocks**](docs/CardanoBlocksApi.md#getpreviousblocks) | **GET** /blocks/{hash_or_number}/previous | Listing of previous blocks
*CardanoBlocksApi* | [**getTransactionsInLatestBlock**](docs/CardanoBlocksApi.md#gettransactionsinlatestblock) | **GET** /blocks/latest/txs | Latest block transactions
*CardanoEpochsApi* | [**getActiveStakesForEpoch**](docs/CardanoEpochsApi.md#getactivestakesforepoch) | **GET** /epochs/{number}/stakes | Stake distribution
*CardanoEpochsApi* | [**getActiveStakesForEpochAndPool**](docs/CardanoEpochsApi.md#getactivestakesforepochandpool) | **GET** /epochs/{number}/stakes/{pool_id} | Stake distribution by pool
*CardanoEpochsApi* | [**getBlocksForEpoch**](docs/CardanoEpochsApi.md#getblocksforepoch) | **GET** /epochs/{number}/blocks | Block distribution
*CardanoEpochsApi* | [**getBlocksForEpochAndPool**](docs/CardanoEpochsApi.md#getblocksforepochandpool) | **GET** /epochs/{number}/blocks/{pool_id} | Block distribution by pool
*CardanoEpochsApi* | [**getEpoch**](docs/CardanoEpochsApi.md#getepoch) | **GET** /epochs/{number} | Specific epoch
*CardanoEpochsApi* | [**getEpochParam**](docs/CardanoEpochsApi.md#getepochparam) | **GET** /epochs/{number}/parameters | Protocol parameters
*CardanoEpochsApi* | [**getLatestEpoch**](docs/CardanoEpochsApi.md#getlatestepoch) | **GET** /epochs/latest | Latest epoch
*CardanoEpochsApi* | [**getLatestEpochParam**](docs/CardanoEpochsApi.md#getlatestepochparam) | **GET** /epochs/latest/parameters | Latest epoch protocol parameters
*CardanoEpochsApi* | [**getNextEpochs**](docs/CardanoEpochsApi.md#getnextepochs) | **GET** /epochs/{number}/next | Listing of next epochs
*CardanoEpochsApi* | [**getPreviousEpochs**](docs/CardanoEpochsApi.md#getpreviousepochs) | **GET** /epochs/{number}/previous | Listing of previous epochs
*CardanoLedgerApi* | [**getGenesis**](docs/CardanoLedgerApi.md#getgenesis) | **GET** /genesis | Blockchain genesis
*CardanoMetadataApi* | [**getTransactionMetadataCborForLabel**](docs/CardanoMetadataApi.md#gettransactionmetadatacborforlabel) | **GET** /metadata/txs/labels/{label}/cbor | Transaction metadata content in CBOR
*CardanoMetadataApi* | [**getTransactionMetadataJsonForLabel**](docs/CardanoMetadataApi.md#gettransactionmetadatajsonforlabel) | **GET** /metadata/txs/labels/{label} | Transaction metadata content in JSON
*CardanoMetadataApi* | [**getTransactionMetadataLabels**](docs/CardanoMetadataApi.md#gettransactionmetadatalabels) | **GET** /metadata/txs/labels | Transaction metadata labels
*CardanoNetworkApi* | [**getNetwork**](docs/CardanoNetworkApi.md#getnetwork) | **GET** /network | Network information
*CardanoPoolsApi* | [**getPool**](docs/CardanoPoolsApi.md#getpool) | **GET** /pools/{pool_id} | Specific stake pool
*CardanoPoolsApi* | [**getPoolBlocks**](docs/CardanoPoolsApi.md#getpoolblocks) | **GET** /pools/{pool_id}/blocks | Stake pool blocks
*CardanoPoolsApi* | [**getPoolDelegators**](docs/CardanoPoolsApi.md#getpooldelegators) | **GET** /pools/{pool_id}/delegators | Stake pool delegators
*CardanoPoolsApi* | [**getPoolHistory**](docs/CardanoPoolsApi.md#getpoolhistory) | **GET** /pools/{pool_id}/history | Stake pool history
*CardanoPoolsApi* | [**getPoolMetadata**](docs/CardanoPoolsApi.md#getpoolmetadata) | **GET** /pools/{pool_id}/metadata | Stake pool metadata
*CardanoPoolsApi* | [**getPoolRelays**](docs/CardanoPoolsApi.md#getpoolrelays) | **GET** /pools/{pool_id}/relays | Stake pool relays
*CardanoPoolsApi* | [**getPoolUpdates**](docs/CardanoPoolsApi.md#getpoolupdates) | **GET** /pools/{pool_id}/updates | Stake pool updates
*CardanoPoolsApi* | [**getPools**](docs/CardanoPoolsApi.md#getpools) | **GET** /pools | List of stake pools
*CardanoPoolsApi* | [**getRetiredPools**](docs/CardanoPoolsApi.md#getretiredpools) | **GET** /pools/retired | List of retired stake pools
*CardanoPoolsApi* | [**getRetiringPools**](docs/CardanoPoolsApi.md#getretiringpools) | **GET** /pools/retiring | List of retiring stake pools
*CardanoScriptsApi* | [**getScript**](docs/CardanoScriptsApi.md#getscript) | **GET** /scripts/{script_hash} | Specific script
*CardanoScriptsApi* | [**getScriptRedeemers**](docs/CardanoScriptsApi.md#getscriptredeemers) | **GET** /scripts/{script_hash}/redeemers | Redeemers of a specific script
*CardanoScriptsApi* | [**getScripts**](docs/CardanoScriptsApi.md#getscripts) | **GET** /scripts | Scripts
*CardanoTransactionsApi* | [**getTransaction**](docs/CardanoTransactionsApi.md#gettransaction) | **GET** /txs/{hash} | Specific transaction
*CardanoTransactionsApi* | [**getTransactionDelegations**](docs/CardanoTransactionsApi.md#gettransactiondelegations) | **GET** /txs/{hash}/delegations | Transaction delegation certificates
*CardanoTransactionsApi* | [**getTransactionMetadata**](docs/CardanoTransactionsApi.md#gettransactionmetadata) | **GET** /txs/{hash}/metadata | Transaction metadata
*CardanoTransactionsApi* | [**getTransactionMetadataCbor**](docs/CardanoTransactionsApi.md#gettransactionmetadatacbor) | **GET** /txs/{hash}/metadata/cbor | Transaction metadata in CBOR
*CardanoTransactionsApi* | [**getTransactionMirs**](docs/CardanoTransactionsApi.md#gettransactionmirs) | **GET** /txs/{hash}/mirs | Transaction MIRs
*CardanoTransactionsApi* | [**getTransactionPoolRetires**](docs/CardanoTransactionsApi.md#gettransactionpoolretires) | **GET** /txs/{hash}/pool_retires | Transaction stake pool retirement certificates
*CardanoTransactionsApi* | [**getTransactionPoolUpdates**](docs/CardanoTransactionsApi.md#gettransactionpoolupdates) | **GET** /txs/{hash}/pool_updates | Transaction stake pool registration and update certificates
*CardanoTransactionsApi* | [**getTransactionRedeemers**](docs/CardanoTransactionsApi.md#gettransactionredeemers) | **GET** /txs/{hash}/redeemers | Transaction redeemers
*CardanoTransactionsApi* | [**getTransactionStakes**](docs/CardanoTransactionsApi.md#gettransactionstakes) | **GET** /txs/{hash}/stakes | Transaction stake addresses certificates
*CardanoTransactionsApi* | [**getTransactionUtxos**](docs/CardanoTransactionsApi.md#gettransactionutxos) | **GET** /txs/{hash}/utxos | Transaction UTXOs
*CardanoTransactionsApi* | [**getTransactionWithdrawals**](docs/CardanoTransactionsApi.md#gettransactionwithdrawals) | **GET** /txs/{hash}/withdrawals | Transaction withdrawal
*CardanoTransactionsApi* | [**submitTransaction**](docs/CardanoTransactionsApi.md#submittransaction) | **POST** /tx/submit | Submit a transaction
*HealthApi* | [**getApiRoot**](docs/HealthApi.md#getapiroot) | **GET** / | Root endpoint
*HealthApi* | [**getCurrentBackendTime**](docs/HealthApi.md#getcurrentbackendtime) | **GET** /health/clock | Current backend time
*HealthApi* | [**getHealth**](docs/HealthApi.md#gethealth) | **GET** /health | Backend health status
*IPFSAddApi* | [**add**](docs/IPFSAddApi.md#add) | **POST** /ipfs/add | Add a file to IPFS
*IPFSGatewayApi* | [**get**](docs/IPFSGatewayApi.md#get) | **GET** /ipfs/gateway/{IPFS_path} | Relay to an IPFS gateway
*IPFSPinsApi* | [**getPinList**](docs/IPFSPinsApi.md#getpinlist) | **GET** /ipfs/pin/list/ | List pinned objects
*IPFSPinsApi* | [**getPinListByIpfsPath**](docs/IPFSPinsApi.md#getpinlistbyipfspath) | **GET** /ipfs/pin/list/{IPFS_path} | Get details about pinned object
*IPFSPinsApi* | [**pinAdd**](docs/IPFSPinsApi.md#pinadd) | **POST** /ipfs/pin/add/{IPFS_path} | Pin an object
*IPFSPinsApi* | [**removePin**](docs/IPFSPinsApi.md#removepin) | **POST** /ipfs/pin/remove/{IPFS_path} |
*MetricsApi* | [**getMetrics**](docs/MetricsApi.md#getmetrics) | **GET** /metrics/ | Blockfrost usage metrics
*MetricsApi* | [**getMetricsEndpoints**](docs/MetricsApi.md#getmetricsendpoints) | **GET** /metrics/endpoints | Blockfrost endpoint usage metrics
*NutLinkApi* | [**getAddress**](docs/NutLinkApi.md#getaddress) | **GET** /nutlink/{address} |
*NutLinkApi* | [**getAddressTickers**](docs/NutLinkApi.md#getaddresstickers) | **GET** /nutlink/{address}/tickers |
*NutLinkApi* | [**getTickerRecordsByAddressAndTicker**](docs/NutLinkApi.md#gettickerrecordsbyaddressandticker) | **GET** /nutlink/{address}/tickers/{ticker} |
*NutLinkApi* | [**getTickerRecordsByTicker**](docs/NutLinkApi.md#gettickerrecordsbyticker) | **GET** /nutlink/tickers/{ticker} |


<a name="documentation-for-models"></a>
## Documentation for Models

- [io.blockfrost.dsk.kotlin.models.AccountAddressesAsset](docs/AccountAddressesAsset.md)
- [io.blockfrost.dsk.kotlin.models.AccountAddressesContent](docs/AccountAddressesContent.md)
- [io.blockfrost.dsk.kotlin.models.AccountContent](docs/AccountContent.md)
- [io.blockfrost.dsk.kotlin.models.AccountDelegationContent](docs/AccountDelegationContent.md)
- [io.blockfrost.dsk.kotlin.models.AccountHistoryContent](docs/AccountHistoryContent.md)
- [io.blockfrost.dsk.kotlin.models.AccountMirContent](docs/AccountMirContent.md)
- [io.blockfrost.dsk.kotlin.models.AccountRegistrationContent](docs/AccountRegistrationContent.md)
- [io.blockfrost.dsk.kotlin.models.AccountRewardContent](docs/AccountRewardContent.md)
- [io.blockfrost.dsk.kotlin.models.AccountWithdrawalContent](docs/AccountWithdrawalContent.md)
- [io.blockfrost.dsk.kotlin.models.AddressContent](docs/AddressContent.md)
- [io.blockfrost.dsk.kotlin.models.AddressContentTotal](docs/AddressContentTotal.md)
- [io.blockfrost.dsk.kotlin.models.AddressTransactionsContent](docs/AddressTransactionsContent.md)
- [io.blockfrost.dsk.kotlin.models.AddressUtxoContent](docs/AddressUtxoContent.md)
- [io.blockfrost.dsk.kotlin.models.Asset](docs/Asset.md)
- [io.blockfrost.dsk.kotlin.models.AssetAddress](docs/AssetAddress.md)
- [io.blockfrost.dsk.kotlin.models.AssetHistory](docs/AssetHistory.md)
- [io.blockfrost.dsk.kotlin.models.AssetMetadata](docs/AssetMetadata.md)
- [io.blockfrost.dsk.kotlin.models.AssetPolicy](docs/AssetPolicy.md)
- [io.blockfrost.dsk.kotlin.models.AssetTransaction](docs/AssetTransaction.md)
- [io.blockfrost.dsk.kotlin.models.Assets](docs/Assets.md)
- [io.blockfrost.dsk.kotlin.models.BlockContent](docs/BlockContent.md)
- [io.blockfrost.dsk.kotlin.models.EpochContent](docs/EpochContent.md)
- [io.blockfrost.dsk.kotlin.models.EpochParamContent](docs/EpochParamContent.md)
- [io.blockfrost.dsk.kotlin.models.EpochStakeContent](docs/EpochStakeContent.md)
- [io.blockfrost.dsk.kotlin.models.EpochStakePoolContent](docs/EpochStakePoolContent.md)
- [io.blockfrost.dsk.kotlin.models.GenesisContent](docs/GenesisContent.md)
- [io.blockfrost.dsk.kotlin.models.Metric](docs/Metric.md)
- [io.blockfrost.dsk.kotlin.models.MetricsEndpoint](docs/MetricsEndpoint.md)
- [io.blockfrost.dsk.kotlin.models.Network](docs/Network.md)
- [io.blockfrost.dsk.kotlin.models.NetworkStake](docs/NetworkStake.md)
- [io.blockfrost.dsk.kotlin.models.NetworkSupply](docs/NetworkSupply.md)
- [io.blockfrost.dsk.kotlin.models.NutlinkAddress](docs/NutlinkAddress.md)
- [io.blockfrost.dsk.kotlin.models.NutlinkAddressTicker](docs/NutlinkAddressTicker.md)
- [io.blockfrost.dsk.kotlin.models.NutlinkAddressTickers](docs/NutlinkAddressTickers.md)
- [io.blockfrost.dsk.kotlin.models.NutlinkTickersTicker](docs/NutlinkTickersTicker.md)
- [io.blockfrost.dsk.kotlin.models.Pool](docs/Pool.md)
- [io.blockfrost.dsk.kotlin.models.PoolDelegation](docs/PoolDelegation.md)
- [io.blockfrost.dsk.kotlin.models.PoolDelegator](docs/PoolDelegator.md)
- [io.blockfrost.dsk.kotlin.models.PoolHistory](docs/PoolHistory.md)
- [io.blockfrost.dsk.kotlin.models.PoolListRetire](docs/PoolListRetire.md)
- [io.blockfrost.dsk.kotlin.models.PoolMetadata](docs/PoolMetadata.md)
- [io.blockfrost.dsk.kotlin.models.PoolRelay](docs/PoolRelay.md)
- [io.blockfrost.dsk.kotlin.models.PoolUpdate](docs/PoolUpdate.md)
- [io.blockfrost.dsk.kotlin.models.Script](docs/Script.md)
- [io.blockfrost.dsk.kotlin.models.ScriptRedeemer](docs/ScriptRedeemer.md)
- [io.blockfrost.dsk.kotlin.models.Scripts](docs/Scripts.md)
- [io.blockfrost.dsk.kotlin.models.TxContent](docs/TxContent.md)
- [io.blockfrost.dsk.kotlin.models.TxContentDelegation](docs/TxContentDelegation.md)
- [io.blockfrost.dsk.kotlin.models.TxContentMetadata](docs/TxContentMetadata.md)
- [io.blockfrost.dsk.kotlin.models.TxContentMetadataCbor](docs/TxContentMetadataCbor.md)
- [io.blockfrost.dsk.kotlin.models.TxContentMir](docs/TxContentMir.md)
- [io.blockfrost.dsk.kotlin.models.TxContentOutputAmount](docs/TxContentOutputAmount.md)
- [io.blockfrost.dsk.kotlin.models.TxContentPoolCert](docs/TxContentPoolCert.md)
- [io.blockfrost.dsk.kotlin.models.TxContentPoolRetire](docs/TxContentPoolRetire.md)
- [io.blockfrost.dsk.kotlin.models.TxContentRedeemer](docs/TxContentRedeemer.md)
- [io.blockfrost.dsk.kotlin.models.TxContentStakeAddr](docs/TxContentStakeAddr.md)
- [io.blockfrost.dsk.kotlin.models.TxContentUtxo](docs/TxContentUtxo.md)
- [io.blockfrost.dsk.kotlin.models.TxContentUtxoAmount](docs/TxContentUtxoAmount.md)
- [io.blockfrost.dsk.kotlin.models.TxContentUtxoInputs](docs/TxContentUtxoInputs.md)
- [io.blockfrost.dsk.kotlin.models.TxContentUtxoOutputs](docs/TxContentUtxoOutputs.md)
- [io.blockfrost.dsk.kotlin.models.TxContentWithdrawal](docs/TxContentWithdrawal.md)
- [io.blockfrost.dsk.kotlin.models.TxMetadataLabel](docs/TxMetadataLabel.md)
- [io.blockfrost.dsk.kotlin.models.TxMetadataLabelCbor](docs/TxMetadataLabelCbor.md)
- [io.blockfrost.dsk.kotlin.models.TxMetadataLabelJson](docs/TxMetadataLabelJson.md)

<a name="documentation-for-authorization"></a>
## Documentation for Authorization

- **Type**: API key
- **API key parameter name**: project_id
- **Location**: HTTP header
