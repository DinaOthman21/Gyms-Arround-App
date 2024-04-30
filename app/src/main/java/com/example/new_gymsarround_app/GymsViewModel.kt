package com.example.new_gymsarround_app

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch


class GymsViewModel(): ViewModel() {
   private var _state by mutableStateOf( GymsScreenState(
        gyms = emptyList(),
        isLoading = true
    ))

    val state:State<GymsScreenState>
        get()= derivedStateOf { _state }


    private val repo =GymsRepository()

    private val errorHandler = CoroutineExceptionHandler{ _, throwable ->
      throwable.printStackTrace()
        _state=_state.copy(
            isLoading = false,
            error = throwable.message
        )
    }


    init {
        getGyms()
    }

    private fun getGyms(){
         viewModelScope.launch( errorHandler) {
             val recievedGyms=repo.getAllGyms()
             _state=_state.copy(
                 gyms = recievedGyms,
                 isLoading = false
             )
         }
    }

    fun taggleFavouriteState (gymId:Int){
        val gyms = _state.gyms.toMutableList()
        val itemIndex = gyms.indexOfFirst { it.id == gymId }

        viewModelScope.launch {
           val updatedGymsList= repo.taggleFavouriteGym( gymId, !gyms[itemIndex].isFavourite)
            _state= _state.copy(gyms=updatedGymsList)
        }
    }

}