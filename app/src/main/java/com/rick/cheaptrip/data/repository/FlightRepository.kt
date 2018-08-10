package com.rick.cheaptrip.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.rick.cheaptrip.data.local.room.FlightDao
import com.rick.cheaptrip.data.model.Flight
import com.rick.cheaptrip.data.remote.ApiResponse
import com.rick.cheaptrip.data.remote.ApiService
import com.rick.cheaptrip.utils.Resource
import com.rick.cheaptrip.utils.reactive.AppSchedulerProvider
import javax.inject.Inject

class FlightRepository @Inject constructor(
        val flightDao: FlightDao,
        val appSchedulerProvider: AppSchedulerProvider,
        val apiService: ApiService) {

    fun loadFlights(): LiveData<Resource<List<Flight>>> {

        return object : NetworkBoundResource<List<Flight>, List<Flight>>(appSchedulerProvider) {

            override fun loadFromDb(): LiveData<List<Flight>> = flightDao.getFlightList()

            override fun shouldFetch(data: List<Flight>?): Boolean {
//                return data == null || data.isEmpty()
                return true
            }

            override fun createCall(): LiveData<ApiResponse<List<Flight>>> = apiService.getFlightList()

            override fun saveCallResult(item: List<Flight>) = flightDao.insertFlightList(item)

        }.asLiveData()
    }
}