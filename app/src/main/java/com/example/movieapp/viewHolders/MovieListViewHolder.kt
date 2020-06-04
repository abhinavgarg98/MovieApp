package com.example.movieapp.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.movieapp.R
import com.example.movieapp.databinding.MovieListItemBinding
import com.example.movieapp.models.MovieListResponse
import kotlinx.android.synthetic.main.movie_list_item.view.*

class MovieListViewHolder(binding: MovieListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    companion object{
        fun create(inflater: LayoutInflater ,
                   viewGroup: ViewGroup) : MovieListViewHolder {
            val binding = DataBindingUtil.inflate<MovieListItemBinding>(inflater, R.layout.movie_list_item , viewGroup ,false)
            return MovieListViewHolder(binding)
        }
    }

    fun bind(movieListResponse: MovieListResponse){
        itemView.movie_desc_tv.text = movieListResponse.overview
        itemView.movie_name_tv.text = movieListResponse.original_title
        Glide.with(itemView)
            .load("https://image.tmdb.org/t/p/w342${movieListResponse.backdrop_path}")
            .transform(CenterCrop())
            .into(itemView.movie_image_iv)
    }

}