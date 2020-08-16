package com.example.movieapp.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.RelativeLayout
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.adapters.MovieAdapter
import com.example.movieapp.data.vos.GenresVO
import com.example.movieapp.data.vos.MovieVO
import com.example.movieapp.delegates.MoviesDelegate
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.item_movie.view.*
import kotlinx.android.synthetic.main.viewpod_movie_types.view.*

class MovieTypesViewpod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private lateinit var mDelegate : MoviesDelegate
    private lateinit var mLifecycleOwner: LifecycleOwner
    lateinit var movieAdapter : MovieAdapter
    var genreIdList : MutableList<Int> = mutableListOf()
    var genreId: Int = 12



    override fun onFinishInflate() {
        super.onFinishInflate()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {

                genreId = genreIdList.getOrElse(tabLayout.selectedTabPosition, {12})
                mDelegate.onTabGenre(mLifecycleOwner, genreId)
                //Log.e("result", genreId.toString())

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

    }



    private fun setUpRecyclerView() {
        val movieLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvGenreMovies.layoutManager= movieLayoutManager

        movieAdapter= MovieAdapter(mDelegate)
        rvGenreMovies.adapter=movieAdapter
    }

    fun setDelegateAndLifecycleOwner(delegate: MoviesDelegate, lifecycleOwner: LifecycleOwner){
        mDelegate = delegate
        mLifecycleOwner = lifecycleOwner

        setUpRecyclerView()
    }

    fun displayMoviesByGenres(movies: List<MovieVO>) {
        vpEmpty.visibility= View.GONE
        rvGenreMovies.visibility= View.VISIBLE
        movieAdapter.setNewData(movies)
    }

    fun displayGenresList(genres: List<GenresVO>){
        for (i in 0 until genres.size){
            tabLayout.addTab(tabLayout.newTab().setText(genres[i].name))
            genreIdList.add(genres[i].id)
        }
    }

    fun displayEmptyViewpod(){
        rvGenreMovies.visibility= View.GONE
        vpEmpty.visibility= View.VISIBLE
    }








}