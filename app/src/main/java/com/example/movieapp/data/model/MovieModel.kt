package com.example.movieapp.data.model

import androidx.lifecycle.LiveData
import com.example.movieapp.data.vos.GenresVO
import com.example.movieapp.data.vos.MovieVO
import com.example.movieapp.data.vos.PersonVO
import com.example.movieapp.data.vos.VideoVO

interface MovieModel {

    fun getPopularMovies(onError: (String) -> Unit): LiveData<List<MovieVO>>
    fun getUpcomingMovies(onError: (String) -> Unit): LiveData<List<MovieVO>>
    fun getNowPlayingMovies(onError: (String) -> Unit): LiveData<List<MovieVO>>
    fun getMoviesFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)
    fun getMovieById(id:Int): LiveData<MovieVO>
    fun getGenresList() : LiveData<List<GenresVO>>
    fun getMoviesByGenres(genreId: Int) : LiveData<List<MovieVO>>
   // fun getMovieList(onError: (String) -> Unit) : LiveData<List<MovieVO>>
    fun getBestActors(onError: (String) -> Unit): LiveData<List<PersonVO>>
    fun getVideoById(movieId: Int, onSuccess: (List<VideoVO>) -> Unit, onError: (String) -> Unit)

}