package com.example.semesterproject.data.user

interface UserRepository {
    suspend fun insertUser(user: User)
    suspend fun getName():String
    suspend fun getUser(): User
}