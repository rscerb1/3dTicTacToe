package com.example.semesterproject

import androidx.lifecycle.LiveData
import com.example.semesterproject.data.user.User

interface UserRepository {
    suspend fun insertUser(user: User)
    suspend fun getUser(user: User) : List<User>
    suspend fun getName(user: User) : List<String>
}