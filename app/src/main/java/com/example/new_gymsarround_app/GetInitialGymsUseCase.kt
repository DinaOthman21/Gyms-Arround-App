package com.example.new_gymsarround_app

class GetInitialGymsUseCase {
    private val gymsRepository=GymsRepository()
    private val getSortedGymsUseCase=GetSortedGymsUseCase()
    suspend operator fun invoke() :List<Gym>{
         gymsRepository.loadGyms()
        return getSortedGymsUseCase()
    }

}