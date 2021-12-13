package com.example.semesterproject.data.user

import android.app.Application
import androidx.room.Room

class UserDatabaseRepo(app:Application):UserRepository {
    private val database:UserDatabase
    private var user = User("PlaceHolder",0,0,0)

    init{
        database = Room.databaseBuilder(
            app,
            UserDatabase::class.java,
            "user.db"
        ).fallbackToDestructiveMigration().build()
    }
    override suspend fun insertUser(user: User) {
        TODO("Not yet implemented")
    }

    override suspend fun getName(): String {
        TODO("Not yet implemented")
    }

    override suspend fun getUser(): User {
        TODO("Not yet implemented")
    }

}