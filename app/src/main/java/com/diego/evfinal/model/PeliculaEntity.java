package com.diego.evfinal.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "peliculas")
public class PeliculaEntity {

  @PrimaryKey(autoGenerate = true)
  public int id;

  @ColumnInfo(name= "title")
  public String title;

  @ColumnInfo(name =  "image")
  public String image;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }
}
