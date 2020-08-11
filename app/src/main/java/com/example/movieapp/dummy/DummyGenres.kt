package com.example.movieapp.dummy

import com.example.movieapp.data.vos.GenresVO

fun getDummyGenres(): ArrayList<GenresVO>{

    val genresOne = GenresVO()
    genresOne.id = 1
    genresOne.name = "Action"

    val genresTwo = GenresVO()
    genresTwo.id = 2
    genresTwo.name = "Drama"

    val genresThree = GenresVO()
    genresThree.id = 3
    genresThree.name = "Comedy"

    val genresFour = GenresVO()
    genresFour.id = 4
    genresFour.name = "Horror"

    return arrayListOf(genresOne, genresTwo, genresThree, genresFour)

}