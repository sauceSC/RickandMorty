package com.example.rickandmorty.main.repository.remote

import android.util.Log
import com.example.rickandmorty.main.api.RickMortyAPI
import com.example.rickandmorty.main.model.MainConverter
import com.example.rickandmorty.main.model.Results

class MainRemoteRepository(
    val api: RickMortyAPI
) : MainRepository {
    override suspend fun getResults(): List<Results> {
        val data = api.getCharacters()

        return MainConverter.fromNetwork(data)
    }


}