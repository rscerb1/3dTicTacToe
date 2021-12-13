package com.example.semesterproject.network

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.example.semesterproject.data.game.Game
import android.util.Log
import com.example.semesterproject.data.user.User
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody

data class NewGameData(
    val player0: String,
    val player1: String
)

data class NewUserData(
    val username: String,
    val password: String
)

class DataFetcher() {

    private val client = OkHttpClient()

    suspend fun postGame(player0: String, player1: String) {
        return withContext(IO) {
            val gameData = NewGameData(player0, player1)
            val gson = Gson()
            val jsonBody = gson.toJson(gameData)
            val json = jsonBody.toRequestBody("application/json".toMediaTypeOrNull())
            val request = Request.Builder()
                .url("http://69.250.96.168:5555/games")
                .post(json)
                .build()
            client.newCall(request).execute()
        }
    }

    suspend fun postNewUser(username: String, password: String) {
        withContext(IO) {
            val userData = NewUserData(username, password)
            val gson = Gson()
            val jsonBody = gson.toJson(userData)
            Log.e("postNewUser-json", jsonBody)
            val json = jsonBody.toRequestBody("application/json".toMediaTypeOrNull())

            val request = Request.Builder()
                .url("http://69.250.96.168:5555/players")
                .post(json)
                .build()

            client.newCall(request).execute()
        }
    }

    suspend fun fetchGames(): List<Game> {
        return withContext(IO) {
            val request = Request.Builder()
                .url("http://69.250.96.168:5555/games")
                .get()
                .build()

            val response = client.newCall(request).execute()
            val json = response.body?.string()
            if (json != null) {
                val gson = Gson()
                val listTypeToken = object : TypeToken<List<Game>>() {}
                val listType = listTypeToken.type
                gson.fromJson(json, listType)
            } else {
                listOf()
            }
        }
    }

    suspend fun fetchUsers(): List<User> {
        return withContext(IO) {
            val request = Request.Builder()
                .url("http://69.250.96.168:5555/users")
                .get()
                .build()
            val response = client.newCall(request).execute()
            val json = response.body?.string()
            if (json != null) {
                val gson = Gson()
                val listTypeToken = object : TypeToken<List<User>>() {}
                val listType = listTypeToken.type
                gson.fromJson(json, listType)
            } else {
                listOf()
            }
        }
    }

    suspend fun fetchUser(username: String): User {
        return withContext(IO) {
            val request = Request.Builder()
                .url("http://69.250.96.168:5555/users")
                .get()
                .build()
            val response = client.newCall(request).execute()
            val json = response.body?.string()
            if (json != null) {
                val gson = Gson()
                val typeToken = object : TypeToken<User>() {}
                val type = typeToken.type
                gson.fromJson(json, type)
            } else {
                User("", 0, 0, 0)
            }
        }
    }

}