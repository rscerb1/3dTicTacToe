package com.example.semesterproject.data.game

interface GameRepository {
    suspend fun getGame()
    suspend fun addGame()
    suspend fun deleteGame()
}