package ar.edu.unlam.mobile2.domain

import ar.edu.unlam.mobile2.api.AnimeResponse
import ar.edu.unlam.mobile2.data.GameData
import kotlin.random.Random

class GameFactory {

    fun GameGuessByTitle(anime1UrlImg: String, anime2UrlImg: String, anime1Title: String, anime2Title: String): GameData {

        val number = 0
        val boolean = getRandomBoolean()
        return if(boolean){
            GameData(anime1UrlImg, anime2UrlImg, anime1Title, 1)
        } else{
            GameData(anime1UrlImg, anime2UrlImg, anime1Title, 2)
        }

    }

    private fun getRandomBoolean():Boolean{
        return Random.nextBoolean()
    }

}
