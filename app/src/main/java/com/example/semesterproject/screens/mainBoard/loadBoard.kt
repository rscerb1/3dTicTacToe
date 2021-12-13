package com.example.semesterproject.screens.mainBoard

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

var firstBoardState =
    listOf(
        1, 1, 1,
        0, 0, 0,
        2, 2, 2,

        0, 0, 0,
        1, 1, 1,
        0, 0, 0,

        2, 2, 2,
        0, 0, 0,
        1, 1, 1)

@ExperimentalComposeApi
@Composable
fun load3dBoard(navController: NavHostController = rememberNavController()) {

    var cordpair = CordPair(0f, 0f)
    var cordList = listOf(cordpair)

    draw3dGrid(cordList)

    Log.d("LIST IS", cordList.toString())

//    var boardUpdate = mutableListOf(firstBoardState)

    var cordReference = listOf<CordPair>(CordPair(190.0f ,234.0f), CordPair(365.0f, 234.0f), CordPair(540.0f, 234.0f), CordPair(315.0f, 334.0f), CordPair(490.0f, 334.0f), CordPair(665.0f, 334.0f), CordPair(440.0f, 434.0f), CordPair(615.0f, 434.0f), CordPair(790.0f, 434.0f), CordPair(190.0f, 734.0f), CordPair(365.0f, 734.0f), CordPair(540.0f, 734.0f), CordPair(315.0f, 834.0f), CordPair(490.0f, 834.0f), CordPair(665.0f, 834.0f), CordPair(440.0f, 934.0f), CordPair(615.0f, 934.0f), CordPair(790.0f, 934.0f), CordPair(190.0f, 1234.0f), CordPair(365.0f, 1234.0f), CordPair(540.0f, 1234.0f), CordPair(315.0f, 1334.0f), CordPair(490.0f, 1334.0f), CordPair(665.0f, 1334.0f), CordPair(440.0f, 1434.0f), CordPair(615.0f, 1434.0f), CordPair(790.0f, 1434.0f))


    for (i in 0..26) {
        if (firstBoardState[i] == 1) {

            Log.d("current I is ####", cordReference[i].toString())
            draw3dO(cordReference[i])
        }

        if (firstBoardState[i] == 2) {
            draw3dX(cordReference[i])
        }
    }

    }

@Composable
fun load2dBoardTop(navController: NavHostController = rememberNavController()) {
    var cordpair = CordPair(0f, 0f)
    var cordList = listOf(cordpair)

    draw2dGrid(cordList)

    var firstState= firstBoardState
    firstState = firstState.dropLast(18)
    Log.d("listy listy is: ", firstState.toString())

//    var firstBoardState =
//        listOf(
//            1, 1, 1,
//            0, 0, 0,
//            2, 2, 2,
//        )

    var cordReference = listOf<CordPair>(CordPair(230.0f, 451.14285f), CordPair(530.0f, 451.14285f), CordPair(830.0f, 451.14285f), CordPair(230.0f, 751.1428f), CordPair(530.0f, 751.1428f), CordPair(830.0f, 751.1428f), CordPair(230.0f, 1051.1428f), CordPair(530.0f, 1051.1428f), CordPair(830.0f, 1051.1428f))


    for (i in 0..8) {
        if (firstBoardState[i] == 1) {

            Log.d("current I is ####", cordReference[i].toString())
            draw2dO(cordReference[i])
        }

        if (firstBoardState[i] == 2) {
            draw2dX(cordReference[i])
        }
    }
}


//    draw2dGrid()
//
//
//    draw2dO()
//    draw2dX()
//    MakeMove()
