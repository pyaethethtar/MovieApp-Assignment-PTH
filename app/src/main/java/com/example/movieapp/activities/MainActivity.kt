package com.example.movieapp.activities


import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.movieapp.R
import com.example.movieapp.data.vos.GenresVO
import com.example.movieapp.data.vos.MovieVO
import com.example.movieapp.data.vos.PersonVO
import com.example.movieapp.mvp.presenters.MainPresenter
import com.example.movieapp.mvp.presenters.MainPresenterImpl
import com.example.movieapp.mvp.views.MainView
import com.example.movieapp.views.viewpods.*
import com.example.shared.BaseActivity
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MainView, BaseActivity(){


    private lateinit var mPresenter : MainPresenter
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    lateinit var mPopularMoviesViewpod: MoviesViewpod
    lateinit var mMovieTypesViewpod: MovieTypesViewpod
    lateinit var mShowcasesViewpod: ShowcaseViewpod
    lateinit var mPeopleViewpod: PeopleViewpod
    lateinit var mSliderViewpod: SliderViewpod



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setUpPresenterAndViewPods()
        mPresenter.onUiReady(this)


    }


    private fun setUpPresenterAndViewPods() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)

        mPopularMoviesViewpod = vpPopularFilms as MoviesViewpod
        mPopularMoviesViewpod.setDelegate(mPresenter)

        mMovieTypesViewpod = vpMovieTypes as MovieTypesViewpod
        mMovieTypesViewpod.setDelegateAndLifecycleOwner(mPresenter, this)

        mShowcasesViewpod = vpShowcases as ShowcaseViewpod

        mPeopleViewpod = vpActors as PeopleViewpod
        mPeopleViewpod.setDelegate(mPresenter)

        mSliderViewpod = vpSlider as SliderViewpod

    }



    override fun displayPopularMovies(popularMovies: List<MovieVO>) {

        mPopularMoviesViewpod.displayPopularMovies(popularMovies)
    }

    override fun displayGenresList(genres: List<GenresVO>) {
        mMovieTypesViewpod.displayGenresList(genres)
    }

    override fun displayMoviesByGenres(movies: List<MovieVO>) {
        mMovieTypesViewpod.displayMoviesByGenres(movies)
    }

    override fun displayShowcases(showcases: List<MovieVO>) {
        mShowcasesViewpod.displayShowcases(showcases)
    }

    override fun displayBestActors(actors: List<PersonVO>) {
        mPeopleViewpod.displayBestActors(actors)
    }

    override fun navigateToMovieDetails(id: Int) {

        startActivity(DetailsActivity.newIntent(this, id))
    }

    override fun displaySliderImages(movies: List<MovieVO>) {
        mSliderViewpod.displaySliderImages(movies)
    }

    override fun displayEmptyViewpod() {
        mMovieTypesViewpod.displayEmptyViewpod()
    }

    override fun setFavPeople() {
        mPeopleViewpod.setFavMovie()
    }


    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }






}
