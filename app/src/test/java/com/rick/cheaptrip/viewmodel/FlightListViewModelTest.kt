package com.rick.cheaptrip.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.rick.cheaptrip.data.repository.FlightRepository
import com.rick.cheaptrip.ui.flightlist.FlightListViewModel
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class FlightListViewModelTest {

    @JvmField
    @Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val flightRepository = mock(FlightRepository::class.java)
    private val flightViewModel = FlightListViewModel(flightRepository)

    @Test
    fun testIfNull() {

        assertThat(flightViewModel.repository, notNullValue())
    }

    @Test
    fun changeWhenObserved() {

        flightViewModel.flightList
        verify(flightRepository).loadFlights()
    }
}