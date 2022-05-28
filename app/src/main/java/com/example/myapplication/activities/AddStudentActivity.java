package com.example.myapplication.activities;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.database.DatabaseHandler;
import com.example.myapplication.database.Helper;
import com.example.myapplication.model.Student;
import com.google.firebase.database.DataSnapshot;

public class AddStudentActivity extends AppCompatActivity {

    private DatabaseHandler databaseHandler;
    private EditText name, id, surName, fatherName, dateOfBirth, idNational, gender;
    private Student currentStudent ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle("Add Student");
        setContentView(R.layout.activity_add_student);
        databaseHandler = new DatabaseHandler(this, null, 1);

        name = findViewById(R.id.et_name_student);
        id = findViewById(R.id.et_id_student);
        surName = findViewById(R.id.et_surname_student);
        fatherName = findViewById(R.id.et_father_name_student);
        dateOfBirth = findViewById(R.id.et_dateOfBirth_student);
        idNational = findViewById(R.id.et_national_id_student);
        gender = findViewById(R.id.et_gander_student);


        if (  Helper.isEditMode)
        {
            currentStudent= Helper.currentStudent;


            id.setText(currentStudent.getId());
            name.setText(currentStudent.getName());
            surName.setText(currentStudent.getSurName());
            fatherName.setText(currentStudent.getFatherName());
            dateOfBirth.setText(currentStudent.getDateOfBirth());
            idNational.setText(currentStudent.getNationalID());
            gender.setText(currentStudent.getGender());

            id.setEnabled(false);

        }

        findViewById(R.id.btn_submit).setOnClickListener(view ->
        {
            if (TextUtils.isEmpty(id.getText()))
                Toast.makeText(this, "Please enter Student ID", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(name.getText()))
                Toast.makeText(this, "Please enter Student Name", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(surName.getText()))
                Toast.makeText(this, "Please enter Student Sur Name", Toast.LENGTH_SHORT).show();

            else if (TextUtils.isEmpty(fatherName.getText()))
                Toast.makeText(this, "Please enter Student Father Name", Toast.LENGTH_SHORT).show();

            else if (TextUtils.isEmpty(dateOfBirth.getText()))
                Toast.makeText(this, "Please enter Date of Birth ", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(gender.getText()))
                Toast.makeText(this, "Please enter Student Gender", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(idNational.getText()))
                Toast.makeText(this, "Please enter Student National ID", Toast.LENGTH_SHORT).show();

            else {
                Student student =  new Student(
                        id.getText().toString(),
                        name.getText().toString(),
                        surName.getText().toString(),
                        fatherName.getText().toString(),
                        idNational.getText().toString(),
                        dateOfBirth.getText().toString(),
                        gender.getText().toString());
                if ( Helper.isEditMode)
                {
                    if ( Helper.isFirebaseMode)
                    {
                        Helper.studentsRef.child(student.getId()).setValue(student).addOnSuccessListener(unused -> {
                            Toast.makeText(AddStudentActivity.this, "Student has been successfully Update", Toast.LENGTH_SHORT).show();
                            finish();
                        });
                    }
                    else {

                         if (databaseHandler.updateStudent(student)) {
                            Toast.makeText(this, "Student has been successfully Update", Toast.LENGTH_SHORT).show();
                            finish();

                        } else
                            Toast.makeText(this, "Failed, We could not Update", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {

                    if ( Helper.isFirebaseMode)
                    {
                        Helper.studentsRef.orderByKey().get().addOnSuccessListener(dataSnapshot ->
                        {
                            for (DataSnapshot snapshot : dataSnapshot.getChildren())
                            {
                                if (snapshot.getKey().equals(student.getId()))
                                {
                                    Toast.makeText(this, "Failed, Student ID already exists", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }

                            Helper.studentsRef.child(student.getId()).setValue(student).addOnSuccessListener(unused -> {
                                Toast.makeText(AddStudentActivity.this, "Student has been successfully added", Toast.LENGTH_SHORT).show();
                                finish();
                            });
                        });

                    }
                    else {
                        if (databaseHandler.isIdStudent(id.getText().toString()))
                            Toast.makeText(this, "Failed, Student ID already exists", Toast.LENGTH_SHORT).show();
                        else if (databaseHandler.insertStudent(student)) {
                            Toast.makeText(this, "Student has been successfully added", Toast.LENGTH_SHORT).show();
                            finish();

                        } else
                            Toast.makeText(this, "Failed, We could not add the student", Toast.LENGTH_SHORT).show();
                    }

                }


            }

        });
    }
}