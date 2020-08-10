package com.example.movieapp.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.movieapp.adapters.SliderAdapter
import com.example.movieapp.data.vos.MovieVO
import com.example.movieapp.utils.IMAGE_URL
import com.smarteist.autoimageslider.SliderViewAdapter
import kotlinx.android.synthetic.main.item_slider_image.view.*

class SliderViewHolder(itemView: View?) : SliderViewAdapter.ViewHolder(itemView) {


    fun bindData(data: MovieVO){
        Glide.with(itemView.context).load(IMAGE_URL+data.posterPath).into(itemView.ivMovie)
        itemView.tvMovieName.text = data.title
    }
}