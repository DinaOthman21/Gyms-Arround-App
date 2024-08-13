package com.example.new_gymsarround_app.gyms.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.new_gymsarround_app.gyms.presentation.gymDetails.GymDetailsScreen
import com.example.new_gymsarround_app.gyms.presentation.gymsList.GymsScreen
import com.example.new_gymsarround_app.gyms.presentation.gymsList.GymsViewModel

@Composable
fun GymsArroundApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "gyms"  ){

        composable(route="gyms"){
            val vm: GymsViewModel = hiltViewModel()
            GymsScreen(state=vm.state.value,
                onItemClick ={  id-> navController.navigate("gyms/$id") },
                onFavouriteIconClick = {id,oldvalue->
                    vm.taggleFavouriteState(id,oldvalue)
                }
            )
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