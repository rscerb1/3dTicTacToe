package Screens

import android.widget.TableLayout
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HighScoreScreen() {
    val ScoreList: List<HighSch>
    ScoreList = (0..10).map { i ->
            HighSch(i, "Player &i", i * 2, i + 2)
    }
    //LazyColumn()
}


data class HighSch(
    val Rank: Int,
    val Name: String,
    val Wins: Int,
    val AvgMov: Int
){}