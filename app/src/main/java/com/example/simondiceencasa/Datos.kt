package com.example.simondiceencasa

import androidx.room.*

@Entity
data class Dato(
    @PrimaryKey (autoGenerate = true),
    @ColumnInfo(name = "puntos") val puntos: Int?,
    @ColumnInfo(name = "fecha") val fecha: String?
   )

