package com.example.loginandroid_29_09_2023.beans;

public class Compra {
    private Integer id_compra;
    private Integer id_user;
    private Integer id_actuacion;
    private String fechaCompra;
    private Float importe;
    private Integer nEntradas;
    private String tituloObra;


    public Compra(Integer id_compra, Integer id_user, Integer id_actuacion, String fechaCompra, Float importe, Integer nEntradas, String tituloObra) {
        this.id_compra = id_compra;
        this.id_user = id_user;
        this.id_actuacion = id_actuacion;
        this.fechaCompra = fechaCompra;
        this.importe = importe;
        this.nEntradas = nEntradas;
        this.tituloObra = tituloObra;
    }
    public String getTituloObra() {
        return tituloObra;
    }

    public void setTituloObra(String tituloObra) {
        this.tituloObra = tituloObra;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }

    public Integer getnEntradas() {
        return nEntradas;
    }

    public void setnEntradas(Integer nEntradas) {
        this.nEntradas = nEntradas;
    }

    public Compra() {
    }

    public Integer getId_compra() {
        return id_compra;
    }

    public void setId_compra(Integer id_compra) {
        this.id_compra = id_compra;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public Integer getId_actuacion() {
        return id_actuacion;
    }

    public void setId_actuacion(Integer id_actuacion) {
        this.id_actuacion = id_actuacion;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }


}

