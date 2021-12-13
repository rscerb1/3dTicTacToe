package com.example.semesterproject.screens.mainBoard

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

                }
                if (moveSelection =="12") {
//                    Log.d("value of text is 12: ", moveSelection)
                }
                if (moveSelection =="13") {
//                    Log.d("value of text is 13: ", moveSelection)
                }
                if (moveSelection =="21") {
//                    Log.d("value of text is 21: ", moveSelection)
                }
                if (moveSelection =="22") {
//                    Log.d("value of text is 22: ", moveSelection)
                }
                if (moveSelection =="23") {
//                    Log.d("value of text is 23: ", moveSelection)
                }
                if (moveSelection =="31") {
//                    Log.d("value of text is 31: ", moveSelection)
                }
                if (moveSelection =="32") {
//                    Log.d("value of text is 32: ", moveSelection)
                }
                if (moveSelection =="33") {
//                    Log.d("value of text is 33: ", moveSelection)
                }
            }) {
                Text("Confirm Move")
            }
        }
    }
}