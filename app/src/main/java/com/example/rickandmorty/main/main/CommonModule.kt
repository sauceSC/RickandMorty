package com.example.rickandmorty.main.main

import com.example.rickandmorty.main.api.RickAndMortyAPI
import com.example.rickandmorty.utils.Utils
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object CommonModule {
    fun createRetrofit() = module {
        single {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Utils.BASE_URL)
                .client(client)
                .build()
            retrofit.create(RickAndMortyAPI::class.java)
        }
    }
}