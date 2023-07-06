package com.example.simplemovieapp.ui.home.movie

import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simplemovieapp.BR
import com.example.simplemovieapp.R
import com.example.simplemovieapp.data.dto.MoviesResponse
import com.example.simplemovieapp.databinding.FragmentMovieBinding
import com.example.simplemovieapp.ui.MoviePagingAdapter
import com.example.simplemovieapp.ui.base.BaseFragment
import com.example.simplemovieapp.util.ScaleCenterItemLayoutManager
import com.example.simplemovieapp.util.viewpager_carousel.BaseAdapter
import com.example.simplemovieapp.util.viewpager_carousel.carouselItemDecoration
import com.example.simplemovieapp.util.viewpager_carousel.carouselTransformer
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieFragment : BaseFragment<MovieViewModel, FragmentMovieBinding>() {

    override val layoutId: Int = R.layout.fragment_movie

    override val viewModelClass: Class<MovieViewModel> = MovieViewModel::class.java

    private var upComingMovieAdapter: MoviePagingAdapter? = null

    private var modelAdapter: BaseAdapter<MoviesResponse.Result>? = null

    companion object {
        fun newInstance(): MovieFragment {
            val fragment = MovieFragment()
            return fragment
        }
    }

    override fun initUI() {
        setUpComingMoviesAdapter()

        viewModel.upcomingMovie.observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                upComingMovieAdapter?.submitData(it)
            }
        }

        lifecycleScope.launch {
            upComingMovieAdapter?.loadStateFlow
                ?.collectLatest {
                    val list = upComingMovieAdapter?.snapshot()
                    if (list?.isNotEmpty() == true) {
                        modelAdapter?.setItems(list.items)
                    }
                }
        }

        modelAdapter = BaseAdapter(R.layout.recycler_upcoming_item, BR.movieResult)
        binding.viewPagerUpComing.apply {
            offscreenPageLimit = 1
            setPageTransformer(this.carouselTransformer())
            addItemDecoration(this.carouselItemDecoration())
            adapter = modelAdapter
        }
    }

    private fun setUpComingMoviesAdapter() {
        upComingMovieAdapter = MoviePagingAdapter(onItemClick = { movieResult ->

        })

        binding.rvUpComingMovies.adapter = upComingMovieAdapter
        binding.rvUpComingMovies.layoutManager = ScaleCenterItemLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }

}