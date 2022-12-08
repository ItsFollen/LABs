package com.example.readingsensor411

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.readingsensor411.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private var sensorL: Sensor? = null
    private var sensorR: Sensor? = null
    private var sensorA: Sensor? = null
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        //Detection of sensors
        sensorL = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
        sensorR = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)
        sensorA = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)


        if (sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT) == null) {
            Toast.makeText(this, resources.getString(R.string.sensorAbsentL), Toast.LENGTH_SHORT)
                .show()
        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR) == null) {
            Toast.makeText(this, resources.getString(R.string.sensorAbsentR), Toast.LENGTH_SHORT)
                .show()

        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) == null) {
            Toast.makeText(this, resources.getString(R.string.sensorAbsentA), Toast.LENGTH_SHORT)
                .show()

        }

        binding.l.setOnCheckedChangeListener { compoundButton, b ->
            if (b)
                select(0)
        }
        binding.r.setOnCheckedChangeListener { compoundButton, b ->
            if (b)
                select(1)

        }
        binding.a.setOnCheckedChangeListener { compoundButton, b ->
            if (b)
                select(2)
        }


    }


    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this, sensorL, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, sensorR, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, sensorA, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    private fun select(type: Int) {
        when (type) {
            0 -> {
                binding.seansText.text = "Освещённость : "
                binding.r.isChecked = false
                binding.a.isChecked = false

            }
            1 -> {
                binding.seansText.text = "Проекции вектора по остям : "
                binding.l.isChecked = false
                binding.a.isChecked = false
            }
            2 -> {
                binding.seansText.text = "Динамическое ускорение по осям: "
                binding.r.isChecked = false
                binding.l.isChecked = false
            }
        }
    }

    override fun onSensorChanged(p0: SensorEvent) {
        when (p0.sensor.type) {

            Sensor.TYPE_LIGHT -> {
                if (binding.l.isChecked) {
                    binding.seansText.text = "Освещённость : ${p0.values[0]}"
                }
                Log.e("TAG", "onSensorChanged: sensor when L   ${p0}")
            }
            Sensor.TYPE_ROTATION_VECTOR -> {
                if (binding.r.isChecked) {
                    binding.seansText.text =
                        "Проекции вектора по остям : \nOX(${p0.values[0]})\nOY(${p0.values[1]})\n" +
                                "OZ(${p0.values[2]})\nскалярная мера угла поворота: ${p0.values[3]}"
                }

            }
            Sensor.TYPE_ACCELEROMETER -> {
                if (binding.a.isChecked) {


                    binding.seansText.text = "Динамическое ускорение по остям:\n" +
                            "OX(${p0.values[0]})\n" +
                            "OY(${p0.values[1]})\n" +
                            "OZ(${p0.values[2]})"
                }

            }
        }


    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        Log.e("TAG", "onSensorChanged:ser ${p0}")
    }
}