package com.example.shimon.multiitemrecyclerview.network

import com.example.shimon.multiitemrecyclerview.models.RecyclerViewItem
import retrofit2.Response
import retrofit2.http.GET

interface MovieService {

    @GET("movies")
    suspend fun getMovies():Response<List<RecyclerViewItem.Movie>>

    @GET("directors")
    suspend fun getDirector():Response<List<RecyclerViewItem.Director>>



}