package com.example.pr3_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val tVGuess = findViewById<TextView>(R.id.textGuess)
        val bLess = findViewById<Button>(R.id.btnLess)
        val bMore = findViewById<Button>(R.id.btnMore)
        val bAnswer = findViewById<Button>(R.id.btnAnswer)
        val tVAnswer = findViewById<TextView>(R.id.answer)


        var fN = intent.extras?.get("firstN").toString().toInt()
        var sN = intent.extras?.get("secondN").toString().toInt()
        fN--
        sN++
        var middle = (fN+sN)/2

        tVGuess.setText(middle.toString())

        bLess.setOnClickListener(View.OnClickListener {
            sN = middle
            middle = (fN + sN)/2
            tVGuess.setText(middle.toString())
        })
        bMore.setOnClickListener(View.OnClickListener {
            fN = middle
            middle = (fN + sN)/2
            tVGuess.setText(middle.toString())
        })

        bAnswer.setOnClickListener(View.OnClickListener {
            tVAnswer.setText(middle.toString())
            bMore.setEnabled(false)
            bLess.setEnabled(false)
        })

    }
}