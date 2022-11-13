package com.example.simondiceencasa

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    var contadorRonda: Int = 0;
    var secuencia = ArrayList<Int>()
    var posicion: Int = 0;
    var secuenciaUser = ArrayList<Int>()
    var porcentaje: Int = 100;

    val rojo = Color.alpha(R.color.red)
    val verde = Color.alpha(R.color.green)
    val amarillo = Color.alpha(R.color.yellow)
    val azul = Color.alpha(R.color.blue)

    val rojoClaro = Color.parseColor("#FF4B4B")
    val verdeClaro = Color.parseColor("#93FF4B")
    val amarilloClaro = Color.parseColor("#FFFE00")
    val azulClaro = Color.parseColor("#00FFF9")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}