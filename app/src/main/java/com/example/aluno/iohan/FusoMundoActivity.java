package com.example.aluno.iohan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FusoMundoActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private EditText input;
    private TextView resultText, gmtView;
    private Button add, sub, calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuso_mundo);
        this.radioGroup = findViewById(R.id.radioGroup);
        this.gmtView = findViewById(R.id.showGmt);
        this.input = findViewById(R.id.editText);
        this.resultText = findViewById(R.id.textView4);
        this.radioGroup.setOnCheckedChangeListener(radioChangeOuvinte);
        this.add = findViewById(R.id.button);
        this.sub = findViewById(R.id.button2);
        this.calc = findViewById(R.id.button3);
        this.add.setOnClickListener(adicao);
        this.sub.setOnClickListener(subtracao);
        this.calc.setOnClickListener(calculo);
    }

    private Integer calculoGMT(Integer hour, Integer gmt) {
        Integer result = hour + gmt;
        if (result > 23) {
            result = result - 24;
        }
        if (result < 0) {
            result = result + 24;
        }
        return result;
    }

    Button.OnClickListener adicao = new Button.OnClickListener() {
        public void onClick(View v) {
            Integer gmt;
            if (gmtView.getText().toString().isEmpty()) {
                gmt = 0;
            } else {
                gmt = Integer.parseInt(gmtView.getText().toString());
            }

            if (gmt > 11) {
                Toast.makeText(FusoMundoActivity.this, "O máximo é 12", Toast.LENGTH_LONG).show();
            } else {
                gmt++;
                gmtView.setText(gmt.toString());
            }
        }
    };

    Button.OnClickListener subtracao = new Button.OnClickListener() {
        public void onClick(View v) {
            Integer gmt;
            if (gmtView.getText().toString().isEmpty()) {
                gmt = 0;
            } else {
                gmt = Integer.parseInt(gmtView.getText().toString());
            }

            if (gmt < -11) {
                Toast.makeText(FusoMundoActivity.this, "O minimo é -12", Toast.LENGTH_LONG).show();
            } else {
                gmt--;
                gmtView.setText(gmt.toString());
            }
        }
    };

    Button.OnClickListener calculo = new Button.OnClickListener() {
        public void onClick(View v) {
            String text = input.getText().toString();
            String gmtText = gmtView.getText().toString();
            int result, gmtInt = 0;
            if (text.isEmpty() || gmtText.isEmpty()) {
                Toast.makeText(FusoMundoActivity.this, "É necessário informar um horário e um GMT", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                result = Integer.parseInt(input.getText().toString());
                gmtInt = Integer.parseInt(gmtView.getText().toString());
            } catch (Exception exception) {
                Toast.makeText(FusoMundoActivity.this, "Somente números devem ser informados", Toast.LENGTH_LONG).show();
                return;
            }

            if (result > 23 || result < 0) {
                Toast.makeText(FusoMundoActivity.this, "Deve ser informado apenas inteiros de 0 A 23", Toast.LENGTH_LONG).show();
                return;
            }
            result = calculoGMT(result, gmtInt);

            resultText.setText("Hora no destino:    " + result);
        }
    };

    RadioGroup.OnCheckedChangeListener radioChangeOuvinte = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.radioButton:
                    gmtView.setText("-5");
                    break;
                case R.id.radioButton2:
                    gmtView.setText("-4");
                    break;
                case R.id.radioButton3:
                    gmtView.setText("-3");
                    break;
                case R.id.radioButton4:
                    gmtView.setText("-2");
                    break;
            }
        }
    };
}
