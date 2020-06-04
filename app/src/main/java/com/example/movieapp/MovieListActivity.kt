package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MovieListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        initFragment()
    }

    private fun initFragment(){
        val bundle = intent.extras
            supportFragmentManager.beginTransaction()
                .replace(R.id.container , MovieListFragment.newInstance()).commitNow()
    }
}