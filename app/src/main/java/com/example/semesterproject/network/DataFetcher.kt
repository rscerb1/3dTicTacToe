package com.example.semesterproject.network

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.example.semesterproject.data.game.Game
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import com.example.semesterproject.data.user.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.invoke
import kotlinx.coroutines.withContext
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.util.Objects.toString

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

    suspend fun postNewUser(username: String, password: String) {
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
                Log.i(ContentValues.TAG, "Loaded Data from API")
                gson.fromJson(json, listType)
            } else {
                listOf()
            }
        }
    }

    suspend fun fetchHighScores(): List<User> {
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
                Log.i(ContentValues.TAG, "Loaded Data from API")
                gson.fromJson(json, listType)
            } else {
                listOf()
            }
        }
    }


}