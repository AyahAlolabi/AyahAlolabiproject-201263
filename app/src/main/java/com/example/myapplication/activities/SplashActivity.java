package com.example.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.google.firebase.FirebaseApp;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_activity);
        FirebaseApp.initializeApp(this);

        new Handler().postDelayed(() -> {

            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();


        }, 2000);
    }
}
