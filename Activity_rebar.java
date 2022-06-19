package com.example.my_calc;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Activity_rebar extends AppCompatActivity {

    private String[] clConcrete = {"B20", "B25", "B30"};
    private String[] сlRebar = {"A500", "A400", "A240"};
    private String[] boundaryСond = {"З-З", "З-Ш", "Ш-Ш"};
    private Button btn_count;
    String[] sh = {" "," "," "," "};
    String sh4, sh5, sh6, sh7, sh8;
    String sh9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rebar);

        addListenerOnButton();

        final EditText eText4 = findViewById(R.id.editTextNumberDecimal_q);
        final EditText eText5 = findViewById(R.id.editTextNumberDecimal_qn);
        final EditText eText6 = findViewById(R.id.editTextNumberDecimal3);
        final EditText eText7 = findViewById(R.id.editTextNumberDecimal2);
        final EditText eText8 = findViewById(R.id.editTextNumberDecimal);
        final EditText eText9 = findViewById(R.id.editTextNumberDecimal4);

        eText4.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN &&
                        (keyCode == KeyEvent.KEYCODE_ENTER))
                {
                    sh4 = eText4.getText().toString();
                    return true;
                }
                return false;
            }

        });

        eText5.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN &&
                        (keyCode == KeyEvent.KEYCODE_ENTER))
                {
                    sh5 = eText5.getText().toString();
                    return true;
                }
                return false;
            }

        });

        eText6.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN &&
                        (keyCode == KeyEvent.KEYCODE_ENTER))
                {
                    sh6 = eText6.getText().toString();
                    return true;
                }
                return false;
            }

        });

        eText7.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN &&
                        (keyCode == KeyEvent.KEYCODE_ENTER))
                {
                    sh7 = eText7.getText().toString();
                    return true;
                }
                return false;
            }

        });

        eText8.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN &&
                        (keyCode == KeyEvent.KEYCODE_ENTER))
                {
                    sh8 = eText8.getText().toString();
                    return true;
                }
                return false;
            }

        });

        eText9.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN &&
                        (keyCode == KeyEvent.KEYCODE_ENTER))
                {
                    sh9 = eText9.getText().toString();
                    return true;
                }
                return false;
            }

        });


        ArrayAdapter<String> clConcreteAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,clConcrete);
        clConcreteAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spClConcrete = (Spinner) findViewById(R.id.sp_ClConcrete);
        spClConcrete.setAdapter(clConcreteAdapter);

        spClConcrete.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sh[0] = parent.getSelectedItem().toString();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> clRebarAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,сlRebar);
        clConcreteAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spClRebar = (Spinner) findViewById(R.id.sp_ClRebar);
        spClRebar.setAdapter(clRebarAdapter);
        spClRebar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sh[1] = parent.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> boundaryСondAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,boundaryСond);
        clConcreteAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spBoundaryСond = (Spinner) findViewById(R.id.sp_BoundaryСond);
        spBoundaryСond.setAdapter(boundaryСondAdapter);
        spBoundaryСond.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sh[2] = parent.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    public void addListenerOnButton() {
        final TextView resText = (TextView) findViewById(R.id.Res_count);
        btn_count = (Button) findViewById(R.id.button_count);
        btn_count.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resText.setText(sh[0]+" "+sh[1]+" "+sh[2]+" "+sh4+" "+sh5+" "+sh6+" "+sh7+" "+sh8+" "+sh9);
                    }
                });
    };




}