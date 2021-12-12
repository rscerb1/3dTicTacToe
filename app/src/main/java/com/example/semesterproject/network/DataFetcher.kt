package com.example.semesterproject.network

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.example.semesterproject.data.game.Game
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import com.example.semesterproject.data.user.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.util.Objects.toString

data class newGameData(
    val player0: String,
    val player1: String
)

class DataFetcher() {

    private val client = OkHttpClient()


    fun postGame(player0: String, player1: String) {
        val gameData = newGameData(player0, player1)
        val gson = Gson()
        val jsonBody = gson.toJson(gameData)
        val json = jsonBody.toRequestBody("application/json".toMediaTypeOrNull())
        val request = Request.Builder()
            .url("http://10.0.5.152:5000/games")
            .post(json)
            .build()
        Log.i("POST Response", client.newCall(request).execute().toString())
    }


    fun fetchGames(): List<Game> {
        val request = Request.Builder()
                .url("http://10.0.5.152:5000/games")
                .get()
                .build()
        val response = client.newCall(request).execute()
        val json = response.body?.string()
        return if (json != null) {
            val gson = Gson()
            val listTypeToken = object : TypeToken<List<Game>>() {}
            val listType = listTypeToken.type
            Log.i(ContentValues.TAG,"Loaded Data from API")
            gson.fromJson(json, listType)
        } else { listOf() }
    }


}