package com.example.semesterproject.data.user

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.semesterproject.data.game.Game

@Entity
data class User(
        @PrimaryKey
        val username: String,
        val wins: Int,
        val loses: Int,
        val ties: Int
        )

private fun users(): List<User> {
        return mutableListOf()
}

object UserRepo{
        fun getUsers(): List<User> = users()
}