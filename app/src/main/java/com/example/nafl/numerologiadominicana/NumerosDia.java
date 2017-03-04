package com.example.nafl.numerologiadominicana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NumerosDia extends AppCompatActivity {


    TextView textViewDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numeros_dia);


        textViewDatos=(TextView)findViewById(R.id.textViewData);
        textViewDatos.setText(FirebaseBackgroundService.message);

        startService(new Intent(this, FirebaseBackgroundService.class));
    }



}
