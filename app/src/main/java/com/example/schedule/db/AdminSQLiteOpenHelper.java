package com.example.schedule.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.schedule.model.Class;
import com.example.schedule.model.Schedule;
import com.example.schedule.model.Teacher;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "scheduler";
    private static final int VERSION = 1;

    public AdminSQLiteOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL1 = "CREATE TABLE IF NOT EXISTS teacher (" +
                                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                    "name TEXT);";

        final String SQL3 = "CREATE TABLE IF NOT EXISTS class(" +
                                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                    "name TEXT NOT NULL," +
                                    "description TEXT NOT NULL," +
                                    "teacher_id INTEGER NOT NULL," +
                                    "FOREIGN KEY(teacher_id) REFERENCES teacher(id));";

        final String SQL2 = "CREATE TABLE IF NOT EXISTS schedule (" +
                                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                    "start_time INTEGER NOT NULL, " +
                                    "end_time INTEGER NOT NULL," +
                                    "day TEXT NOT NULL," +
                                    "class_id INTEGER NOT NULL," +
                                    "FOREIGN KEY(class_id) REFERENCES class(id));";

        db.execSQL(SQL1);
        db.execSQL(SQL3);
        db.execSQL(SQL2);
    }
    public Teacher getTeacherById(int id){
        Teacher teacher = null;
        final String SQL = "SELECT * " +
                            "FROM teacher " +
                            "WHERE id = "+id+";";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(SQL, null);
        if(cursor.moveToFirst()){
            int id_ = cursor.getInt(0);
            String name = cursor.getString(1);
            teacher = new Teacher(id_, name);
        }
        db.close();
        return teacher;
    }
    private List<Schedule> getScheduleByIdAndClass(int idClass){
        SQLiteDatabase db = getReadableDatabase();
        final String SQL = "SELECT * " +
                            "FROM schedule " +
                            "WHERE class_id = "+idClass+";";
        Cursor cursor = db.rawQuery(SQL, null);
        List<Schedule> schedules = new ArrayList<>();
        while(cursor.moveToNext()){
            int id_ = cursor.getInt(0);
            int startTime = cursor.getInt(1);
            int endTime = cursor.getInt(2);
            String day = cursor.getString(3);
            int idClass_ = cursor.getInt(4);
            Class class_ = getClassById(idClass_);
            schedules.add(new Schedule(day, startTime, endTime, class_));
        }
        return schedules;
    }

    private Class getClassById(int id){
        Class class_ = null;
        final String SQL = "SELECT * " +
                            "FROM class " +
                            "WHERE id = "+id+";";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(SQL, null);
        if(cursor.moveToFirst()){
            int id_ = cursor.getInt(0);
            String name = cursor.getString(1);
            String description = cursor.getString(2);
            int idTeacher = cursor.getInt(3);
            Teacher teacher = getTeacherById(idTeacher);
            class_ = new Class(id_, name, description, teacher, null, null);
        }
        return class_;
    }

    public List<Class> getClasses(){
        List<Class> classes = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        final String SQL = "SELECT * FROM class";
        Cursor cursor = db.rawQuery(SQL, null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String description = cursor.getString(2);
            int idTeacher = cursor.getInt(3);
            Teacher teacher = getTeacherById(idTeacher);
            List<Schedule> schedules = getScheduleByIdAndClass(id);

            classes.add(new Class(id, name, description, teacher, schedules.get(0), schedules.get(1)));
        }
        db.close();
        return classes;
    }
    public void addTeacher(String name){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        db.insert("teacher", null, values);
        db.close();
    }
    public void addSchedule(String day, int startTime, int endTime, int idClass) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("start_time", startTime);
        values.put("end_time", endTime);
        values.put("day", day);
        values.put("class_id", idClass);
        db.insert("schedule", null, values);
        db.close();
    }
    public void addClass(String name, String description, int teacherId){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("description", description);
        values.put("teacher_id", teacherId);
        db.insert("class", null, values);
        db.close();
    }

    public void initDefaultValues(){
        addTeacher("Faber Danilo Giraldo Velasquez");
        addTeacher("Juan Sebastian Salazar Osorio");
        addTeacher("Jorge Iván Triviño Arbelaez");
        addTeacher("Esperanza Espitia Peña");
        addTeacher("Gustavo Adolfo Rincón Botero");

        addClass("Ingeniería del Software 3","Rama de Ingeniería del Software", 1);
        addClass("Redes de Computadores 2","Rama de Redes", 2);
        addClass("Profundización en Bases de Datos", "Rama de Gestión del Conocimiento", 3);
        addClass("Gerencia de Tecnología Informática", "Rama de Organizacional",4);
        addClass("Investigación de Operaciones", "Rama de Organizacional", 5);

       addSchedule("Lunes", 6, 8, 2);
       addSchedule("Lunes", 8, 10, 1);
       addSchedule("Martes", 4, 6, 3);
       addSchedule("Martes", 8, 10, 5);
       addSchedule("Miercoles", 9, 11, 4);
       addSchedule("Miercoles", 6, 8, 1);
       addSchedule("Jueves", 6, 8, 5);
       addSchedule("Jueves", 8, 10, 2);
       addSchedule("Viernes", 7, 9, 4);
       addSchedule("Viernes", 2, 4, 3);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
