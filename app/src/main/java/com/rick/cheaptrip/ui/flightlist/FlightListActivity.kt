package com.rick.cheaptrip.ui.flightlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.rick.cheaptrip.CheapTripApp
import com.rick.cheaptrip.R
import com.rick.cheaptrip.data.model.Flight
import com.rick.cheaptrip.databinding.ActivityFlightListBinding
import com.rick.cheaptrip.di.activity.DaggerActivityComponent
import com.rick.cheaptrip.utils.ViewModelFactory
import javax.inject.Inject

class FlightListActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: FlightListViewModel

    @Inject
    lateinit var flightListAdapter: FlightListAdapter

    lateinit var dataBinding: ActivityFlightListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDagger()
        initViewModel()
        initDataBinding()

        setupLayout()
    }

    private fun setupLayout(){

        with(dataBinding.rv){

            val linearLayoutManager = LinearLayoutManager(this@FlightListActivity)

            adapter = flightListAdapter
            layoutManager = linearLayoutManager
            addItemDecoration(DividerItemDecoration(this@FlightListActivity, linearLayoutManager.orientation))

            updateRecyclerView()
        }
    }

    private fun updateRecyclerView() {

        val adapter = dataBinding.rv.adapter as FlightListAdapter

        viewModel.flightList.observe(this, Observer { resource ->

            adapter.updateItemList(resource.data as ArrayList<Flight>?)
        })
    }

    private fun initDataBinding() {

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_flight_list)
        dataBinding.flightListViewModel = viewModel
    }

    private fun initDagger() {

        val app = application as CheapTripApp

        DaggerActivityComponent.builder()
                .appComponent(app.getAppComponent(this))
                .build().inject(this)
    }

    private fun initViewModel() {

        viewModel = ViewModelProviders.of(this, ViewModelFactory(viewModel)).get(FlightListViewModel::class.java)
    }
}