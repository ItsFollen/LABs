package com.example.pr2_8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SubMenu
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val op = resources.getStringArray(R.array.operation)
        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, op)
            spinner.adapter = adapter
        }

        val result = findViewById<TextView>(R.id.solution)
        val idA = findViewById<EditText>(R.id.sideA)
        val idB = findViewById<EditText>(R.id.sideB)
        val idC = findViewById<EditText>(R.id.sideC)
        val btn = findViewById<Button>(R.id.getSolution)


        btn.setOnClickListener(View.OnClickListener {

            val num = idA.text.toString().toIntOrNull()
            val num1 = idB.text.toString().toIntOrNull()
            val num2 = idC.text.toString().toIntOrNull()

            if ((num != null) && (num1 != null) && (num2 != null)) {
                val sumA = idA.text.toString().toInt()
                val sumB = idB.text.toString().toInt()
                val sumC = idC.text.toString().toInt()
                val option = spinner.selectedItem.toString()

                if (option == "Сумма длины ребер") {
                    val res = 4 * (sumA + sumB + sumC)
                    result.setText(res.toString())
                }else if (option == "Площадь поверхности") {
                    val res = 2 * (sumA * sumB + sumB * sumC + sumC * sumA)
                    result.setText(res.toString())
                }else {
                    val res = sumA * sumB * sumC
                    result.setText(res.toString())
                }
            }else {
                val res = "Ошибка ввода"
                result.setText(res)
            }



        })



    }
}