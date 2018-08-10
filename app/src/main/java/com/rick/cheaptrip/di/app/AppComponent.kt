package com.rick.cheaptrip.di.app

import com.rick.cheaptrip.CheapTripApp
import com.rick.cheaptrip.data.local.room.FlightDao
import com.rick.cheaptrip.data.remote.ApiService
import com.rick.cheaptrip.utils.reactive.AppSchedulerProvider
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class, RoomModule::class])
interface AppComponent {

    fun provideApiService(): ApiService
    fun provideFlightDao(): FlightDao
    fun provideSchedulerProvider(): AppSchedulerProvider

    fun inject(cheapTripApp: CheapTripApp)
}