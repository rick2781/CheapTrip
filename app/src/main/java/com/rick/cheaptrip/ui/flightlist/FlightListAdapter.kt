package com.rick.cheaptrip.ui.flightlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rick.cheaptrip.R
import com.rick.cheaptrip.data.model.Flight
import com.rick.cheaptrip.databinding.FlightListItemBinding
import javax.inject.Inject

class FlightListAdapter @Inject constructor(): RecyclerView.Adapter<FlightListAdapter.ViewHolder>() {

    private var itemList: ArrayList<Flight> = ArrayList()

    class ViewHolder(val binding: FlightListItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

        val binding: FlightListItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(p0.context),
                R.layout.flight_list_item,
                p0,
                false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        p0.binding.flight = itemList[p1]
    }

    fun updateItemList(newList: ArrayList<Flight>?) {

        if (newList != null)
            itemList = newList
        else itemList.clear()

        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = itemList.count()
}