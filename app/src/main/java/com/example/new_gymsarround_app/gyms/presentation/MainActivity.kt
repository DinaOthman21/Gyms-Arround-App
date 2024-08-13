package com.example.new_gymsarround_app.gyms.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.new_gymsarround_app.gyms.presentation.navigation.GymsArroundApp
import com.example.new_gymsarround_app.ui.theme.New_GymsArround_AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
         New_GymsArround_AppTheme {
        GymsArroundApp()
         }
        }
    }
}







