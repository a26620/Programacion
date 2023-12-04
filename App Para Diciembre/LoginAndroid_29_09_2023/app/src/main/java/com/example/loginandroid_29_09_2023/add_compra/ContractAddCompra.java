package com.example.loginandroid_29_09_2023.add_compra;


import com.example.loginandroid_29_09_2023.beans.Compra;

public interface ContractAddCompra {
    public interface View{
        public void successLogin();
        void failureLogin(String err);
        // void failureLogin(MyException err);
    }
    public interface Presenter{
        // void login(String email, String pass);
        void add(Compra compra);
        // void login(ViewUser viewUser);
        // VIEW-ORM
        // BEANS-ENTITIES
        // MVP - MVVM
    }
    public interface Model{
        interface OnAddCompraListener{
            void onFinished();
            void onFailure(String err);
        }
        void addCompraAPI(Compra compra,
                        OnAddCompraListener onAddCompraListener);
    }
}
