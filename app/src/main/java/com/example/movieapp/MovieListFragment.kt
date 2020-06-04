package com.example.movieapp

import android.graphics.Movie
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.adapter.MovieListItemDecorator
import com.example.movieapp.adapter.MovieListRVAdapter
import com.example.movieapp.network.ResultResponse
import kotlinx.android.synthetic.main.fragment_main.*


class MovieListFragment : Fragment() {

    companion object {
        fun newInstance() = MovieListFragment().apply {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main , container , false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        initViewModel()
        initData()
        initViewModelObserver()
        initAdapter()
    }

    private fun initData() {
        viewModel.getMovieList("762468f515d6235dff546e41954f9c3c")
    }

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: MovieListRVAdapter
    private lateinit var itemDecorator: MovieListItemDecorator
    private fun initAdapter() {
        linearLayoutManager = LinearLayoutManager(activity , RecyclerView.VERTICAL , false)
        adapter = MovieListRVAdapter()
        itemDecorator = MovieListItemDecorator()
        movie_list_rv.adapter = adapter
        movie_list_rv.addItemDecoration(itemDecorator)
        movie_list_rv.layoutManager = linearLayoutManager
    }

    private fun initViewModelObserver() {
        viewModel.onGetMovieListResponseMld.observe(viewLifecycleOwner, Observer {
            onGetExamListResponse(it)
        })
    }

    private fun onGetExamListResponse(resultResponse: ResultResponse<Any>?) {
        when(resultResponse){
            is ResultResponse.Error -> {
                Log.d("Error", "Error")
            }
            is ResultResponse.Success -> {
                onGetExamListResponseSuccess(resultResponse)
            }
        }
    }

    lateinit var data : ArrayList<*>
    private fun onGetExamListResponseSuccess(resultResponse: ResultResponse.Success<Any>) {
        data = resultResponse.data as ArrayList<*>
        adapter.submitList(data)
    }

    private lateinit var viewModel : MovieListViewModel
    private fun initViewModel(){
        viewModel = ViewModelProviders.of(this , MovieListViewModelFactory())
                .get(MovieListViewModel::class.java)

    }
}