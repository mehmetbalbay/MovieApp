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

fun Context.dpToPx(dp: Float): Float {
    val scale = resources.displayMetrics.density
    return dp * scale + 0.5f
}

fun Context.pxToDp(px: Float): Float {
    val scale = resources.displayMetrics.density
    return px / scale + 0.5f
}