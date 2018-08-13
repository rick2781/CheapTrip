package com.rick.cheaptrip.ui

import androidx.lifecycle.MutableLiveData
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.rick.cheaptrip.data.model.Flight
import com.rick.cheaptrip.ui.flightlist.FlightListActivity
import com.rick.cheaptrip.ui.flightlist.FlightListViewModel
import com.rick.cheaptrip.utils.Resource
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

@RunWith(AndroidJUnit4::class)
class FlightListTest {

    @Rule
    @JvmField
    val activityRule = ActivityTestRule(FlightListActivity::class.java)

    private lateinit var viewModel: FlightListViewModel

    private val flightListLiveData = MutableLiveData<Resource<List<Flight>>>()

    fun init() {

        viewModel = mock(FlightListViewModel::class.java)

        `when`(viewModel.flightList).thenReturn(flightListLiveData)
    }
}