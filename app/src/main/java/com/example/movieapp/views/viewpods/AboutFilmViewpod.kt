package com.example.movieapp.views.viewpods

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.core.content.res.TypedArrayUtils.getText
import com.example.movieapp.R
import com.example.movieapp.data.vos.CountryVO
import com.example.movieapp.data.vos.MovieVO
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.viewpod_about_film.view.*

class AboutFilmViewpod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    override fun onFinishInflate() {
        super.onFinishInflate()




    }

    fun displayAboutFilm(movie: MovieVO){

        var type: String = ""
        var production = ""


        for (genre in movie.genres){
            type = type+genre.name+", "
        }
        for (country in movie.productionCountries){
            production = production+country.name+" "
        }

        tvOriginalTitle.text = movie.originalTitle
        tvPremiere.text = movie.releaseDate
        tvDescription.text = movie.overview
        tvProduction.text = production
        tvType.text = type


    }
}