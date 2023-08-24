package com.diego.evfinal.database;



import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.diego.evfinal.model.PeliculaEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {PeliculaEntity.class}, version = 1)
public abstract class EVFINAL_DB extends RoomDatabase{
  public abstract PeliculaDao peliculaDao();
  private static volatile EVFINAL_DB db;

  public static final ExecutorService dataBaseWriteExecutor = Executors.newFixedThreadPool(4);

  public static EVFINAL_DB getInstance(Context context){
    if (db == null){
      synchronized(EVFINAL_DB.class){
        if (db== null){
          db = Room.databaseBuilder(context.getApplicationContext(), EVFINAL_DB.class, "evFinal-database").build();
        }
      }
    }
    return db;
  }

}
