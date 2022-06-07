package com.example.rickandmorty.main.repository.local

import com.example.rickandmorty.main.model.Results
import kotlinx.coroutines.flow.Flow

interface LocalRepository {
    suspend fun getHeroes(): Flow<List<Results>>

    suspend fun insertHeroesToDb(heroes: List<Results>)
}