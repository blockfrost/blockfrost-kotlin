# Blockfrost Kotlin SDK Example app

An Example app demonstrating usage of Blockfrost Kotlin SDK.

Usage:
```bash
BF_PROJECT_ID=your-project-id-here ./gradlew run
```

Output:
```
API root endpoint: ApiRoot(url=https://blockfrost.io/, version=0.10.0)
API health: Health(isHealthy=true)
API time: Clock(serverTime=1633615448772)
AddressContentTotal(address=addr1q8zu4smzyf2r2mfqjd6tc6vxf2p8rccdfk82ye3eut2udkw9etpkygj5x4kjpym5h35cvj5zw83s6nvw5fnrnck4cmvshkfm4y, receivedSum=[TxContentOutputAmount(unit=lovelace, quantity=2430412032)], sentSum=[TxContentOutputAmount(unit=lovelace, quantity=2430412032)], txCount=6)
```

If project_id is invalid:
```
Exception: io.blockfrost.sdk_kotlin.infrastructure.ForbiddenException: 
io.blockfrost.sdk_kotlin.infrastructure.ForbiddenException: 
        at io.blockfrost.sdk_kotlin.infrastructure.ApiClient.handleError(ApiClient.kt:50)
        at io.blockfrost.sdk_kotlin.infrastructure.ApiClient.handleResponse(ApiClient.kt:76)
        at io.blockfrost.sdk_kotlin.api.HealthApi$getApiRoot$2.invokeSuspend(HealthApi.kt:49)
        at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
        at kotlinx.coroutines.DispatchedTask.run(DispatchedTask.kt:106)
        at kotlinx.coroutines.scheduling.CoroutineScheduler.runSafely(CoroutineScheduler.kt:571)
        at kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.executeTask(CoroutineScheduler.kt:750)
        at kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.runWorker(CoroutineScheduler.kt:678)
        at kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.run(CoroutineScheduler.kt:665)
```