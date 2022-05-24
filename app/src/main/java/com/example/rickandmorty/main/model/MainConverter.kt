package com.example.rickandmorty.main.model

import android.util.Log
import com.example.rickandmorty.main.api.model.CharacterApiResponse
import com.example.rickandmorty.main.api.model.LocationResponse
import com.example.rickandmorty.main.api.model.OriginResponse
import com.example.rickandmorty.main.api.model.ResultsResponse

object MainConverter {
    fun fromNetwork(response: CharacterApiResponse): List<Results> {
        Log.i("###", "Converter")
        return response.results.map { result ->
            Results(
                id = result.id,
                name = result.name,
                status = result.status,
                species = result.species,
                type = result.type,
                gender = result.gender,
                origin = fromNetwork(result.origin),
                image = result.image,
                episode = result.episode,
                url = result.url,
                created = result.created
            )
        }
    }

    private fun fromNetwork(response: OriginResponse) =
        Origin(
            name = response.name,
            url = response.url
        )

}