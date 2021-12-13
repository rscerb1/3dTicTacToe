package com.example.semesterproject.screens.mainBoard

import androidx.compose.runtime.Composable

@Composable
fun loadBoard() {
    var boardState = listOf(1,1,1,0,0,0,2,2,2,0,0,0,1,1,1,0,0,0,2,2,2,0,0,0,1,1,1)

    draw2dGrid()
    draw2dO()
    draw2dX()
    MakeMove()
}