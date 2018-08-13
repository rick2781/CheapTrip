package com.rick.cheaptrip.repository

import android.app.Instrumentation
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.room.Room
import com.bumptech.glide.load.engine.Resource
import com.rick.cheaptrip.data.local.room.CheapTripDatabase
import com.rick.cheaptrip.data.local.room.FlightDao
import com.rick.cheaptrip.data.model.Flight
import com.rick.cheaptrip.data.remote.ApiService
import com.rick.cheaptrip.data.repository.FlightRepository
import com.rick.cheaptrip.util.ApiUtil.successCall
import com.rick.cheaptrip.utils.reactive.AppSchedulerProvider
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.*

@RunWith(JUnit4::class)
class FlightRepositoryTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var repository: FlightRepository

    private val dao = mock(FlightDao::class.java)
    private val service = mock(ApiService::class.java)

    @Before
    fun init(){
        repository = FlightRepository(dao, AppSchedulerProvider(), service)
    }

    @Test
    fun loadFlightsListFromAPI() {

        val dbData = MutableLiveData<List<Flight>>()
        `when`(dao.getFlightList()).thenReturn(dbData)

        val flightList = listOf(Flight(1, "","","", 1, "", ""))
        val successCall = successCall(flightList)
        `when`(service.getFlightList()).thenReturn(successCall)

        repository.loadFlights()
        verify(dao).getFlightList()
        verifyNoMoreInteractions(service)
    }
}