package com.example.shimon.multiitemrecyclerview.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import coil.load
import com.example.shimon.multiitemrecyclerview.databinding.DirectorItemBinding
import com.example.shimon.multiitemrecyclerview.databinding.ItemTitleBinding
import com.example.shimon.multiitemrecyclerview.databinding.MovieItemBinding
import com.example.shimon.multiitemrecyclerview.models.RecyclerViewItem

sealed class HomeRecyclerVH(binding: ViewBinding):RecyclerView.ViewHolder(binding.root) {

    class TitleVH(private var binding : ItemTitleBinding) : HomeRecyclerVH(binding){

        fun bind(title: RecyclerViewItem.Title){

            binding.titleTV.text = title.title

        }

    }
    class MovieVH(private var binding : MovieItemBinding) : HomeRecyclerVH(binding){

        fun bind(movie: RecyclerViewItem.Movie){
            binding.backgroundIV.load(movie.thumbnail)

        }

    }
    class DirectorVH(private var binding : DirectorItemBinding) : HomeRecyclerVH(binding){

        fun bind(director:RecyclerViewItem.Director){

            binding.directorIV.load(director.avatar)
            binding.directorTV.text = director.name
            binding.totalMoviesTV.text = "Number of Movies: ${director.movie_count}"

        }

    }

}