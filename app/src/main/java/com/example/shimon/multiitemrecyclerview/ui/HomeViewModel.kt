package com.example.shimon.multiitemrecyclerview.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shimon.multiitemrecyclerview.models.RecyclerViewItem
import com.example.shimon.multiitemrecyclerview.repo.HomeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val repo:HomeRepo) : ViewModel(){

    private val _itemList = MutableLiveData<List<RecyclerViewItem>>()

    val itemList : LiveData<List<RecyclerViewItem>>
        get() = _itemList

    init {
        getDataList()
    }

        private fun getDataList(){

            viewModelScope.launch {

                val movieResponse = async{ repo.getMovies() }
                val directorResponse = async{ repo.getDirector() }

                val movies = movieResponse.await()
                val director = directorResponse.await()

                val homeList = mutableListOf<RecyclerViewItem>()

                if (movies.isNotEmpty() && director.isNotEmpty()){

                    homeList.add(RecyclerViewItem.Title(id=1,title="Recommended"))
                    homeList.addAll(movies)
                    homeList.add(RecyclerViewItem.Title(id=2,"Director"))
                    homeList.addAll(director)
                    _itemList.postValue(homeList)


                }


            }

        }

}