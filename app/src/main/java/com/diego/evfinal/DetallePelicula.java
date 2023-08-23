package com.diego.evfinal;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.diego.evfinal.databinding.ActivityDetallePeliculaBinding;

import coil.Coil;
import coil.ImageLoader;
import coil.request.ImageRequest;

public class DetallePelicula extends AppCompatActivity {


  private ActivityDetallePeliculaBinding binding;

  public static final String TITLE = "title";
  public static final String IMAGE = "image";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityDetallePeliculaBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());


    String titulo = getIntent().getStringExtra(TITLE);
    String image = getIntent().getStringExtra(IMAGE);

    binding.txtTitleDetalle.setText(titulo);

    ImageLoader imageLoader = Coil.imageLoader(binding.getRoot().getContext());
    ImageRequest request = new ImageRequest.Builder(binding.getRoot().getContext()).data(image).crossfade(true).target(binding.imgPeliculaDetalle).build();
    imageLoader.enqueue(request);


  }






}
