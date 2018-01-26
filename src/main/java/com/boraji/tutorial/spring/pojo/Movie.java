package com.boraji.tutorial.spring.pojo;

public class Movie {

  long id;
  String title;
  int releaseYear;

  public Movie(long id, String title, int releaseYear) {
    this.id = id;
    this.title = title;
    this.releaseYear = releaseYear;
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(int releaseYear) {
    this.releaseYear = releaseYear;
  }
}
