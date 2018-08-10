package com.rick.cheaptrip

import android.app.Application
import android.content.Context
import com.rick.cheaptrip.di.app.AppComponent
import com.rick.cheaptrip.di.app.AppModule
import com.rick.cheaptrip.di.app.DaggerAppComponent
import com.rick.cheaptrip.di.app.RoomModule

/**
 * This class was made to inject App Level dependencies.
 *
 * That means every class, no matter where they are located,
 * will be able to use what AppModule has to offer.
 */
class CheapTripApp: Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initializeInjector()
    }

    private fun initializeInjector() {

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .roomModule(RoomModule(this))
                .build()
    }

    fun getAppComponent(context: Context): AppComponent {

        val app = context.applicationContext as CheapTripApp
        return app.appComponent
    }
}