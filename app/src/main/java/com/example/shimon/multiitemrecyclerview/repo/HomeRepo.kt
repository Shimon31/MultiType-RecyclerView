package com.example.shimon.multiitemrecyclerview.repo

import android.content.res.Resources.NotFoundException
import com.example.shimon.multiitemrecyclerview.models.RecyclerViewItem
import com.example.shimon.multiitemrecyclerview.network.MovieService
import javax.inject.Inject

class HomeRepo @Inject constructor(private val service: MovieService) {

    suspend fun getMovies():List<RecyclerViewItem.Movie>{

        return if (service.getMovies().isSuccessful){
            service.getMovies().body()!!
        }
        else{
            throw NotFoundException("Movies Not Found")
        }

    }

    suspend fun getDirector(): List<RecyclerViewItem.Director> {

        return if (service.getDirector().isSuccessful){
            service.getDirector().body()!!
        }
        else{
            throw NotFoundException("Director Not Found")
        }

    }


}