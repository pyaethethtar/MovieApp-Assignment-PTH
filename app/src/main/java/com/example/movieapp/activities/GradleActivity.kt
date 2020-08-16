package com.example.movieapp.activities


import android.os.Bundle
import android.view.View
import com.example.movieapp.BuildConfig
import com.example.movieapp.R
import com.example.shared.BaseActivity
import kotlinx.android.synthetic.main.activity_gradle.*

class GradleActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gradle)

        tvSensitiveData.text = BuildConfig.MY_ACCOUNT
        tvBaseUrl.text = BuildConfig.BASE_URL_FIELD




    }


    fun showSensitiveData(){
        tvSensitiveData.visibility = View.VISIBLE
    }
    fun hideSensitiveData(){
        tvSensitiveData.visibility = View.GONE
    }



}
