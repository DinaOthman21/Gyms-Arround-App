package com.example.new_gymsarround_app.gyms.presentation.navigation

sealed class Screen (val route :String){
    data object Gyms : Screen("GymsScreen")
    data object Details : Screen("DetailsScreen")
}