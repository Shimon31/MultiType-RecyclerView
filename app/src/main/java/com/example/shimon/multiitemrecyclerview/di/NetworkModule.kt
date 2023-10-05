package com.example.shimon.multiitemrecyclerview.di

import com.example.shimon.multiitemrecyclerview.network.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit():Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl("https://60d194a45b017400178f3e51.mockapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Provides
    @Singleton
    fun provideMovieService(retrofit:Retrofit.Builder):MovieService{

        return retrofit.build().create(MovieService::class.java)

    }

}