package ar.edu.unlam.mobile2.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile2.api.AnimeApi
import ar.edu.unlam.mobile2.api.AnimeResponse
import ar.edu.unlam.mobile2.api.AnimeService
import ar.edu.unlam.mobile2.data.GameData
import ar.edu.unlam.mobile2.domain.GameFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GameViewModel : ViewModel() {

    private val _gameData = MutableStateFlow(GameData())
    val gameData = _gameData.asStateFlow()

    init {
        getRandomAnime()
    }

    fun getRandomAnime() {
        viewModelScope.launch {
            try {
                val animeServiceApi1 = AnimeApi().getNewAnime().create(AnimeService::class.java)
                val rndInt = AnimeApi().generateRandomNumber()
                Log.i("RANDOM", "$rndInt")
                animeServiceApi1.getAnime(rndInt).enqueue(object : Callback<AnimeResponse> {
                    override fun onResponse(call: Call<AnimeResponse>, response: Response<AnimeResponse>) {
                        if (response.isSuccessful) {
                            response.body()?.let { animeResponse ->
                                val firstAnimeUrlString = animeResponse.data.images.jpg.imageUrl
                                val firstAnimeTitleString = animeResponse.data.title
                                retrieveSecondAnime(firstAnimeUrlString, firstAnimeTitleString)
                            }
                        }
                    }

                    override fun onFailure(call: Call<AnimeResponse>, t: Throwable) {
                        // Handle API error
                    }
                })
            } catch (e: Exception) {
                // Handle network or other errors
            }
        }
    }

    private fun retrieveSecondAnime(firstAnimeUrlString: String, firstAnimeTitleString: String) {
        viewModelScope.launch {
            try {
                val animeServiceApi2 = AnimeApi().getNewAnime().create(AnimeService::class.java)

                animeServiceApi2.getAnime(200).enqueue(object : Callback<AnimeResponse> {
                    override fun onResponse(call: Call<AnimeResponse>, response: Response<AnimeResponse>) {
                        if (response.isSuccessful) {
                            response.body()?.let { animeResponse ->
                                val secondAnimeUrlString = animeResponse.data.images.jpg.imageUrl
                                val secondAnimeTitleString = animeResponse.data.title
                                val gameData = GameFactory().GameGuessByTitle(
                                    firstAnimeUrlString,
                                    secondAnimeUrlString,
                                    firstAnimeTitleString,
                                    secondAnimeTitleString
                                )
                                _gameData.value = gameData
                            }
                        }
                    }

                    override fun onFailure(call: Call<AnimeResponse>, t: Throwable) {
                        // Handle API error
                    }
                })
            } catch (e: Exception) {
                // Handle network or other errors
            }
        }
    }
}
