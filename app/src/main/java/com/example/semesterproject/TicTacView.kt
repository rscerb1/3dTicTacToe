package com.example.semesterproject

import Screens.Routes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.intellij.lang.annotations.JdkConstants

@ExperimentalFoundationApi
@Composable

fun TicTacView (
    navController: NavHostController = rememberNavController()
){

    Row(
        modifier = Modifier.fillMaxHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                modifier = Modifier.padding(16.dp).width(120.dp).height(60.dp),
                onClick = { navController.navigate((Routes.PlayScreen.route)) })
            {
                Text(text = "Play")
            }
            Button(
                modifier = Modifier.padding(16.dp).width(120.dp).height(60.dp),
                onClick = { navController.navigate(Routes.HighScores.route) })
            {
                Text(text = "Highscores")
            }
            Button(
                modifier = Modifier.padding(16.dp).width(120.dp).height(60.dp),
                onClick = { navController.navigate(Routes.SettingScreen.route) })
            {
                Text(text = "Settings")
            }

        }
    }
}