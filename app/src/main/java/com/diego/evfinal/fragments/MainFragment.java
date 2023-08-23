package com.diego.evfinal.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.diego.evfinal.R;
import com.diego.evfinal.data.response.PeliculasResponse;
import com.diego.evfinal.data.retrofit.RetrofitHelper;
import com.diego.evfinal.databinding.FragmentMainBinding;
import com.diego.evfinal.model.Peliculas;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainFragment extends Fragment {

  private FragmentMainBinding binding;
  private RecyclerView recyclerView;
  private RVPeliculasAdapter adapter;



//  @Override
//  public void onCreate(Bundle savedInstanceState) {
//    super.onCreate(savedInstanceState);
//
//
//  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    binding = FragmentMainBinding.inflate(inflater, container, false);
    return binding.getRoot();
  }



  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    recyclerView = view.findViewById(R.id.rvPeliculas);
    LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
    binding.rvPeliculas.setLayoutManager(layoutManager);




  RetrofitHelper.getService().getPeliculas().enqueue(new Callback<List<Peliculas>>() {
    @Override
    public void onResponse(Call<List<Peliculas>> call, Response<List<Peliculas>> response) {
        List<Peliculas> items = response.body();
        RVPeliculasAdapter adapter = new RVPeliculasAdapter(items);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailure(Call<List<Peliculas>> call, Throwable t) {

    }
  });
  }
}







