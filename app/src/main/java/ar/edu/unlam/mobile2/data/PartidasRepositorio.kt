package ar.edu.unlam.mobile2.data

object PartidasRepositorio {
    val partidas = mutableListOf<Partida>()

    init {
        agregarPartida(Partida("Jugador 1", 10))
        agregarPartida(Partida("Jugador 2", 5))
        agregarPartida(Partida("Jugador 3", 25))
        agregarPartida(Partida("Jugador 4", 15))
        agregarPartida(Partida("Jugador 5", 20))
        agregarPartida(Partida("Jugador 6", 6))
        agregarPartida(Partida("Jugador 7", 5))
        agregarPartida(Partida("Jugador 8", 3))
        agregarPartida(Partida("Jugador 9", 1))
        agregarPartida(Partida("Jugador 10", 30))
        agregarPartida(Partida("Jugador 11", 50))
        agregarPartida(Partida("Jugador 12",22))
        agregarPartida(Partida("Jugador 13", 13))
        agregarPartida(Partida("Jugador 14", 15))
        agregarPartida(Partida("Jugador 15", 4))
    }

    fun agregarPartida(partida: Partida) {
        partidas.add(partida)
    }

    fun ordenar(): List<Partida> {
        return partidas.sortedByDescending { it.puntaje }
    }
}