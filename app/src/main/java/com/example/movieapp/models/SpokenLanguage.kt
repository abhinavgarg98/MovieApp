package com.example.movieapp.models


import androidx.annotation.Keep

@Keep
data class SpokenLanguage(
    val iso_639_1: String,
    val name: String
)