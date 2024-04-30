package com.example.new_gymsarround_app

class GetSortedGymsUseCase {
    private val gymsRepository= GymsRepository()
    suspend operator fun invoke() :List<Gym>{
        return gymsRepository.getGyms().sortedBy { it.name }
    }

}