package com.example.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.database.Helper;
import com.google.firebase.FirebaseApp;

/**
 * Ayah Alolabi
 * ID: 201263
 **/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(getApplicationContext());

        findViewById(R.id.btn_firebase).setOnClickListener(view ->
        {


            Helper.isFirebaseMode=true;
            startActivity(new Intent(this, ListFirebaseActivity.class));
        });
        findViewById(R.id.btn_sqlite).setOnClickListener(view ->
        {

            Helper.isFirebaseMode=false;
            startActivity(new Intent(this, ListSQLiteActivity.class));
        });

        findViewById(R.id.btn_weather).setOnClickListener(view ->
        {
            startActivity(new Intent(this, WeatherActivity.class));
        });
    }
}