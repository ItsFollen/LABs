package com.example.pr2_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import java.math.MathContext
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val km = findViewById<EditText>(R.id.km)
        val m = findViewById<EditText>(R.id.m)
        val dm = findViewById<EditText>(R.id.dm)
        val sm = findViewById<EditText>(R.id.sm)
        val mm = findViewById<EditText>(R.id.mm)
        val result = findViewById<TextView>(R.id.rezult)
        val btn = findViewById<Button>(R.id.inspect)
        val iv: ImageView = findViewById(R.id.answer)
        btn.setOnClickListener( {
//            var inkm = km.getText().toString().toDouble()
//            var sum: Double = inkm * 10
//            var s = sum.toString()
//            result.setText(s)
            var inkm = km.getText().toString().toDouble()
            var inm = m.getText().toString().toDouble()
            var indm = dm.getText().toString().toDouble()
            var insm = sm.getText().toString().toDouble()
            var inmm = mm.getText().toString().toDouble()
            var resm = inkm * 1000
            var resdm = inm * 10
            var ressm = indm * 10
            var resmm = insm * 10

            if (resm == inm && resdm == indm && ressm == insm && resmm == inmm) {
                result.setText("Отлично!")
                iv.setImageResource(R.drawable.cool)

            } else {
                result.setText("Повторите материал, ответ неверный!")
                iv.setImageResource(R.drawable.bad)
            }
        } )
        iv.setOnTouchListener { view, motionEvent ->
            when(motionEvent.getAction()) {
                MotionEvent.ACTION_DOWN -> iv.alpha -= 0.1.toFloat()
            }
            true
        }
    }
}