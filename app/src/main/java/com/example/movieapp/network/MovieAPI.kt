package com.example.movieapp.network

import com.example.movieapp.data.vos.MovieVO
import com.example.movieapp.network.responses.GetActorsResponse
import com.example.movieapp.network.responses.GetGenresListResponse
import com.example.movieapp.network.responses.GetMoviesResponse
import com.example.movieapp.utils.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieAPI {


    @GET(GET_POPULAR_MOVIES)
    fun getPopularMovies(@Query(API_KEY_PARAM) apiKey: String): Observable<GetMoviesResponse>

    @GET(GET_UPCOMING_MOVIES)
    fun getUpcomingMovies(@Query(API_KEY_PARAM)apiKey: String): Observable<GetMoviesResponse>

    @GET(GET_PLAYING_MOVIES)
    fun getNowPlayingMovies(@Query(API_KEY_PARAM)apiKey: String): Observable<GetMoviesResponse>

    @GET(GET_GENRES_LIST)
    fun getGenresList(@Query(API_KEY_PARAM) apiKey: String) : Observable<GetGenresListResponse>

    @GET("$GET_MOVIES/{GENRE_ID}")
    fun getMoviesByGenres(@Path("GENRE_ID") genreId: Int, @Query(API_KEY_PARAM) apiKey: String) : Observable<GetMoviesResponse>

    @GET(GET_MOVIES)
    fun getMovieList(@Query(API_KEY_PARAM) apiKey: String): Observable<GetMoviesResponse>

    @GET(GET_ACTORS)
    fun getPopularActors(@Query(API_KEY_PARAM) apiKey: String): Observable<GetActorsResponse>

    @GET("$GET_MOVIE_DETAILS/{MOVIE_ID}")
    fun getMovieDetails(@Path("MOVIE_ID") movieId: Int, @Query(API_KEY_PARAM) apiKey: String): Observable<MovieVO>




}