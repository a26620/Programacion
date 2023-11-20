package com.example.loginandroid_29_09_2023.list_sala;

import com.example.loginandroid_29_09_2023.beans.Sala;

import java.util.ArrayList;

public interface ContractListSala  {
    public interface View{
        public void successLogin(Sala sala);
        void failureLogin(String err);
        // void failureLogin(MyException err);
    }
    public interface Presenter{
        // void login(String email, String pass);
        void add(Sala sala);
        // void login(ViewUser viewUser);
        // VIEW-ORM
        // BEANS-ENTITIES
        // MVP - MVVM
    }
    public interface Model{
        interface OnListSalaListener{
            void onFinished(ArrayList<Sala> lstSala);
            void onFailure(String err);
        }
        void listSalaAPI(Sala sala,
                         ContractListSala.Model.OnListSalaListener OnListSalaListener);
    }
}
