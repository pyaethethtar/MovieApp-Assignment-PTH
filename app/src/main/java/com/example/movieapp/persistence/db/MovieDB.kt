package com.example.movieapp.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movieapp.data.vos.GenresVO
import com.example.movieapp.data.vos.MovieVO
import com.example.movieapp.data.vos.PersonVO
import com.example.movieapp.persistence.daos.GenresDao
import com.example.movieapp.persistence.daos.MovieDao
import com.example.movieapp.persistence.daos.PersonDao

@Database(entities = [MovieVO::class, GenresVO::class, PersonVO::class], version = 9, exportSchema = false)
abstract class MovieDB : RoomDatabase(){

    companion object{

        val DB_NAME = "Movie_DB"
        var dbInstance:MovieDB?=null

        fun getDBInstance(context: Context):MovieDB{
            when(dbInstance){
                null -> {
                    dbInstance = Room.databaseBuilder(context, MovieDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            val i= dbInstance
            return i!!
        }
    }

    abstract fun movieDao() : MovieDao
    abstract fun genresDao() : GenresDao
    abstract fun personDao() : PersonDao
}