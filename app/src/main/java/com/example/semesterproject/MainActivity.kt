package com.example.semesterproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Surface
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.ExperimentalComposeUiApi
import com.example.semesterproject.screens.gameSelect.GameSelectViewModel
import com.example.semesterproject.screens.mainBoard.*

class MainActivity : AppCompatActivity() {
    @ExperimentalComposeApi
    @ExperimentalComposeUiApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent(){
            Surface{
                MainScreen()
            }
        }
    }

}