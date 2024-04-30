package com.example.new_gymsarround_app.gyms.presentation.gymDetails

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.new_gymsarround_app.gyms.data.Remote.GymsApiService
import com.example.new_gymsarround_app.gyms.domain.Gym
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GymsDetailsViewModel(
    private val SavedStateHandle: SavedStateHandle
) : ViewModel() {
    var state by mutableStateOf<Gym?>(null)
    private var apiService: GymsApiService

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://cairo-gyms-427a3-default-rtdb.firebaseio.com/")
            .build()
        apiService= retrofit.create(GymsApiService::class.java)
        val gymId=SavedStateHandle.get<Int>("gym_id")?:0
        getGyms(gymId)
    }

    private fun getGyms(id:Int) {
      viewModelScope.launch {
          val gym =getGymFromRemoteDB(id)
          state = gym
      }
    }

    private suspend fun getGymFromRemoteDB(id: Int) = withContext(Dispatchers.IO){
        apiService.getGym(id).values.first().let {
            Gym(
                id  = it.id,
                name =it.name,
                place = it.place,
                isOpen =it.isOpen,
            )
        }
    }


}