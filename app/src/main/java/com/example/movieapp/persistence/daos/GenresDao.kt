package com.example.movieapp.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.movieapp.data.vos.GenresVO

@Dao
interface GenresDao {

    @Query("SELECT * FROM genres")
    fun getGenresList() : LiveData<List<GenresVO>>

    @Insert
    fun insertGenresList(genres : List<GenresVO>)

}