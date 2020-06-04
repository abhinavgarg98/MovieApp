package com.example.movieapp.network

import com.example.movieapp.models.MovieListResponse
import com.example.movieapp.models.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieListService {

    @GET("popular")
    suspend fun getMovieList(@Query("api_key") apiKey : String) : MovieResponse

}