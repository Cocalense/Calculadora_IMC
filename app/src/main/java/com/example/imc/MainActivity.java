package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.PrivilegedAction;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    private EditText editPeso;
    private EditText editAltura;
    private TextView textResultado;
    private Button btnCalcular;
    private String textResultadoVirado;

    //comentarios antes
    //outState.putString("txtViewDt", txtViewDt); salva uma string
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("textResultadoVirado", textResultadoVirado);

    }

    //comentario antes
    //txtEditDt = savedInstanceState.getString("txtViewDt"); le uma string
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textResultadoVirado = savedInstanceState.getString("textResultadoVirado");
        textResultado.setText(textResultadoVirado);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAltura = (EditText) findViewById(R.id.edtAltura);
        editPeso = (EditText) findViewById(R.id.edtPeso);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        textResultado = (TextView) findViewById(R.id.txtResultado);

        // criando o listner ,
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double altura = Double.parseDouble(editAltura.getText().toString());
                double peso = Double.parseDouble(editPeso.getText().toString());
                double imc = (peso/(altura*altura));
                DecimalFormat formato = new DecimalFormat("#,##");
                if (imc >= 18.4) {
                    textResultado.setText("Seu IMC é : "+ Double.valueOf(formato.format(imc))+ "\n Abaixo do peso");
                }else if((imc >= 18.5) && (imc <=24.9)){
                    textResultado.setText("Seu  IMC  é : "+ Double.valueOf(formato.format(imc))+ "\n Peso normal");
                }else if ((imc > 25) && (imc <=29.9)){
                    textResultado.setText("Seu IMC é : "+ Double.valueOf(formato.format(imc))+ "\n Sobrepeso");
                }else if ((imc >= 30) && (imc <= 34.9)){
                    textResultado.setText("Seu IMC é : "+ Double.valueOf(formato.format(imc))+ "\n Obesidade grau 1");
                }else if ((imc >= 35) && (imc <= 39.9)){
                    textResultado.setText("Seu IMC é : "+ Double.valueOf(formato.format(imc))+ "\n Obesidade grau 2");
                }else if (imc >= 40){
                    textResultado.setText("Seu IMC é : "+ Double.valueOf(formato.format(imc))+ "\n Obesidade grau 3");
                }
                textResultadoVirado = (String)textResultado.getText();
            }
        });
    }

}