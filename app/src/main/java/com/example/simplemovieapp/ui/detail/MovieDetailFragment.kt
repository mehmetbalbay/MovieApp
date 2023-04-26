package com.example.simplemovieapp.ui.detail

import com.example.simplemovieapp.R
import com.example.simplemovieapp.databinding.FragmentMovieDetailBinding
import com.example.simplemovieapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment : BaseFragment<MovieDetailViewModel, FragmentMovieDetailBinding>() {

    override val layoutId: Int = R.layout.fragment_movie_detail

    override val viewModelClass: Class<MovieDetailViewModel> = MovieDetailViewModel::class.java

    override fun initUI() {
    }

}