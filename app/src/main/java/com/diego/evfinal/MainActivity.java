package com.diego.evfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.diego.evfinal.databinding.ActivityMainBinding;
import com.diego.evfinal.fragments.MainFragment;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {


  private ActivityMainBinding binding;
  private SharedPreferences sharedPreferences;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    sharedPreferences = getSharedPreferences(LoginActivity.SESSION_PREFERENCE, MODE_PRIVATE);
    setContentView(binding.getRoot());

//    boolean isSessionActivated = sharedPreferences.getBoolean(LoginActivity.SESSION_ACTIVATED, false);
//    if (isSessionActivated) {
//      Intent intent = new Intent(this, InicioActivity.class);
//    }
    binding.fabAddMovie.setOnClickListener(v -> {
      Snackbar.make(binding.getRoot(), "Añadiste una pelicula/OVA", Snackbar.LENGTH_SHORT).show();
    });
    binding.tbEVC03.setTitle("Studio Ghibli");
    setSupportActionBar(binding.tbEVC03);
    addHomeFragment();
  }

  private void addHomeFragment() {
    getSupportFragmentManager().beginTransaction().add(binding.fcvMain.getId(), new MainFragment()).commit();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_items, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    if (item.getItemId() == R.id.search) {
      Snackbar.make(binding.getRoot(), "Search", Snackbar.LENGTH_SHORT).show();
      return true;
//    } else if (item.getItemId() == R.id.settings) {
//      Snackbar.make(binding.getRoot(), "Settings", Snackbar.LENGTH_SHORT).show();
//      return true;
    } else if (item.getItemId() == R.id.logout) {
      sharedPreferences.edit().clear().apply();
      Intent intent = new Intent(this, LoginActivity.class);
      startActivity(intent);
      finish();
      return true;

    } else {
      return false;
    }
  }
}