package com.example.semesterproject

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
import org.intellij.lang.annotations.JdkConstants

@ExperimentalFoundationApi
@Composable

fun TicTacView (){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center) {
        Text(text = "3D Tic Tac Toe", fontSize = 32.sp)
    }
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
                onClick = { /*TODO*/ })
            {
                Text(text = "Play")
            }
            Button(
                modifier = Modifier.padding(16.dp).width(120.dp).height(60.dp),
                onClick = { /*TODO*/ })
            {
                Text(text = "Highscores")
            }
            Button(
                modifier = Modifier.padding(16.dp).width(120.dp).height(60.dp),
                onClick = { /*TODO*/ })
            {
                Text(text = "Settings")
            }

        }
    }
}