package com.example.waiting46

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.*
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.waiting46.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {


    //    var timerBroadCast = object : BroadcastReceiver() {
//        override fun onReceive(p0: Context?, intent: Intent?) {
//
//            intent?.let {
//                val time = it.getStringExtra(TimeTickService.TIME_EXTRA)
//                content.print.text = "время созерцания: $time мин."
//            }
//
//        }
    var tickReceiver: BroadcastReceiver? = null


    private val content: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(content.root)


        tickReceiver = object : BroadcastReceiver() {
            override fun onReceive(p0: Context?, intent: Intent?) {
                var bm = applicationContext.getSystemService(BATTERY_SERVICE) as BatteryManager


                val level = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)

                if (level ==15)
                    Toast.makeText(
                        p0,
                        "${resources.getString(R.string.toast_text)}  $level",
                        Toast.LENGTH_SHORT
                    )
                        .show()

                content.print.text =
                    "время созерцания: ${Calendar.getInstance().get(Calendar.MINUTE)} мин."

            }

        }


        registerReceiver(tickReceiver, IntentFilter(Intent.ACTION_TIME_TICK))


    }


    fun cancel_wait(view: View) {

        try {
            unregisterReceiver(tickReceiver)
        } catch (e: IllegalArgumentException) {
            print(e)
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        try {

        } catch (e: IllegalArgumentException) {
            print(e)
        }
    }
}
