package com.example.rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rickandmorty.databinding.ActivityMainBinding
import com.example.rickandmorty.main.api.RetrofitClient
import com.example.rickandmorty.main.api.RickAndMortyAPI
import com.example.rickandmorty.main.models.character.CharacterApi
import com.example.rickandmorty.main.models.episode.EpisodeApi
import com.example.rickandmorty.main.models.location.LocationApi
import com.example.rickandmorty.main.ui.MainPresenter
import com.example.rickandmorty.main.ui.RickMortyView
import retrofit2.create
import timber.log.Timber

class MainActivity() : AppCompatActivity(), RickMortyView{
    private val api: RickAndMortyAPI = RetrofitClient.getRetrofit().create(RickAndMortyAPI::class.java)
    private val presenter: MainPresenter = MainPresenter(api)
    private val binding: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        presenter.attach(this)
        presenter.getCharacterData()
    }

    override fun showCharacterData(data: CharacterApi){
        Timber.i("character name" + data.results[0].name)
        Timber.i("gender " + data.results[0].gender)
        Timber.i("status" + data.results[0].status)
    }

    override fun showEpisodeData(data: EpisodeApi) {
        Timber.i("episode name " + data.resultsEpisode[0].name)
        Timber.i("episode" + data.resultsEpisode[0].episode)
    }

    override fun showLocationData(data: LocationApi) {
        Timber.i("location name " + data.results[0].name)
    }

    override fun onFail(throwable: Throwable) {
        Timber.e(throwable.cause.toString())
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }
}