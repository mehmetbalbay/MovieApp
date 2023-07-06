package com.example.simplemovieapp.ui.home

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.simplemovieapp.ui.base.BaseFragment

class HomePagerAdapter(
    fm: FragmentManager,
    private val fragments: List<PagerFragment>
) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int = fragments.size

    override fun getItem(position: Int): BaseFragment<*, *> {
        return fragments[position].fragment
    }

    override fun getPageTitle(position: Int): CharSequence {
        return fragments[position].title
    }


}