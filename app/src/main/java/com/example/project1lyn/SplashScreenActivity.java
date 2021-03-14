package com.example.project1lyn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import static androidx.core.content.ContextCompat.startActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread timer = new Thread(){ //mengatur berapa lama splash screen akan ditampilkan
            public void run(){
                try {
                    sleep(3000); //3detik
                }catch (Exception ex){
                    ex.printStackTrace();
                }finally {
                    Intent intent = new Intent(SplashScreenActivity.this,HomeActivity.class);
                    startActivity(intent);
                }
            }
        };
        timer.start();
    }
}