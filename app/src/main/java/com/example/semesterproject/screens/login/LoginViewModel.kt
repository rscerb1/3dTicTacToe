package com.example.semesterproject.screens.login

import android.app.Application
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.semesterproject.data.user.User
import com.example.semesterproject.network.DataFetcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(): ViewModel() {

    fun addUser(newUser: String, password: String){
        CoroutineScope(Dispatchers.IO).launch {
            Log.e("addUSER:", newUser+password)
            DataFetcher().postNewUser(newUser, password)
        }
    }
}