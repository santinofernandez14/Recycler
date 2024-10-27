package com.mysoft.recycler;

public class Movie {
    private String title;
    private String cover;
    private float estrellas;

    public Movie(String title, String cover, float estrellas) {
        this.title = title;
        this.cover = cover;
        this.estrellas = estrellas;
    }

    public String getTitle() {
        return title;
    }

    public String getCover() {
        return cover;
    }

    public float getEstrellas() {
        return estrellas;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setEstrellas(float estrellas) {
        this.estrellas = estrellas;
    }
}
