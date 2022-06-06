package com.example.my_calc;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_rebar extends AppCompatActivity {

    private String[] clConcrete = {"B20", "B25", "B30"};
    private String[] сlRebar = {"A500", "A400", "A240"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rebar);

        ArrayAdapter<String> clConcreteAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,clConcrete);
        clConcreteAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spClConcrete = (Spinner) findViewById(R.id.spClConcrete);
        spClConcrete.setAdapter(clConcreteAdapter);
        spClConcrete.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> clRebarAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,сlRebar);
        clConcreteAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spClRebar = (Spinner) findViewById(R.id.spClRebar);
        spClRebar.setAdapter(clRebarAdapter);
        spClConcrete.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}