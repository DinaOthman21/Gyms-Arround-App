package com.example.new_gymsarround_app

class TaggleFavouriteStateUseCase {
    private val gymsRepository=GymsRepository()
    private val getSortedGymsUseCase = GetSortedGymsUseCase()
    suspend operator fun invoke(id:Int ,oldstate:Boolean) : List<Gym>{
        val newstate=oldstate.not()
        gymsRepository.taggleFavouriteGym(id ,newstate)
        return getSortedGymsUseCase()

    }
}