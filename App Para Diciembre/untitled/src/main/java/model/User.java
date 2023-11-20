package model;

import java.util.List;

public class User{
    private String username;
    private String pass;
    private String email;
    private int id_user;
    private String rol;


    //Constructores
    public User(String username, String pass, String email, int id_user, String rol) {
        this.username = username;
        this.pass = pass;
        this.email = email;
        this.id_user = id_user;
        this.rol = rol;
    }
    public User() {
    }


    // Getters y setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}

