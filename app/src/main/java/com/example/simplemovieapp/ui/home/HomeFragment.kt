package com.example.simplemovieapp.ui.home

import com.bumptech.glide.Glide
import com.example.simplemovieapp.R
import com.example.simplemovieapp.databinding.FragmentHomeBinding
import com.example.simplemovieapp.ui.base.BaseFragment
import com.example.simplemovieapp.ui.home.movie.MovieFragment
import com.example.simplemovieapp.ui.home.mylist.MyListFragment
import com.example.simplemovieapp.ui.home.tvshow.TvShowFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    override val layoutId: Int = R.layout.fragment_home

    override val viewModelClass: Class<HomeViewModel> = HomeViewModel::class.java

    private var homePagerAdapter: HomePagerAdapter? = null

    override fun initUI() {
        setHomePager()

        setProfileImage()
    }

    private fun setHomePager() {
        val fragments = listOf(
            PagerFragment("Movie", MovieFragment.newInstance()),
            PagerFragment("TvShow", TvShowFragment.newInstance()),
            PagerFragment("MyList", MyListFragment.newInstance())
        )

        homePagerAdapter = HomePagerAdapter(requireActivity().supportFragmentManager, fragments)
        binding.viewPagerHome.adapter = homePagerAdapter
        binding.tabLayoutHome.setupWithViewPager(binding.viewPagerHome)
    }

    private fun setProfileImage() {
        Glide.with(this).load(R.drawable.profile_placeholder).circleCrop()
            .into(binding.imageViewProfile)
    }

}