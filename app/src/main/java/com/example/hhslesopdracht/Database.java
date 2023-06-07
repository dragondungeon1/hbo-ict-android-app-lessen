package com.example.hhslesopdracht;


import android.content.Context;

import com.example.hhslesopdracht.DOAs.CharacterDAO;
import com.example.hhslesopdracht.DOAs.ShowDAO;
import com.example.hhslesopdracht.models.Character;
import com.example.hhslesopdracht.models.Show;

@androidx.room.Database(
        entities = {
                Character.class,
                Show.class
        },
        version = 1,
        exportSchema = false
)

public abstract class Database extends RoomDatabase {
    public abstract CharacterDAO characterDAO();
    public abstract ShowDAO showDAO();

    public static Database getDatabase(Context context) {
        Database database;
        synchronized (Database.class) {
            database = Room.databaseBuilder(context, Database.class, "primeDB")
                    .allowMainThreadQueries()
                    .build();
        }
    }
}
