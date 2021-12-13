package com.example.semesterproject

import androidx.lifecycle.LiveData
import com.example.semesterproject.data.user.User
import com.example.semesterproject.network.DataFetcher

class UserApi(
    private val dataBase:UserDaoRepo,
    private val dataFetcher : DataFetcher
):UserRepository {
    override suspend fun insertUser(user: User) {
        dataBase.insertUser(user)
        TODO("Not yet implemented")
    }

    override suspend fun getUser(user: User): List<User> {
        if(dataBase.getUser(user) == null){
            val user = dataFetcher.fetchUser()
        }
        TODO("Not yet implemented")
    }

    override suspend fun getName(user: User): List<String> {
        dataBase.getName(user)
        TODO("Not yet implemented")
    }

}