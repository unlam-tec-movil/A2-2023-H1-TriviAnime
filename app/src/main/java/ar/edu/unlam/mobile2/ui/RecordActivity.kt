package ar.edu.unlam.mobile2.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.data.Partida
import ar.edu.unlam.mobile2.data.PartidasRepositorio
import ar.edu.unlam.mobile2.ui.ui.theme.TriviAnime_Theme
import ar.edu.unlam.mobile2.ui.ui.theme.VioletLight
import ar.edu.unlam.mobile2.ui.ui.theme.VioletDark

class RecordActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Content()
        }
    }

    @Preview
    @Composable
    private fun Content() {
        TriviAnime_Theme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = VioletLight
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                )
                {
                    TopBar()
                    Spacer(Modifier.size(5.dp))
                    Ranking()
                    Spacer(Modifier.size(30.dp))
                }
            }
        }
    }

    @Composable
    private fun TopBar() {
        Row(
            modifier = Modifier
                .background(VioletDark)
                .fillMaxWidth()
                .height(36.dp)
                .wrapContentHeight()
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_close_24),
                contentDescription = "",
                modifier = Modifier.clickable(enabled = true, onClick = {
                    irAInicio()
                    onStop()
                })
            )
        }
    }

    @Composable
    private fun Ranking() {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .background(VioletDark),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = "Jugador", color = Color.White, fontSize = 30.sp)
            Text(text = "Puntaje", color = Color.White, fontSize = 30.sp)
        }
        Spacer(Modifier.size(10.dp))
        MostrarRanking(PartidasRepositorio.ordenar() as MutableList<Partida>)
    }

    @Composable
    private fun Texto(texto: String) {
        Text(texto, color = Color.Black, fontSize = 30.sp)
    }

    @Composable
    private fun MostrarRanking(datos: MutableList<Partida>) {
        LazyColumn (
            modifier = Modifier.fillMaxWidth(),
        ) {
            items(datos) { item -> ListItemRow(item) }
        }
    }

    @Composable
    private fun ListItemRow(item: Partida) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
        ){
            Texto(item.jugador)
            Texto(item.puntaje.toString())
        }
    }

    private fun irAInicio() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}

