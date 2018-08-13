package com.rick.cheaptrip.db

import androidx.arch.core.executor.testing.CountingTaskExecutorRule
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.InstrumentationRegistry
import com.rick.cheaptrip.data.local.room.CheapTripDatabase
import org.junit.After
import org.junit.Before
import org.junit.Rule
import java.util.concurrent.TimeUnit

abstract class DbTest {

    @Rule
    @JvmField
    val countingTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var _db: CheapTripDatabase

    val db: CheapTripDatabase
        get() = _db

    @Before
    fun initDb() {

        _db = Room.inMemoryDatabaseBuilder(
                InstrumentationRegistry.getContext(),
                CheapTripDatabase::class.java
        ).build()
    }

    @After
    fun closeDb() {
        _db.close()
    }
}