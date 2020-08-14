package com.example.movieapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
}
