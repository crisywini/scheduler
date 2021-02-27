package com.example.schedule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.schedule.db.AdminSQLiteOpenHelper;
import com.example.schedule.model.Class;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView idTextView;
    private TextView nameTextView;
    private Spinner daySpinner;
    private RecyclerView scheduleRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureView();
    }

    private void configureView(){
        idTextView = (TextView) findViewById(R.id.id_text_view);
        nameTextView = (TextView) findViewById(R.id.name_text_view);
        daySpinner = (Spinner) findViewById(R.id.day_spinner);
        scheduleRecyclerView = (RecyclerView) findViewById(R.id.schedules_recyclerview);
        String[] namesSpinner = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes"};
        ArrayAdapter<String> nameSpinArrAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, namesSpinner);
        daySpinner.setAdapter(nameSpinArrAdapter);
        daySpinner.setPrompt("Días");

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this);
        List<Class> classes = admin.getClasses();
        ScheduleRecViewAdapter adapter = new ScheduleRecViewAdapter(this);
        adapter.setClasses(classes);
        scheduleRecyclerView.setAdapter(adapter);
        scheduleRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


}