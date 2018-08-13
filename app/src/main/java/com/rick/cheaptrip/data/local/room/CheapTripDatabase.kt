package com.rick.cheaptrip.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.rick.cheaptrip.data.model.Flight

@Database(
        entities = [Flight::class],
        version = 1,
        exportSchema = false
)
abstract class CheapTripDatabase: RoomDatabase() {

    abstract fun flightDao(): FlightDao
}