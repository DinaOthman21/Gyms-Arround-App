package com.example.new_gymsarround_app.gyms.presentation.gymDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.new_gymsarround_app.gyms.domain.Gym
import com.example.new_gymsarround_app.gyms.presentation.common.DefaultIcon

@Composable
fun GymDetailsScreen(
    gym : Gym ,
){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
        {
                DefaultIcon(
                    icon = Icons.Filled.Place,
                    modifier = Modifier
                        .padding(bottom = 32.dp, top = 32.dp),
                    contentDescription = "location Icon"
                )
                GymDetails(
                    gym = gym,
                    modifier = Modifier
                        .padding(bottom = 32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                    Text(
                        text = if (gym.isOpen) "Gym is Open" else "Gym is Closed",
                        color = if (gym.isOpen) Color.Green else Color.Red
                    )


        }


}