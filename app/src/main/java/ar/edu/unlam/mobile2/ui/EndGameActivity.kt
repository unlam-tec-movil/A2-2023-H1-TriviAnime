package ar.edu.unlam.mobile2.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile2.ui.ui.theme.TriviAnime_Theme
import ar.edu.unlam.mobile2.ui.ui.theme.VioletLight


class EndGameActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = intent.extras
        val gamer: String? = bundle?.getString("gamer")
        val score: String? = bundle?.getString("score")

        setContent {
            Content(gamer!!, score!!)
        }
    }

    @Composable
    private fun Content(gamer: String, score: String) {
        TriviAnime_Theme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = VioletLight
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                )
                {
                    EndGame(gamer, score)
                }
            }
        }
    }

    @Composable
    fun EndGame(gamer: String, score: String) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .padding(horizontal = 12.dp, vertical = 12.dp)
                    .border(width = 4.dp, color = Color.Black),
                contentAlignment = Alignment.Center
            ) {
                Column() {
                    Text("Fin de la Partida")
                    Text("Jugador: $gamer")
                    Text("Puntaje: $score")
                }

            }
            Button(onClick = {
                nuevaPartida()
                finish()
            }) {
                Text(text = "Nueva Partida")
            }
            Button(onClick = {
                irAMenu()
                finish()
            }) {
                Text(text = "Menú Principal")
            }
        }
    }

    private fun nuevaPartida() {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }

    private fun irAMenu() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}