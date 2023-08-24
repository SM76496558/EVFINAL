package com.diego.evfinal.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.diego.evfinal.DetallePelicula;
import com.diego.evfinal.data.retrofit.RetrofitHelper;
import com.diego.evfinal.databinding.PeliculaShowRvBinding;
import com.diego.evfinal.model.Peliculas;

import java.util.List;

import coil.Coil;
import coil.ImageLoader;
import coil.request.ImageRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RVPeliculasAdapter extends RecyclerView.Adapter<RVPeliculasAdapter.ResumeVH> {


  private List<Peliculas> peliculas;

  public RVPeliculasAdapter(List<Peliculas> peliculas) {
    this.peliculas = peliculas;
  }


  @NonNull
  @Override
  public ResumeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    PeliculaShowRvBinding binding = PeliculaShowRvBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

    return new ResumeVH(binding);
  }


  @Override
  public void onBindViewHolder(@NonNull ResumeVH holder, @SuppressLint("RecyclerView") int position) {
    holder.bind(peliculas.get(position));

    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        RetrofitHelper.getService().getPelicula(peliculas.get(position).getId()).enqueue(new Callback<Peliculas>() {
          @Override
          public void onResponse(Call<Peliculas> call, Response<Peliculas> response) {
            if (response.isSuccessful()) {
              Intent intent = new Intent(view.getContext(), DetallePelicula.class);
              intent.putExtra(DetallePelicula.IMAGE, peliculas.get(position).getImage());
              intent.putExtra(DetallePelicula.TITLE, peliculas.get(position).getTitle());
              intent.putExtra(DetallePelicula.ORIGINALTITLE, peliculas.get(position).getOriginal_title());
              intent.putExtra(DetallePelicula.DIRECTOR, peliculas.get(position).getDirector());
              intent.putExtra(DetallePelicula.RELEASEDATE, peliculas.get(position).getRelease_date());
              intent.putExtra(DetallePelicula.DESCRIPTION, peliculas.get(position).getDescription());
              view.getContext().startActivity(intent);
            }
          }

          @Override
          public void onFailure(Call<Peliculas> call, Throwable t) {
            System.out.println(t);
          }
        });
      }


    });
  }


  @Override
  public int getItemCount() {
    return peliculas.size();
  }

  class ResumeVH extends RecyclerView.ViewHolder {
    private PeliculaShowRvBinding binding;

    public ResumeVH(PeliculaShowRvBinding binding) {
      super(binding.getRoot());
      this.binding = binding;
    }

    public void bind(Peliculas pelicula) {

      binding.txtTitle.setText(pelicula.getTitle());
      binding.txtTitleJapanese.setText(pelicula.getOriginal_title_romanised());
      binding.txtDescripcion.setText(pelicula.getDescription());
      ImageLoader imageLoader = Coil.imageLoader(binding.getRoot().getContext());
      ImageRequest request = new ImageRequest.Builder(binding.getRoot().getContext()).data(pelicula.getMovie_banner()).crossfade(true).target(binding.imgPelicula).build();
      imageLoader.enqueue(request);


    }
  }
}
