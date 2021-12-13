package com.example.semesterproject.data.user

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(user: User)

    @Query("SELECT username FROM User LIMIT(1)")
    fun getName(): String

    @Query("SELECT * FROM User LIMIT(1)")
    fun getUser(): User
}
