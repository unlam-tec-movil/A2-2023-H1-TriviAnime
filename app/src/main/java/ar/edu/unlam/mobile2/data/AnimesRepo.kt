package ar.edu.unlam.mobile2.data

interface AnimesRepo {

    suspend fun getNewAnime(): String
}