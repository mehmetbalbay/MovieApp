package com.example.simplemovieapp.ui.home.mylist

import com.example.simplemovieapp.R
import com.example.simplemovieapp.databinding.FragmentMylistBinding
import com.example.simplemovieapp.ui.base.BaseFragment

class MyListFragment : BaseFragment<MyListViewModel, FragmentMylistBinding>() {

    override val layoutId: Int = R.layout.fragment_mylist

    override val viewModelClass: Class<MyListViewModel> = MyListViewModel::class.java

    companion object {
        fun newInstance(): MyListFragment {
            val fragment = MyListFragment()
            return fragment
        }
    }

    override fun initUI() {

    }

}