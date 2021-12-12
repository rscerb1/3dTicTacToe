package com.example.semesterproject.screens.highScore

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScoreRow (
    index:Int,
    Score: HighScore
        ){
    Row(
        modifier = Modifier.fillMaxWidth().padding(5.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
       Column(
       ) {
           Text(text = "${index+1}")
       }

       Column() {
           Text(text = "${Score.Name}")
       }
       Column() {
           Text(text = "${Score.Wins}")
       }
    }

}