package com.example.nafl.numerologiadominicana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public static String PACKAGE_NAME;

    Button numerosDia, baseDia;
    private TextView informacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        informacion = (TextView)findViewById(R.id.infoTextView);

        if (getIntent().getExtras()!=null)
        {
            for (String key  : getIntent().getExtras().keySet()){

                String value = getIntent().getExtras().getString(key);
                informacion.append("\n"+key+": "+ value);
            }
        }


        numerosDia = (Button)findViewById(R.id.btNumerosDia);
        baseDia = (Button)findViewById(R.id.btBaseDia);


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
    }
}
