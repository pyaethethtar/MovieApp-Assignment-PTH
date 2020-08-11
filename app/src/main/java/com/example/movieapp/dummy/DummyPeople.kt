package com.example.movieapp.dummy

import android.app.Person
import com.example.movieapp.data.vos.PersonVO
import com.example.movieapp.utils.IMAGE_URL

fun getDummyPeople() : List<PersonVO>{

    val personOne = PersonVO()
    personOne.id = 1
    personOne.name = "Name of One"
    personOne.profilePath = IMAGE_URL+"/iEWtgDu0OweicGOl1rxybzCaota.jpg"

    val personTwo = PersonVO()
    personTwo.id = 2
    personTwo.name = "Name of Two"
    personTwo.profilePath = IMAGE_URL+"/fAcrRVZqLMVDVcgfvf7xmY7QRtY.jpg"

    val personThree = PersonVO()
    personThree.id = 3
    personThree.name = "Name of Three"
    personThree.profilePath = IMAGE_URL+"/p3wxUblbPwRVzTp7jW1lXISKIob.jpg"

    val personFour = PersonVO()
    personFour.id = 4
    personFour.name = "Name of Four"
    personFour.profilePath = IMAGE_URL+"/9u9PkuRWm8y8LLNroy5JMEG8orO.jpg"

    return arrayListOf(personOne, personTwo, personThree, personFour)
}