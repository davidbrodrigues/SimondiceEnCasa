package com.example.simondiceencasa

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

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

        val botonJugar: Button = findViewById(R.id.jugar)
        val bcomprobar: Button = findViewById(R.id.comprobar)
        val brojo: Button = findViewById(R.id.rojo)
        val bamarillo: Button = findViewById(R.id.amarillo)
        val bazul: Button = findViewById(R.id.azul)
        val bverde: Button = findViewById(R.id.verde)

    }

    fun mostrarRonda() {

        val tContador: TextView = findViewById(R.id.contador)
        contadorRonda++
        tContador.text=( "Puntos: "+contadorRonda.toString())
        Log.d("estado", "aparece marcador de ronda")
        Toast.makeText(this, "Mostramos contador " + contadorRonda, Toast.LENGTH_LONG).show()

        Log.d("estado", "ronda:" + contadorRonda)

    }

}

