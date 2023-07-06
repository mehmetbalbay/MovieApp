package com.example.simplemovieapp.ui.home

import com.example.simplemovieapp.ui.base.BaseFragment

data class PagerFragment(
    val title: String,
    val fragment: BaseFragment<*, *>
)