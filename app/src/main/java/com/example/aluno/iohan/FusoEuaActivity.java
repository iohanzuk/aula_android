package com.example.aluno.iohan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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
            String text = hora.getText().toString();
            int result = 0;
            if (text.isEmpty()) {
                Toast.makeText(FusoEuaActivity.this, "É necessário informar um horário", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                 result = Integer.parseInt(hora.getText().toString());
            } catch (Exception exception) {
                Toast.makeText(FusoEuaActivity.this, "Somente números devem ser informados", Toast.LENGTH_LONG).show();
                return;
            }

            if (result > 23 || result < 0) {
                Toast.makeText(FusoEuaActivity.this, "Deve ser informado apenas inteiros de 0 A 23", Toast.LENGTH_LONG).show();
                return;
            }

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
