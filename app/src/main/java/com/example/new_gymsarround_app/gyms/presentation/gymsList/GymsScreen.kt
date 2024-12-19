package com.example.new_gymsarround_app.gyms.presentation.gymsList


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import com.example.new_gymsarround_app.gyms.domain.Gym
import com.example.new_gymsarround_app.gyms.presentation.SemanticDescription

@Composable
fun GymsScreen(
    state:GymsScreenState,
    onItemClick: (Gym) -> Unit ,
    onFavouriteIconClick: (Gym) ->  Unit
){
    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    )
    {
        LazyColumn {
            items(state.gyms) {gym->
                GymItem(
                    gym=gym,
                    onFavouriteIconClick ={ onFavouriteIconClick(gym) },
                    onItemClick = {  onItemClick(gym)}
                )
            }
        }

        if(state.isLoading) CircularProgressIndicator(
            Modifier.semantics{
                this.contentDescription= SemanticDescription.Gyms_List_Loadind
            }
        )
        if(state.error!= null) Text(state.error)
    }
}







