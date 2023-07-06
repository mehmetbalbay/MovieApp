package com.example.simplemovieapp.util.viewpager_carousel

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.simplemovieapp.R

fun ViewPager2.carouselTransformer(): ViewPager2.PageTransformer {
    val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
    val currentItemHorizontalMarginPx = resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
    val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
    val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
        page.translationX = -pageTranslationX * position
//            // Next line scales the item's height. You can remove it if you don't want this effect
        page.scaleY = 1 - (0.25f * kotlin.math.abs(position))
//            // If you want a fading effect uncomment the next line:
        page.alpha = 0.25f + (1 - kotlin.math.abs(position))
    }
    return pageTransformer
}

fun ViewPager2.carouselItemDecoration(): HorizontalMarginItemDecoration {
    val itemDecoration = HorizontalMarginItemDecoration(
        this.context,
        R.dimen.viewpager_current_item_horizontal_margin
    )
    return itemDecoration
}