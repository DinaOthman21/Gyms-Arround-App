package com.example.new_gymsarround_app.gyms.domain

import com.example.new_gymsarround_app.gyms.data.GymsRepository
import javax.inject.Inject

class GetSortedGymsUseCase @Inject constructor(
    private val gymsRepository:GymsRepository
) {

    suspend operator fun invoke() :List<Gym>{
        return gymsRepository.getGyms().sortedBy { it.name }
    }

}