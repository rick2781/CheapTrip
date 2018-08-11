package com.rick.cheaptrip.api

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.rick.cheaptrip.data.model.Flight
import com.rick.cheaptrip.data.remote.ApiService
import com.rick.cheaptrip.data.remote.ApiSuccessResponse
import com.rick.cheaptrip.utils.LiveDataCallAdapterFactory
import com.rick.cheaptrip.utils.LiveDataTestUtil.getValue
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.Okio
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

@RunWith(JUnit4::class)
class ApiServiceTest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var service: ApiService
    private lateinit var mockServer: MockWebServer

    @Before
    fun initService() {

        mockServer = MockWebServer()

        service = Retrofit.Builder()
                .baseUrl(mockServer.url("/"))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .build()
                .create(ApiService::class.java)
    }

    @After
    fun stopService() {
        mockServer.shutdown()
    }

    @Test
    fun getFlights() {

        enqueueResponse("flightlist.json")

        val response = (getValue(service.getFlightList()) as ApiSuccessResponse<List<Flight>>).body

        // On purpose showing different ways to use assert methods

        assertEquals(response.size, 3)
        assertEquals(response.first().origin, "San Diego")
        assertTrue(response.first().price == 380)
        assertThat(response[0].destination, `is`("New York"))
    }

    private fun enqueueResponse(fileName: String) {

        val inputStream = javaClass.classLoader.getResourceAsStream(fileName)

        val source = Okio.buffer(Okio.source(inputStream))

        mockServer.enqueue(MockResponse().setBody(source.readString(Charsets.UTF_8)))
    }
}