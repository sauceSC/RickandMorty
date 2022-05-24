package com.example.rickandmorty.main.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class CharacterApi(
    val info: Info,
    val results: List<Results>
) : Parcelable
