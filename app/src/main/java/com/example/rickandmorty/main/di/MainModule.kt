package com.example.rickandmorty.main.di

import com.example.rickandmorty.main.interactor.MainInteractor
import com.example.rickandmorty.main.repository.MainRemoteRepository
import com.example.rickandmorty.main.ui.MainPresenter
import com.example.rickandmorty.main.ui.RickMortyView
import org.koin.dsl.bind
import org.koin.dsl.module

object MainModule {
    fun create() = module {
        single { MainPresenter(get()) } bind RickMortyView.Presenter :: class
        factory {
            val interactor = MainInteractor(get())
            interactor
        } bind MainInteractor :: class
        single <MainRemoteRepository> {MainRemoteRepository(get())}
    }
}