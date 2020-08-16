package com.example.movieapp.dummy

import com.example.movieapp.data.vos.VideoVO

fun getDummyVideos() : List<VideoVO>{

    val videoOne = VideoVO()
    videoOne.id = "abc"
    videoOne.key ="bu9e410C__I"

    val videoTwo = VideoVO()
    videoTwo.id = "def"
    videoTwo.key ="W_vJhUAOFpI"

    return arrayListOf(videoOne, videoTwo)

}