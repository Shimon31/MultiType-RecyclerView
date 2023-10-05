package com.example.shimon.multiitemrecyclerview.ui

import android.media.RouteListingPreference.Item
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shimon.multiitemrecyclerview.R
import com.example.shimon.multiitemrecyclerview.databinding.DirectorItemBinding
import com.example.shimon.multiitemrecyclerview.databinding.ItemTitleBinding
import com.example.shimon.multiitemrecyclerview.databinding.MovieItemBinding
import com.example.shimon.multiitemrecyclerview.models.RecyclerViewItem
import java.lang.IllegalArgumentException

class HomeAdapter : RecyclerView.Adapter<HomeRecyclerVH>() {

    var items = listOf<RecyclerViewItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecyclerVH {

        return when (viewType) {

            R.layout.director_item -> HomeRecyclerVH.DirectorVH(
                DirectorItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            R.layout.movie_item -> HomeRecyclerVH.MovieVH(
                MovieItemBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )

            R.layout.item_title -> HomeRecyclerVH.TitleVH(
                ItemTitleBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )
            else-> throw IllegalArgumentException("Invalid ViewType")
        }

    }

    override fun onBindViewHolder(holder: HomeRecyclerVH, position: Int) {

        when(holder){
            is HomeRecyclerVH.DirectorVH -> holder.bind(items[position] as RecyclerViewItem.Director)
            is HomeRecyclerVH.MovieVH -> holder.bind(items[position] as RecyclerViewItem.Movie)
            is HomeRecyclerVH.TitleVH -> holder.bind(items[position] as RecyclerViewItem.Title)
        }


    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is RecyclerViewItem.Director -> R.layout.director_item
            is RecyclerViewItem.Movie -> R.layout.movie_item
            is RecyclerViewItem.Title -> R.layout.item_title
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}