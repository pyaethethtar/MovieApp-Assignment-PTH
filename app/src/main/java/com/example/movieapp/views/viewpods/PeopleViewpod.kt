package com.example.movieapp.views.viewpods

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.adapters.PeopleAdapter
import com.example.movieapp.data.vos.PersonVO
import com.example.movieapp.delegates.MoviesDelegate
import com.example.movieapp.delegates.PeopleDelegate
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.item_actor.*
import kotlinx.android.synthetic.main.item_actor.view.*
import kotlinx.android.synthetic.main.viewpod_people.view.*

class PeopleViewpod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    lateinit var peopleAdapter: PeopleAdapter
    lateinit var mDelegate: PeopleDelegate

    override fun onFinishInflate() {
        super.onFinishInflate()


        btnMoreActors.paintFlags = btnMoreActors.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        btnMoreActors.text = context.getString(R.string.btn_more_actors)


    }

    private fun setUpRecyclerView() {
        val peopleLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvPeople.layoutManager= peopleLayoutManager

        peopleAdapter = PeopleAdapter(mDelegate)
        rvPeople.adapter = peopleAdapter
    }

    fun displayBestActors(actors: List<PersonVO>){
        peopleAdapter.setNewData(actors)


    }

    fun setDelegate(delegate: PeopleDelegate){
        mDelegate = delegate

        setUpRecyclerView()
    }

    fun setFavMovie(){
        if (btnFav.visibility== View.VISIBLE){
            btnFav.visibility= View.GONE
            btnFavSelected.visibility= View.VISIBLE
        }
        else{
            btnFav.visibility= View.VISIBLE
            btnFavSelected.visibility= View.GONE
        }
    }










}