package com.example.simondiceencasa;

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

public class MyViewModel: ViewModel() {
    // para que sea mas facil la etiqueta del log
    private val TAG_LOG: String = "mensaje ViewModel"

    // este va a ser nuestra lista para la secuencia random
    // usamos mutable, ya que la queremos modificar
    val contadorRonda = mutableListOf<Int>()
    // definimos una MutableLiveData
    // para poder observar los valores de la MutableList<Int>
    val livedata_contadorRonda = MutableLiveData<MutableList<Int>>()

    // inicializamos variables cuando instanciamos
    init {
        Log.d(TAG_LOG, "Inicializamos livedata")
        livedata_contadorRonda.value = contadorRonda
    }

    /**
     * añadimos entero random al
     */
    fun si(): Int {
        if (contadorRonda.isEmpty())
            contadorRonda.add(0)
        var ultimoValor=contadorRonda[contadorRonda.lastIndex]
        ultimoValor++
        contadorRonda.add(ultimoValor)
        Log.d("estado", "aparece marcador de ronda")

        Log.d("estado", "ronda:" + contadorRonda)
        return contadorRonda[contadorRonda.lastIndex]
    }
}
