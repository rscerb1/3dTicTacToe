package com.example.semesterproject.screens.mainMenu

import com.example.semesterproject.navigation.Routes
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun MainMenuView (navController: NavHostController = rememberNavController()){

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
                onClick = { navController.navigate(Routes.GameSelect.route) })
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

