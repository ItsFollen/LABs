package com.example.pr26

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: RandomNumberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var provider = ViewModelProvider(this)
        viewModel = provider.get(RandomNumberViewModel::class.java)

        observeViewModel()
        clickBtn()

}
    fun observeViewModel(){
        viewModel.currentRandomNumber.observe(this, Observer {
            val r = findViewById<TextView>(R.id.rndNum)
            r.text = it.toString()
        })
    }

    fun clickBtn() {
        val b = findViewById<Button>(R.id.getRnd)
        b.setOnClickListener{
            viewModel.generateNumber()
        }
    }


}