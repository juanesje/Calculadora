package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var opercion: Int = 0
    var numero1: Double = 0.0
    lateinit var VT_num1: TextView
    lateinit var VT_num2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        VT_num1 = findViewById(R.id.VT_num1)
        VT_num2 = findViewById(R.id.VT_num2)
        val btn_borrar: Button = findViewById(R.id.btn_borrar)
        val btn_igual: Button = findViewById(R.id.btn_igual)

        btn_igual.setOnClickListener{
            var numero2: Double = VT_num2.text.toString().toDouble()
            var resp: Double = 0.0

            when(opercion){
                1 -> resp = numero1 + numero2
                2 -> resp = numero1 - numero2
                3 -> resp = numero1 * numero2
                4 -> resp = numero1 / numero2
            }

            VT_num2.setText(resp.toString())
            VT_num1.setText("")
        }

        btn_borrar.setOnClickListener {
            VT_num2.text = ""
            VT_num1.text = ""
            numero1 = 0.0
            opercion = 0
        }

    }

    fun presionarDigito(view: View) {
        var num2_text: String = VT_num2.text.toString()

        when (view.id) {
            R.id.btn_0 -> num2_text += "0"
            R.id.btn_1 -> num2_text += "1"
            R.id.btn_2 -> num2_text += "2"
            R.id.btn_3 -> num2_text += "3"
            R.id.btn_4 -> num2_text += "4"
            R.id.btn_5 -> num2_text += "5"
            R.id.btn_6 -> num2_text += "6"
            R.id.btn_7 -> num2_text += "7"
            R.id.btn_8 -> num2_text += "8"
            R.id.btn_9 -> num2_text += "9"
        }

        VT_num2.text = num2_text
    }


    fun clickOperacion(view: View){
        numero1 = VT_num2.text.toString().toDouble()
        var num2_text: String = VT_num2.text.toString()
        VT_num2.setText("")

        when (view.id){
            R.id.btn_mas -> {
                VT_num1.setText(num2_text + "+")
                opercion = 1
            }
            R.id.btn_menos -> {
                VT_num1.setText(num2_text + "-")
                opercion = 2
            }
            R.id.btn_por -> {
                VT_num1.setText(num2_text + "x")
                opercion = 3
            }
            R.id.btn_div -> {
                VT_num1.setText(num2_text + "/")
                opercion = 4
            }
        }
    }
}
