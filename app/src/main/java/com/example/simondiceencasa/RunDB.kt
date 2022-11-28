package com.example.simondiceencasa

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

class RunDB{
@Database(
    entities = [Dato::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): DAO.UserDao
}

val db = Room.databaseBuilder(
    applicationContext,
    AppDatabase::class.java, "Datos"
).build()

val userDao = db.userDao()
val dato: List<Dato> = userDao.getAll()

}