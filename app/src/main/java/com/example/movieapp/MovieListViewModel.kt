package com.example.movieapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.models.GetMovieListRespone
import com.example.movieapp.network.MovieListRepo
import com.example.movieapp.network.ResultResponse
import kotlinx.coroutines.launch
import java.lang.Exception

class MovieListViewModel : ViewModel() {

    private val movieRepo = MovieListRepo()
    val onGetMovieListResponseMld : MutableLiveData<ResultResponse<Any>> = MutableLiveData()

    fun getMovieList(apiKey : String){
        viewModelScope.launch {
            try{
                val response = movieRepo.getVideosList(apiKey)
                onGetMovieListResponseSuccess(response)
            }
            catch (e : Exception){

            }
        }
    }

    private fun onGetMovieListResponseSuccess(response: GetMovieListRespone) {
        onGetMovieListResponseMld.value = ResultResponse.Success(response.items)
    }
}