package com.example.movieapp.mvp.views

import com.example.movieapp.data.vos.GenresVO
import com.example.movieapp.data.vos.MovieVO
import com.example.movieapp.data.vos.PersonVO
import com.example.shared.BaseView

interface MainView : BaseView {

    fun displaySliderImages(movies: List<MovieVO>)
    fun displayPopularMovies(popularMovies: List<MovieVO>)
    fun displayGenresList(genres: List<GenresVO>)
    fun displayMoviesByGenres(movies: List<MovieVO>)
    fun displayShowcases(showcases: List<MovieVO>)
    fun displayBestActors(actors: List<PersonVO>)
    fun displayEmptyViewpod()
    fun navigateToMovieDetails(id: Int)
}