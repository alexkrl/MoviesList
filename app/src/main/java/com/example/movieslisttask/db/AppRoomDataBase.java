package com.example.movieslisttask.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.movieslisttask.model.Movie;
import com.example.movieslisttask.model.MovieDao;

/**
 * Created by alexkorolov on 2020-01-17.
 */

@Database(entities = {Movie.class}, version = 1, exportSchema = false)
public abstract class AppRoomDataBase extends RoomDatabase {

    public abstract MovieDao movieDao();

    private static AppRoomDataBase INSTANCE;

    public static AppRoomDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppRoomDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppRoomDataBase.class, "room_db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
