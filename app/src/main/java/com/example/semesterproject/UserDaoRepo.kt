package com.example.semesterproject

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.semesterproject.data.user.User
import com.example.semesterproject.data.user.UserDao
import com.example.semesterproject.data.user.UserDatabase

class UserDaoRepo(app:Application):UserRepository {
    private val database:UserDatabase
    private var _user:User = User("Placeholder",0,0,0)

    init{
        database = Room.databaseBuilder(
            app,
            UserDatabase::class.java,
            "user.db"
        ).fallbackToDestructiveMigration().build()
    }

    override suspend fun insertUser(user: User) {
        return database.userDao().insertUser(user)
        TODO("Not yet implemented")
    }

    override suspend fun getUser(user: User): LiveData<User> {
        return database.userDao().getUser(user)
        TODO("Not yet implemented")
    }

    override suspend fun getName(user: User): LiveData<String> {
        return database.userDao().getName(user)
        TODO("Not yet implemented")
    }


}