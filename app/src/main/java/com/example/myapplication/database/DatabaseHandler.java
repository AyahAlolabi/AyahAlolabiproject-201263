package com.example.myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.format.Time;

import androidx.annotation.Nullable;

import com.example.myapplication.model.Student;


import java.net.IDN;
import java.util.ArrayList;
import java.util.List;



public class DatabaseHandler extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME="Students.db";
    private static final String TABLE_NAME="StudentsTable";

    private static final String KEY_ID ="ID";
    private static final String KEY_Name ="Name";
    private static final String KEY_Sur_Name ="SurName";
    private static final String KEY_Father_Name ="FatherName";
    private static final String KEY_National_ID ="nationalID";
    private static final String KEY_date_Of_Birth ="dateOfBirth";
    private static final String KEY_Gender ="Gender";


    public DatabaseHandler(@Nullable Context context, @Nullable SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, DATABASE_NAME, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        String create_table = "CREATE TABLE " +TABLE_NAME +"(" +
                KEY_ID + " TEXT, " + KEY_Name +" TEXT, "+
                KEY_Sur_Name +" TEXT, "+
                KEY_Father_Name +" TEXT, "+
                KEY_National_ID +" TEXT, "+
                KEY_date_Of_Birth +" TEXT, "+
                KEY_Gender +" TEXT)";
        sqLiteDatabase.execSQL(create_table);
        System.out.println("create table");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
        System.out.println("table dropped");

    }



    public boolean isIdStudent(String id){

        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {KEY_ID};
        String[] args = {String.valueOf(id)};

        Cursor cursor = db.query(TABLE_NAME, columns, KEY_ID + " = ? ", args, null, null, null);

        boolean isExist = cursor.moveToFirst() && cursor.getCount() >= 1;

        cursor.close();

        return isExist;

    }
    public boolean insertStudent(Student student)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_ID, student.getId());
        contentValues.put(KEY_Name, student.getName());
        contentValues.put(KEY_Sur_Name, student.getSurName());
        contentValues.put(KEY_Father_Name, student.getFatherName());
        contentValues.put(KEY_National_ID, student.getNationalID());
        contentValues.put(KEY_date_Of_Birth, student.getDateOfBirth());
        contentValues.put(KEY_Gender, student.getGender());

        long result =  database.insert(TABLE_NAME , null,contentValues);
        if (result==-1)
            return false;
        else
            return true;

    }

  public boolean deleteStudent(Student student)
  {
      SQLiteDatabase database = this.getWritableDatabase();
      long result = database.delete(TABLE_NAME , KEY_ID + "=?",new String[]{String.valueOf(student.getId())});
      if (result==-1)
          return false;
      else
          return true;

  }


    public List<Student> getStudents()
    {

        List<Student> arrayList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery,null);

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            do {

                String id=cursor.getString(0);
                String name=cursor.getString(1);
                String surName=cursor.getString(2);
                String fatherName=cursor.getString(3);
                String nationalID=cursor.getString(4);
                String dateOfBirth=cursor.getString(5);
                String gender=cursor.getString(6);

                arrayList.add(new Student(id,name,fatherName,surName,nationalID,dateOfBirth,gender));


            }while (cursor.moveToNext());

        }
        return arrayList;
    }

    public boolean updateStudent(Student student){
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_ID, student.getId());
        contentValues.put(KEY_Name, student.getName());
        contentValues.put(KEY_Sur_Name, student.getSurName());
        contentValues.put(KEY_Father_Name, student.getFatherName());
        contentValues.put(KEY_National_ID, student.getNationalID());
        contentValues.put(KEY_date_Of_Birth, student.getDateOfBirth());
        contentValues.put(KEY_Gender, student.getGender());
        SQLiteDatabase   sqLiteDatabase = this.getWritableDatabase();
        long result =   sqLiteDatabase.update(TABLE_NAME,contentValues,KEY_ID + " = ?" , new String[]
                {String.valueOf(student.getId())});

        if (result==-1)
            return false;
        else
            return true;
    }
}
