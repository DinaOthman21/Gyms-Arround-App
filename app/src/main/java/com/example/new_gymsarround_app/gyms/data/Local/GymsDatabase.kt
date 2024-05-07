package com.example.new_gymsarround_app.gyms.data.Local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [LocalGym::class],
    version = 3 ,
    exportSchema = false
)

abstract class GymsDatabase : RoomDatabase() {
    abstract val dao: GymsDao


}