
package ga.awsapps.jetexplore.ui

import androidx.compose.Composable
import androidx.ui.graphics.Color
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Typography
import androidx.ui.material.lightColorPalette
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.text.font.ResourceFont
import androidx.ui.text.font.fontFamily
import androidx.ui.unit.sp
import ga.awsapps.jetexplore.R


@Composable
fun ExploreTheme(content: @Composable() () -> Unit) {
//    val colors = darkColorPalette(
//        primary = Color.White,
//        surface = Color(0xFF26282F),
//        onSurface = Color.White,
//        background = Color(0xFF26282F),
//        onBackground = Color.White
//    )

    val colors = lightColorPalette(
    primary = Color.Black,
    primaryVariant = Color(0xFF3700B3),
    secondary = Color(0xFF03DAC6),
    secondaryVariant = Color(0xFF018786),
    background = Color.White,
    surface = Color.White,
    error = Color(0xFFB00020),
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    onError = Color.White
    )

//    val colors = darkColorPalette(
//        primary = Color.Black,
//        surface = Color.White,
//        onSurface = Color.Black,
//        background = Color.White,
//        onBackground = Color.Black
//    )

    val appFontFamily = fontFamily(
        fonts = listOf(
            ResourceFont(R.font.circularstd_book),
            ResourceFont(R.font.circularstd_medium, FontWeight.W600),
            ResourceFont(R.font.circularstd_black, FontWeight.Bold),
            ResourceFont(R.font.circularstd_bold, FontWeight.W900)
        )
    )


    val typography = Typography(
        defaultFontFamily = appFontFamily,

        h1 = TextStyle(
            fontWeight = FontWeight.W100,
            fontSize = 96.sp
        ),
        h2 = TextStyle(
            fontWeight = FontWeight.W600,
            fontSize = 44.sp
        ),
        h3 = TextStyle(
            fontWeight = FontWeight.W400,
            fontSize = 14.sp
        ),

        h4 = TextStyle(
            fontWeight = FontWeight.W700,
            fontSize = 34.sp
        ),

        h5 = TextStyle(
            fontWeight = FontWeight.W700,
            fontSize = 24.sp
        ),

        h6 = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp
        ),
        subtitle1 = TextStyle(
            fontWeight = FontWeight.W300,
            fontSize = 14.sp
        ),
        subtitle2 = TextStyle(
            fontWeight = FontWeight.W400,
            fontSize = 14.sp
        ),
        body1 = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ),
        body2 = TextStyle(
            fontWeight = FontWeight.W200,
            fontSize = 14.sp
        ),
        button = TextStyle(
            fontWeight = FontWeight.W700,
            fontSize = 14.sp
        ),

        caption = TextStyle(
            fontWeight = FontWeight.W500,
            fontSize = 12.sp
        ),

        overline = TextStyle(
            fontWeight = FontWeight.W500,
            fontSize = 10.sp
        )
    )
    MaterialTheme(colors = colors, typography = typography, content = content)
}

