package org.openapitools.client.api

import org.openapitools.client.exception.APIException
import org.openapitools.client.models.Genesis

interface LedgerService {
    @Throws(APIException::class)
    suspend fun getGenesis(): Genesis?
}