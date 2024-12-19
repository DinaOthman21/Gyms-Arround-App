package com.example.new_gymsarround_app.gyms.presentation.gymDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.new_gymsarround_app.gyms.domain.Gym

@Composable
fun GymDetails(
    gym: Gym,
    modifier: Modifier,
    horizontalAlignment: Alignment.Horizontal= Alignment.Start
) {
    Column(modifier=modifier , horizontalAlignment=horizontalAlignment) {
        Text(
            text = gym.name,
            style = MaterialTheme.typography.h5,
            color = Color.Magenta
        )

        Text(
            text = gym.place,
            style = MaterialTheme.typography.body2,
            fontWeight = FontWeight.Medium
        )
    }
}