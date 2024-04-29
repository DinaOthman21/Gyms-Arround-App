package com.example.new_gymsarround_app

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity("gyms_table")
data class Gym(
               @PrimaryKey
               @ColumnInfo(name="gym_id")
                val id:Int ,

               @ColumnInfo(name="gym_name")
                @SerializedName("gym_name")
                val name: String ,

                @ColumnInfo(name="gym_location")
                @SerializedName("gym_location")
                val place :String ,

                @SerializedName("is_open")
                val isOpen: Boolean ,

               @ColumnInfo(name="is_favourite")
                val isFavourite:Boolean=false)
