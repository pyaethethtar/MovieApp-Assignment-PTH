package com.example.movieapp.mvp.presenters

import com.example.movieapp.mvp.views.BaseView

interface BasePresenter<T: BaseView> {

    fun initPresenter(view: T)
}