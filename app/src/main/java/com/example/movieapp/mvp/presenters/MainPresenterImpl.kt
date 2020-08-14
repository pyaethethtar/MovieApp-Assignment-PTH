package com.example.movieapp.mvp.presenters

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.movieapp.data.model.MovieModel
import com.example.movieapp.data.model.MovieModelImpl
import com.example.movieapp.mvp.views.MainView
import com.example.shared.AbstractBasePresenter

class MainPresenterImpl: MainPresenter, AbstractBasePresenter<MainView>() {



    var mMovieModel: MovieModel = MovieModelImpl


    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        loadMoviesFromApi()
        requestPopularMovies(lifecycleOwner)
        requestUpcomingMovies(lifecycleOwner)
        requestNowPlayingMovies(lifecycleOwner)
        requestGenresList(lifecycleOwner)
        requestBestActorList(lifecycleOwner)
    }


    override fun onTabGenre(lifecycleOwner: LifecycleOwner, genreId: Int) {

        requestMoviesByGenres(lifecycleOwner, genreId)
    }

    override fun onTapPopularMovieItem(id: Int) {
        mView?.navigateToMovieDetails(id)
    }

    override fun onTapFavPeople() {
        mView?.setFavPeople()
    }

    private fun loadMoviesFromApi(){
        mMovieModel.getMoviesFromApiAndSaveToDatabase(onSuccess = {}, onError = {})
    }

    private fun requestPopularMovies(lifecycleOwner: LifecycleOwner){
        mMovieModel.getPopularMovies(
            onError = { Log.e("error","Movie Error")}
        ).observe(lifecycleOwner, Observer {
            if (it.isNotEmpty()){
                mView?.displayPopularMovies(it)
            }
        })
    }

    private fun requestUpcomingMovies(lifecycleOwner: LifecycleOwner) {
        mMovieModel.getUpcomingMovies(
            onError = {Log.e("error", "Movie Error")}
        ).observe(lifecycleOwner, Observer {
            if (it.isNotEmpty()){
                mView?.displaySliderImages(it)
            }
        })
    }

    private fun requestNowPlayingMovies(lifecycleOwner: LifecycleOwner){
        mMovieModel.getNowPlayingMovies(
            onError = {Log.e("error", "Movie Error")}
        ).observe(lifecycleOwner, Observer {
            if (it.isNotEmpty()){
                mView?.displayShowcases(it)
            }
        })
    }

    private fun requestGenresList(lifecycleOwner: LifecycleOwner){
        mMovieModel.getGenresList()
            .observe(lifecycleOwner, Observer {
                if (it.isNotEmpty()){
                    mView?.displayGenresList(it)
                }
            })
    }


    private fun requestMoviesByGenres(lifecycleOwner: LifecycleOwner, genreId: Int){
        mMovieModel.getMoviesByGenres(genreId)
            .observe(lifecycleOwner, Observer {
                var movies = it.filter {
                    it.genreIds.contains(genreId)
                }
                if (movies.isNotEmpty()){
                    mView?.displayMoviesByGenres(movies)
                }
                else    mView?.displayEmptyViewpod()

            })
    }


    private fun requestBestActorList(lifecycleOwner: LifecycleOwner){
        mMovieModel.getBestActors(
            onError = { Log.e("error","Movie Error")}
        ) .observe(lifecycleOwner, Observer {
            if (it.isNotEmpty()){
                mView?.displayBestActors(it)
            }
        })
    }


}