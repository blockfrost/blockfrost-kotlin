package org.openapitools.client.retrofit

import org.openapitools.client.models.BlockContent
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface BlocksApi {
    @GET("blocks/{hash_or_number}/next")
    suspend fun blocksHashOrNumberNextGet(
        @Header("project_id") projectId: String?,
        @Path("hash_or_number") hashOrNumber: String?,
        @Query("count") count: Int?,
        @Query("page") page: Int?
    ): Response<List<BlockContent?>?>

}