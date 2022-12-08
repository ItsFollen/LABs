package com.example.alarmmanager12

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.HandlerThread
import android.os.IBinder
import android.os.Process.THREAD_PRIORITY_BACKGROUND
import android.os.SystemClock
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.os.Process;
import androidx.core.app.NotificationCompat
import com.example.alarmmanager12.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    val binding: ActivityMainBinding by
    lazy { ActivityMainBinding.inflate(layoutInflater) }
    var pendingIntent: PendingIntent? = null
    private var alarmMgr: AlarmManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.understand.setOnClickListener {
            alarmMgr = baseContext.getSystemService(Context.ALARM_SERVICE) as? AlarmManager?


            val alarmIntent = Intent(this, AlarmReceiver::class.java)


            val pendingIntent = PendingIntent.getBroadcast(
                baseContext,
                123456,
                alarmIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
            )
            alarmMgr?.setRepeating(
                AlarmManager.RTC_WAKEUP,
                SystemClock.elapsedRealtime() + 60 * 1000,
                1000 * 3600,
                pendingIntent
            )

            startActivity(Intent(this, ExerciseActivity::class.java))
        }
        binding.enough.setOnClickListener {

            if (pendingIntent != null)
                alarmMgr!!.cancel(pendingIntent)
        }
    }
}

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, p1: Intent?) {


        Toast.makeText(context, "Alarm", Toast.LENGTH_SHORT).show()

        var prefs = context!!.getSharedPreferences("myPresf", Context.MODE_PRIVATE)

        prefs.edit().putInt("ID", (0 until 6).random())

    }

}


