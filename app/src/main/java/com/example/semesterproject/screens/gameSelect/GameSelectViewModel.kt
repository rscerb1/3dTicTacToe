package com.example.semesterproject.screens.gameSelect

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.semesterproject.data.game.Game
import com.example.semesterproject.data.game.GameRepo
import com.example.semesterproject.network.DataFetcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameSelectViewModel: ViewModel() {
    var games by mutableStateOf(GameRepo.getGames())

    init {
        viewModelScope.launch {
            delay(1000)
            fetchGames()
        }
    }

    fun addGame(game: Game) {

    }

    private fun fetchGames() {
        CoroutineScope(IO).launch {
            games = games + DataFetcher().fetchGames()
        }
        Log.i(TAG,"Called Coroutine")
    }

}