package com.example.movieapp.data.model

import android.content.Context
import com.example.movieapp.BuildConfig
import com.example.movieapp.network.MovieAPI
import com.example.movieapp.persistence.db.MovieDB
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel {

    protected var mMovieApi : MovieAPI
    protected lateinit var mTheDB: MovieDB
    var baseUrl = BuildConfig.BASE_URL

    init {
        val mOkHttpClient= OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit= Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(mOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        mMovieApi =retrofit.create(MovieAPI::class.java)
    }

    fun initDatabase(context: Context) {
        mTheDB = MovieDB.getDBInstance(context)
    }
}