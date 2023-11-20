package com.example.loginandroid_29_09_2023.beans;

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

    public static String convertUsersToJSONString(List<User> users) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");
        jsonBuilder.append("[");

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            jsonBuilder.append("{");
            jsonBuilder.append("\"id_user\": \"").append(user.getId_user()).append("\", ");
            jsonBuilder.append("\"username\": \"").append(user.getUsername()).append("\", ");
            jsonBuilder.append("\"pass\": \"").append(user.getPass()).append("\", ");
            jsonBuilder.append("\"email\": \"").append(user.getEmail()).append("\", ");
            jsonBuilder.append("\"rol\": \"").append(user.getRol()).append("\"");
            jsonBuilder.append("}");

            // Si no es el último elemento, añade una coma
            if (i < users.size() - 1) {
                jsonBuilder.append(", ");
            }
        }

        jsonBuilder.append("]");
        jsonBuilder.append("}");
        System.out.println(jsonBuilder.toString());
        return jsonBuilder.toString();
    }
}

