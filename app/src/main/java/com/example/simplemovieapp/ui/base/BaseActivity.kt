package com.example.simplemovieapp.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseActivity<V : ViewModel, B : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var viewModel: V
    protected lateinit var binding: B

    abstract val layoutId: Int
    abstract val viewModelClass: Class<V>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutId)

        viewModel = ViewModelProvider(this).get(viewModelClass)

        binding.lifecycleOwner = this

        initUI()
    }

    abstract fun initUI()

}