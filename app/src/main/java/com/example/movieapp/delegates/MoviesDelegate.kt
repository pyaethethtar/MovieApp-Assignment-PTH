package com.example.movieapp.delegates

import androidx.lifecycle.LifecycleOwner

interface MoviesDelegate {

    fun onTapPopularMovieItem(id: Int)

    fun onTabGenre(lifecycleOwner: LifecycleOwner, genreId: Int)

    fun onTapPlay(movieId : Int)

}