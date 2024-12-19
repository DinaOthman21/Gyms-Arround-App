package com.example.new_gymsarround_app.gyms.domain

import com.example.new_gymsarround_app.gyms.data.GymsRepository
import javax.inject.Inject

class TaggleFavouriteStateUseCase @Inject constructor(
    private val gymsRepository:GymsRepository,
            private val getSortedGymsUseCase : GetSortedGymsUseCase
) {

    suspend operator fun invoke(gym: Gym) : List<Gym>{
        val newstate = gym.isFavourite.not()
        gymsRepository.taggleFavouriteGym(gym ,newstate)
        return getSortedGymsUseCase()

    }
}