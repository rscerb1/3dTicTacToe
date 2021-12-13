package com.example.semesterproject.navigation

sealed class Routes(val route: String) {
    object MainMenu : Routes("MainMenu")
    object HighScores : Routes("HighScores")
    object SettingScreen : Routes("SettingScreen")
    object GameSelect : Routes("GameSelect")
    object Login: Routes("Login")
    object MainBoard: Routes("Main Board")
    //TODO-add routes for game modes
}