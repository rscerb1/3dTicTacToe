package com.example.semesterproject.navigation

sealed class Routes(val route: String) {
    object MainMenu : Routes("MainMenu")
    object HighScores : Routes("HighScores")
    object SettingScreen : Routes("SettingScreen")
    object GameSelect : Routes("GameSelect")
    object Login: Routes("Login")


    //TODO-add routes for game modes
}