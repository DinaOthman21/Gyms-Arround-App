package com.example.new_gymsarround_app.gyms.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.new_gymsarround_app.gyms.presentation.gymDetails.GymDetailsScreen
import com.example.new_gymsarround_app.gyms.presentation.gymsList.GymsScreen
import com.example.new_gymsarround_app.ui.theme.New_GymsArround_AppTheme

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


@Composable
fun GymsArroundApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "gyms"  ){

        composable(route="gyms"){
            GymsScreen {  id->
                navController.navigate("gyms/$id")
                }
            }


        composable(route = "gyms/{gym_id}" ,
            arguments = listOf(
                navArgument("gym_id"){
                    type= NavType.IntType
                },)){
            GymDetailsScreen()
        }


        }


    }




/*
@Preview(name="p1",showBackground = true , showSystemUi = true)
@Composable
fun PreviewSection(){

}*/
