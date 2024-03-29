package com.c235.rebar_calc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
    private String[] boundaryСond = {"З-З", "З-Ш", "Ш-Ш", "К"};
    private Button btn_count;
    String[] hint = {"Ввести все значения", "Попробуй еще разок", "Осталось немного", "Не ленись"};
    int i = 0;
    String sh_con = " ";
    String sh_reb = " ";
    String sh = " ";
    String sh_q, sh_qn, sh_l, sh_h, sh_b, sh_A0;
    public Rebar act_result = new Rebar();


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rebar);

        addListenerOnButton();

        final EditText eText_q = findViewById(R.id.editTextNumberDecimal_q);
        final EditText eText_qn = findViewById(R.id.editTextNumberDecimal_qn);
        final EditText eText_l = findViewById(R.id.editTextNumberDecimal_L);
        final EditText eText_h = findViewById(R.id.editTextNumberDecima_H);
        final EditText eText_b = findViewById(R.id.editTextNumberDecimal_B);
        final EditText eText_A0 = findViewById(R.id.editTextNumberDecima_A0);

        /*eText_q.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN &&
                        (keyCode == KeyEvent.KEYCODE_ENTER))
                {
                    sh_q = eText_q.getText().toString();
                    return true;
                }
                return false;
            }

        });*/



        eText_q.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) sh_q = eText_q.getText().toString();
            }
        });

        eText_qn.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) sh_qn = eText_qn.getText().toString();
            }
        });

        eText_l.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) sh_l = eText_l.getText().toString();
            }
        });

        eText_h.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) sh_h = eText_h.getText().toString();

            }
        });

        eText_b.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) sh_b = eText_b.getText().toString();
            }
        });

        eText_A0.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) sh_A0 = eText_A0.getText().toString();
            }
        });

        //снятие фокуса и сркытие клавиатуры после нажатия ввод поле h
        eText_h.setOnKeyListener(new View.OnKeyListener()
        {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    eText_h.clearFocus();
                    //скрытие клавиатуры после набора edittext поля h
                    Context context = v.getContext();
                    InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    return true;
                }
                return false;
            }
        });
        //снятие фокуса после нажатия ввод поле A0
        eText_A0.setOnKeyListener(new View.OnKeyListener()
        {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    eText_A0.clearFocus();
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
                sh_con = parent.getSelectedItem().toString();

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
                sh_reb = parent.getSelectedItem().toString();

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
                sh = parent.getSelectedItem().toString();

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
                        //проверка введенного значения
                        if (sh_q == null | sh_qn == null |
                                sh_h == null | sh_b == null |
                                sh_l == null  | sh_A0 == null) {
                            resText.setText(hint[i++]);
                            if (i == 4) i = 0;
                        }
                        else
                        resText.setText(act_result.provideMy( sh_con, sh_reb, sh,
                                Double.parseDouble(sh_q), Double.parseDouble(sh_qn), Double.parseDouble(sh_h),
                                Double.parseDouble(sh_b), Double.parseDouble(sh_l), Double.parseDouble(sh_A0)));
                    }
                });
    };
}