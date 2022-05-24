package com.example.rickandmorty.common


interface MvpPresenter<V : MvpView> {
    fun attach(view: V)
    fun detach()
}