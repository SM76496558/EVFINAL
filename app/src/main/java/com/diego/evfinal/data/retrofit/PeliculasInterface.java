package com.diego.evfinal.data.retrofit;

import com.diego.evfinal.data.response.PeliculasResponse;
import com.diego.evfinal.model.Peliculas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PeliculasInterface {
  @GET("films")
  Call<List<Peliculas>> getPeliculas();

  @GET("films/{filmId}")
  Call<Peliculas> getPelicula(@Path("filmId") String filmId);
}
