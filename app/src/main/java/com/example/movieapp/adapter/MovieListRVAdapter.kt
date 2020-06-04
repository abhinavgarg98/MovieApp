package com.example.movieapp.adapter

import android.graphics.Movie
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.models.MovieListResponse
import com.example.movieapp.viewHolders.MovieListViewHolder

class MovieListRVAdapter() : ListAdapter<Any, RecyclerView.ViewHolder>(MovieListDiffcallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var viewHolder : RecyclerView.ViewHolder? = null
        val inflater = LayoutInflater.from(parent.context)
        when(viewType){
            R.layout.movie_list_item -> viewHolder = MovieListViewHolder.create(inflater , parent)
        }
        return  viewHolder!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when(holder){
            is MovieListViewHolder -> holder.bind(item as MovieListResponse)
        }
    }

    override fun getItemViewType(position: Int): Int {
        super.getItemViewType(position)
        val item = getItem(position)
        var itemViewType = 0
        when(item){
            is MovieListResponse -> itemViewType = R.layout.movie_list_item
        }
        return itemViewType
    }

    public override fun getItem(position: Int): Any {
        return super.getItem(position)
    }
}
