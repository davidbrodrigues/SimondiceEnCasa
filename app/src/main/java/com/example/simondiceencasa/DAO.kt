package com.example.simondiceencasa

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

class DAO {
    @Dao
    interface UserDao {
        @Query("SELECT * FROM Dato")
        fun getAll(): List<Dato>

        @Query("SELECT * FROM Dato WHERE puntos = SELECT MAX(puntos) FROM Datos")

        @Insert
        fun insertAll(Dato: Dato)
    }
}