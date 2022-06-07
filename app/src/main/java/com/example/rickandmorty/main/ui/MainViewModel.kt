package com.example.rickandmorty.main.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.main.interactor.MainInteractor
import com.example.rickandmorty.main.model.Results
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel (private val interactor: MainInteractor) : ViewModel(){
    val listLiveData = MutableLiveData<List<Results>>()

    init {
        viewModelScope.launch {
            interactor.getHeroesFromDb().collect { list ->
                listLiveData.value = list
            }
        }
    }

    fun loadRickMorty() = viewModelScope.launch {
        try {
            interactor.loadHeroes()
        } catch (throwable: Throwable) {
            Log.e("###", "Error process in loadDataHeroes() ", throwable)
        }
    }
}