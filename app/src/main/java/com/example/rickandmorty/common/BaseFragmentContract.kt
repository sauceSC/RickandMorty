package com.example.rickandmorty.common

import androidx.annotation.AnimRes

interface BaseFragmentContract {
    fun overrideEnterAnimation(@AnimRes animation: Int)
    fun overrideExitAnimation(@AnimRes animation: Int)
}