package com.example.movieapp.views.viewpods

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.example.movieapp.R
import kotlinx.android.synthetic.main.viewpod_location.view.*

class LocationViewpod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    override fun onFinishInflate() {
        super.onFinishInflate()

        btnSeeMore.paintFlags = btnSeeMore.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        btnSeeMore.text = context.getString(R.string.btn_see_more)
    }

}