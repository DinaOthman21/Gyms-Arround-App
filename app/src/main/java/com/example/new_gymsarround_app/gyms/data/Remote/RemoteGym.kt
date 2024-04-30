package com.example.new_gymsarround_app.gyms.data.Remote

import com.google.gson.annotations.SerializedName


data class RemoteGym(

                val id:Int ,

                @SerializedName("gym_name")
                val name: String ,

                @SerializedName("gym_location")
                val place :String ,

                @SerializedName("is_open")
                val isOpen: Boolean ,
)