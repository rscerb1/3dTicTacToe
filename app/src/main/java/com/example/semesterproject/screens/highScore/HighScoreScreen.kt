package com.example.semesterproject.screens.highScore

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HighScoreScreen() {
    val ScoreList: List<HighScore> = (1..50).map { i ->
            HighScore(i, "Player $i", i * 2, i + 2)
    }
    val _ScoreList =  ScoreList.sortedByDescending { it.Wins }
    Row (
        modifier = Modifier.fillMaxWidth().padding(5.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
       Column() {
          Text(text = "Rank") 
       } 
        Column() {
            Text(text = "Name")
        }
        Column() {
            Text(text = "Wins")
        }
    }
    LazyColumn(
        modifier = Modifier.padding(40.dp)
    ){
        itemsIndexed(_ScoreList){ index, HighScore ->
           ScoreRow(index = index, Score = HighScore)
        }
    }

}


