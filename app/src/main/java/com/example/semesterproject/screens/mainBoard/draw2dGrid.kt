package com.example.semesterproject.screens.mainBoard

import android.util.Log
import androidx.compose.animation.EnterExitState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.material.Button

@Composable
fun draw2dGrid(cordList: List<CordPair>) {

    var cordpair = CordPair(0f, 0f)
    var cordList = listOf(cordpair)

    Canvas(modifier = Modifier.fillMaxSize()) {
        val canvasSize = size
        val canvasWidth = size.width
        val canvasHeight = size.height

        drawLine(
            color = Color.Black,
            start = Offset(x = canvasWidth - 100F, y = canvasHeight - 400F),
            end = Offset(x = canvasWidth - 1000f, y = canvasHeight - 400F),
            strokeWidth = 10F
        )
        drawLine(
            color = Color.Black,
            start = Offset(x = canvasWidth - 1000F, y = canvasHeight - 400F),
            end = Offset(x = canvasWidth - 1000f, y = canvasHeight - 1300F),
            strokeWidth = 10F
        )
        drawLine(
            color = Color.Black,
            start = Offset(x = canvasWidth - 100F, y = canvasHeight - 400F),
            end = Offset(x = canvasWidth - 100f, y = canvasHeight - 1300F),
            strokeWidth = 10F
        )
        drawLine(
            color = Color.Black,
            start = Offset(x = canvasWidth - 100F, y = canvasHeight - 1300F),
            end = Offset(x = canvasWidth - 1000f, y = canvasHeight - 1300F),
            strokeWidth = 10F
        )
        drawLine(
            color = Color.Black,
            start = Offset(
                x = canvasWidth - 100F,
                y = (canvasHeight - 400 - canvasHeight / 5.6).toFloat()
            ),
            end = Offset(
                x = canvasWidth - 1000f,
                y = (canvasHeight - 400 - canvasHeight /5.6).toFloat()
            ),
            strokeWidth = 10F
        )
        drawLine(
            color = Color.Black,
            start = Offset(
                x = canvasWidth - 100F,
                y = (canvasHeight - 400 - canvasHeight / 2.8).toFloat()
            ),
            end = Offset(
                x = canvasWidth - 1000f,
                y = (canvasHeight - 400 - canvasHeight / 2.8).toFloat()
            ),
            strokeWidth = 10F
        )
        drawLine(
            color = Color.Black,
            start = Offset(
                x = (canvasWidth - 100F - canvasWidth / 1.8).toFloat(),
                y = canvasHeight - 1300f
            ),
            end = Offset(
                x = (canvasWidth - 100f - canvasWidth / 1.8).toFloat(),
                y = canvasHeight - 400f
            ),
            strokeWidth = 10F
        )
        drawLine(
            color = Color.Black,
            start = Offset(
                x = (canvasWidth - 100F - canvasWidth / 3.6).toFloat(),
                y = canvasHeight - 1300f
            ),
            end = Offset(
                x = (canvasWidth - 100f - canvasWidth / 3.6).toFloat(),
                y = canvasHeight - 400f
            ),
            strokeWidth = 10F
        )

        //  Creates grid reference points for the center of each grid square
        //  and stores them into a list
        var startingX = (((canvasWidth - 1000) + (canvasWidth-100-canvasWidth/1.8))/2).toFloat()
        var startingY = (((canvasHeight - 1300) + (canvasHeight - 400 - canvasHeight/2.8))/2).toFloat()

        var currentX = startingX
        var currentY = startingY


        cordpair.xcord = currentX
        cordpair.ycord = currentY
        cordList = cordList + listOf(CordPair(cordpair.xcord, cordpair.ycord))

        drawCircle(
            color = Color.Unspecified,
            center = Offset(
                x = (((canvasWidth - 1000) + (canvasWidth-100-canvasWidth/1.8))/2).toFloat(),
                y = (((canvasHeight - 1300) + (canvasHeight - 400 - canvasHeight/2.8))/2).toFloat()),
            radius = 10f
        )

        for (i in 1..8) {

//            Log.d(" TOP  x-Value ", "$currentX")
//            Log.d(" TOP  y-Value ", "$currentY")

            if (i % 3 == 0) {
                currentX -= 600f
                currentY += 300f
            } else {
                currentX += 300f
            }
            drawCircle(
                color = Color.Unspecified,
                center = Offset(x = currentX, y = currentY),
                radius = 10f
            )

            cordpair.xcord = currentX
            cordpair.ycord = currentY
            cordList = cordList + listOf(CordPair(cordpair.xcord, cordpair.ycord))
        }
        cordList = cordList.drop(1)
        Log.d("Tag", cordList.toString())
        Log.d("# of ele in cordpair",  cordList.size.toString())


    }
}

// shifts right by 300 pixels and down by 300 pixels
@Composable
fun draw2dO(cordPair: CordPair) {
    Canvas(modifier = Modifier.fillMaxSize()) {

        val canvasSize = size
        val canvasWidth = size.width
        val canvasHeight = size.height
        var startingX = (((canvasWidth - 1000) + (canvasWidth-100-canvasWidth/1.8))/2).toFloat()
        var startingY = (((canvasHeight - 1300) + (canvasHeight - 400 - canvasHeight/2.8))/2).toFloat()

        drawCircle(
            color = Color.Black,
            center = Offset(cordPair.xcord, cordPair.ycord),
            radius = 90f,
            style = Stroke(width = size.width * 0.01f)
        )
    }
}


// Will use selectedCord to draw 2 lines from
@Composable
fun draw2dX(cordPair: CordPair) {
    Canvas(modifier = Modifier.fillMaxSize()) {

        val canvasSize = size
        val canvasWidth = size.width
        val canvasHeight = size.height
        var startingX = (((canvasWidth - 1000) + (canvasWidth-100-canvasWidth/1.8))/2).toFloat()
        var startingY = (((canvasHeight - 1300) + (canvasHeight - 400 - canvasHeight/2.8))/2).toFloat()

        // If the reference point is TOP:[1,1] (230,571.8929) finalcordList(1)
        // then the first line is the reference point modified by
        // start: referenceX+90f, referenceY+90f
        // end: referenceX-90f, referenceY-90f
        drawLine(
            color = Color.Black,
            start = Offset(x = cordPair.xcord + 90f, cordPair.ycord + 90f),
            end = Offset(x = cordPair.xcord - 90f, cordPair.ycord - 90f),
            strokeWidth = 10F
        )

        //If the reference point is TOP:[1,1] (190,381)
        // then the second line is the reference point modified by
        // Start: referenceX + 90, referenceY-90
        // End: referenceX - 90, referenceY+90
        drawLine(
            color = Color.Black,
            start = Offset(x = cordPair.xcord + 90f, cordPair.ycord - 90f),
            end = Offset(x = cordPair.xcord - 90f, cordPair.ycord + 90f),
            strokeWidth = 10F
        )
    }
}
