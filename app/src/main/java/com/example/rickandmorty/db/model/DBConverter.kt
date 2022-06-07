package com.example.rickandmorty.db.model

import com.example.rickandmorty.main.model.Results

object DBConverter {
    fun fromDatabase(characterEntities: List<CharacterEntity>) =
        characterEntities.map {
            Results(
                id = it.id,
                name = it.name,
                status = it.status,
                species = it.species,
                gender = it.gender,
                image = it.image,
                type = it.type
            )
        }

    fun toDatabase(characters: List<Results>) =
        characters.map {
            CharacterEntity(
                id = it.id,
                name = it.name,
                status = it.status,
                species = it.species,
                gender = it.gender,
                image = it.image,
                type = it.type
            )
        }

}