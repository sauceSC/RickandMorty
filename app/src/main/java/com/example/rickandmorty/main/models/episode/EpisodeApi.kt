package com.example.rickandmorty.main.models.episode

import com.google.gson.annotations.SerializedName

data class EpisodeApi(
    @SerializedName("info")
    val infoEpisode: InfoEpisode,
    @SerializedName("results")
    val resultsEpisode: List<ResultsEpisode>
)
