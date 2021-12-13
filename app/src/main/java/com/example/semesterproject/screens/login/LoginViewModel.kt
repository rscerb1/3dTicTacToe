package com.example.semesterproject.screens.login

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.semesterproject.network.DataFetcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(): ViewModel() {

    fun addUser(newUser: String, password: String): Boolean{
        var status: Boolean = false
        CoroutineScope(Dispatchers.IO).launch {
            if(DataFetcher().postNewUser(newUser, password)){
                status = true
            }
        }
        return status
    }
}