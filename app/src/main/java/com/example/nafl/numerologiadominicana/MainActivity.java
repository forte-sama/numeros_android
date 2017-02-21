package com.example.nafl.numerologiadominicana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button numerosDia, baseDia, informacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numerosDia = (Button)findViewById(R.id.btNumerosDia);
        baseDia = (Button)findViewById(R.id.btBaseDia);

        numerosDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numerosDia = new Intent(MainActivity.this, NumerosDia.class);
                startActivity(numerosDia);
            }
        });

        baseDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent baseDia = new Intent(MainActivity.this,BaseDia.class);
                startActivity(baseDia);
            }
        });
    }
}
