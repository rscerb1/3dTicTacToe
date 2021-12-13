package com.example.semesterproject.screens.login

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.semesterproject.data.game.GameRepo
import com.example.semesterproject.data.user.UserRepo
import com.example.semesterproject.network.DataFetcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(): ViewModel() {

    var users by mutableStateOf(UserRepo.getUsers())

    var mainUser by mutableStateOf("")

    fun signIn(username: String){
        mainUser = username
    }

    fun addUser(newUser: String, password: String){
        CoroutineScope(Dispatchers.IO).launch {
            Log.i("addUserCall", "calling dataFetcher with user=${newUser} pass=${password}")
            DataFetcher().postNewUser(newUser, password)
        }
    }
}
