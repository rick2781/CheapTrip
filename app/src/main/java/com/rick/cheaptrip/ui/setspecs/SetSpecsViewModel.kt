package com.rick.cheaptrip.ui.setspecs

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rick.cheaptrip.data.repository.FlightRepository
import com.rick.cheaptrip.utils.EventWrapper
import javax.inject.Inject

class SetSpecsViewModel @Inject constructor(): ViewModel() {

    val fromField = MutableLiveData<String>()
    val toField = MutableLiveData<String>()

    val navigationLD: MutableLiveData<EventWrapper<Int>> = MutableLiveData()

    fun navigationEvent() = navigationLD.postValue(EventWrapper(1))
}