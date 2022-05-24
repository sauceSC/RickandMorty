package com.example.rickandmorty.main.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Origin(
    val name: String,
    val url:String
) : Parcelable
