package com.example.rickandmorty.main.ui

import android.util.Log
import com.example.rickandmorty.common.BasePresenter
import com.example.rickandmorty.main.interactor.MainInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class MainPresenter(
    private val interactor: MainInteractor
) : BasePresenter<RickMortyView.View>(),
    RickMortyView.Presenter{

    private val presenterScope = CoroutineScope(Dispatchers.Main.immediate)

    override fun getCharacterList() {
        presenterScope.launch {
            try {
                Log.i("###", "presenter")
                val data = interactor.getResults()
                view?.showHeroList(data)
            } catch (t: Throwable) {
                Log.i("###", "onfailed")
                Timber.e(t.message)
            }
        }
    }
}