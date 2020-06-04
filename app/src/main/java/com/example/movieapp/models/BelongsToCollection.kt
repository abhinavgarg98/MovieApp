package com.example.movieapp.models


import androidx.annotation.Keep

@Keep
data class BelongsToCollection(
    val backdrop_path: String,
    val id: Int,
    val name: String,
    val poster_path: String
)