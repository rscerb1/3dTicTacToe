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
        startDestination = Routes.MainScreen.route
    ){
        composable(Routes.MainScreen.route){
            TicTacView()
        }
        composable(Routes.PlayScreen.route){

        }
    }
}