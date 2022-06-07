package com.example.rickandmorty.main.interactor

import com.example.rickandmorty.main.model.Results
import com.example.rickandmorty.main.repository.local.MainLocalRepository
import com.example.rickandmorty.main.repository.remote.MainRemoteRepository
import kotlinx.coroutines.flow.Flow

class MainInteractor(
    private val remoteRep : MainRemoteRepository,
    private val localRep: MainLocalRepository
) {
    suspend fun getHeroesFromDb(): Flow<List<Results>> {
        return localRep.getHeroes()
    }

    suspend fun loadHeroes() {
        val heroes = remoteRep.getResults()
        localRep.insertHeroesToDb(heroes)
    }
}