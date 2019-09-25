package com.example.aluno.iohan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class FusoMundoActivity extends AppCompatActivity {

    private RadioGroup radios;
    private EditText hora, input;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuso_mundo);
        this.radios = findViewById(R.id.radioGroup);
        this.hora = findViewById(R.id.editText);
        this.input = findViewById(R.id.editText2);
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

   public void calcular()
   {
      int result = this.calculoGMT(Integer.parseInt(this.hora.getText().toString()),
              Integer.parseInt(this.input.getText().toString()));
      this.textView.setText("Hora no destino:    " + result);
   }

    RadioGroup.OnCheckedChangeListener radioChangeOuvinte = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int result = Integer.parseInt(hora.getText().toString());
            switch (checkedId) {
                case R.id.radioButton:
                    input.setText("-5");
                    break;
                case R.id.radioButton2:
                    input.setText("-4");
                    break;
                case R.id.radioButton3:
                    input.setText("-3");
                    break;
                case R.id.radioButton4:
                    input.setText("-2");
                    break;
            }
        }
    };
}
