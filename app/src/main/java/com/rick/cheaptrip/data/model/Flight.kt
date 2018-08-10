package com.rick.cheaptrip.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "flight")
data class Flight(

        @PrimaryKey
        val id: Int,

        @ColumnInfo(name = "place_icon")
        val placeIcon: String,

        @ColumnInfo(name = "origin")
        val origin: String,

        @ColumnInfo(name = "destination")
        val destination: String,

        @ColumnInfo(name = "price")
        val price: Int,

        @ColumnInfo(name = "departure")
        val departure: String,

        @ColumnInfo(name = "arrival")
        val arrival: String
)