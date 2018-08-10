package com.rick.cheaptrip.di.app

import android.app.Application
import androidx.room.Room
import com.rick.cheaptrip.data.local.room.CheapTripDatabase
import com.rick.cheaptrip.data.local.room.FlightDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule(application: Application) {

    private val cheapTripManagerDb = Room.databaseBuilder(
            application,
            CheapTripDatabase::class.java,
            "FlightManagerDatabase.db"
    )
            .build()

    @Provides
    fun provideCheapTripManagerDb(): CheapTripDatabase = cheapTripManagerDb

    @Provides
    fun provideFlightDao(cheapTripDatabase: CheapTripDatabase): FlightDao = cheapTripDatabase.flightDao()
}