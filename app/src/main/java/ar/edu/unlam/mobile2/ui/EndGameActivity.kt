package ar.edu.unlam.mobile2.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.unlam.mobile2.ui.ui.theme.CyanLight
import ar.edu.unlam.mobile2.ui.ui.theme.Purple40
import ar.edu.unlam.mobile2.ui.ui.theme.Purple80
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
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(horizontal = 12.dp, vertical = 12.dp)
                    .background(Color.Black)
                    .border(width = 4.dp, color = Purple80),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextCustom(text = "Fin de la Partida", fontSize = 40.sp)
                    TextCustom(text = "Jugador: $gamer")
                    TextCustom(text = "Puntaje: $score")
                }

            }
            Button(
                onClick = {
                    nuevaPartida()
                    finish()
                },
                colors = ButtonDefaults.elevatedButtonColors(containerColor = CyanLight),
                shape = ButtonDefaults.elevatedShape,
                elevation = ButtonDefaults.elevatedButtonElevation(32.dp),
                border = null,
                modifier = Modifier
                    .width(180.dp)
                    .height(64.dp)
            ) {
                Text(
                    text = "Nueva Partida",
                    color = VioletLight,
                    fontSize = 20.sp,
                    fontFamily = latoFamily,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
            Button(
                onClick = {
                    irAMenu()
                    finish()
                },
                colors = ButtonDefaults.elevatedButtonColors(containerColor = CyanLight),
                shape = ButtonDefaults.elevatedShape,
                elevation = ButtonDefaults.elevatedButtonElevation(32.dp),
                border = null,
                modifier = Modifier
                    .width(180.dp)
                    .height(64.dp)
            ) {
                Text(
                    text = "Menú Principal",
                    color = VioletLight,
                    fontSize = 20.sp,
                    fontFamily = latoFamily,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
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