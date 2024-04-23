package com.example.new_gymsarround_app


import retrofit2.Call
import retrofit2.http.GET

interface GymsApiService {
    @GET("gyms.json")
    fun getGyms(): Call<List<Gym>>

}