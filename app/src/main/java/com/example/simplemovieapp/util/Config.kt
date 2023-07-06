package com.example.simplemovieapp.util

object Config {
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val IMAGE_URL = "https://image.tmdb.org/t/p/"

    private const val W_300 = "w300"
    private const val W_700 = "w700"
    private const val W_1280 = "w1280"
    private const val ORIGINAL = "original"

    const val ORIGINAL_IMAGE_URL = IMAGE_URL + ORIGINAL
    const val W1280_IMAGE_URL = IMAGE_URL + W_1280
    const val W700_IMAGER_URL = IMAGE_URL + W_700
    const val W300_IMAGE_URL = IMAGE_URL + W_300
}