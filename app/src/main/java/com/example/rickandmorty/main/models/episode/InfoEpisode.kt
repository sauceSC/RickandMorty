package com.example.rickandmorty.main.models.episode

import com.google.gson.annotations.SerializedName

data class InfoEpisode(

    @SerializedName("count")
    val count: Int,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("prev")
    val prev: String
)
