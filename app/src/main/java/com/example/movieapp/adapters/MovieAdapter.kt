package com.example.movieapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.movieapp.R
import com.example.movieapp.data.vos.MovieVO
import com.example.movieapp.delegates.MoviesDelegate
import com.example.movieapp.views.viewholders.MovieViewHolder
import com.example.shared.BaseAdapter
import com.example.shared.BaseViewHolder

class MovieAdapter(delegate: MoviesDelegate): BaseAdapter<BaseViewHolder<MovieVO>, MovieVO>() {

    private val mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<MovieVO> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view, mDelegate)
    }



}