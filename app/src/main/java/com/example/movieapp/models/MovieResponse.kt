package com.example.movieapp.models

import android.graphics.Movie

data class MovieResponse(val page : Int , val results : List<MovieListResponse> , val total_pages : Int) {
}