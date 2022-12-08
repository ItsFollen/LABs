package com.example.pr3_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.startBtn)
        btn.setOnClickListener(View.OnClickListener {
            val fNum = findViewById<EditText>(R.id.firstNum).getText().toString()
            val sNum = findViewById<EditText>(R.id.secondNum).getText().toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("firstN", fNum)
            intent.putExtra("secondN", sNum)
            startActivity(intent)
        })
    }
}