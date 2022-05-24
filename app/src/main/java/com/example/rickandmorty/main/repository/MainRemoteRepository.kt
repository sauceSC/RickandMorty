package com.example.rickandmorty.main.repository

import android.util.Log
import com.example.rickandmorty.main.api.RickAndMortyAPI
import com.example.rickandmorty.main.model.MainConverter
import com.example.rickandmorty.main.model.Results

class MainRemoteRepository(
    val api: RickAndMortyAPI
) : MainRepository {
    override suspend fun getResults(): List<Results> {
        val data = api.getCharacters()
        Log.i("###", "RemoteRep")

        return MainConverter.fromNetwork(data)
    }


}