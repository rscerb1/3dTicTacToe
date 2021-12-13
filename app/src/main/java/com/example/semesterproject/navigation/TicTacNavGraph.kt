package com.example.semesterproject.navigation

import com.example.semesterproject.screens.highScore.HighScoreScreen
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.semesterproject.data.game.Game
import com.example.semesterproject.data.game.GameRepo
import com.example.semesterproject.screens.login.AccountView
import com.example.semesterproject.screens.SettingView
import com.example.semesterproject.screens.gameSelect.GameSelectView
import com.example.semesterproject.screens.gameSelect.GameSelectViewModel
import com.example.semesterproject.screens.login.LoginViewModel
import com.example.semesterproject.screens.mainBoard.ViewModels.Game3dView
import com.example.semesterproject.screens.mainBoard.load2dBoard
import com.example.semesterproject.screens.mainMenu.MainMenuView

@ExperimentalComposeApi
@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun TicTacNavGraph (navController: NavHostController = rememberNavController(), ){

    val gvm: GameSelectViewModel = viewModel()
    val loginVm: LoginViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Routes.Login.route
    )
    {
        composable(Routes.Login.route){
            AccountView(
                navController,
                signIn = {loginVm.signIn(it)},
                loginVm
            )
        }
        composable(Routes.MainMenu.route){
            MainMenuView(navController)
        }
        composable(Routes.HighScores.route){
            HighScoreScreen()
        }
        composable(Routes.SettingScreen.route){
            SettingView()
        }
        composable(Routes.GameSelect.route){
            gvm.setMainUser(loginVm.mainUser)
            GameSelectView(
                gvm.games,
                setOpp = {gvm.setOpp(it)},
                addGame = {gvm.addGame()},
                loginVm.mainUser
            )
        }
        composable(Routes.Game3d.route) {
            Game3dView()
        }
        //TODO-Add paths for game modes
    }
}
