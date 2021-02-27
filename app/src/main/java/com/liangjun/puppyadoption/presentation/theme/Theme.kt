package com.liangjun.puppyadoption.presentation.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightThemeColors = lightColors(
    primary = Blue600,
    primaryVariant = Blue400,
    onPrimary = Color.White,
    secondary = Teal300,
    secondaryVariant = Teal500,
    onSecondary = Color.White,
    background = Gray1,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Black2
)
private val DarkThemeColors = darkColors(
    primary = Blue800,
    primaryVariant = Color.White,
    onPrimary = Color.White,
    secondary = Black2,
    onSecondary = Color.White,
    background = Black3,
    onBackground = Color.White,
    surface = Black2,
    onSurface = Color.White
)

@Composable
fun AppTheme(
    darkTheme: Boolean,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) DarkThemeColors else LightThemeColors
    ) {
        content()
    }
}