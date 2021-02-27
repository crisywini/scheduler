package com.example.schedule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView idTextView;
    private TextView nameTextView;
    private Spinner daySpinner;
    private RecyclerView scheduleRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    }
}