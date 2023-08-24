package com.diego.evfinal.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.diego.evfinal.model.PeliculaEntity;

import java.util.List;

public class PeliculaRepository {

  private PeliculaDao dao;
  private EVFINAL_DB db;

  public PeliculaRepository(Application application) {
    db = EVFINAL_DB.getInstance(application);
    dao = db.peliculaDao();
  }

  public void addPelicula(PeliculaEntity peliculaEntity){
    EVFINAL_DB.dataBaseWriteExecutor.execute(() ->
            dao.addPelicula(peliculaEntity));
  }

  public LiveData<List<PeliculaEntity>> getAll(){
    return dao.getAll();
  }
}
