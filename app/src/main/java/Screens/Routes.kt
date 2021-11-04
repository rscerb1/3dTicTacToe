package Screens

sealed class Routes(val route: String) {
    object MainScreen : Routes("MainScreen")
    object PlayScreen : Routes("PlayScreen")
    object HighScores : Routes("HighScores")
    object SettingScreen : Routes("SettingScreen")
}