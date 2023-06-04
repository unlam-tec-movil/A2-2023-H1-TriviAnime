package ar.edu.unlam.mobile2.data

import retrofit2.Response
import retrofit2.http.GET

interface AnimeApi {

    @GET("/v4/anime/{id}/full")
    suspend fun getAnimes(): Response<List<AnimeApiModel>>
}