package com.example.semesterproject

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


    private val DarkColorPalette = darkColors(
        primary = DarkGreen,
        primaryVariant = GreenMain,
        secondary = Purple,
        background = Color.Gray
    )

    private val LightColorPalette = lightColors(
        primary = GreenMain,
        primaryVariant = DarkGreen,
        secondary = Purple,
        surface = Color.White,
        background = Color.White,
    )

@Composable
fun TicTacTheme(DarkTheme: Boolean = isSystemInDarkTheme(), cont: @Composable() () -> Unit){
    val Colors = if(DarkTheme) DarkColorPalette else LightColorPalette

    MaterialTheme(
        colors = Colors,
        typography = Typography(),
        shapes = Shapes(),
        content = cont
    )
}