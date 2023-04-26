package com.example.simplemovieapp.util

import android.content.Context
import androidx.swiperefreshlayout.widget.CircularProgressDrawable

fun Context.circleProgressDrawable(): CircularProgressDrawable {
    val circularProgressDrawable = CircularProgressDrawable(this)
    circularProgressDrawable.strokeWidth = 5f
    circularProgressDrawable.centerRadius = 30f
    circularProgressDrawable.start()
    return circularProgressDrawable
}