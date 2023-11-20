package com.example.loginandroid_29_09_2023.beans;


import java.util.List;
public class Sala{
    private String nombre;
    private int capacidad;
    private int id_sala;

    //Constructores
    public Sala(String nombre, int capacidad, int id_sala) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.id_sala = id_sala;
    }

    public Sala() {
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getId_sala() {
        return id_sala;
    }

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }
}

