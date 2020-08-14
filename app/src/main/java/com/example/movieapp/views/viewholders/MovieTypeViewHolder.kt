package com.example.movieapp.views.viewholders

import android.view.View
import com.example.movieapp.data.vos.GenresVO
import com.example.movieapp.data.vos.MovieVO
import com.example.shared.BaseViewHolder
import kotlinx.android.synthetic.main.item_type.view.*

class MovieTypeViewHolder(itemView: View) : BaseViewHolder<GenresVO>(itemView) {

    override fun bindData(data: GenresVO) {
        itemView.tvType.text = data.name
    }

}