package com.hefesto.calculadora_de_imc

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.math.BigDecimal
import kotlin.math.roundToInt
import kotlin.math.roundToLong


class MainActivity : AppCompatActivity() {
    private var txt_valor1: EditText? = null
    private var txt_valor2: EditText? = null
    private var txt_resultado: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txt_valor1 = findViewById<View>(R.id.txt_valor1) as EditText
        txt_valor2 = findViewById<View>(R.id.txt_valor2) as EditText
        txt_resultado = findViewById<View>(R.id.txt_resultado) as TextView
    }

    @SuppressLint("SetTextI18n")
    fun calcular(view: View?) {
        val valor1: Double
        val valor2: Double
        val valor: String
        val resultado: Double

        valor1 = txt_valor1!!.text.toString().toDouble()
        valor2 = txt_valor2!!.text.toString().toDouble()

        resultado = valor1 / (valor2 * valor2)
        valor = String.format("%.2f", resultado)
        //valor = resultado.toDouble().toBigDecimal(2)
        //resultado = valor1 / (valor2 * valor2)
        //txt_resultado!!.text = java.lang.Double.toString(resultado)
        txt_resultado!!.text = java.lang.Double.toString(valor)
    }
}