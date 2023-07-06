package com.example.simplemovieapp.ui.base

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.simplemovieapp.R
import com.example.simplemovieapp.util.Config
import com.example.simplemovieapp.util.circleProgressDrawable

object RecyclerViewBinding {

    @BindingAdapter("movieTitle")
    @JvmStatic
    fun setMovieTitle(view: TextView, text: String?) {
        text?.let {
            view.text = it
        }
    }

    @BindingAdapter("moviePosterPath")
    @JvmStatic
    fun setMoviePosterPath(view: ImageView, posterPath: String?) {
        posterPath?.let {
            Glide.with(view.context).load(Config.ORIGINAL_IMAGE_URL + it)
                .placeholder(view.context.circleProgressDrawable())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.popcorn)
                .into(view)
        } ?: kotlin.run {
            view.setImageResource(R.drawable.popcorn)
        }
    }

}