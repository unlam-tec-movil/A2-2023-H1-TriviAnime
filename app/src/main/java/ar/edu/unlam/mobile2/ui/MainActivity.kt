package ar.edu.unlam.mobile2.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.ui.AppBarConfiguration
import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.databinding.ActivityMainBinding
import ar.edu.unlam.mobile2.ui.ui.theme.TriviAnime_Theme
import ar.edu.unlam.mobile2.ui.ui.theme.VioletLight
import ar.edu.unlam.mobile2.ui.ui.theme.WhiteBone
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : /*AppCompatActivity()*/ ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MainActivity", "onCreate")
        setContent {
            content()
        }
    }
    @Preview
    @Composable
    private fun content() {
        TriviAnime_Theme {
            Surface(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .background(VioletLight)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextCustom(
                        text = "TriviAnime",
                        color = WhiteBone,
                        fontSize = 64.sp,
                        fontFamily = tekoFamily,
                        fontWeight = FontWeight.Bold,
                        dropShadow = true
                    )
                    TextFieldCustom("Nombre", "Ingresa tu nombre")
                    Spacer(modifier = Modifier.height(36.dp))
                    ButtonCustom(
                        text = "Jugar",
                        onClick = {
                            irAJuego()
                            onStop()
                        })
                    Spacer(modifier = Modifier.height(36.dp))
                    ButtonCustom(
                        text = "Ajustes",
                        onClick = {
                            irAConfiguracion()
                            onStop()
                        })
                    Spacer(modifier = Modifier.height(36.dp))
                    ButtonCustom(
                        text = "Historial",
                        onClick = {
                            irAHistorial()
                            onStop()
                        })
                }
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "onStart")

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
    /*override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }*/
    private fun irAJuego() {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }
    private fun irAConfiguracion() {
        val intent = Intent(this, ConfigActivity::class.java)
        startActivity(intent)
    }
    private fun irAHistorial() {
        val intent = Intent(this, RecordActivity::class.java)
        startActivity(intent)
    }
}

