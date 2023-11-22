package com.example.loginandroid_29_09_2023.beans;

import java.util.List;

public class Valoracion {
    private int id_rating;
    private int id_user;
    private int id_obra;
    private float puntuacion;
    private String fechaValoracion;

    // Constructor vacío
    public Valoracion() {
    }

    // Constructor con parámetros
    public Valoracion(int id_rating, int id_user, int id_obra, float puntuacion, String fechaValoracion) {
        this.id_rating = id_rating;
        this.id_user = id_user;
        this.id_obra = id_obra;
        this.puntuacion = puntuacion;
        this.fechaValoracion = fechaValoracion;
    }

    // Getters y Setters para cada atributo
    public int getId_rating() {
        return id_rating;
    }

    public void setId_rating(int id_rating) {
        this.id_rating = id_rating;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_obra() {
        return id_obra;
    }

    public void setId_obra(int id_obra) {
        this.id_obra = id_obra;
    }

    public float getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(float puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getFechaValoracion() {
        return fechaValoracion;
    }

    public void setFechaValoracion(String fechaValoracion) {
        this.fechaValoracion = fechaValoracion;
    }
}