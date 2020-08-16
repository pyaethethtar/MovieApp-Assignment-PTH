package com.example.movieapp.views.viewholders

import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.example.movieapp.adapters.SliderAdapter
import com.example.movieapp.data.vos.MovieVO
import com.example.movieapp.delegates.MoviesDelegate
import com.example.movieapp.utils.IMAGE_URL
import com.smarteist.autoimageslider.SliderViewAdapter
import kotlinx.android.synthetic.main.item_slider_image.view.*

class SliderViewHolder(itemView: View, private val delegate: MoviesDelegate) : SliderViewAdapter.ViewHolder(itemView) {

    var movieId : Int = 0

    init {
        itemView.btnPlay.setOnClickListener {
            movieId.let {
                delegate.onTapPlay(it)
            }
        }
    }

    fun bindData(data: MovieVO){
        movieId = data.id
        Glide.with(itemView.context).load(IMAGE_URL+data.posterPath).into(itemView.ivMovie)
        itemView.tvMovieName.text = data.title
    }
}