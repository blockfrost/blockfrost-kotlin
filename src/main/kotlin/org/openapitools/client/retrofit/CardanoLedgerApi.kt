package org.openapitools.client.retrofit

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody

import org.openapitools.client.models.GenesisContent
import org.openapitools.client.models.InlineResponse400
import org.openapitools.client.models.InlineResponse403
import org.openapitools.client.models.InlineResponse418
import org.openapitools.client.models.InlineResponse429
import org.openapitools.client.models.InlineResponse500

interface CardanoLedgerApi {
    /**
     * Blockchain genesis
     * Return the information about blockchain genesis.
     * Responses:
     *  - 200: Return the genesis parameters.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @return [GenesisContent]
     */
    @GET("genesis")
    suspend fun getGenesis(): Response<GenesisContent>

}
