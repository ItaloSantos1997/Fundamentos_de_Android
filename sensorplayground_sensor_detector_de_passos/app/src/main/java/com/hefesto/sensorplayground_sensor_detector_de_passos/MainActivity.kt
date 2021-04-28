package com.hefesto.sensorplayground_sensor_detector_de_passos

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
    private lateinit var StepDetectorSensor: Sensor
    var steps: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text = findViewById<View>(R.id.textView) as TextView

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        StepDetectorSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this, StepDetectorSensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onAccuracyChanged(sensor: Sensor, accurancy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent) {
        val stepCount = event.values[0]
        if (stepCount != null){
            steps += 1
            text!!.text = "Número de Passos: $steps"
        }
    }
}