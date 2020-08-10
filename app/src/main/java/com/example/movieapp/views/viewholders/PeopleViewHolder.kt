package com.example.movieapp.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.movieapp.data.vos.PersonVO
import com.example.movieapp.delegates.PeopleDelegate
import com.example.movieapp.utils.IMAGE_URL
import kotlinx.android.synthetic.main.item_actor.view.*

class PeopleViewHolder(itemView: View, private val mDelegate: PeopleDelegate) : BaseViewHolder<PersonVO>(itemView) {

    init {
        itemView.btnFav.setOnClickListener {
            mDelegate.onTapFavPeople()
        }
        itemView.btnFavSelected.setOnClickListener {
            mDelegate.onTapFavPeople()
        }
    }


    override fun bindData(data: PersonVO) {

        Glide.with(itemView.context).load(IMAGE_URL+data.profilePath).into(itemView.ivActor)
        itemView.tvActorName.text = data.name
    }

}