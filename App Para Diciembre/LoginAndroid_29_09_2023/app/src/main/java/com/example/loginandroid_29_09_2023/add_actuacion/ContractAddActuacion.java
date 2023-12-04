package com.example.loginandroid_29_09_2023.add_actuacion;


import com.example.loginandroid_29_09_2023.beans.Obra;

public interface ContractAddActuacion {
    public interface View{
        public void successLogin();
        void failureLogin(String err);
        // void failureLogin(MyException err);
    }
    public interface Presenter{
        // void login(String email, String pass);
        void add(Obra obra);
        // void login(ViewUser viewUser);
        // VIEW-ORM
        // BEANS-ENTITIES
        // MVP - MVVM
    }
    public interface Model{
        interface OnAddActuacionListener{
            void onFinished();
            void onFailure(String err);
        }
        void addActuacionAPI(Obra obra,
                        OnAddActuacionListener onAddActuacionListener);
    }
}
