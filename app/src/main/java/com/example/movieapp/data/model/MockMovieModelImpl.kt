package com.example.movieapp.data.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movieapp.data.vos.GenresVO
import com.example.movieapp.data.vos.MovieVO
import com.example.movieapp.data.vos.PersonVO
import com.example.movieapp.data.vos.VideoVO
import com.example.movieapp.dummy.getDummyGenres
import com.example.movieapp.dummy.getDummyMovies
import com.example.movieapp.dummy.getDummyPeople
import com.example.movieapp.dummy.getDummyVideos

object MockMovieModelImpl: MovieModel {


    override fun getPopularMovies(onError: (String) -> Unit): LiveData<List<MovieVO>> {
        val liveData = MutableLiveData<List<MovieVO>>()
        liveData.postValue(getDummyMovies())
        return liveData
    }

    override fun getUpcomingMovies(onError: (String) -> Unit): LiveData<List<MovieVO>> {
        val liveData = MutableLiveData<List<MovieVO>>()
        liveData.postValue(getDummyMovies())
        return liveData
    }

    override fun getNowPlayingMovies(onError: (String) -> Unit): LiveData<List<MovieVO>> {
        val liveData = MutableLiveData<List<MovieVO>>()
        liveData.postValue(getDummyMovies())
        return liveData
    }

    override fun getMoviesFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
    }

    override fun getMovieById(id: Int): LiveData<MovieVO> {
        val liveData = MutableLiveData<MovieVO>()
        liveData.postValue(getDummyMovies().first(){
            it.id==id
        })
        return liveData
    }

    override fun getGenresList(): LiveData<List<GenresVO>> {
        val liveData = MutableLiveData<List<GenresVO>>()
        liveData.postValue(getDummyGenres())
        return liveData
    }

    override fun getMoviesByGenres(genreId: Int): LiveData<List<MovieVO>> {
        val liveData = MutableLiveData<List<MovieVO>>()
        liveData.postValue(getDummyMovies().filter {
            it.genreIds.contains(genreId)
        })
        return liveData
    }

    override fun getBestActors(onError: (String) -> Unit): LiveData<List<PersonVO>> {
        val liveData = MutableLiveData<List<PersonVO>>()
        liveData.postValue(getDummyPeople())
        return liveData
    }

    override fun getVideoById(
        movieId: Int,
        onSuccess: (List<VideoVO>) -> Unit,
        onError: (String) -> Unit
    ) {
        onSuccess(getDummyVideos())

    }


}