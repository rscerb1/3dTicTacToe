package com.example.semesterproject.data.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
        @PrimaryKey val username: String,
        val wins: Int,
        val loses: Int,
        val ties: Int
        )
