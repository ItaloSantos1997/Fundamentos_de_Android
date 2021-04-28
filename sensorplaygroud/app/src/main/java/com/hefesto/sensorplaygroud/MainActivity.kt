package com.hefesto.sensorplaygroud

import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private var text: TextView? = null
    private lateinit var sensorManager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text = findViewById<View>(R.id.textView) as TextView

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        val availableSensors = sensorManager.getSensorList(Sensor.TYPE_ALL)
        availableSensors.firstOrNull() {it.vendor.contains(other = "Google LLC")}

        for (sensor in availableSensors) text!!.append("${sensor.name}\n")

        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null){
            // Sensor DETECTADO!!
        }
        else {
            // Sensor NÃO DETECTADO!!
        }
    }
}