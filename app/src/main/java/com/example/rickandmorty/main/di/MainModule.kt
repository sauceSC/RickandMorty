package com.example.rickandmorty.main.di

import androidx.room.Room
import com.example.rickandmorty.db.database.AppDatabase
import com.example.rickandmorty.main.interactor.MainInteractor
import com.example.rickandmorty.main.repository.local.MainLocalRepository
import com.example.rickandmorty.main.repository.remote.MainRemoteRepository
import com.example.rickandmorty.main.ui.MainViewModel
import com.example.rickandmorty.utils.Utils
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

object MainModule {
    fun create() = module {
        single { get<AppDatabase>().getCharactersDao() }
        singleOf(::MainLocalRepository)
        singleOf(::MainRemoteRepository)
        factoryOf(::MainInteractor) bind MainInteractor::class
        singleOf(::MainViewModel) bind MainViewModel::class
        single { Room.databaseBuilder(
            get(),
            AppDatabase::class.java, Utils.TABLE_NAME
        ).build()}
    }
}