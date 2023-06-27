package ar.edu.unlam.mobile2.data

data class GameData(

    var anime1imgUrl: String = "",
    var anime2imgUrl: String = "",
    var animeTitleWinner: String = "",
    var winnerTrigger: Int = 0
    //En caso de que sea falso el ganador es el primer anime, en caso de que sea verdadero el ganador es el segundo anime
)
