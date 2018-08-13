package com.rick.cheaptrip.db

import androidx.test.runner.AndroidJUnit4
import com.rick.cheaptrip.data.model.Flight
import com.rick.cheaptrip.utils.LiveDataTestUtil.getValue
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FlightDaoTest: DbTest() {

    @Test
    fun insertAndRead() {

        val flightList = listOf(Flight(1, "","New York","San Diego", 1, "", ""))

        db.flightDao().insertFlightList(flightList)

        val data = getValue(db.flightDao().getFlightList())

        assertThat(data, notNullValue())

        assertThat(data.first().origin, `is`("New York"))
        assertThat(data.first().destination, `is`("San Diego"))
    }
}