package com.example.loginandroid_29_09_2023.login_user.data;

import com.example.loginandroid_29_09_2023.beans.User;

import java.util.ArrayList;

public class DataUsers {
    private String message;
    private ArrayList<User> usersList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<User> getUsersList() {
        return usersList;
    }

    public void setProductList(ArrayList<User> usersList) {
        this.usersList = usersList;
    }
}
