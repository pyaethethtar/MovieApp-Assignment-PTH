package com.example.movieapp.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.example.movieapp.data.vos.MovieVO
import kotlinx.android.synthetic.main.viewpod_storyline.view.*

class StorylineViewpod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {




    fun displayStoryline(movie: MovieVO){
        tvStoryline.text = movie.overview
    }

}