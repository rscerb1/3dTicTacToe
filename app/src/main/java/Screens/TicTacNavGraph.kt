package Screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.semesterproject.TicTacView
import com.example.semesterproject.TicTacViewModel

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun TicTacNavGraph (
    navController: NavHostController = rememberNavController()
){
    val VM: TicTacViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = Routes.StartScreen.route
    ){
        composable(Routes.StartScreen.route){
            TicTacView(navController)
        }
        composable(Routes.PlayScreen.route){
            Playscreen()
        }
        composable(Routes.HighScores.route){
            HighScoreScreen()
        }
        composable(Routes.SettingScreen.route){
            SettingView()
        }
        //TODO-Add paths for game modes
    }
}