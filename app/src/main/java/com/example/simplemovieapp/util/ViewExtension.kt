package com.example.simplemovieapp.util

import android.content.res.Resources
import android.view.View

fun View.showView(isShow: Boolean) {
    visibility = if (isShow) View.VISIBLE else View.INVISIBLE
}

val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()
val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()