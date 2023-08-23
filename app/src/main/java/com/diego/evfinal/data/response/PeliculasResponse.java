package com.diego.evfinal.data.response;

import com.diego.evfinal.model.Peliculas;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PeliculasResponse {
  @SerializedName("peliculasList")
  private List<Peliculas> peliculasList;

  public List<Peliculas> getPeliculasList() {
    return peliculasList;
  }
}