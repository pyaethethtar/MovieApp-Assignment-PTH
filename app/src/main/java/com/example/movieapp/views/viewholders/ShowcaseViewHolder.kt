package com.example.movieapp.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.movieapp.data.vos.MovieVO
import com.example.movieapp.utils.IMAGE_URL
import kotlinx.android.synthetic.main.item_showcase.view.*

class ShowcaseViewHolder(itemView: View) : BaseViewHolder<MovieVO>(itemView) {


    override fun bindData(data: MovieVO) {

        itemView.tvShowcaseName.text = data.title
        itemView.tvShowcaseDate.text = data.releaseDate
        Glide.with(itemView.context).load(IMAGE_URL+data.backDropPath).into(itemView.ivShowcase)
    }


}