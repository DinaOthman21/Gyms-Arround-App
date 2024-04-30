package com.example.new_gymsarround_app.gyms.data.Local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface GymsDao {
    @Query("SELECT * FROM gyms_table ")
    suspend fun getAll(): List<LocalGym>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAll(gyms:List<LocalGym>)

    @Update(entity = LocalGym::class)
    suspend fun update(gymsFavouriteState: GymsFavouriteState)


    @Query("SELECT * FROM gyms_table WHERE is_favourite=1")
    suspend fun getFavouriteGyms(): List<LocalGym>

    @Update(entity = LocalGym::class)
    suspend fun updateAll(gymsStates:List <GymsFavouriteState>)



}