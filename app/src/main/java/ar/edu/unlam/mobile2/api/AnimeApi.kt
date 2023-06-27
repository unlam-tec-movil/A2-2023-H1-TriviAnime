package ar.edu.unlam.mobile2.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.random.Random

class AnimeApi{

    private val BASE_URL = "https://api.jikan.moe/v4/"
    private val TAG = "CHECK_RESPONSE"

    fun getNewAnime(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun generateRandomNumber(): Int {
        val random = Random.nextInt(1000 - 1 + 1) + 1
        return random
    }
}

// todo: HACER FUNCIONALIDAD DEL JUEGO, AUNQUE SEA PARA QUE REINICIE LAS IMAGENES.

