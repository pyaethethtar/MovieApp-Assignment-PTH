package com.example.movieapp.mvp.views

import com.example.movieapp.data.vos.MovieVO
import com.example.movieapp.data.vos.PersonVO

interface DetailsView : BaseView{

    fun displayMovieDetails(details: MovieVO)
    fun displayStoryline(storyline: MovieVO)
    fun displayActors(actors: List<PersonVO>)
    fun displayAboutFilm(film: MovieVO)
    fun displayCreators(creators: List<PersonVO>)
    fun goBackToMain()
    fun setFavMovie()
}