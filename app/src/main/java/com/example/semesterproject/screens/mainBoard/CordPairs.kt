package com.example.semesterproject.screens.mainBoard

data class CordPair(

    var xcord: Float,
    var ycord: Float


)

private fun cordPairs(): List<CordPair> {
    return mutableListOf()
}
object cordRepo {

    fun getcordPairs(): List<CordPair> = cordPairs()
}