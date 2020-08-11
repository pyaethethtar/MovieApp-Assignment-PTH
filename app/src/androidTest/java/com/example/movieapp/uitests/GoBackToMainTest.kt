package com.example.movieapp.uitests

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.example.movieapp.R
import com.example.movieapp.activities.DetailsActivity
import com.example.movieapp.views.viewholders.MovieViewHolder
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class GoBackToMainTest {

    private val activityTestRule = ActivityTestRule<DetailsActivity>(DetailsActivity::class.java)



    @Before
    fun setUp(){
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun onTapBack_GoToMain(){
        Espresso.onView(ViewMatchers.withId(R.id.rvMovies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<MovieViewHolder>(0,
                ViewActions.click()
            ))
        Espresso.onView(ViewMatchers.withId(R.id.btnBack)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.tvDiscover)).check(matches(isDisplayed()))
    }


}