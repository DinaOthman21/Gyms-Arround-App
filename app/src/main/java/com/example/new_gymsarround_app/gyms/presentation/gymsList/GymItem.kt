package com.example.new_gymsarround_app.gyms.presentation.gymsList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.new_gymsarround_app.gyms.domain.Gym
import com.example.new_gymsarround_app.gyms.presentation.common.DefaultIcon
import com.example.new_gymsarround_app.gyms.presentation.gymDetails.GymDetails

@Composable
fun GymItem(
    gym : Gym,
    onFavouriteIconClick:(Gym) ->Unit,
    onItemClick:(Gym)->Unit
) {


    val icon = if (gym.isFavourite){
        Icons.Filled.Favorite
    } else{
        Icons.Filled.FavoriteBorder
    }
    Card( elevation = 4.dp,
        modifier = Modifier
            .padding(8.dp)
            .clickable
            { onItemClick(gym) }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(8.dp)
        ) {
            DefaultIcon(
                Icons.Filled.Place ,
                Modifier
                    .weight(0.15f),
                "Location Icon"
            )

            GymDetails(
                gym,
                Modifier.weight(.70f)
            )

            DefaultIcon(
                icon ,
                Modifier.weight(.15f),
                "Favourite gym icon",
                onClick ={
                    onFavouriteIconClick(gym)
                }   )

        }
    }
}