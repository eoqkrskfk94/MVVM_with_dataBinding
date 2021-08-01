package com.mj.mvvm_with_databinding.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.mj.mvvm_with_databinding.R
import com.mj.mvvm_with_databinding.databinding.ActivityMainBinding
import com.mj.mvvm_with_databinding.presentation.viewModel.LottoViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = LottoViewModel()

        binding.drwNo = 100

    }
}