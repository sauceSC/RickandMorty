package com.example.rickandmorty.main.api.model

import com.google.gson.annotations.SerializedName

data class InfoResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("next")
    val next: String?,
    @SerializedName("prev")
    val prev: String?
)
