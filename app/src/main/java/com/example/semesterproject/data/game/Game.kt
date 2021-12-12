package com.example.semesterproject.data.game;

import androidx.room.Entity;

@Entity(primaryKeys = ["user1", "user2"], tableName = "GAME_DATA")
data class Game(
    val player0: String,
    val player1: String,
    val board: String,
    val turn: String,
    val status: String
)

private fun games(): List<Game> {
    return mutableListOf()
}

object GameRepo{
    fun getGames(): List<Game> = games()
}