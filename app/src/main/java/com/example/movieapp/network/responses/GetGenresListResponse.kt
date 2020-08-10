package com.example.movieapp.network.responses

import com.example.movieapp.data.vos.GenresVO
import com.google.gson.annotations.SerializedName

data class GetGenresListResponse (

   @SerializedName("genres") val genres: ArrayList<GenresVO> ?= null
)