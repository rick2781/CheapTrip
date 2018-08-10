package com.rick.cheaptrip.ui.flightlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rick.cheaptrip.data.model.Flight
import com.rick.cheaptrip.data.repository.FlightRepository
import com.rick.cheaptrip.utils.Resource
import javax.inject.Inject

class FlightListViewModel @Inject constructor(val repository: FlightRepository): ViewModel() {

    var flightList: LiveData<Resource<List<Flight>>> = repository.loadFlights()
}