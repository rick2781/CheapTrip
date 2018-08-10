package com.rick.cheaptrip.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rick.cheaptrip.data.model.Flight

@Dao
abstract class FlightDao {

    @Query("SELECT * FROM flight")
    abstract fun getFlightList(): LiveData<List<Flight>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertFlightList(flightList: List<Flight>)
}