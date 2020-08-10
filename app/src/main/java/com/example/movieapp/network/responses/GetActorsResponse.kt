package com.example.movieapp.network.responses

import com.example.movieapp.data.vos.MovieVO
import com.example.movieapp.data.vos.PersonVO
import com.google.gson.annotations.SerializedName

data class GetActorsResponse(
    @SerializedName("page") val page: Int = 0,
    @SerializedName("total_results") val totalResults : Int = 0,
    @SerializedName("total_pages") val totalPages: Int = 0,
    @SerializedName("results") val results: ArrayList<PersonVO> ?= null
)