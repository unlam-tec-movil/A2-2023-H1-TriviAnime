package ar.edu.unlam.mobile2.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import ar.edu.unlam.mobile2.data.Data
import retrofit2.Response

interface AnimeService {
    @GET("anime/{id}")
    fun getAnime(@Path("id")id: Int): Call<AnimeResponse>
}