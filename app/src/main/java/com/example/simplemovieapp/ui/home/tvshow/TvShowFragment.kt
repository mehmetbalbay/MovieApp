package com.example.simplemovieapp.ui.home.tvshow

import com.example.simplemovieapp.R
import com.example.simplemovieapp.databinding.FragmentTvshowBinding
import com.example.simplemovieapp.ui.base.BaseFragment

class TvShowFragment : BaseFragment<TvShowViewModel, FragmentTvshowBinding>() {

    override val layoutId: Int = R.layout.fragment_tvshow

    override val viewModelClass: Class<TvShowViewModel> = TvShowViewModel::class.java

    companion object {
        fun newInstance(): TvShowFragment {
            val fragment = TvShowFragment()
            return fragment
        }
    }

    override fun initUI() {

    }

}