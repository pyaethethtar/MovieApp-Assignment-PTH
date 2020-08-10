package com.example.movieapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.data.vos.MovieVO
import com.example.movieapp.views.viewholders.BaseViewHolder
import com.example.movieapp.views.viewholders.ShowcaseViewHolder

class ShowcaseAdapter: BaseAdapter<BaseViewHolder<MovieVO>, MovieVO>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<MovieVO> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_showcase, parent, false)
        return ShowcaseViewHolder(view)
    }


}