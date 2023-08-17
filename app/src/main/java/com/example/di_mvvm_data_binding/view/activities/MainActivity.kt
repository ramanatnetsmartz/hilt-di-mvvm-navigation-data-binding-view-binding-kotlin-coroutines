package com.example.di_mvvm_data_binding.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.di_mvvm_data_binding.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}