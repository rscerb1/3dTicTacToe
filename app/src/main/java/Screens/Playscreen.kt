package Screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.SpaceEvenly
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun Playscreen () {

    Row(modifier = Modifier.fillMaxHeight(),verticalAlignment = Alignment.CenterVertically ) {

        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, ) {
            Button(onClick = {}, modifier = Modifier.padding(16.dp).width(150.dp).height(80.dp)) {
                Text("Player\nvs.\nPlayer", textAlign = TextAlign.Center)
            }
            Button(onClick = {}, modifier = Modifier.padding(16.dp).width(150.dp).height(80.dp)) {
                Text("Player vs. AI \n (future feature)", textAlign = TextAlign.Center)
            }
        }
    }
}

