package com.example.semesterproject.screens.gameSelect

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.semesterproject.data.game.Game

@Composable
fun GameSelectView(
    games: List<Game>,
    addGame: (Game) -> Unit
) {

    Scaffold(floatingActionButton = { FloatingActionButton(onClick = { }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null )
            } }) { innerPadding ->
        LazyColumn(contentPadding = innerPadding){
            items(games) { game ->
                GameCard(game)
            }
        }
    }
}

@Composable
fun GameCard(game: Game){
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp)
    ){
        Text("Game with: ${game.player1}")
    }
}


@Preview(showBackground = true)
@Composable
fun PreGameCard(){
    val game = remember {
        Game("a","Bob","a","a","a")
    }
    GameCard(game)
}