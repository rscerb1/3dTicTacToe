package com.example.semesterproject.navigation

sealed class Routes(val route: String) {
    object MainMenu : Routes("MainMenu")
    object HighScores : Routes("HighScores")
    object SettingScreen : Routes("SettingScreen")
    object GameSelect : Routes("GameSelect")
    object Login: Routes("Login")
    object Game3d: Routes("Game3d")
    object Game2d: Routes("Game2d")
}