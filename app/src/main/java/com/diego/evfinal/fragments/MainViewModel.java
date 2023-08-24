package com.diego.evfinal.fragments;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.diego.evfinal.database.PeliculaRepository;
import com.diego.evfinal.model.PeliculaEntity;
import com.diego.evfinal.model.Peliculas;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
  private PeliculaRepository repository;
  private LiveData<List<PeliculaEntity>> allPeliculas;
  public LiveData<List<PeliculaEntity>> listLiveData = new MutableLiveData<List<PeliculaEntity>>();

  public MainViewModel(@NonNull Application application) {
    super(application);
    repository = new PeliculaRepository(application);
    allPeliculas = repository.getAll();
  }

  public void addPelicula(Peliculas pelicula){
    PeliculaEntity peliculaEntity = new PeliculaEntity();
    peliculaEntity.setTitle(pelicula.getTitle());
    peliculaEntity.setImage(pelicula.getImage());
    repository.addPelicula(peliculaEntity);
  }

  public LiveData<List<PeliculaEntity>> getAllPeliculas() {
    return allPeliculas;
  }

  public void getPeliculas(){
    listLiveData = repository.getAll();
  }

  public class MainViewModelFactory implements ViewModelProvider.Factory{
    private final Application application;
    public MainViewModelFactory(Application myApplication){
      application = myApplication;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
      return (T)  new MainViewModel(application);
    }
  }
}
