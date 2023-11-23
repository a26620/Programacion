package com.example.loginandroid_29_09_2023.login_user.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.SharedPreferences;


import com.example.loginandroid_29_09_2023.Home;
import com.example.loginandroid_29_09_2023.MainActivity;
import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.admin.view.AdminHome;
import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.login_user.ContractLoginUser;
import com.example.loginandroid_29_09_2023.login_user.presenter.LoginUserPresenter;

import java.util.Objects;

public class LoginUserM extends AppCompatActivity implements ContractLoginUser.View{

    SharedPreferences sharedPreferencesUserCFG;

    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnLogin;


    private LoginUserPresenter presenter =
            new LoginUserPresenter(this);

    /* PATRÓN SINGLETON*/
    private static LoginUserM mainActivity = null;
    public static LoginUserM getInstance(){
        return mainActivity; //0x457845AF
    }
    /* FIN PATRÓN SINGLETON*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user_m);
        mainActivity = this;
        initComponents();

    }

    private void initComponents(){
        sharedPreferencesUserCFG = getSharedPreferences("com.MyApp.USER_CFG", Context.MODE_PRIVATE);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(mainActivity, message, Toast.LENGTH_SHORT).show();
                //sPeliculas.getDatosPeliculas();
                User user = new User();
                user.setUsername(edtEmail.getText().toString());
                user.setPass(edtPassword.getText().toString());
                presenter.login(user);
            }
        });
    }


    @Override
    public void successLogin(User user) {
        SharedPreferences.Editor editor = sharedPreferencesUserCFG.edit();
        editor.putBoolean("isLoggedIn", true);
        editor.putString("username", user.getUsername());
        editor.putInt("id_user", user.getId_user());
        editor.apply();
        if (Objects.equals(user.getRol(), "A")){
            Intent mainIntent = new Intent(LoginUserM.this,
                    AdminHome.class);
            startActivity(mainIntent);
        } else if (Objects.equals(user.getRol(), "U")) {
            Intent mainIntent = new Intent(LoginUserM.this,
                    Home.class);
            startActivity(mainIntent);
        }
    }

    @Override
    public void failureLogin(String err) {

    }




}