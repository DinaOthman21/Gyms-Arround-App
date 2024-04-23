package com.example.new_gymsarround_app

import retrofit2.http.GET

interface GymsApiService {
    @GET("gyms.json")
    suspend fun getGyms(): List<Gym>

}