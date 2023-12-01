package model;

public class Compra {
    private Integer id_compra;
    private Integer id_user;
    private Integer id_actuacion;
    private String fechaCompra;

    public Compra(Integer id_compra, Integer id_user, Integer id_actuacion, String fechaCompra) {
        this.id_compra = id_compra;
        this.id_user = id_user;
        this.id_actuacion = id_actuacion;
        this.fechaCompra = fechaCompra;
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
