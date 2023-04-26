package com.example.simplemovieapp.ui

import androidx.navigation.fragment.NavHostFragment
import com.example.simplemovieapp.R
import com.example.simplemovieapp.databinding.ActivityMainBinding
import com.example.simplemovieapp.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override val layoutId: Int = R.layout.activity_main
    override val viewModelClass: Class<MainViewModel> = MainViewModel::class.java

    override fun initUI() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigateUp()
    }
}