package com.example.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapters.StudentsAdapter;
import com.example.myapplication.database.DatabaseHandler;
import com.example.myapplication.database.Helper;

import com.example.myapplication.model.Student;

import java.util.ArrayList;
import java.util.List;


/**
 * Ayah Alolabi
 * ID: 201263
 **/

public class ListSQLiteActivity extends AppCompatActivity {

    private DatabaseHandler databaseHandler;
    private StudentsAdapter adapter;
    private RecyclerView recyclerView;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_sqlite);
        getSupportActionBar().setTitle("SQLite");
        recyclerView = findViewById(R.id.student_list);
        searchView = findViewById(R.id.search_bar);

        databaseHandler = new DatabaseHandler(this, null, 1);
        adapter = new StudentsAdapter(this, databaseHandler.getStudents());

        recyclerView.setAdapter(adapter);

        findViewById(R.id.fab_add).setOnClickListener(view -> {
            Helper.isEditMode=false;
            Helper.isFirebaseMode=false;
            startActivity(new Intent(this, AddStudentActivity.class));

        });
        searchView.setOnClickListener(v -> searchView.setIconified(true));


        //when close search
        searchView.setOnCloseListener(() -> {

            resetSearch();

            return false;
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (!newText.trim().isEmpty()) {

                    List<Student> userArrayList = new ArrayList<>();

                    for (Student student :  databaseHandler.getStudents()) {

                        if (newText.contains(student.getId()) ||  Long.parseLong(newText) == Long.parseLong(student.getId()))
                            userArrayList.add(student);

                        }

                    adapter = new StudentsAdapter(ListSQLiteActivity.this, userArrayList);
                    recyclerView.setAdapter(adapter);

            }
                    return true;



            }


        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter = new StudentsAdapter(this, databaseHandler.getStudents());
        recyclerView.setAdapter(adapter);
    }

    private void resetSearch() {

        adapter = new StudentsAdapter(this, databaseHandler.getStudents());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}