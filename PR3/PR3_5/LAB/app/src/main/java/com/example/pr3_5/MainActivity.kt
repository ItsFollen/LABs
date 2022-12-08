package com.example.pr3_5

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pr3_5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.caption.setOnClickListener {

            when(resources.configuration.orientation){
                Configuration.ORIENTATION_PORTRAIT -> requestedOrientation=ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                Configuration.ORIENTATION_LANDSCAPE -> requestedOrientation=ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED

            }
        }
    }
}