package org.openapitools.client.api

import org.openapitools.client.exception.APIException

interface MetricsService {
    @Throws(APIException::class)
    suspend fun getUsageMetrics(): List<Any?>?

    @Throws(APIException::class)
    suspend fun getEndpointUsageMetrics(): List<Any?>?
}