package ar.edu.unlam.mobile2.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.ui.ui.theme.CyanLight
import ar.edu.unlam.mobile2.ui.ui.theme.VioletLight
import ar.edu.unlam.mobile2.ui.ui.theme.WhiteBone

val latoFamily = FontFamily(
    Font(R.font.latothin, FontWeight.Thin),
    Font(R.font.latolight, FontWeight.Light),
    Font(R.font.latoregular, FontWeight.Normal),
    Font(R.font.latobold, FontWeight.Bold),
    Font(R.font.latoblack, FontWeight.Black)
)

val tekoFamily = FontFamily(
    Font(R.font.tekolight, FontWeight.Light),
    Font(R.font.tekoregular, FontWeight.Normal),
    Font(R.font.tekomedium, FontWeight.Medium),
    Font(R.font.tekobold, FontWeight.Bold)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldCustom(
    label: String,
    placeholder: String
) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(text = label, fontFamily = latoFamily, fontWeight = FontWeight.Normal) },
        placeholder = {
            Text(
                text = placeholder,
                fontFamily = latoFamily,
                fontWeight = FontWeight.Light
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.baseline_person_24),
                contentDescription = "",
                tint = WhiteBone,
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = WhiteBone,
            unfocusedBorderColor = WhiteBone,
            unfocusedLabelColor = WhiteBone,
            focusedBorderColor = WhiteBone,
            focusedLabelColor = WhiteBone,
            cursorColor = WhiteBone,
            focusedLeadingIconColor = WhiteBone,
            placeholderColor = WhiteBone,
            disabledPlaceholderColor = WhiteBone
        ),
        singleLine = true,
        modifier = Modifier
            .width(240.dp)
            .height(64.dp)
    )
}

@Composable
fun ButtonCustom(
    text: String,
    onClick: () -> Unit,
    width: Dp = 180.dp,
    height: Dp = 64.dp
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.elevatedButtonColors(containerColor = CyanLight),
        shape = ButtonDefaults.elevatedShape,
        elevation = ButtonDefaults.elevatedButtonElevation(32.dp),
        border = null,
        modifier = Modifier
            .width(width)
            .height(height)
    ) {
        Text(
            text,
            color = VioletLight,
            fontSize = 24.sp,
            fontFamily = latoFamily,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun TextWithBorder() {

}

@Composable
fun TextCustom(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = WhiteBone,
    fontSize: TextUnit = 32.sp,
    fontFamily: FontFamily = latoFamily,
    fontWeight: FontWeight = FontWeight.Normal,
    dropShadow: Boolean = false,

    border: Boolean = false,
) {
    Box() {
        if (border) {
            Text(
                modifier = modifier
                    .offset(x = 1.dp, y = 0.dp),
                color = Color.Black,
                fontSize = fontSize,
                text = text,
                fontFamily = fontFamily,
                fontWeight = fontWeight,
                //maxLines = maxLines
            )
            Text(
                modifier = modifier
                    .offset(x = 0.dp, y = 1.dp),
                color = Color.Black,
                fontSize = fontSize,
                text = text,
                fontFamily = fontFamily,
                fontWeight = fontWeight,
                //maxLines = maxLines
            )
            Text(
                modifier = modifier
                    .offset(x = -1.dp, y = 0.dp),
                color = Color.Black,
                fontSize = fontSize,
                text = text,
                fontFamily = fontFamily,
                fontWeight = fontWeight,
                //maxLines = maxLines
            )
            Text(
                modifier = modifier
                    .offset(x = 0.dp, y = -1.dp),
                color = Color.Black,
                fontSize = fontSize,
                text = text,
                fontFamily = fontFamily,
                fontWeight = fontWeight,
                //maxLines = maxLines
            )
        }
        if (dropShadow) {
            Text(
                modifier = modifier
                    .alpha(alpha = 0.25f)
                    .offset(x = 2.dp, y = 1.dp)
                    .blur(radius = 2.dp),
                color = Color.Black,
                fontSize = fontSize,
                text = text,
                fontFamily = fontFamily,
                fontWeight = fontWeight,
                //maxLines = maxLines
            )
        }
        Text(
            modifier = modifier,
            text = text,
            color = color,
            fontSize = fontSize,
            fontFamily = fontFamily,
            fontWeight = fontWeight,
            //maxLines = maxLines
        )
    }
}
