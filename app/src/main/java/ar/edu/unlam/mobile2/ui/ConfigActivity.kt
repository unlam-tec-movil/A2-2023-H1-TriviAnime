package ar.edu.unlam.mobile2.ui

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.ui.ui.theme.VioletLight
import ar.edu.unlam.mobile2.ui.ui.theme.CyanLight
import ar.edu.unlam.mobile2.ui.ui.theme.TriviAnime_Theme
import ar.edu.unlam.mobile2.ui.ui.theme.WhiteBone

class ConfigActivity : ComponentActivity() {

    private var sonidoDeFondo: MediaPlayer? = null
    private var musicPlaying: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = VioletLight
            ) {
                content()
            }
        }
    }

    @Preview
    @Composable
    private fun content() {
        TriviAnime_Theme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = VioletLight
            ) {
                Row {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 50.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center

                    ) {
                        difficultySelector()
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 80.dp, start = 40.dp, end = 40.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            soundBar()
                            musicBar()
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 80.dp, start = 40.dp, end = 40.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        )
                        {
                            buttonCustom(text = "Guardar", onClick = { buttonSaveOnClick() })
                            buttonCustom(text = "Cancelar", onClick = { buttonCancelOnClick() })
                        }
                    }
                }
            }
        }//Theme
    }

    @Composable
    fun buttonCustom(text: String, onClick: () -> Unit) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(containerColor = CyanLight),
        ) {
            Text(text)
        }
    }

    fun buttonSaveOnClick() {
        // Deberia llevar la data de la config
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }

    fun buttonCancelOnClick() {
        // Deberia llevar la data de la config
        finish()
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun difficultySelector() {
        var isExpanded by remember {
            mutableStateOf(false)
        }
        var difficulty by remember {
            mutableStateOf("Normal")
        }

        ExposedDropdownMenuBox(expanded = isExpanded, onExpandedChange = { isExpanded = it })
        {
            TextField(
                value = difficulty,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(containerColor = WhiteBone),
                modifier = Modifier.menuAnchor(),
                label = { Text(text = "Difficulty") },

                )
            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }
            )
            {
                DropdownMenuItem(
                    text = { Text("Normal") },
                    onClick = {
                        difficulty = "Normal"
                        isExpanded = false
                    })
                DropdownMenuItem(
                    text = { Text("Hardcore") },
                    onClick = {
                        difficulty = "Hardcore"
                        isExpanded = false
                    })
            }
        }
    }

    @Composable
    fun soundBar() {
        val checkedState = remember { mutableStateOf(true) }
        Column(
            modifier = Modifier
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Sonido")
            Switch(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it },
                colors = SwitchDefaults.colors(Color.Green)
            )
        }
    }

    @Composable
    fun musicBar() {
        val checkedState = remember { mutableStateOf(true) }
        Column(
            modifier = Modifier
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Música")


            Switch(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it },
                colors = SwitchDefaults.colors(Color.Green)
            )
        }
    }

    fun playSound() {
        sonidoDeFondo = MediaPlayer.create(this, R.raw.maintheme)
        sonidoDeFondo?.setOnPreparedListener {
            sonidoDeFondo?.start()
            musicPlaying = true
        }
    }

    fun pauseSound() {
        sonidoDeFondo!!.stop()
    }

    fun resumeSound() {
        sonidoDeFondo!!.start()
    }


}

