package com.example.nafl.numerologiadominicana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Text;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static String PACKAGE_NAME;

    Button numerosDia, baseDia, resultadoDia;

    private TextView informacion,textViewResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        startService(new Intent(this, FirebaseBackgroundService.class));
        informacion = (TextView)findViewById(R.id.infoTextView);
        textViewResultado=(TextView)findViewById(R.id.textViewResultado);
        if (getIntent().getExtras()!=null)
        {
            for (String key  : getIntent().getExtras().keySet()){

                String value = getIntent().getExtras().getString(key);
                informacion.append("\n"+key+": "+ value);
            }
        }


        numerosDia = (Button)findViewById(R.id.btNumerosDia);
        baseDia = (Button)findViewById(R.id.btBaseDia);
        resultadoDia = (Button)findViewById(R.id.button2Resultado);


        PACKAGE_NAME = getApplicationContext().getPackageName();

        System.out.println(PACKAGE_NAME);
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


        resultadoDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultadoDia = new Intent(MainActivity.this,ResultadosDelDia.class);

                startActivity(resultadoDia);
            }
        });
    }








}
