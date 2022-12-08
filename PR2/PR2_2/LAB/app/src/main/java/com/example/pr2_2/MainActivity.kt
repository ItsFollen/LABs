package com.example.pr2_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var NCREATE = Toast.makeText(this,"Activity CREATED", Toast.LENGTH_SHORT)
        NCREATE.show()
    }

    override fun onStart() {
        super.onStart()
        var NSTART = Toast.makeText(this,"Activity STARTED", Toast.LENGTH_SHORT)
        NSTART.setGravity(Gravity.LEFT,0,0)
        NSTART.show()
    }

    override fun onResume() {
        super.onResume()
        var NRESUME = Toast.makeText(this,"Activity RESUME", Toast.LENGTH_SHORT)
        NRESUME.setGravity(Gravity.TOP,0,0)
        NRESUME.show()
    }

    override fun onPause() {
        super.onPause()
        var NPAUSE = Toast.makeText(this,"Activity PAUSED", Toast.LENGTH_SHORT)
        NPAUSE.setGravity(Gravity.RIGHT,0,0)
        NPAUSE.show()
    }

    override fun onStop() {
        super.onStop()
        var NSTOP = Toast.makeText(this,"Activity STOPPED", Toast.LENGTH_SHORT)
        NSTOP.setGravity(Gravity.CENTER,0,0)
        NSTOP.show()
    }

    override fun onRestart() {
        super.onRestart()
        var NRESTART = Toast.makeText(this,"Activity RESTARTED", Toast.LENGTH_SHORT)
        NRESTART.setGravity(Gravity.FILL_HORIZONTAL,0,0)
        NRESTART.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        var NDESTROY = Toast.makeText(this,"Activity DESTROYED", Toast.LENGTH_SHORT)
        NDESTROY.setGravity(Gravity.FILL,0,0)
        NDESTROY.show()
    }

}