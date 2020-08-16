package com.example.movieapp.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.movieapp.data.vos.MovieVO
import com.example.movieapp.delegates.MoviesDelegate
import com.example.movieapp.utils.IMAGE_URL
import com.example.shared.BaseViewHolder
import kotlinx.android.synthetic.main.item_showcase.view.*

class ShowcaseViewHolder(itemView: View, private val mDelegate: MoviesDelegate) : BaseViewHolder<MovieVO>(itemView) {

    private var movieId = 0
    init {
        itemView.btnPlayShowcase.setOnClickListener {
            mDelegate.onTapPlay(movieId)
        }
    }


    override fun bindData(data: MovieVO) {

        movieId = data.id
        itemView.tvShowcaseName.text = data.title
        itemView.tvShowcaseDate.text = data.releaseDate
        Glide.with(itemView.context).load(IMAGE_URL+data.backDropPath).into(itemView.ivShowcase)
    }


}