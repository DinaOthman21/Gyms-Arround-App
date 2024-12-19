package com.example.new_gymsarround_app.gyms.presentation.gymsList

import com.example.new_gymsarround_app.gyms.domain.Gym

data class GymsScreenState(
    val gyms:List<Gym> =  emptyList(),
    val isLoading:Boolean = false,
    val error:String?=null

)
