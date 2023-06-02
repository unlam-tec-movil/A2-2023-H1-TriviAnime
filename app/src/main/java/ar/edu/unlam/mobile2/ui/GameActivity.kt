package ar.edu.unlam.mobile2.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.ui.AppBarConfiguration
import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.databinding.ActivityMainBinding
import ar.edu.unlam.mobile2.ui.ui.theme.HeartColor
import ar.edu.unlam.mobile2.ui.ui.theme.TriviAnime_Theme
import ar.edu.unlam.mobile2.ui.ui.theme.VioletDark
import ar.edu.unlam.mobile2.ui.ui.theme.VioletLight

class GameActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {
            content()
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
                Column(
                    modifier = Modifier.fillMaxSize()
                )
                {
                    TopBar()
                    Game()
                }//Column

            }//Surface
        }//Theme
    }

    @Composable
    private fun TopBar() {
        Row(
            modifier = Modifier
                .background(VioletDark)
                .fillMaxWidth()
                .height(36.dp)
                .wrapContentHeight()
                .padding(6.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_favorite_24),
                contentDescription = ""
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_favorite_24),
                contentDescription = ""
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_favorite_24),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.baseline_close_24),
                contentDescription = "",
                modifier = Modifier
                    .clickable(enabled = true, onClick = {
                        irAInicio()
                        onStop()
                    })
                    .fillMaxHeight()
            )
        }
    }

    @Composable
    fun Game() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            TextCustom(text = "¿Cual se emitió primero?", fontSize = 28.sp, border = true)

            ImageAnime(R.drawable.animeimage_cowboybebop, "Cowboy Bebop")
            ImageCustom(R.drawable.vs, 64.dp, 64.dp)
            ImageAnime(R.drawable.animeimage_kimetsunoyaiba, "Demon Slayer")

            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                ImageCustom(R.drawable.baseline_lightbulb_24, 64.dp, 64.dp)
                Box(
                    modifier = Modifier
                        .wrapContentSize()
                        .background(HeartColor, RoundedCornerShape(16.dp))
                        .border(2.dp, Color.Black, RoundedCornerShape(16.dp))
                        .padding(12.dp)
                ) {
                    TextCustom(
                        text = score.toString(),
                        border = true
                    )
                }
                ImageCustom(R.drawable.baseline_replay_24, 64.dp, 64.dp)
            }
        }
    }

    @Composable
    fun ImageCustom(imageId: Int, width: Dp, height: Dp) {
        Image(
            modifier = Modifier
                .width(width)
                .height(height),
            painter = painterResource(id = imageId),
            contentDescription = stringResource(id = imageId)
        )
    }

    @Composable
    fun ImageAnime(imageId: Int, name: String) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .padding(horizontal = 12.dp, vertical = 12.dp)
                .border(width = 4.dp, color = Color.Black),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = painterResource(id = imageId),
                contentDescription = stringResource(id = imageId),
                contentScale = ContentScale.Crop,
            )
            TextCustom(
                modifier = Modifier.align(Alignment.CenterEnd),
                text = name,
                border = true
            )
        }

    }

    private fun irAInicio() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}