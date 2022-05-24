package com.example.rickandmorty.main.repository

import com.example.rickandmorty.main.model.Results

interface MainRepository {
    suspend fun getResults(): List<Results>
}