package com.example.semesterproject

import Screens.TicTacNavGraph
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import org.intellij.lang.annotations.JdkConstants

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun MainScreen (){
    val nav = rememberNavController()
    Scaffold (
        topBar = {
            TopBar()
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