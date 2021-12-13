package com.example.semesterproject.screens.mainBoard.ViewModels

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.semesterproject.screens.mainBoard.CordPair
import com.example.semesterproject.screens.mainBoard.CordRepo

class boardViewModel: ViewModel() {

    var cordPairs by mutableStateOf(CordRepo.getCordPairs())
    //val _cordList: State<List> = mutableListOf()

    val cordList = mutableListOf<CordPair>()
    var currentX: MutableState<Float> = mutableStateOf(0.0f)
    var currentY: MutableState<Float> = mutableStateOf(0.0f)

    //fun addCordPairs() {
//        cordList.add(CordPair( ))
//    }
    fun addPairs(cords: List <CordPair>) {
        cordPairs = cords
    }
}
