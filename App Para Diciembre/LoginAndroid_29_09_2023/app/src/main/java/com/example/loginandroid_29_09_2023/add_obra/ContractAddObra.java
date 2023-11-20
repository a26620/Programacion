package com.example.loginandroid_29_09_2023.add_obra;


import com.example.loginandroid_29_09_2023.beans.Obra;

public interface ContractAddObra {
    public interface View{
        public void successLogin(Obra obra);
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
        interface OnAddObraListener{
            void onFinished();
            void onFailure(String err);
        }
        void addObraAPI(Obra obra,
                        OnAddObraListener OnAddObraListener);
    }
}
