package com.example.new_gymsarround_app.gyms.domain

import com.example.new_gymsarround_app.gyms.data.GymsRepository
import javax.inject.Inject

class TaggleFavouriteStateUseCase @Inject constructor(
    private val gymsRepository:GymsRepository,
            private val getSortedGymsUseCase : GetSortedGymsUseCase
) {

    suspend operator fun invoke(id:Int ,oldstate:Boolean) : List<Gym>{
        val newstate=oldstate.not()
        gymsRepository.taggleFavouriteGym(id ,newstate)
        return getSortedGymsUseCase()

    }
}