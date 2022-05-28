package com.example.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapters.StudentsAdapter;
import com.example.myapplication.database.Helper;
import com.example.myapplication.model.Student;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListFirebaseActivity extends AppCompatActivity {
    private StudentsAdapter adapter;
    private RecyclerView recyclerView;
    private SearchView searchView;
    private List<Student> studentList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_firebase);

        getSupportActionBar().setTitle("Firebase");
        recyclerView = findViewById(R.id.student_list);
        searchView = findViewById(R.id.search_bar);

        adapter = new StudentsAdapter(this, studentList);
        recyclerView.setAdapter(adapter);

        findViewById(R.id.fab_add).setOnClickListener(view -> {
            Helper.isEditMode=false;
            Helper.isFirebaseMode=true;
            startActivity(new Intent(this, AddStudentActivity.class));

        });
        searchView.setOnClickListener(v -> searchView.setIconified(false));

        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (!newText.trim().isEmpty()) {

                    List<Student> userArrayList = new ArrayList<>();

                    for (Student student : studentList) {

                        if (newText.contains(student.getId()) ||  Long.parseLong(newText) == Long.parseLong(student.getId()))
                            userArrayList.add(student);

                    }

                    adapter = new StudentsAdapter(ListFirebaseActivity.this, userArrayList);
                    recyclerView.setAdapter(adapter);

                }
                return false;



            }
        });
        //when close search
        searchView.setOnCloseListener(() -> {
            resetSearch();

            return false;
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        getStudentsFromFirebase();
    }

    private void getStudentsFromFirebase()
    {
        studentList.clear();
        Helper.studentsRef.orderByKey().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {

                if (snapshot.exists())
                {
                    studentList.clear();
                    for (DataSnapshot dataSnapshot: snapshot.getChildren())
                    {
                        Student student =dataSnapshot.getValue(Student.class);
                        studentList.add(student);

                    }

                    adapter = new StudentsAdapter(ListFirebaseActivity.this, studentList);
                    recyclerView.setAdapter(adapter);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void resetSearch() {

        adapter = new StudentsAdapter(this, studentList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}