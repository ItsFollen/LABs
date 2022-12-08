package com.example.pr3_2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val input = findViewById<EditText>(R.id.argumentET)
        val fRB = findViewById<RadioButton>(R.id.webAddress)
        val sRB = findViewById<RadioButton>(R.id.geopoint)
        val tRB = findViewById<RadioButton>(R.id.phone)
        val btn = findViewById<Button>(R.id.btnCall)

        btn.setOnClickListener(View.OnClickListener {
            if (fRB.isChecked) {
                var mes = input.text.toString()
                val webpage: Uri = Uri.parse(mes)
                val intent = Intent(Intent.ACTION_VIEW, webpage)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
            }
            else if (sRB.isChecked) {
                val intent = Intent(Intent.ACTION_VIEW)
                var mes = "geo:" + input.text.toString()
                intent.setData(Uri.parse(mes))
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
            }
            else if (tRB.isChecked) {
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    val mes = input.text.toString()
                    intent.setData(Uri.parse(mes))
                }
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
            }
            else {
                val mes = input.text.toString()
                val web = Regex("^((https?|ftp)\\:\\/\\/)?([a-z0-9]{1})((\\.[a-z0-9-])|([a-z0-9-]))*\\.([a-z]{2,6})(\\/?)\$")
                val geo = Regex("^[-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?),\\s*[-+]?(180(\\.0+)?|((1[0-7]\\d)|([1-9]?\\d))(\\.\\d+)?)\$")
                val phone = Regex("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}\$")
                if (web.matches(mes)) {
                    val webpage: Uri = Uri.parse(mes)
                    val intent = Intent(Intent.ACTION_VIEW, webpage)
                    if (intent.resolveActivity(packageManager) != null) {
                        startActivity(intent)
                    }
                }
                else if (geo.matches(mes)) {
                    val intent = Intent(Intent.ACTION_VIEW)
                    var res = "geo:" + input.text.toString()
                    intent.setData(Uri.parse(res))
                    if (intent.resolveActivity(packageManager) != null) {
                        startActivity(intent)
                    }
                }
                else if (phone.matches(mes)){
                    val intent = Intent(Intent.ACTION_DIAL).apply {
                        intent.setData(Uri.parse(mes))
                    }
                    if (intent.resolveActivity(packageManager) != null) {
                        startActivity(intent)
                    }
                }
                else {
                    Toast.makeText(this,"Некорректный ввод", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}