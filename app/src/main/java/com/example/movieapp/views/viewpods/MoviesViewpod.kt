package com.example.movieapp.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.movieapp.adapters.MovieAdapter
import com.example.movieapp.data.vos.MovieVO
import com.example.movieapp.delegates.MoviesDelegate
import kotlinx.android.synthetic.main.activity_details.view.*
import kotlinx.android.synthetic.main.item_movie.view.*
import kotlinx.android.synthetic.main.viewpod_movies.view.*

class MoviesViewpod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private lateinit var mDelegate : MoviesDelegate
    lateinit var movieAdapter : MovieAdapter



    override fun onFinishInflate() {
        super.onFinishInflate()

        //setUpRecyclerView()
    }



    private fun setUpRecyclerView() {
        val movieLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvMovies.layoutManager= movieLayoutManager

        movieAdapter= MovieAdapter(mDelegate)
        rvMovies.adapter=movieAdapter
    }

    fun displayPopularMovies(movies: List<MovieVO>) {
       movieAdapter.setNewData(movies.toMutableList())
    }

    fun setDelegate(delegate: MoviesDelegate){
        mDelegate = delegate

        setUpRecyclerView()
    }








}

