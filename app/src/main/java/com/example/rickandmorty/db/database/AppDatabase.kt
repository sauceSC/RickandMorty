package com.example.rickandmorty.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rickandmorty.db.dao.CharactersDao
import com.example.rickandmorty.db.model.CharacterEntity

@Database(version = 1, entities = [CharacterEntity::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun getCharactersDao(): CharactersDao
}