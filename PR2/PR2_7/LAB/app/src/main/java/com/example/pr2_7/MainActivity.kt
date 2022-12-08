package com.example.pr2_7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val eT = findViewById<EditText>(R.id.editText)
        val cB = findViewById<CheckBox>(R.id.checkBox)
        val tB = findViewById<ToggleButton>(R.id.toggleButton)
        val rB1 = findViewById<RadioButton>(R.id.radioButton)
        val rB2 = findViewById<RadioButton>(R.id.radioButton2)
        val btn = findViewById<Button>(R.id.button)
        val tV = findViewById<TextView>(R.id.solution)

        btn.setOnClickListener(View.OnClickListener {

            val TEXT = eT.getText()
            val mes1 = "EditText: " + TEXT
            var mes2 = "CheckBox: "
            var mes3 = "ToggleButton: "
            var mes4 = "RadioGroup: "

            if (cB.isChecked) {
                mes2 += "ON"
            }else {
                mes2 += "OFF"
            }

            if (tB.isChecked) {
                mes3 += "ON"
            }else{
                mes3 += "OFF"
            }

            if (rB1.isChecked) {
                mes4 += "RadioButton 1"
            }else {
                mes4 += "RadioButton 2"
            }

            val mes = mes1 + "\n" + mes2 + "\n" + mes3 + "\n" + mes4
            tV.setText(mes)
        })

        val text =  "пусто"
        val duration =  Toast.LENGTH_SHORT
        val toast =  Toast.makeText(applicationContext,text,duration)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()


    }
}