package com.example.semesterproject.navigation

import androidx.activity.viewModels
import com.example.semesterproject.screens.highScore.HighScoreScreen
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.semesterproject.screens.SettingView
import com.example.semesterproject.screens.ticTak.TicTacView
import com.example.semesterproject.screens.gameSelect.GameSelectView
import com.example.semesterproject.screens.gameSelect.GameSelectViewModel

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun TicTacNavGraph (
    navController: NavHostController = rememberNavController(),
){
    val vm: GameSelectViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = Routes.StartScreen.route
    ){
        composable(Routes.StartScreen.route){
            TicTacView(navController)
        }
        composable(Routes.HighScores.route){
            HighScoreScreen()
        }
        composable(Routes.SettingScreen.route){
            SettingView()
        }
        composable(Routes.GameSelect.route){
            GameSelectView(
                vm.games,
                addGame = {vm.addGame(it)}
            )
        }
        //TODO-Add paths for game modes
    }
}
