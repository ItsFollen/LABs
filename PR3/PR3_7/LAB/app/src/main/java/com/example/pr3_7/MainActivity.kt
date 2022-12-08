package com.example.pr3_7

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.pr3_7.databinding.ActivityMainBinding
import com.example.pr3_7.databinding.ChekboxDialogBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.timepicker.MaterialTimePicker

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    var sun = false
    var moon = false
    var  hour=0
    var  minute=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.root.setOnClickListener {

            MaterialAlertDialogBuilder(this).apply {
                val dialogContent = AlertDialogContent(context, sun, moon)
                setView(dialogContent)
                setPositiveButton("ok") { d, s ->
                    sun = dialogContent.day
                    moon = dialogContent.moon

                    showDateTimePiker()
                }
            }.show()
        }

    }



    //Datetime piker
    fun showDateTimePiker() {

        val timePicker: MaterialTimePicker = MaterialTimePicker
            .Builder()
            .setHour(hour)
            .setMinute(minute)
            .setTitleText("Select a time")
            .build()
        timePicker.show(supportFragmentManager, "TIME_PICKER")

        timePicker.addOnPositiveButtonClickListener {
            timePicker.hour     // returns the selected hour
            timePicker.minute   // returns the selected minute
            hour=timePicker.hour
            minute=timePicker.minute
            supportFragmentManager.findFragmentById(R.id.fragment).apply {
                if (this is TestFragment)
                  this.setState(timePicker.hour,timePicker.minute,sun,moon)
            }


        }
    }
}


//CheckBox Dialog Content

class AlertDialogContent(context: Context, var day: Boolean, var moon: Boolean) :
    LinearLayout(context) {

    var content: ChekboxDialogBinding

    init {

        content = ChekboxDialogBinding.inflate(LayoutInflater.from(context))


        content.moon.apply {
            isChecked = moon
            setOnCheckedChangeListener { compoundButton, b ->
                moon = b

            }
        }
        content.day.apply {
            isChecked = day
            setOnCheckedChangeListener { compoundButton, b ->
                day = b

            }
        }
        addView(content.root)
    }


}