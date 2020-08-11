package com.example.movieapp.instrumentationtests

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.movieapp.data.vos.GenresVO
import com.example.movieapp.data.vos.MovieVO
import com.example.movieapp.data.vos.PersonVO
import com.example.movieapp.dummy.getDummyGenres
import com.example.movieapp.dummy.getDummyMovies
import com.example.movieapp.dummy.getDummyPeople
import com.example.movieapp.persistence.daos.GenresDao
import com.example.movieapp.persistence.daos.MovieDao
import com.example.movieapp.persistence.daos.PersonDao
import com.example.movieapp.persistence.db.MovieDB
import com.example.movieapp.utils.IMAGE_URL
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DatabaseTest {

    private lateinit var db: MovieDB
    private lateinit var movieDao: MovieDao
    private lateinit var genresDao: GenresDao
    private lateinit var personDao: PersonDao

    @Before
    fun createDB(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, MovieDB::class.java).build()
        movieDao = db.movieDao()
        genresDao = db.genresDao()
        personDao = db.personDao()
    }

    @After
    fun closeDB(){
        db.close()
    }

    @Test
    fun insertIntoDatabaseTest(){
        val movieOne = MovieVO()
        movieOne.id = 1
        movieOne.title="Title 1"
        movieOne.originalTitle = "Original Title 1"
        movieOne.posterPath = IMAGE_URL +"/mb7wQv0adK3kjOUr9n93mANHhPJ.jpg"

        val genresOne = GenresVO()
        genresOne.id = 1
        genresOne.name = "Action"

        val personOne = PersonVO()
        personOne.id = 1
        personOne.name = "Name of One"
        personOne.profilePath = IMAGE_URL+"/iEWtgDu0OweicGOl1rxybzCaota.jpg"


        movieDao.insertMovie(movieOne)
        genresDao.insertGenresList(getDummyGenres())
        personDao.insertAllPeople(getDummyPeople())

        assert(movieDao.getMovieById(movieOne.id).value?.id==movieOne.id)
        assert(genresDao.getGenresById(genresOne.id).value?.id==genresOne.id)
        assert(personDao.getActorById(personOne.id).value?.id==personOne.id)
    }


}