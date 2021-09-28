package org.openapitools.client.api

import org.openapitools.client.exception.APIException
import org.openapitools.client.models.Network

interface NetworkService {
    @Throws(APIException::class)
    suspend fun getNetwork(): Network?
}