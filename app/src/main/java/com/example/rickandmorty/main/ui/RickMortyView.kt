package com.example.rickandmorty.main.ui

import com.example.rickandmorty.common.BaseFragmentContract
import com.example.rickandmorty.common.MvpPresenter
import com.example.rickandmorty.common.MvpView
import com.example.rickandmorty.main.model.Results

interface RickMortyView : BaseFragmentContract {
    interface View : MvpView {
        fun showHeroList(results: List<Results>)
        fun onFail(throwable: Throwable)
    }

    interface Presenter : MvpPresenter<View> {
        fun getCharacterList()
    }


}