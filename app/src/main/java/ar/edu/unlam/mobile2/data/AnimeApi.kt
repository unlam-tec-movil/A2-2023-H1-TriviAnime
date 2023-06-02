package ar.edu.unlam.mobile2.data

import retrofit2.Response
import retrofit2.http.GET

interface AnimeApi {

    @GET("/v2/anime?q=one&limit=4'")
    suspend fun getAnimes(): Response<List<AnimeApiModel>>
}