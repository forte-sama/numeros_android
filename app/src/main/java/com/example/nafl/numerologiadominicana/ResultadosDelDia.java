package com.example.nafl.numerologiadominicana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ResultadosDelDia extends AppCompatActivity {


    TextView textViewResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_del_dia);

        textViewResultado =(TextView)findViewById(R.id.textViewResultado);

        getWebsite();
    }



    private void getWebsite() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final StringBuilder builder = new StringBuilder();

                try {
                    Document doc = Jsoup.connect("http://www.loteriasdominicanas.com/").get();
                    String titulo = doc.title();
                    Elements links = doc.select("a[href]");
                    builder.append("\n");

                    for (Element link: links){
                        builder
                                .append("\n")
                                .append("link :")
                                .append(link.attr("href"))
                                .append("\n")
                                .append("Text: ")
                                .append(link.text());
                    }



                } catch (IOException e) {
                    e.printStackTrace();
                    builder.append("Necesita conectarse a Internet para ver los numeros");
                }


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textViewResultado.setText(builder.toString());
                    }
                });
            }
        }).start();
    }
}
