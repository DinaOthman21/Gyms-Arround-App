package com.example.new_gymsarround_app

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class GymsFavouriteState(
    @ColumnInfo(name="gym_id")
    val id:Int ,

    @ColumnInfo(name="is_favourite")
    val isFavourite:Boolean=false
)