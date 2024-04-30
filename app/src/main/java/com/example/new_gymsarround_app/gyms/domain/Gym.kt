package com.example.new_gymsarround_app.gyms.domain

import androidx.room.Entity


@Entity("gyms_table")
data class Gym(
                val id:Int ,
                val name: String ,
                val place :String ,
                val isOpen: Boolean ,
                val isFavourite:Boolean=false)
