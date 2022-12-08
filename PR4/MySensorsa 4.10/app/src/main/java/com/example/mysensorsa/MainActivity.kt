package com.example.mysensorsa


import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.mysensorsa.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), SensorEventListener, AdapterView.OnItemSelectedListener {
    private lateinit var sensorManager: SensorManager
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    val enviromentSensors = arrayOf(
        Sensor.TYPE_AMBIENT_TEMPERATURE,
        Sensor.TYPE_LIGHT,
        Sensor.TYPE_PRESSURE,
        Sensor.TYPE_RELATIVE_HUMIDITY,
        Sensor.TYPE_TEMPERATURE
    )
    val positionSensors = arrayOf(
        Sensor.TYPE_GAME_ROTATION_VECTOR,
        Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR,
        Sensor.TYPE_MAGNETIC_FIELD,
        Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED,
        Sensor.TYPE_ORIENTATION,
        Sensor.TYPE_PROXIMITY
    )

    val motionSensors = arrayOf(
        Sensor.TYPE_ACCELEROMETER,
        Sensor.TYPE_ACCELEROMETER_UNCALIBRATED,
        Sensor.TYPE_GRAVITY,
        Sensor.TYPE_GYROSCOPE,
        Sensor.TYPE_GYROSCOPE_UNCALIBRATED,
        Sensor.TYPE_LINEAR_ACCELERATION,
        Sensor.TYPE_ROTATION_VECTOR,
        Sensor.TYPE_SIGNIFICANT_MOTION,
        Sensor.TYPE_STEP_COUNTER,
        Sensor.TYPE_STEP_DETECTOR,
    )
    var sensList = listOf<Sensor>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        sensList = sensorManager.getSensorList(Sensor.TYPE_ALL)
        val ad: ArrayAdapter<*> = ArrayAdapter<Any?>(
            this,
            android.R.layout.simple_spinner_item,
            resources.getStringArray(R.array.type_sensors)
        )

        ad.setDropDownViewResource(
            android.R.layout
                .simple_spinner_dropdown_item
        )
        binding.spinner.adapter = ad
        binding.spinner.onItemSelectedListener = this
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()

    }

    override fun onSensorChanged(p0: SensorEvent?) {

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        binding.listSensor.text = ""

        sensList.forEach {

            when (position) {

                0 -> if (enviromentSensors.contains(it.type)) binding.listSensor.text =
                    binding.listSensor.text.toString().plus("${it.name}\n")
                1 -> if (positionSensors.contains(it.type)) binding.listSensor.text =
                    binding.listSensor.text.toString().plus("${it.name}\n")
                2 -> if (motionSensors.contains(it.type)) binding.listSensor.text =
                    binding.listSensor.text.toString().plus("${it.name}\n")
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}