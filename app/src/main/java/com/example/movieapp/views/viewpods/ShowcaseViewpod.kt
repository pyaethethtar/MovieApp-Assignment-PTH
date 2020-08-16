package com.example.movieapp.views.viewpods

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.adapters.ShowcaseAdapter
import com.example.movieapp.data.vos.MovieVO
import com.example.movieapp.delegates.MoviesDelegate
import kotlinx.android.synthetic.main.viewpod_showcases.view.*

class ShowcaseViewpod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private lateinit var showcaseAdapter: ShowcaseAdapter
    private lateinit var mDelegate : MoviesDelegate

    override fun onFinishInflate() {
        super.onFinishInflate()
        //setUpShowcaseRecyclerView()

        btnMoreShowcases.paintFlags = btnMoreShowcases.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        btnMoreShowcases.text = context.getText(R.string.btn_more_showcases)
    }

    private fun setUpShowcaseRecyclerView() {

        val showcaseLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvShowcases.layoutManager = showcaseLayoutManager

        showcaseAdapter = ShowcaseAdapter(mDelegate)
        rvShowcases.adapter = showcaseAdapter
    }

    fun displayShowcases(showcases: List<MovieVO>){
        showcaseAdapter.setNewData(showcases)
    }

    fun setDelegate(delegate: MoviesDelegate){
        mDelegate = delegate

        setUpShowcaseRecyclerView()
    }

}