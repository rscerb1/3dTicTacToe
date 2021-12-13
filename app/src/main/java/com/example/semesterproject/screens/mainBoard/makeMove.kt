package com.example.semesterproject.screens.mainBoard

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun MakeMove() {

    var text by rememberSaveable { mutableStateOf("") }
    var moveSelection: String = "0"

    Column() {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center

        ) {

            androidx.compose.material.TextField(
                value = text,
                onValueChange = { text = it },
                label= { Text("Enter move using  #Row#Col    ex: first square = 11") },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            Button(onClick = {

                moveSelection = text
                text = ""

                if (moveSelection == "11") {
//                    Log.d("value of text is 11: ", moveSelection)
                    updateBoardState[0] = moveSelection.toInt()
                }
                if (moveSelection =="12") {
//                    Log.d("value of text is 12: ", moveSelection)
                    updateBoardState[1] = moveSelection.toInt()

                }
                if (moveSelection =="13") {
//                    Log.d("value of text is 13: ", moveSelection)
                    updateBoardState[2] = moveSelection.toInt()

                }
                if (moveSelection =="21") {
//                    Log.d("value of text is 21: ", moveSelection)
                    updateBoardState[3] = moveSelection.toInt()

                }
                if (moveSelection =="22") {
//                    Log.d("value of text is 22: ", moveSelection)
                    updateBoardState[4] = moveSelection.toInt()

                }
                if (moveSelection =="23") {
//                    Log.d("value of text is 23: ", moveSelection)
                    updateBoardState[5] = moveSelection.toInt()
                }
                if (moveSelection =="31") {
//                    Log.d("value of text is 31: ", moveSelection)
                    updateBoardState[6] = moveSelection.toInt()
                }
                if (moveSelection =="32") {
//                    Log.d("value of text is 32: ", moveSelection)
                    updateBoardState[7] = moveSelection.toInt()

                }
                if (moveSelection =="33") {
//                    Log.d("value of text is 33: ", moveSelection)
                    updateBoardState[8] = moveSelection.toInt()

                }
            }) {
                Text("Confirm Move")
            }
        }
    }
}