package com.diego.evfinal;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.diego.evfinal.databinding.ActivityDetallePeliculaBinding;

import coil.Coil;
import coil.ImageLoader;
import coil.request.ImageRequest;

public class DetallePelicula extends AppCompatActivity {


  private ActivityDetallePeliculaBinding binding;
  public static final String IMAGE = "image";
  public static final String TITLE = "title";
  public static final String ORIGINALTITLE = "originaltitle";
  public static final String DIRECTOR = "director";
  public static final String RELEASEDATE = "releasedate";
  public static final String DESCRIPTION = "description";


  @Override

  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityDetallePeliculaBinding.inflate(getLayoutInflater());
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




  }


}
