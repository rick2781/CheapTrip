package com.rick.cheaptrip.di.activity

import com.rick.cheaptrip.di.app.AppComponent
import com.rick.cheaptrip.ui.flightlist.FlightListActivity
import com.rick.cheaptrip.ui.setspecs.SetSpecsActivity
import dagger.Component

@Component(dependencies = [AppComponent::class])
interface ActivityComponent {

    fun inject(setSpecsActivity: SetSpecsActivity)
    fun inject(flightListActivity: FlightListActivity)
}