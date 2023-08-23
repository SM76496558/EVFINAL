package com.diego.evfinal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.diego.evfinal.databinding.ActivityInicioBinding;

public class InicioActivity extends AppCompatActivity {

  private static final int delay = 5000;
  private ActivityInicioBinding binding;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityInicioBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    binding.txtInicioUp.setText(R.string.txtStartUp);


    new Handler().postDelayed(new Runnable() {
      @Override
      public void run() {
        Intent intent = new Intent(InicioActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
      }
    }, delay);
  }


}
