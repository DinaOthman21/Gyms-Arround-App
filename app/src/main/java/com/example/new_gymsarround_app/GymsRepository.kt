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

     suspend fun taggleFavouriteGym(gymId:Int, state: Boolean) = withContext(
        Dispatchers.IO){
        gymsDao.update(
            GymsFavouriteState(
                id=gymId,
                isFavourite = state
            )
        )
        return@withContext gymsDao.getAll().sortedBy { it.name }
    }

     suspend fun loadGyms() = withContext(Dispatchers.IO){
        try {
            updateLocalDatabase()
        }
        catch (ex:Exception){
            if(gymsDao.getAll().isEmpty()){
                throw Exception("try connect to internet")
            }
        }
    }

    suspend fun getGyms():List<Gym> {
        return withContext(Dispatchers.IO){
            return@withContext gymsDao.getAll()
        }
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