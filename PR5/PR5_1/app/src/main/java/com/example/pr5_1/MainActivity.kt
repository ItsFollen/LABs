package com.example.pr5_1

import com.example.pr5_1.R
import android.content.Context
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    var read: Button? = null
    var write: Button? = null

    var userInput: EditText? = null
    var fileContent: TextView? = null
    private val filename = "data.txt"
    private val filepath = "MyFileStorage"
    internal var myExternalFile: File?=null


    private val isExternalStorageReadOnly: Boolean get() {
        val extStorageState = Environment.getExternalStorageState()
        return Environment.MEDIA_MOUNTED_READ_ONLY == extStorageState
    }

    private val isExternalStorageAvailable: Boolean get() {
        val extStorageState = Environment.getExternalStorageState()
        return Environment.MEDIA_MOUNTED == extStorageState
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        read = findViewById(R.id.read) as Button
        write = findViewById(R.id.write) as Button
        userInput = findViewById(R.id.input)
        fileContent = findViewById(R.id.content)
        if (!isExternalStorageAvailable || isExternalStorageReadOnly) {
            write!!.isEnabled = false
        }
        read!!.setOnClickListener(this)
        write!!.setOnClickListener(this)
    }

    fun printMessage(m: String?) {
        Toast.makeText(this, m, Toast.LENGTH_LONG).show()
    }

    override fun onClick(view: View) {
        val b: Button = view as Button
        val b_text: String = b.getText().toString()
        when (b_text.toLowerCase()) {
            "write" -> {
                writeData()
            }
            "read" -> {
                readData()
            }
        }
    }

    private fun writeData() {


        myExternalFile = File(getExternalFilesDir(filepath), filename)
        try {
            val fos = FileOutputStream(myExternalFile)
            val data = userInput!!.text.toString()
            fos.write(data.toByteArray())
            fos.flush()
            fos.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        userInput!!.setText("")
        printMessage("writing to file " + filename + "completed...")
    }

    private fun readData() {
        try {
            myExternalFile = File(getExternalFilesDir(filepath), filename)
            var fin = FileInputStream(myExternalFile)
            var a: Char
            val temp = StringBuilder()

            while (fin.read().also { a = it.toChar() } != -1) {
                temp.append(a)
                //Log.d("AAAAAA", a.toString())
            }
            fileContent!!.text = temp.toString()
            fin.close()


        } catch (e: IOException) {
            e.printStackTrace()
        }
        printMessage("reading to file $filename completed..")
    }
}