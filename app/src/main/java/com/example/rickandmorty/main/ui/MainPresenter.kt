package com.example.rickandmorty.main.ui

import com.example.rickandmorty.main.api.RickAndMortyAPI
import com.example.rickandmorty.main.models.character.CharacterApi
import com.example.rickandmorty.main.models.episode.EpisodeApi
import com.example.rickandmorty.main.models.location.LocationApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(private val rickMorty: RickAndMortyAPI) {
    private var rickMortyView: RickMortyView? = null

    fun attach(view: RickMortyView){
        rickMortyView = view
    }

    fun detach() {
        rickMortyView = null
    }

    fun getCharacterData() {
        rickMorty.getCharacters().enqueue(object : Callback<CharacterApi> {
            override fun onFailure(call: Call<CharacterApi>, throwable: Throwable) {
                rickMortyView?.onFail(throwable)
            }

            override fun onResponse(call: Call<CharacterApi>, response: Response<CharacterApi>) {
                if (response.isSuccessful && response.body() != null) {
                    val data = response.body()!!
                    rickMortyView?.showCharacterData(data)
                }
            }
        }
        )
    }

    fun getLocationData(){
        rickMorty.getLocation().enqueue(object : Callback<LocationApi>{
            override fun onFailure(call: Call<LocationApi>, throwable: Throwable) {
                rickMortyView?.onFail(throwable)
            }

            override fun onResponse(call: Call<LocationApi>, response: Response<LocationApi>) {
                if (response.isSuccessful && response.body() != null) {
                    val data = response.body()!!
                    rickMortyView?.showLocationData(data)
                }
            }
        })
    }

    fun getEpisodeData(){
        rickMorty.getEpisode().enqueue(object : Callback<EpisodeApi>{
            override fun onFailure(call: Call<EpisodeApi>, throwable: Throwable) {
                rickMortyView?.onFail(throwable)
            }

            override fun onResponse(call: Call<EpisodeApi>, response: Response<EpisodeApi>) {
                if (response.isSuccessful && response.body() != null) {
                    val data = response.body()!!
                    rickMortyView?.showEpisodeData(data)
                }
            }
        })
    }
}