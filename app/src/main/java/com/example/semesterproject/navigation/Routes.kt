package com.example.semesterproject.navigation

sealed class Routes(val route: String) {
    object StartScreen : Routes("StartScreen")
    object HighScores : Routes("HighScores")
    object SettingScreen : Routes("SettingScreen")
    object GameSelect : Routes("GameSelect")
    //TODO-add routes for game modes
}