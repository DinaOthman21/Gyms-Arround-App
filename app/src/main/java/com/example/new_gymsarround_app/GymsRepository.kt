package com.example.new_gymsarround_app

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GymsRepository {

    private val apiService:GymsApiService = Retrofit.Builder()
        .addConverterFactory(
            GsonConverterFactory.create()
        )
        .baseUrl(
            "https://cairo-gyms-427a3-default-rtdb.firebaseio.com/"
        )
        .build()
        .create(GymsApiService::class.java)

    private var gymsDao=GymsDatabase.getDaoInstance(
        GymsApplication.getApplicationContext()
    )

     suspend fun taggleFavouriteGym(gymId:Int, newFavouriteState: Boolean) = withContext(
        Dispatchers.IO){
        gymsDao.update(
            GymsFavouriteState(
                id=gymId,
                isFavourite = newFavouriteState
            )
        )
        return@withContext gymsDao.getAll()
    }

     suspend fun getAllGyms() = withContext(Dispatchers.IO){
        try {
            updateLocalDatabase()
        }
        catch (ex:Exception){
            if(gymsDao.getAll().isEmpty()){
                throw Exception("try connect to internet")
            }
        }
        gymsDao.getAll()
    }

     suspend fun updateLocalDatabase() {
        val gyms = apiService.getGyms()
        val favouriteGymsList =gymsDao.getFavouriteGyms()

        gymsDao.addAll(gyms)
        gymsDao.updateAll(
            favouriteGymsList.map{
                GymsFavouriteState(id=it.id,true)
            }
        )
    }


}