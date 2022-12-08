package com.example.pr2_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val img = findViewById<ImageView>(R.id.mood)
        val good = findViewById<RadioButton>(R.id.good)
        val bad = findViewById<RadioButton>(R.id.bad)
        good.setOnClickListener( {
            img.setImageResource(R.drawable.cheerful)
        })
        bad.setOnClickListener( {
            img.setImageResource(R.drawable.cry)
        })

        val event = findViewById<EditText>(R.id.vevent)
        val time = findViewById<EditText>(R.id.time)
        val date = findViewById<EditText>(R.id.vdate)
        val post = findViewById<EditText>(R.id.post)

        val btn = findViewById<Button>(R.id.save)
        btn.setOnClickListener({
            var text = Toast.makeText(this, "Записано!" + "\n" + "Событие:" +
                    event.getText() + "\n" + "Дата:" + date.getText() + "\n" +
                    "Время:" + time.getText() + "\n" + "Заметки:" + post.getText(), Toast.LENGTH_LONG)
            text.show()
            event.getText().clear()
            time.getText().clear()
            date.getText().clear()
            post.getText().clear()
            img.setImageResource(R.drawable.cheerful)
        })


    }
}