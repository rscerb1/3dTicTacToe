package Screens

sealed class Routes(val route: String) {
    object StartScreen : Routes("StartScreen")
    object PlayScreen : Routes("PlayScreen")
    object HighScores : Routes("HighScores")
    object SettingScreen : Routes("SettingScreen")
    //TODO-add routes for game modes
}