package com.example.movieapp.views.viewholders

import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.example.movieapp.data.vos.MovieVO
import com.example.movieapp.delegates.MoviesDelegate
import com.example.movieapp.mvp.presenters.MainPresenterImpl
import com.example.movieapp.views.viewpods.MoviesViewpod
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_movie.view.*
import kotlinx.android.synthetic.main.viewpod_movies.view.*

class MovieViewHolder(itemView: View, private val mDelegate: MoviesDelegate) : BaseViewHolder<MovieVO>(itemView) {

    var movieId : Int = 0

    init {
        itemView.setOnClickListener {

            mDelegate.onTapPopularMovieItem(movieId)

        }
    }



    override fun bindData(data: MovieVO) {

        movieId = data.id
        Glide.with(itemView.context).load("https://image.tmdb.org/t/p/original"+data.posterPath).into(itemView.ivPopularFilm)
        itemView.tvPopularFilmName.text = data.originalTitle
        itemView.tvReviewCount.text = data.voteCount.toString()
        itemView.rbPopularFilm.rating = data.voteAverage.toFloat()
    }
}