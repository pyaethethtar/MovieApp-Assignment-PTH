package com.example.movieapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.movieapp.R
import com.example.movieapp.data.vos.MovieVO
import com.example.movieapp.data.vos.PersonVO
import com.example.movieapp.delegates.PeopleDelegate
import com.example.movieapp.views.viewholders.BaseViewHolder
import com.example.movieapp.views.viewholders.PeopleViewHolder

class PeopleAdapter(private val mDelegate: PeopleDelegate): BaseAdapter<BaseViewHolder<PersonVO>, PersonVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<PersonVO>{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_actor, parent, false)
        return PeopleViewHolder(view, mDelegate)
    }
}