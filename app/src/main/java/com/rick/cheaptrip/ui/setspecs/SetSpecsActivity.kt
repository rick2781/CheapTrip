package com.rick.cheaptrip.ui.setspecs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.room.Room
import com.rick.cheaptrip.CheapTripApp
import com.rick.cheaptrip.R
import com.rick.cheaptrip.data.local.room.CheapTripDatabase
import com.rick.cheaptrip.data.model.Flight
import com.rick.cheaptrip.data.remote.ApiErrorResponse
import com.rick.cheaptrip.data.remote.ApiResponse
import com.rick.cheaptrip.data.remote.ApiService
import com.rick.cheaptrip.databinding.ActivitySetSpecsBinding
import com.rick.cheaptrip.di.activity.DaggerActivityComponent
import com.rick.cheaptrip.ui.flightlist.FlightListActivity
import com.rick.cheaptrip.utils.LiveDataCallAdapterFactory
import com.rick.cheaptrip.utils.ViewModelFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class SetSpecsActivity : AppCompatActivity() {

    @Inject
    lateinit var setSpecsViewModel: SetSpecsViewModel

    private lateinit var dataBinding: ActivitySetSpecsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDagger()
        initViewModel()
        initDataBinding()

        setupNavigation()
    }

    private fun initDataBinding() {

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_set_specs)
        dataBinding.setSpecsViewModel = setSpecsViewModel
    }

    private fun initDagger() {

        val app = application as CheapTripApp

        DaggerActivityComponent.builder()
                .appComponent(app.getAppComponent(this))
                .build().inject(this)
    }

    private fun initViewModel() {

        setSpecsViewModel = ViewModelProviders.of(this, ViewModelFactory(setSpecsViewModel)).get(SetSpecsViewModel::class.java)
    }

    private fun setupNavigation() {

        setSpecsViewModel.navigationLD.observe(this, Observer {

            it?.getContentIfNotHandled()?.let {

                startActivity(Intent(this, FlightListActivity::class.java))
            }
        })
    }
}
