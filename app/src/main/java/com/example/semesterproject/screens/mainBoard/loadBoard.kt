package com.example.semesterproject.screens.mainBoard

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi

@ExperimentalComposeApi
@Composable
fun loadBoard() {


    var cordpair = CordPair(0f, 0f)
    var cordList = listOf(cordpair)

    draw3dGrid(cordList)

    Log.d("LIST IS", cordList.toString())

    var firstBoardState =
        arrayOf(1, 1, 1, 0, 0, 0, 2, 2, 2, 0, 0, 0, 1, 1, 1, 0, 0, 0, 2, 2, 2, 0, 0, 0, 1, 1, 1)
    var boardUpdate = mutableListOf(firstBoardState)



    for (i in 1..27) {
        if (firstBoardState[i] == 1) {

            Log.d("current I is ####", cordList[i].toString())
            draw3dO(cordList[i])
        }

        if (firstBoardState[i] == 2) {
            draw3dX(cordList[i])
        }
    }

    }



//    draw2dGrid()
//
//
//    draw2dO()
//    draw2dX()
//    MakeMove()
