package com.example.shimon.multiitemrecyclerview.models

sealed class RecyclerViewItem {


    class Title(
        val id:Int,
        val title:String
    ):RecyclerViewItem()

    class Movie(

        val id:Int,
        val title: String,
        val thumbnail:String,
        val release_date : String
    ):RecyclerViewItem()

    class Director(
        val id:Int,
        val name:String,
        val avatar: String,
        val movie_count:Int
    ):RecyclerViewItem()

}