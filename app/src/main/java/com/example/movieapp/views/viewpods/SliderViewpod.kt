package com.example.movieapp.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.example.movieapp.adapters.SliderAdapter
import com.example.movieapp.data.vos.MovieVO
import kotlinx.android.synthetic.main.viewpod_slider.view.*

class SliderViewpod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private lateinit var mSliderAdapter : SliderAdapter

    override fun onFinishInflate() {
        super.onFinishInflate()
        mSliderAdapter = SliderAdapter()
        sliderview.setSliderAdapter(mSliderAdapter)
    }

    fun displaySliderImages(movies: List<MovieVO>){
        mSliderAdapter.setNewData(movies)
    }
}