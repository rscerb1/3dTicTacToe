package com.example.semesterproject.navigation

import com.example.semesterproject.screens.highScore.HighScoreScreen
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.semesterproject.screens.login.AccountView
import com.example.semesterproject.screens.SettingView
import com.example.semesterproject.screens.gameSelect.GameSelectView
import com.example.semesterproject.screens.gameSelect.GameSelectViewModel
import com.example.semesterproject.screens.login.LoginViewModel
import com.example.semesterproject.screens.mainBoard.load2dBoardBottom
import com.example.semesterproject.screens.mainBoard.load2dBoardMiddle
import com.example.semesterproject.screens.mainBoard.load2dBoardTop
import com.example.semesterproject.screens.mainBoard.load3dBoard
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
                navController,
                gvm.games,
                setOpp = {gvm.setOpp(it)},
                addGame = {gvm.addGame()},
                loginVm.mainUser
            )
        }
        composable(Routes.Board3d.route) {
            load3dBoard(navController)
        }
        composable(Routes.Board2dTop.route) {
            load2dBoardTop()
        }
        composable(Routes.Board2dMiddle.route) {
            load2dBoardMiddle()
        }
        composable(Routes.Board2dBottom.route) {
            load2dBoardBottom()
        }

        //TODO-Add paths for game modes
    }
}
