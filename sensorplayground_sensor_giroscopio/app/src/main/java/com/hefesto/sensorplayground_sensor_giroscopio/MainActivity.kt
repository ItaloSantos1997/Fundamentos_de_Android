package com.hefesto.sensorplayground_sensor_giroscopio

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity() : AppCompatActivity(), SensorEventListener {
    private var text: TextView? = null
    private lateinit var sensorManager: SensorManager
    private lateinit var gyroscopeSensor: Sensor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text = findViewById<View>(R.id.textView) as TextView

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this, gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onAccuracyChanged(sensor: Sensor, accurancy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent) {
        val x: Float = event.values[0]
        val y: Float = event.values[1]
        val z: Float = event.values[2]

        text!!.text = "x = %.1f rad/s, y = %.1f rad/s, z = %.1f rad/s".format(x, y, z)
    }
}