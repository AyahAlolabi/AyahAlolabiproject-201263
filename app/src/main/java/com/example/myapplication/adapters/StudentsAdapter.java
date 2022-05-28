package com.example.myapplication.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.activities.AddStudentActivity;
import com.example.myapplication.database.DatabaseHandler;
import com.example.myapplication.database.Helper;
import com.example.myapplication.model.Student;

import java.util.List;


public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentAdapterViewHolder> {
    private static final String TAG = StudentsAdapter.class.getSimpleName();
    private final List<Student> studentList;
    private final Context context;
    private final DatabaseHandler databaseHandler;


    public StudentsAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
        databaseHandler = new DatabaseHandler(context, null, 1);

    }


    @Override
    public StudentAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_view, parent, false);
        return new StudentAdapterViewHolder(view);

    }


    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onBindViewHolder(StudentAdapterViewHolder holder, int position) {

        Student student = studentList.get(position);

        holder.id.setText(student.getId());
        holder.name.setText(student.getName() + " " + student.getFatherName());

        holder.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Helper.currentStudent=student;
                Helper.isEditMode=true;
                context.startActivity(new Intent(context, AddStudentActivity.class));
            }
        });
        holder.btn_delete.setOnClickListener(view -> {

            if ( Helper.isFirebaseMode)
            {
                Helper.studentsRef.child(student.getId()).removeValue().addOnSuccessListener(unused ->
                        Toast.makeText(context, "Student has been successfully Deleted From Firebase", Toast.LENGTH_SHORT).show());
                studentList.remove(student);
                notifyDataSetChanged();
            }
            else
            {

                if (databaseHandler.deleteStudent(student))
                {
                    Toast.makeText(context, "Student has been successfully Deleted", Toast.LENGTH_SHORT).show();
                    studentList.remove(student);
                    notifyDataSetChanged();
                }
                else
                    Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
            }




        });

    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public int getItemCount() {
        return studentList == null ? 0 : studentList.size();
    }


    class StudentAdapterViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView id;
        private final Button btn_delete,btnUpdate;


        public StudentAdapterViewHolder(View view) {
            super(view);
            this.name = view.findViewById(R.id.username_text_view);
            this.id = view.findViewById(R.id.id_text_view);
            this.btnUpdate = view.findViewById(R.id.btn_update);
            btn_delete = view.findViewById(R.id.btn_delete);


        }
    }
}
