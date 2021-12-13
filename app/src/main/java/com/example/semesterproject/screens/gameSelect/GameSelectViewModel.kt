package com.example.semesterproject.screens.gameSelect

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.semesterproject.data.game.GameRepo
import com.example.semesterproject.network.DataFetcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameSelectViewModel(app:Application): AndroidViewModel(app) {

    // TODO: replace mainPlayer with whichever user is signed in

    var games by mutableStateOf(GameRepo.getGames())
    var mainUsername by mutableStateOf("")
    var opponent by mutableStateOf("")

    init {
        viewModelScope.launch {
            delay(1000)
            fetchGames()
        }
    }

    fun addGame() {
        CoroutineScope(IO).launch {
            games = try {
                DataFetcher().postGame(mainUsername, opponent)
                DataFetcher().fetchGames()
            } catch (er: Error){
                listOf()
            }
        }
    }

    fun setOpp(oppon: String){
        opponent = oppon
    }

    fun setMainUser(mainUser: String){
        mainUsername = mainUser
    }

    private suspend fun fetchGames() {
        games = DataFetcher().fetchGames()
        Log.i(TAG,"Called Coroutine")
    }

}