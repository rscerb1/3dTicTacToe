package com.example.semesterproject.data.user

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(user: User)

    @Query("SELECT username FROM User LIMIT(1)")
    fun getName(): String

    @Query("SELECT * FROM User LIMIT(1)")
    fun getUser(): User
}

@Database(entities = [User::class], version = 1,exportSchema = false)
    abstract class UserDatabase : RoomDatabase(){
        abstract fun userDao() : UserDao
    }
