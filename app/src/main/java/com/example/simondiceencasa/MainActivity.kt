package com.example.simondiceencasa

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.activity.viewModels
import androidx.lifecycle.Observer

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
        val miModelo by viewModels<MyViewModel>()

        val botonJugar: Button = findViewById(R.id.jugar)
        val bcomprobar: Button = findViewById(R.id.comprobar)
        val brojo: Button = findViewById(R.id.rojo)
        val bamarillo: Button = findViewById(R.id.amarillo)
        val bazul: Button = findViewById(R.id.azul)
        val bverde: Button = findViewById(R.id.verde)
        botonJugar.setOnClickListener() {
            mostrarRonda()
            secuenciaUser.clear()
            ejecutarSecuencia()


        }
        bcomprobar.setOnClickListener(){
            comprobarSecuencia()
        }
        bverde.setOnClickListener(){
            secuenciaUser.add(1)
            val job = GlobalScope.launch(Dispatchers.Main) {
                suspenderVerde(bverde, verdeClaro, verde)
            }
        }
        brojo.setOnClickListener(){
            secuenciaUser.add(2)
            val job2 = GlobalScope.launch(Dispatchers.Main) {
                suspenderRojo(brojo, rojoClaro, rojo)
            }
        }
        bazul.setOnClickListener(){
            secuenciaUser.add(3)
            val job3 = GlobalScope.launch(Dispatchers.Main) {
                suspenderAzul(bazul, azulClaro, azul)
            }
        }
        bamarillo.setOnClickListener(){
            secuenciaUser.add(4)
            val job4 = GlobalScope.launch(Dispatchers.Main) {
                suspenderAmarillo(bamarillo, amarilloClaro, amarillo)
            }
        }

    }

    fun mostrarRonda() {
        val miModelo by viewModels<MyViewModel>()
// observamos cambios en livedata
        miModelo.livedata_contadorRonda.observe(
            this,
            Observer(
            fun (nuevaSecuencia: MutableList<Int>){
                contadorRonda = nuevaSecuencia.size

            }

            )
        )
        val tContador: TextView = findViewById(R.id.contador)
        tContador.text=( "Puntos: "+miModelo.si().toString())

    }

    fun ejecutarSecuencia() {

        val bverde: Button = findViewById(R.id.verde)
        val brojo: Button = findViewById(R.id.rojo)
        val bazul: Button = findViewById(R.id.azul)
        val bamarillo: Button = findViewById(R.id.amarillo)
        val randomInt = (1..4).random()
        Log.d("estado", "se ejecuta la secuencia " + randomInt)



        when (randomInt) {


            1 -> {
                secuencia.add(1)
            }
            2 -> {
                secuencia.add(2)
            }
            3 -> {
                secuencia.add(3)
            }
            4 -> {
                secuencia.add(4)
            }

        }
        println(secuencia)
        Log.d("estado" , "se guarda la secuencia " + secuencia[posicion])

        val job = GlobalScope.launch(Dispatchers.Main) {
            suspenderJugar(bverde,brojo,bazul,bamarillo)
        }
        Log.d("estado" , "se ejecuta la secuencia " + secuencia[posicion])


    }

    fun comprobarSecuencia(){
        if (secuencia.size == secuenciaUser.size){
            if (secuencia==secuenciaUser){
                Toast.makeText(this, "Ronda " + contadorRonda + " SUPERADA", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "PERDISTE MANCO", Toast.LENGTH_LONG).show()

            }
        }else{
            Toast.makeText(this, "PERDISTE MANCO", Toast.LENGTH_LONG).show()

        }

    }

    suspend fun suspenderJugar(bverde: Button,brojo: Button, bazul: Button,bamarillo: Button) {
        posicion=0

        for (i in 1..contadorRonda) {


            delay(1000L - contadorRonda*100)

            when (secuencia[posicion]) {


                1 -> {
                    val job = GlobalScope.launch(Dispatchers.Main) {
                        suspenderVerde(bverde, verdeClaro, verde)
                    }
                }

                2 -> {
                    val job2 = GlobalScope.launch(Dispatchers.Main) {
                        suspenderRojo(brojo, rojoClaro, rojo)
                    }
                }
                3 -> {
                    val job3 = GlobalScope.launch(Dispatchers.Main) {
                        suspenderAzul(bazul, azulClaro, azul)
                    }
                }
                4 -> {
                    val job4 = GlobalScope.launch(Dispatchers.Main) {
                        suspenderAmarillo(bamarillo, amarilloClaro, amarillo)
                    }
                }

            }
            posicion++



        }
    }

    suspend fun suspenderVerde(bverde: Button, colorChange: Int, colorDefault: Int) {
        bverde.setBackgroundColor(colorChange)
        delay(500L - contadorRonda*50)
        bverde.setBackgroundColor(colorDefault)
        delay(500L - contadorRonda*50)
    }

    suspend fun suspenderRojo(brojo: Button, colorChange: Int, colorDefault: Int) {
        brojo.setBackgroundColor(colorChange)
        delay(500L  - contadorRonda*50)
        brojo.setBackgroundColor(colorDefault)
        delay(500L  - contadorRonda*50)
    }

    suspend fun suspenderAzul(bazul: Button, colorChange: Int, colorDefault: Int) {
        bazul.setBackgroundColor(colorChange)
        delay(500L  - contadorRonda*50)
        bazul.setBackgroundColor(colorDefault)
        delay(500L  - contadorRonda*50)
    }

    suspend fun suspenderAmarillo(bamarillo: Button, colorChange: Int, colorDefault: Int) {
        bamarillo.setBackgroundColor(colorChange)
        delay(500L  - contadorRonda*50)
        bamarillo.setBackgroundColor(colorDefault)
        delay(500L  - contadorRonda*50)

    }

}

