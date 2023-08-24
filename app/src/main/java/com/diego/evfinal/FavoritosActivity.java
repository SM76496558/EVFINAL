package com.diego.evfinal;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import com.diego.evfinal.databinding.ActivityDetallePeliculaBinding;
import com.diego.evfinal.databinding.ActivityFavoritosBinding;
import com.diego.evfinal.fragments.MainViewModel;
import com.diego.evfinal.model.PeliculaEntity;
import com.diego.evfinal.model.Peliculas;

import java.util.List;

import coil.Coil;
import coil.ImageLoader;
import coil.request.ImageRequest;

public class FavoritosActivity  extends AppCompatActivity {

  private ActivityFavoritosBinding binding;
  private LinearLayout svPeliculas;
  private MainViewModel mainViewModel;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mainViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainViewModel.class);
    binding = ActivityFavoritosBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    svPeliculas = findViewById(R.id.svPeliculas);


    mainViewModel.getAllPeliculas().observe(this, peliculaEntities -> {
      svPeliculas.removeAllViews();
      for (PeliculaEntity pelicula : peliculaEntities) {
        View movieView = getLayoutInflater().inflate(R.layout.pelicula_db_item, svPeliculas, false);

        TextView txtTitleFav = movieView.findViewById(R.id.txtTitleFavoritoItem);
        ImageView imgFav = movieView.findViewById(R.id.imgPeliculaFavoritoItem);


        txtTitleFav.setText(pelicula.getTitle());

        String imgURL = pelicula.getImage();
        ImageLoader imageLoader = Coil.imageLoader(binding.getRoot().getContext());
        ImageRequest request = new ImageRequest.Builder(binding.getRoot().getContext()).data(imgURL).crossfade(true).target(imgFav).build();
        imageLoader.enqueue(request);



        svPeliculas.addView(movieView);
      }
    });

  }
}
