package com.example.aluno.iohan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class FusoEuaActivity extends AppCompatActivity {

    private RadioGroup radios;
    private EditText hora;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuso_eua);
        this.radios = findViewById(R.id.radioGroup);
        this.hora = findViewById(R.id.editText);
        this.textView = findViewById(R.id.textView4);
        this.radios.setOnCheckedChangeListener(radioChangeOuvinte);
    }

    private Integer calculoGMT(Integer hour, Integer gmt){
        Integer result = hour + gmt;
        if (result > 23) {
            result = result - 24;
        }
        if (result < 0) {
            result = result + 24;
        }
        return result;
    }

    RadioGroup.OnCheckedChangeListener radioChangeOuvinte = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int result = Integer.parseInt(hora.getText().toString());
            switch (checkedId) {
                case R.id.radioButton:
                    result = calculoGMT(Integer.parseInt(hora.getText().toString()), -3);
                    break;
                case R.id.radioButton2:
                    result = calculoGMT(Integer.parseInt(hora.getText().toString()), -2);
                    break;
                case R.id.radioButton3:
                    result = calculoGMT(Integer.parseInt(hora.getText().toString()), -1);
                    break;
                case R.id.radioButton4:
                    result = calculoGMT(Integer.parseInt(hora.getText().toString()), 0);
                    break;
            }
            textView.setText("Hora MS:    " + result);
        }
    };
}
