package com.example.movieapp.data.model

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.movieapp.data.vos.GenresVO
import com.example.movieapp.data.vos.MovieVO
import com.example.movieapp.data.vos.PersonVO
import com.example.movieapp.utils.API_KEY
import com.example.movieapp.utils.EM_NO_INTERNET_CONNECTION
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object MovieModelImpl: MovieModel, BaseModel() {



    @SuppressLint("CheckResult")
    override fun getMoviesFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mMovieApi.getPopularMovies(API_KEY)
            .map { it.results?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                mTheDB.movieDao().insertAllMovies(it)
            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })

        mMovieApi.getUpcomingMovies(API_KEY)
            .map { it.results?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.movieDao().insertAllMovies(it)
            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })

        mMovieApi.getNowPlayingMovies(API_KEY)
            .map { it.results?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.movieDao().insertAllMovies(it)
            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })

        mMovieApi.getGenresList(API_KEY)
            .map { it.genres?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.genresDao().insertGenresList(it)
            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })

//        mMovieApi.getMovieList(API_KEY)
//            .map { it.results?.toList() ?: listOf() }
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//               mTheDB.movieDao().insertAllMovies(it)
//            }, {
//                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
//            })

        mMovieApi.getPopularActors(API_KEY)
            .map { it.results?.toList() ?: listOf()}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.personDao().insertAllPeople(it)
            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getPopularMovies(onError: (String) -> Unit): LiveData<List<MovieVO>> {
        return mTheDB.movieDao().getPopularMovies()
    }




    @SuppressLint("CheckResult")
    override fun getMovieById(id: Int): LiveData<MovieVO> {

        mMovieApi.getMovieDetails(id, API_KEY)
            .subscribeOn(Schedulers.io())
            .subscribe({

                mTheDB.movieDao().insertMovie(it)
            },{
                Log.e("error", it.localizedMessage)
            })

        return mTheDB.movieDao().getMovieById(id)
    }

    override fun getGenresList(): LiveData<List<GenresVO>> {
        return mTheDB.genresDao().getGenresList()
    }

    @SuppressLint("CheckResult")
    override fun getMoviesByGenres(genreId: Int): LiveData<List<MovieVO>> {


        mMovieApi.getMoviesByGenres(genreId, API_KEY)
            .map { it.results?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.movieDao().insertAllMovies(it)
            }, {

            })
        return mTheDB.movieDao().getMoviesByGenre()
    }

//    override fun getMovieList(onError: (String) -> Unit): LiveData<List<MovieVO>> {
//        return mTheDB.movieDao().getMovieList()
//    }

    override fun getBestActors(onError: (String) -> Unit): LiveData<List<PersonVO>> {
        return mTheDB.personDao().getActorList()
    }

    override fun getUpcomingMovies(onError: (String) -> Unit): LiveData<List<MovieVO>> {
        return mTheDB.movieDao().getUpcomingMovies()
    }

    override fun getNowPlayingMovies(onError: (String) -> Unit): LiveData<List<MovieVO>> {
        return mTheDB.movieDao().getNowPlayingMovies()
    }

}