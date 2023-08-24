package com.diego.evfinal.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.diego.evfinal.model.PeliculaEntity;

import java.util.List;

@Dao
public interface PeliculaDao {

  @Insert
  public void addPelicula(PeliculaEntity pelicula);

  @Query("SELECT * FROM peliculas")
  public LiveData<List<PeliculaEntity>> getAll();

  @Query("SELECT * FROM peliculas WHERE title LIKE :title LIMIT 1")
  public PeliculaEntity getPeliculaByTitle(String title);



}
