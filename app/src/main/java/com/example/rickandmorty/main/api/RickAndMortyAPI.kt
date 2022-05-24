package com.example.rickandmorty.main.api

import com.example.rickandmorty.main.api.model.CharacterApiResponse
import retrofit2.http.GET

interface RickAndMortyAPI {
    @GET("character")
    suspend fun getCharacters() : CharacterApiResponse
}