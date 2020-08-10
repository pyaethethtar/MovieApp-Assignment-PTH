package com.example.movieapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.movieapp.R
import com.example.movieapp.data.vos.GenresVO
import com.example.movieapp.data.vos.MovieVO
import com.example.movieapp.views.viewholders.BaseViewHolder
import com.example.movieapp.views.viewholders.MovieTypeViewHolder

class TypeAdapter : BaseAdapter<BaseViewHolder<GenresVO>, GenresVO>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<GenresVO> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_type, parent, false)
        return MovieTypeViewHolder(view)

    }
}