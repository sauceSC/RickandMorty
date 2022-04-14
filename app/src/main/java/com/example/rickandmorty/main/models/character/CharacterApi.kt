package com.example.rickandmorty.main.models.character

import com.google.gson.annotations.SerializedName

data class CharacterApi(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Results>
)
