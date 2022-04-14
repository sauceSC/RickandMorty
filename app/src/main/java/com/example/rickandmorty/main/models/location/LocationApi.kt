package com.example.rickandmorty.main.models.location

import com.google.gson.annotations.SerializedName

data class LocationApi(
    @SerializedName("info")
    val infoLocation: InfoLocation,
    @SerializedName("results")
    val results: List<ResultsLocation>
)
