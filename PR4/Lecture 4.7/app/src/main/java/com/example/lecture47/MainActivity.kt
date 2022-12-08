package com.example.lecture47

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lecture47.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.attendance.setOnClickListener {


            var text=resources.getString(R.string.broadcast)
//
            resources.getStringArray(R.array.broadcast_list).forEach {

              text=  text.plus("$it\n")
            }


            Toast.makeText(this, text, Toast.LENGTH_LONG).show()
        }
    }
}