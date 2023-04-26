package com.example.simplemovieapp.util

import android.view.View

fun View.showView(isShow: Boolean) {
    visibility = if (isShow) View.VISIBLE else View.INVISIBLE
}