package com.example.simplemovieapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.simplemovieapp.R
import com.example.simplemovieapp.data.dto.MovieResponse
import com.example.simplemovieapp.databinding.RecyclerUpcomingItemBinding
import com.example.simplemovieapp.util.Config
import com.example.simplemovieapp.util.circleProgressDrawable
import com.example.simplemovieapp.util.showView

class MoviePagingAdapter(private val onItemClick: (MovieResponse.Result) -> Unit) :
    PagingDataAdapter<MovieResponse.Result, RecyclerView.ViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            RecyclerUpcomingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            when (holder) {
                is ViewHolder -> holder.bind(item)
            }
        }
    }

    inner class ViewHolder(private val binding: RecyclerUpcomingItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val item = getItem(position)
                    if (item != null) {
                        onItemClick(item)
                    }
                }
            }
        }

        fun bind(item: MovieResponse.Result) {
            binding.textViewTitle.text = item.title

            item.backdropPath?.let {
                Glide.with(itemView.context).load(Config.IMAGE_URL + item.backdropPath)
                    .apply(RequestOptions().override(400, 400).centerInside())
                    .placeholder(itemView.context.circleProgressDrawable())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .error(R.drawable.popcorn)
                    .into(binding.imageViewPosterPath)

                binding.imageViewPosterPath.showView(true)
                binding.imageViewEmptyPoster.showView(false)
            } ?: kotlin.run {
                binding.imageViewPosterPath.showView(false)
                binding.imageViewEmptyPoster.showView(true)
            }
        }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<MovieResponse.Result>() {
            override fun areItemsTheSame(
                oldItem: MovieResponse.Result,
                newItem: MovieResponse.Result
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: MovieResponse.Result,
                newItem: MovieResponse.Result
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}

