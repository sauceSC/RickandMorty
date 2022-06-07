package com.example.rickandmorty.main.repository.local

import com.example.rickandmorty.db.dao.CharactersDao
import com.example.rickandmorty.db.model.DBConverter
import com.example.rickandmorty.main.model.Results
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MainLocalRepository(private val charactersDao :CharactersDao) : LocalRepository {
    override suspend fun getHeroes(): Flow<List<Results>> {
        val heroes = charactersDao.getAllCharacters()
        return heroes.map { DBConverter.fromDatabase(it) }
    }

    override suspend fun insertHeroesToDb(heroes: List<Results>) {
        val heroEntities = DBConverter.toDatabase(heroes)
        charactersDao.insertAll(heroEntities)
    }


}