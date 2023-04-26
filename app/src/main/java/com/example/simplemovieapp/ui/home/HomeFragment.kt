package com.example.simplemovieapp.ui.home

import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.simplemovieapp.R
import com.example.simplemovieapp.databinding.FragmentHomeBinding
import com.example.simplemovieapp.ui.MoviePagingAdapter
import com.example.simplemovieapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    override val layoutId: Int = R.layout.fragment_home

    override val viewModelClass: Class<HomeViewModel> = HomeViewModel::class.java

    override fun initUI() {
        val movieAdapter = MoviePagingAdapter(onItemClick = {
            findNavController().navigate(R.id.action_homeFragment_to_movieDetailFragment)
        })

        binding.movieListRecyclerView.apply {
            adapter = movieAdapter
        }

        viewModel.upcomingMovie.observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                movieAdapter.submitData(it)
            }
        }
    }

}