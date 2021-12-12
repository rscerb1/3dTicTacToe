package com.example.semesterproject

import com.example.semesterproject.navigation.TicTacNavGraph
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.rememberNavController

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun MainScreen (){
    val nav = rememberNavController()
    Scaffold (
        topBar = {
            // Text(text = "3D Tic Tac Toe")
            //TODO - Fix Title Bar
        }
            ){
        TicTacNavGraph(nav)
    }
}
@Composable
fun TopBar(){
    TopAppBar (
        title = { Text(text = "3D Tic Tac Toe")}
            )
}