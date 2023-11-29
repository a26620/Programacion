package com.example.loginandroid_29_09_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.loginandroid_29_09_2023.admin.view.AdminHome;
import com.example.loginandroid_29_09_2023.login_user.view.LoginUserM;


public class MainActivity extends AppCompatActivity{
    private static final long SPLASH_DISPLAY_LENGTH = 3000;
    SharedPreferences sharedPreferencesUserCFG;
    private boolean isLoggedIn(){
        return sharedPreferencesUserCFG.getBoolean("isLoggedIn", false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.SplashScreen);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                sharedPreferencesUserCFG = getSharedPreferences("com.MyApp.USER_CFG", Context.MODE_PRIVATE);

                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent;
                if (!isLoggedIn()){
                    mainIntent = new Intent(MainActivity.this, LoginUserM.class);
                    startActivity(mainIntent);
                }else{
                    if (sharedPreferencesUserCFG.getString("Rol", "Valor_Por_Defecto").equals("U")){
                        mainIntent = new Intent(MainActivity.this, Home.class);
                        startActivity(mainIntent);
                    }
                    if (sharedPreferencesUserCFG.getString("Rol", "Valor_Por_Defecto").equals("A")){
                        mainIntent = new Intent(MainActivity.this, AdminHome.class);
                        startActivity(mainIntent);
                    }
                }

                MainActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}