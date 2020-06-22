package com.example.movieslisttask.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movieslisttask.db.entities.Movie

/**
 * Created by alexkorolov on 2020-01-17.
 */
@Database(entities = [Movie::class], version = AppRoomDataBase.DB_VERSION, exportSchema = false)
abstract class AppRoomDataBase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        const val DB_VERSION = 1
        const val DB_NAME = "MOVIES_DATABASE"
    }
}