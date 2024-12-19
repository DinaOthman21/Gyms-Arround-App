package com.example.new_gymsarround_app.gyms.presentation.gymsList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.new_gymsarround_app.gyms.domain.GetInitialGymsUseCase
import com.example.new_gymsarround_app.gyms.domain.Gym
import com.example.new_gymsarround_app.gyms.domain.TaggleFavouriteStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class GymsViewModel @Inject constructor(
    private val getInitialGymsUseCase : GetInitialGymsUseCase,
    private val taggleFavouriteStateUseCase: TaggleFavouriteStateUseCase
): ViewModel() {

    private val _state = MutableStateFlow(GymsScreenState())
    val state: StateFlow<GymsScreenState> get() = _state

   private val errorHandler = CoroutineExceptionHandler { _, throwable ->
       throwable.printStackTrace()
       _state.value = _state.value.copy(
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
             _state.value=_state.value.copy(
                 gyms = recievedGyms,
                 isLoading = false
             )
         }
    }

    fun taggleFavouriteState (gym: Gym){
        viewModelScope.launch {
            val updatedGymsList= taggleFavouriteStateUseCase(gym = gym)
            _state.value= _state.value.copy(gyms= updatedGymsList)
        }
    }


}