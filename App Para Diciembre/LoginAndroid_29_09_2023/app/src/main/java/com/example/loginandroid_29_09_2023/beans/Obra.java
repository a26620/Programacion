package com.example.loginandroid_29_09_2023.beans;

public class Obra{
    private Integer id_obra;
    private String titulo;
    private String descripcion;
    private String img;
    private Float precio;
    private Integer id_sala;
    private String fechaActuacion;
    private Float valoracionMedia;
    private Integer edadRecomendada;
    private String genero;
    private Integer duracion;
    private Integer id_genero;
    private String horaActuacion;

    private Integer id_actuacion;

    public Obra(Integer id_obra, String titulo, String descripcion, String img, Float precio, Integer id_sala, String fechaActuacion, Float valoracionMedia, Integer edadRecomendada, String genero, Integer duracion, String horaActuacion, Integer id_actuacion) {
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
        this.duracion = duracion;
        this.horaActuacion = horaActuacion;
        this.id_actuacion = id_actuacion;
    }

    public Integer getId_actuacion() {
        return id_actuacion;
    }

    public void setId_actuacion(Integer id_actuacion) {
        this.id_actuacion = id_actuacion;
    }

    public String getHoraActuacion() {
        return horaActuacion;
    }

    public void setHoraActuacion(String horaActuacion) {
        this.horaActuacion = horaActuacion;
    }
    public Integer getId_genero() {
        return id_genero;
    }

    public void setId_genero(Integer id_genero) {
        this.id_genero = id_genero;
    }
    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Obra() {
    }

    public Integer getId_obra() {
        return id_obra;
    }

    public void setId_obra(Integer id_obra) {
        this.id_obra = id_obra;
    }

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

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getId_sala() {
        return id_sala;
    }

    public void setId_sala(Integer id_sala) {
        this.id_sala = id_sala;
    }

    public String getFechaActuacion() {
        return fechaActuacion;
    }

    public void setFechaActuacion(String fechaActuacion) {
        this.fechaActuacion = fechaActuacion;
    }

    public Float getValoracionMedia() {
        return valoracionMedia;
    }

    public void setValoracionMedia(Float valoracionMedia) {
        this.valoracionMedia = valoracionMedia;
    }

    public Integer getEdadRecomendada() {
        return edadRecomendada;
    }

    public void setEdadRecomendada(Integer edadRecomendada) {
        this.edadRecomendada = edadRecomendada;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
