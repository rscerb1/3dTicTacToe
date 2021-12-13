package com.example.semesterproject.data.user

import com.example.semesterproject.network.DataFetcher

class UserApi(
    private val database: UserDatabaseRepo,
    private val userFetcher: DataFetcher
):UserRepository{
    override suspend fun insertUser(user: User) {
        database.insertUser(user)
    }

    override suspend fun getName(): String {
        return database.getName()
    }

    override suspend fun getUser(): User {
        if(database.getUser() == null){
            val user = userFetcher.fetchUser("")
        }
        return database.getUser()
    }

}