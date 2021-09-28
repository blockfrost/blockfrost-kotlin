package org.openapitools.client.api

import org.openapitools.client.exception.APIException
import org.openapitools.client.models.Clock
import org.openapitools.client.models.Health

interface HealthService {
    @Throws(APIException::class)
    suspend fun getHealth(): Health?

    @Throws(APIException::class)
    suspend fun getCurrentBackendTime(): Clock?

    @Throws(APIException::class)
    suspend fun apiRoot(): String?
}