package com.example.semesterproject.data.user

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.semesterproject.network.DataFetcher
import kotlinx.coroutines.launch

class UserViewModel(app: Application): AndroidViewModel(app) {
    private val vmuser : MutableState<User> = mutableStateOf(User("PlaceHolder",0,0,0))
    val user : State<User> = vmuser

    private val subrepo : UserRepository = UserApi(UserDatabaseRepo(app), DataFetcher())

    init{
        viewModelScope.launch {
            vmuser.value = subrepo.getUser()
        }
    }
    fun insertUser(user:User){
        viewModelScope.launch {
            subrepo.insertUser(user)
            vmuser.value = subrepo.getUser()
        }
    }
}
