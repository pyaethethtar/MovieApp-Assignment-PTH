package com.example.movieapp.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.movieapp.delegates.MoviesDelegate
import com.example.movieapp.delegates.PeopleDelegate
import com.example.movieapp.mvp.views.MainView
import com.example.shared.BasePresenter

interface MainPresenter : BasePresenter<MainView>, MoviesDelegate, PeopleDelegate{

    fun onUiReady(lifecycleOwner: LifecycleOwner)

}