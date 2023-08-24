package com.diego.evfinal;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


import com.diego.evfinal.database.PeliculaRepository;
import com.diego.evfinal.databinding.ActivityDetallePeliculaBinding;
import com.diego.evfinal.fragments.MainViewModel;
import com.diego.evfinal.model.PeliculaEntity;
import com.diego.evfinal.model.Peliculas;

import coil.Coil;
import coil.ImageLoader;
import coil.request.ImageRequest;

public class DetallePelicula extends AppCompatActivity {


  private ActivityDetallePeliculaBinding binding;

  private MainViewModel mainViewModel;
  private PeliculaRepository repository;
  public static final String IMAGE = "image";
  public static final String TITLE = "title";
  public static final String ORIGINALTITLE = "originaltitle";
  public static final String DIRECTOR = "director";
  public static final String RELEASEDATE = "releasedate";
  public static final String DESCRIPTION = "description";


  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = ActivityDetallePeliculaBinding.inflate(getLayoutInflater());
    mainViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainViewModel.class);
    setContentView(binding.getRoot());



    String image = getIntent().getStringExtra(IMAGE);
    String titulo = getIntent().getStringExtra(TITLE);
    String originalTitulo = getIntent().getStringExtra(ORIGINALTITLE);
    String director = getIntent().getStringExtra(DIRECTOR);
    String releaseDate = getIntent().getStringExtra(RELEASEDATE);
    String descripcion = getIntent().getStringExtra(DESCRIPTION);

    ImageLoader imageLoader = Coil.imageLoader(binding.getRoot().getContext());
    ImageRequest request = new ImageRequest.Builder(binding.getRoot().getContext()).data(image).crossfade(true).target(binding.imgPeliculaDetalle).build();
    imageLoader.enqueue(request);

    binding.txtTitleDetalle.setText(titulo);
    binding.txtOriginalTitle.setText(originalTitulo);
    binding.txtDirector.setText(director);
    binding.txtReleaseDate.setText(releaseDate);
    binding.txtDescripcionDetalle.setText(descripcion);

    Peliculas pelicula = new Peliculas();
    pelicula.setTitle(titulo);
    pelicula.setImage(image);

    binding.btnFavoritos.setOnClickListener(view -> {
      mainViewModel.addPelicula(pelicula);
      Toast.makeText(this, "¡Agregaste una pelicula a favoritos!", Toast.LENGTH_SHORT).show();
    });


  }





}
