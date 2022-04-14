package com.example.rickandmorty.main.ui

import com.example.rickandmorty.main.models.character.CharacterApi
import com.example.rickandmorty.main.models.episode.EpisodeApi
import com.example.rickandmorty.main.models.location.LocationApi

interface RickMortyView {
    fun showCharacterData(data: CharacterApi)
    fun showLocationData(data: LocationApi)
    fun showEpisodeData(data: EpisodeApi)
    fun onFail(throwable: Throwable)
}