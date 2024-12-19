package com.example.new_gymsarround_app.gyms.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.new_gymsarround_app.gyms.domain.Gym
import com.example.new_gymsarround_app.gyms.presentation.gymDetails.GymDetailsScreen
import com.example.new_gymsarround_app.gyms.presentation.gymsList.GymsScreen
import com.example.new_gymsarround_app.gyms.presentation.gymsList.GymsViewModel

@Composable
fun GymsArroundApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Gyms.route  ){

        composable(route=Screen.Gyms.route){
            val vm: GymsViewModel = hiltViewModel()
            val state = vm.state.collectAsState().value
            GymsScreen(
                state=state,
                onItemClick ={gym ->
                    navController.currentBackStackEntry?.savedStateHandle?.set("gym", gym)
                    navController.navigate(Screen.Details.route)
                },
                onFavouriteIconClick = {gym->
                    vm.taggleFavouriteState(gym)
                }
            )
        }


        composable(route = Screen.Details.route){
            val gym = navController.previousBackStackEntry?.savedStateHandle?.get<Gym>("gym")
            if (gym != null) {
                GymDetailsScreen(gym = gym)
            } else {
                navController.popBackStack(Screen.Gyms.route, inclusive = false)
            }
        }


    }


}