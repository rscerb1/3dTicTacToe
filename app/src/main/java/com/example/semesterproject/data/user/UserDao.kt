package com.example.semesterproject.data.user

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun insertUser(user: User)

    @Query("SELECT username FROM User LIMIT(1)")
    suspend fun getName(user: User): List<User>

    @Query("SELECT * FROM User LIMIT(1)")
    suspend fun getUser(user: User): List<User>
}

@Database(entities = [User::class], version = 1,exportSchema = false)
    abstract class UserDatabase : RoomDatabase(){
        abstract fun userDao() : UserDao
    }