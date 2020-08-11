package com.example.movieapp.mvp.presenters

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.movieapp.data.model.MovieModel
import com.example.movieapp.data.model.MovieModelImpl
import com.example.movieapp.data.vos.MovieVO
import com.example.movieapp.mvp.views.DetailsView
import io.reactivex.android.schedulers.AndroidSchedulers

class DetailsPresenterImpl: DetailsPresenter, AbstractBasePresenter<DetailsView>() {

    var mMovieModel : MovieModel = MovieModelImpl

    override fun onDetailsUiReady(lifecycleOwner: LifecycleOwner, id: Int) {

        requestMovieDetails(lifecycleOwner, id)
        requestActorList(lifecycleOwner)

    }

    override fun onTapBack() {
        mView?.goBackToMain()
    }

    override fun onTapFavMovie() {
        mView?.setFavMovie()
    }

    override fun onTapFavPeople() {
        mView?.setFavPeople()
    }



    private fun requestMovieDetails(lifecycleOwner: LifecycleOwner, id: Int){

        mMovieModel.getMovieById(id)
            .observe(lifecycleOwner, Observer {
                if (it!=null){

                    mView?.displayMovieDetails(it)
                    mView?.displayStoryline(it)
                    mView?.displayAboutFilm(it)

                }
            })
    }

    private fun requestActorList(lifecycleOwner: LifecycleOwner){
        mMovieModel.getBestActors(
            onError = { Log.e("error","Movie Error")}
        ).observe(lifecycleOwner, Observer {
                if (it.isNotEmpty()){
                    mView?.displayActors(it)
                    mView?.displayCreators(it)
                }
            })
    }
}