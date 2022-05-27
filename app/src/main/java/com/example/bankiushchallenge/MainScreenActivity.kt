package com.example.bankiushchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bankiushchallenge.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainScreenActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)


    }
}