package com.example.movieapp.dummy

import android.graphics.Movie
import com.example.movieapp.data.vos.MovieVO
import com.example.movieapp.utils.IMAGE_URL

fun getDummyMovies() : List<MovieVO>{

    val movieOne = MovieVO()
    movieOne.id = 1
    movieOne.title="Title 1"
    movieOne.originalTitle = "Original Title 1"
    movieOne.posterPath = IMAGE_URL+"/mb7wQv0adK3kjOUr9n93mANHhPJ.jpg"
    movieOne.genres = getDummyGenres()
    movieOne.genreIds = arrayListOf(1, 2, 3)

    val movieTwo = MovieVO()
    movieTwo.id = 1
    movieTwo.title="Title w"
    movieTwo.originalTitle = "Original Title 2"
    movieTwo.posterPath = IMAGE_URL+"/mb7wQv0adK3kjOUr9n93mANHhPJ.jpg"
    movieTwo.genres = getDummyGenres()
    movieOne.genreIds = arrayListOf(4, 2, 3)

    val movieThree = MovieVO()
    movieThree.id = 1
    movieThree.title="Title 3"
    movieThree.originalTitle = "Original Title 3"
    movieThree.posterPath = IMAGE_URL+"/vFIHbiy55smzi50RmF8LQjmpGcx.jpg"
    movieThree.genres = getDummyGenres()
    movieOne.genreIds = arrayListOf(2, 3)

    val movieFour = MovieVO()
    movieFour.id = 1
    movieFour.title="Title 4"
    movieFour.originalTitle = "Original Title 4"
    movieFour.posterPath = IMAGE_URL+"/bKthjUmxjHjvJK8FktFfQdmwP12.jpg"
    movieFour.genres = getDummyGenres()
    movieOne.genreIds = arrayListOf(1, 4, 3)

    return arrayListOf(movieOne, movieTwo, movieThree, movieFour)
}