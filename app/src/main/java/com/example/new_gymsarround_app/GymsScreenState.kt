package com.example.new_gymsarround_app

data class GymsScreenState(
    val gyms:List<Gym> ,
    val isLoading:Boolean,
    val error:String?=null

)
