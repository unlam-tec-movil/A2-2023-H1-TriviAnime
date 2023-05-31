package ar.edu.unlam.mobile2.data

import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import javax.inject.Inject

class AnimesRestRepo @Inject constructor(builder: Builder) : AnimesRepo {
    var retrofit: Retrofit = builder
        .baseUrl("https://api.myanimelist.net/")
        .build()

    override suspend fun getNewAnime(): String {
        var animeApi = retrofit.create(AnimeApi::class.java)

        var call = animeApi.getAnimes()
        val animes = call.body()

        if (call.isSuccessful) {
            return animes?.get(0)?.id ?: ""
        }

        return "error on call"
    }
}