package com.diego.evfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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

      showLogoutDialog();
      return true;

    } else {
      return false;
    }
  }

  private void showLogoutDialog() {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Cerrar sesión");
    builder.setMessage("¿Estás seguro de que deseas cerrar sesión?");
    builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        sharedPreferences.edit().clear().apply();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();

      }
    });
    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        dialog.dismiss();
      }
    });
    AlertDialog dialog = builder.create();
    dialog.show();
  }
}