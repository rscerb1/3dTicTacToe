package com.example.semesterproject.screens.mainBoard.ViewModels

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.semesterproject.screens.mainBoard.load3dBoard

@ExperimentalComposeApi
@Composable
fun Game3dView(){
    Column (
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            ){
        load3dBoard()
    }
}

@ExperimentalComposeApi
@Preview
@Composable
fun Game3dViewPre(){
    Game3dView()
}