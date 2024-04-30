package com.example.new_gymsarround_app.gyms.data.Remote

import com.example.new_gymsarround_app.gyms.data.Remote.RemoteGym
import retrofit2.http.GET
import retrofit2.http.Query

interface GymsApiService {
    @GET("gyms.json")
    suspend fun getGyms(): List<RemoteGym>

    @GET ("gyms.json?orderBy=\"id\"")
    suspend fun getGym(
        @Query("equalTo") id:Int
    ) : Map<String, RemoteGym>



}