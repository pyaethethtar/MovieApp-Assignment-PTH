package com.example.movieapp.mvp.presenters

import androidx.lifecycle.ViewModel
import com.example.movieapp.mvp.views.BaseView

abstract class AbstractBasePresenter<T: BaseView>: BasePresenter<T>, ViewModel() {

    var mView: T ?= null
    override fun initPresenter(view: T) {
        mView = view
    }
}