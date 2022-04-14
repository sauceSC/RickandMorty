package com.example.rickandmorty.main.api

import com.example.rickandmorty.main.models.character.CharacterApi
import com.example.rickandmorty.main.models.episode.EpisodeApi
import com.example.rickandmorty.main.models.location.LocationApi
import retrofit2.Call
import retrofit2.http.GET

interface RickAndMortyAPI {
    @GET("character")
    fun getCharacters():Call<CharacterApi>

    @GET("location")
    fun getLocation():Call<LocationApi>

    @GET("episode")
    fun getEpisode():Call<EpisodeApi>
}