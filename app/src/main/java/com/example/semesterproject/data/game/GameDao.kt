package com.example.semesterproject.data.game

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase


@Dao
interface GameDao {
}

@Database(entities = [Game::class], version = 1,exportSchema = false)
    abstract class GameDatabase : RoomDatabase(){
        abstract fun gameDao() : GameDao
    }