package com.rick.cheaptrip.di.app

import android.app.Application
import android.content.Context
import com.rick.cheaptrip.data.remote.ApiService
import com.rick.cheaptrip.utils.BASE_URL
import com.rick.cheaptrip.utils.LiveDataCallAdapterFactory
import com.rick.cheaptrip.utils.reactive.AppSchedulerProvider
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule(private val appContext: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context = appContext

    @Provides
    fun provideApiService(): ApiService =
            Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(LiveDataCallAdapterFactory())
                    .build()
                    .create(ApiService::class.java)

    @Provides
    fun provideSchedulerProvider(): AppSchedulerProvider = AppSchedulerProvider()
}