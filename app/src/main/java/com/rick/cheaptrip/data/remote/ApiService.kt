package com.rick.cheaptrip.data.remote

import androidx.lifecycle.LiveData
import com.rick.cheaptrip.data.model.Flight
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/flights/")
    fun getFlightList(): LiveData<ApiResponse<List<Flight>>>
}