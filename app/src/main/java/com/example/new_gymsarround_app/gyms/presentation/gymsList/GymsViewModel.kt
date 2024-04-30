package com.example.new_gymsarround_app.gyms.presentation.gymsList

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.new_gymsarround_app.gyms.domain.GetInitialGymsUseCase
import com.example.new_gymsarround_app.gyms.domain.TaggleFavouriteStateUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch


class GymsViewModel(): ViewModel() {
   private var _state by mutableStateOf( GymsScreenState(
        gyms = emptyList(),
        isLoading = true
    )
   )

    val state:State<GymsScreenState>
        get()= derivedStateOf { _state }


    private val getInitialGymsUseCase = GetInitialGymsUseCase()
    private val taggleFavouriteStateUseCase= TaggleFavouriteStateUseCase()

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
             val recievedGyms=getInitialGymsUseCase()
             _state=_state.copy(
                 gyms = recievedGyms,
                 isLoading = false
             )
         }
    }

    fun taggleFavouriteState (gymId:Int, oldvalue:Boolean){
        viewModelScope.launch {
            val updatedGymsList= taggleFavouriteStateUseCase(gymId,oldvalue)
            _state= _state.copy(gyms= updatedGymsList)
        }
    }


}