package com.example.rickandmorty.main.api.model

import com.google.gson.annotations.SerializedName

data class CharacterApiResponse(
    @SerializedName("info")
    val info: InfoResponse,
    @SerializedName("results")
    val results: List<ResultsResponse>
)
