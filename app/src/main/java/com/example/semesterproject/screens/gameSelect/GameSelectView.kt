package com.example.semesterproject.screens.gameSelect

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.semesterproject.data.game.Game

@ExperimentalFoundationApi
@Composable
fun GameSelectView(
    games: List<Game>,
    setOpp: (String) -> Unit,
    addGame: () -> Unit
) {
    val opponent = remember { mutableStateOf(TextFieldValue()) }
    
    Scaffold() { innerPadding ->
        LazyColumn(contentPadding = innerPadding){
            stickyHeader {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .background(color = Color.LightGray),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    TextField(
                        value = opponent.value,
                        onValueChange = { opponent.value = it },
                        placeholder = {Text("Enter Opponent")},
                        modifier = Modifier.width(300.dp)
                    )
                    Button(onClick = {
                        setOpp(opponent.value.text)
                        addGame()
                    }) {
                        Text(text = "Create Game")
                    }
                }
            }

            items(games) { game ->
                GameRow(game)
            }
        }
    }
}

@Composable
fun GameRow(game: Game){
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ){
        Button(
            onClick = {},
            modifier = Modifier
                .width(320.dp)
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray)
        ){
            Text("Game with: ${game.player1}")
        }
    }
}

