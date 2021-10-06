package org.openapitools.client.retrofit

import org.openapitools.client.models.Network
import retrofit2.Response
import retrofit2.http.GET

interface CardanoNetworkApi {
    /**
     * Network information
     * Return detailed network information.
     * Responses:
     *  - 200: Return detailed network information.
     *  - 400: Bad request
     *  - 403: Authentication secret is missing or invalid
     *  - 404: Component not found
     *  - 429: Usage limit reached
     *  - 418: IP has been auto-banned for extensive sending of requests after usage limit has been reached
     *  - 500: Internal Server Error
     *
     * @return [Network]
     */
    @GET("network")
    suspend fun getNetwork(): Response<Network>

}
