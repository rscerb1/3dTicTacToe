package com.example.semesterproject.navigation

sealed class Routes(val route: String) {
    object MainMenu : Routes("MainMenu")
    object HighScores : Routes("HighScores")
    object SettingScreen : Routes("SettingScreen")
    object GameSelect : Routes("GameSelect")
    object Login: Routes("Login")
    object Board3d: Routes("Board3d")
    object Board2dTop: Routes("Board2dTop")
    object Board2dMiddle: Routes("2d Board Middle")
    object Board2dBottom: Routes("2d Board Bottom")


    //TODO-add routes for game modes
}