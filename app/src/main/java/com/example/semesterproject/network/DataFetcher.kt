package com.example.semesterproject.network

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.example.semesterproject.data.game.Game
import android.content.ContentValues
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

class DataFetcher() {
    private val gamesUrl = "http://10.0.5.152:5000/games"

    suspend fun fetchGames(): List<Game> {
        return withContext(Dispatchers.IO) {
            val client = OkHttpClient()

            val request = Request.Builder()
                .url(gamesUrl)
                .get()
                .build()

            val response = client.newCall(request).execute()

            val json = response.body?.string()

            if (json != null) {
                val gson = Gson()
                val listTypeToken = object : TypeToken<List<Game>>() {}
                val listType = listTypeToken.type
                Log.i(ContentValues.TAG,"Loaded Data from API")
                gson.fromJson(json, listType)

            } else {
                listOf()
            }
        }
    }
}