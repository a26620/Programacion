package com.example.loginandroid_29_09_2023.beans;

public class Obra{
    private int id_obra;
    private String titulo;
    private String descripcion;
    private String img;
    private float precio;
    private int id_sala;
    private String fechaActuacion;
    private int valoracionMedia;
    private int edadRecomendada;
    private String genero;


    public Obra(int id_obra, String titulo, String descripcion, String img, float precio, int id_sala, String fechaActuacion, int valoracionMedia, int edadRecomendada, String genero) {
        this.id_obra = id_obra;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.img = img;
        this.precio = precio;
        this.id_sala = id_sala;
        this.fechaActuacion = fechaActuacion;
        this.valoracionMedia = valoracionMedia;
        this.edadRecomendada = edadRecomendada;
        this.genero = genero;
    }

    public int getValoracionMedia() {
        return valoracionMedia;
    }

    public void setValoracionMedia(int valoracionMedia) {
        this.valoracionMedia = valoracionMedia;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getEdadRecomendada() {
        return edadRecomendada;
    }

    public void setEdadRecomendada(int edadRecomendada) {
        this.edadRecomendada = edadRecomendada;
    }

    public int getId_sala() {
        return id_sala;
    }


    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    public String getFechaActuacion() {
        return fechaActuacion;
    }

    public void setFechaActuacion(String fechaActuacion) {
        this.fechaActuacion = fechaActuacion;
    }

    public Obra() {
    }

    // Getters y setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getId_obra() {
        return id_obra;
    }

    public void setId_obra(int id_obra) {
        this.id_obra = id_obra;
    }
}

