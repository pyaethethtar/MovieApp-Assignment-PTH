package com.example.movieapp.activities

import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.adapters.TypeAdapter
import com.example.movieapp.data.vos.MovieVO
import com.example.movieapp.data.vos.PersonVO
import com.example.movieapp.mvp.presenters.DetailsPresenter
import com.example.movieapp.mvp.presenters.DetailsPresenterImpl
import com.example.movieapp.mvp.views.DetailsView
import com.example.movieapp.utils.IMAGE_URL
import com.example.movieapp.views.viewpods.AboutFilmViewpod
import com.example.movieapp.views.viewpods.PeopleViewpod
import com.example.movieapp.views.viewpods.StorylineViewpod
import com.example.shared.BaseActivity
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.viewpod_people.*
import kotlinx.android.synthetic.main.viewpod_people.view.*

class DetailsActivity : DetailsView, BaseActivity() {

    private lateinit var mPresenter: DetailsPresenter
    private lateinit var typeAdapter: TypeAdapter
    private lateinit var mStorylineViewpod: StorylineViewpod
    private lateinit var mActorsViewpod: PeopleViewpod
    private lateinit var mFilmViewpod: AboutFilmViewpod
    private lateinit var mCreatorsViewpod: PeopleViewpod
    private var movieId: Int = 0

    companion object{

        const val MOVIE_ID_EXTRA = "Movie Id Extra"
        fun newIntent(context: Context, id: Int): Intent{
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(MOVIE_ID_EXTRA, id)
            return intent
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        movieId = intent.getIntExtra(MOVIE_ID_EXTRA, 0)

        setUpPresenter()
        setUpTypeRecyclerview()
        setUpViewpodUI()
        setUpViewPods()
        setUpListener()
        mPresenter.onDetailsUiReady(this, movieId)
    }

    override fun goBackToMain() {
        this.finish()
    }

    override fun setFavMovie() {
        if (btnFavDetails.visibility==View.VISIBLE){
            btnFavDetails.visibility=View.INVISIBLE
            btnFavDetailsSelected.visibility=View.VISIBLE
        }
        else{
            btnFavDetails.visibility=View.VISIBLE
            btnFavDetailsSelected.visibility=View.GONE
        }
    }

    override fun setFavPeople() {
        mActorsViewpod.setFavMovie()
    }

    private fun setUpViewPods() {
        mStorylineViewpod = vpStroyline as StorylineViewpod

        mActorsViewpod = vpActors as PeopleViewpod
        mActorsViewpod.setDelegate(mPresenter)

        mFilmViewpod = vpAboutFilm as AboutFilmViewpod

        mCreatorsViewpod = vpCreators as PeopleViewpod
        mCreatorsViewpod.setDelegate(mPresenter)
    }


    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(DetailsPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpTypeRecyclerview() {

        val typeLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvTypes.layoutManager = typeLayoutManager

        typeAdapter = TypeAdapter()
        rvTypes.adapter = typeAdapter

    }

    private fun setUpViewpodUI() {

        vpActors.setBackgroundColor(resources.getColor(R.color.colorCardviewBackground))
        vpActors.btnMoreActors.text = ""
        vpActors.tvBestActors.text = "ACTORS"

        vpCreators.setBackgroundColor(resources.getColor(R.color.colorCardviewBackground))
        vpCreators.tvBestActors.text = "CREATORS"
        vpCreators.btnMoreActors.paintFlags = btnMoreActors.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        vpCreators.btnMoreActors.text = "More Creators"

    }

    private fun setUpListener(){
        btnBack.setOnClickListener {
            mPresenter.onTapBack()
        }

        btnFavDetails.setOnClickListener {
            mPresenter.onTapFavMovie()
        }

        btnFavDetailsSelected.setOnClickListener {
            mPresenter.onTapFavMovie()
        }

    }


    override fun displayMovieDetails(details: MovieVO) {

        Glide.with(this).load(IMAGE_URL+details.posterPath).into(ivAppbar)
        tvMovieName.text = details.originalTitle
        tvRateCount.text = details.voteAverage.toString()
        rbMovie.rating = details.voteAverage.toFloat()
        tvVotesCount.text = details.voteCount.toString()+" Votes"

        var hour = details.runtime?.div(60)
        var min = details.runtime?.rem(60)
        tvDuration.text = hour.toString()+"h "+min.toString()+"min"

        typeAdapter.setNewData(details.genres)
    }

    override fun displayStoryline(storyline: MovieVO) {
        mStorylineViewpod.displayStoryline(storyline)
    }

    override fun displayActors(actors: List<PersonVO>) {
        mActorsViewpod.displayBestActors(actors)
    }

    override fun displayAboutFilm(film: MovieVO) {
        mFilmViewpod.displayAboutFilm(film)
    }

    override fun displayCreators(creators: List<PersonVO>) {
        mCreatorsViewpod.displayBestActors(creators)
    }
}
