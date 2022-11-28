package com.example.simondiceencasa

import androidx.room.*

@Entity
data class Dato(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "puntos") val puntos: Int?,
    @ColumnInfo(name = "fecha") val fecha: String?
   )

