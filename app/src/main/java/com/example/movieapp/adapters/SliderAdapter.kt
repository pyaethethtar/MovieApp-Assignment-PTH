package com.example.movieapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.movieapp.R
import com.example.movieapp.data.vos.MovieVO
import com.example.movieapp.views.viewholders.SliderViewHolder
import com.smarteist.autoimageslider.SliderViewAdapter

class SliderAdapter : SliderViewAdapter<SliderViewHolder>() {

    var mData : MutableList<MovieVO> = arrayListOf()


    override fun onCreateViewHolder(parent: ViewGroup?): SliderViewHolder {

        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_slider_image, parent, false)
        return SliderViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: SliderViewHolder?, position: Int) {
        viewHolder?.bindData(mData[position])
    }

    override fun getCount(): Int {
        return mData.count()
    }

    fun setNewData(data: List<MovieVO>){
        mData.addAll(data)
        notifyDataSetChanged()
    }
}