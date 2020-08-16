package com.example.movieapp.network.responses

import com.example.movieapp.data.vos.VideoVO
import com.google.gson.annotations.SerializedName

data class GetVideoResponse(

    @SerializedName("id")    var id : Int = 0,
   @SerializedName("results")   var results : ArrayList<VideoVO> = arrayListOf()
)