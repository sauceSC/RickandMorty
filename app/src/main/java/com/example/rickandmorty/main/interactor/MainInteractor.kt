package com.example.rickandmorty.main.interactor

import android.util.Log
import com.example.rickandmorty.main.model.MainConverter
import com.example.rickandmorty.main.model.Results
import com.example.rickandmorty.main.repository.MainRemoteRepository

class MainInteractor(
    private val remoteRep : MainRemoteRepository
) {
    suspend fun getResults() :List<Results>{
        remoteRep.getResults()
        return remoteRep.getResults()
    }
}