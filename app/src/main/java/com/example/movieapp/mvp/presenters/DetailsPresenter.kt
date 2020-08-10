package com.example.movieapp.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.movieapp.delegates.PeopleDelegate
import com.example.movieapp.mvp.views.DetailsView

interface DetailsPresenter : BasePresenter<DetailsView>, PeopleDelegate{

    fun onDetailsUiReady(lifecycleOwner: LifecycleOwner, id: Int)
    fun onTapBack()
    fun onTapFavMovie()
}