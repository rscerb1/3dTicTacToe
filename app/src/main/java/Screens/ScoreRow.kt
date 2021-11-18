package Screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.unit.dp
import org.intellij.lang.annotations.JdkConstants

@Composable
fun ScoreRow (
    index:Int,
    Score:HighScore
        ){
    Row(
        modifier = Modifier.fillMaxWidth().padding(5.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
       Column(
       ) {
           Text(text = "${index+1}")
       }

       Column() {
           Text(text = "${Score.Name}")
       }
       Column() {
           Text(text = "${Score.Wins}")
       }
    }

}