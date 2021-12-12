package com.example.semesterproject.data.user

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(user: UserData)

    @Query("SELECT username FROM UserData LIMIT(1)")
    fun getName(): String

    @Query("SELECT * FROM UserData LIMIT(1)")
    fun getUser(): LiveData<UserData>
}