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
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import okio.IOException
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

    suspend fun postNewUser(username: String, password: String): Boolean {
        var status: Boolean = false
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

            client.newCall(request).enqueue(object: Callback{
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                }
                override fun onResponse(call: Call, response: Response) {
                    response.use {
                        if(response.body!!.string() == "1000"){
                            status = true
                        }
                    }
                }
            })
        }
        return status
    }

    suspend fun fetchGames(): List<Game> {
        var games: List<Game> = listOf()
        withContext(IO) {
            val request = Request.Builder()
                .url("http://69.250.96.168:5555/games")
                .get()
                .build()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {
                    response.use {
                        val rep = response.body?.string()
                        if (rep != null) {
                            val gson = Gson()
                            val listTypeToken = object : TypeToken<List<Game>>() {}
                            val listType = listTypeToken.type
                            games = gson.fromJson(rep, listType)
                        }
                    }
                }
            })
        }
        Log.i("fetchGames", games.toString())
        return games
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

    fun fetchUser(){}

}