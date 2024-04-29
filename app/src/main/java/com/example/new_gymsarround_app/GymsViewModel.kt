package com.example.new_gymsarround_app

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GymsViewModel(): ViewModel() {
    var state by mutableStateOf( emptyList<Gym>())
    private var apiService:GymsApiService
    private var gymsDao=GymsDatabase.getDaoInstance(GymsApplication.getApplicationContext())

    private val errorHandler = CoroutineExceptionHandler{ _, throwable ->
      throwable.printStackTrace()
    }


    init {
   val retrofit:Retrofit = Retrofit.Builder()
       .addConverterFactory(
           GsonConverterFactory.create()
       )
       .baseUrl(
           "https://cairo-gyms-427a3-default-rtdb.firebaseio.com/"
       )
       .build()
        apiService= retrofit.create(GymsApiService::class.java)
        getGyms()
    }

    private fun getGyms(){
         viewModelScope.launch( errorHandler) {
             state=getAllGyms()
         }
    }

    private suspend fun getAllGyms() = withContext(Dispatchers.IO){
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

    private suspend fun updateLocalDatabase() {
        val gyms = apiService.getGyms()
        val favouriteGymsList =gymsDao.getFavouriteGyms()

        gymsDao.addAll(gyms)
        gymsDao.updateAll(
            favouriteGymsList.map{
                GymsFavouriteState(id=it.id,true)
            }
        )
    }

    fun taggleFavouriteState (gymId:Int){
        val gyms = state.toMutableList()
        val itemIndex = gyms.indexOfFirst { it.id == gymId }

        viewModelScope.launch {
           val updatedGymsList= taggleFavouriteGym( gymId, !gyms[itemIndex].isFavourite)
            state=updatedGymsList
        }
    }

   private suspend fun taggleFavouriteGym(gymId:Int, newFavouriteState: Boolean) = withContext(Dispatchers.IO){
        gymsDao.update(
            GymsFavouriteState(
                id=gymId,
                isFavourite = newFavouriteState
            )
        )
       return@withContext gymsDao.getAll()
    }

}