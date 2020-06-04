package com.example.movieapp.network

import com.example.movieapp.models.GetMovieListRespone
import com.example.movieapp.models.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class MovieListRepo {
    var retrofit = RetrofitClientInstance().getInstance()
    protected val ioDispatcher = Dispatchers.IO
    val service: MovieListService = retrofit.create(MovieListService::class.java)

    suspend fun getVideosList(apiKey : String): GetMovieListRespone{
        return withContext(ioDispatcher){
            val async = async {
                service.getMovieList(apiKey)
            }
            val movieListResponse = onGetMovieListResponse(async.await())
            movieListResponse
        }
    }

    val items : ArrayList<Any> = arrayListOf()
    private fun onGetMovieListResponse(result: MovieResponse): GetMovieListRespone {
        for(item in result.results){
            items.add(item)
        }
        return GetMovieListRespone(items)
    }
}