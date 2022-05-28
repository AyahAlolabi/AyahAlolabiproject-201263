package com.example.myapplication.database;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.myapplication.model.Student;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Helper
{


    public static DatabaseReference studentsRef =  FirebaseDatabase.getInstance().getReference("Students");
    public static boolean isFirebaseMode = false;
    public static boolean isEditMode = false;
    public static Student currentStudent = new Student();



    public static final String API_KEY = "17f4e560fc650073511d2995badb4c29";
    public static final String CLIENTS_URL = "http://api.openweathermap.org/data/";

    public static boolean isNetworkAvailable(Context context) {
        if (context != null && context.getSystemService(Context.CONNECTIVITY_SERVICE) != null) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (cm != null) {
                NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                if (null != activeNetwork) {
                    if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                        return true;
                    }
                    return activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE;
                }
            }
        }
        return false;
    }

}
