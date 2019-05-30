package com.grupkobe.tabu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button yeni_oyun = (Button) findViewById(R.id.yeni_oyun_buton);
        Button ayarlar = (Button) findViewById(R.id.ayarlar_buton);
        Button hakkimizda = (Button) findViewById(R.id.hakkimizda_buton);
        Button admin_paneli = (Button) findViewById(R.id.admin_paneli_buton);

        //Yeni Oyun Sayfası
        yeni_oyun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent yeni_oyun_intent = new Intent(getApplicationContext(),takim_secme.class);
                startActivity(yeni_oyun_intent);
            }
        });
        
        //Ayarlar Sayfası
        ayarlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ayarlar_intent = new Intent(getApplicationContext(),ayarlar.class);
                startActivity(ayarlar_intent);
            }
        });

        admin_paneli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent admin_paneli_intent = new Intent(getApplicationContext(),admin_paneli.class);
                startActivity(admin_paneli_intent);
            }
        });
        
        //hakkımızda Sayfası
        hakkimizda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hakkimizda_intent = new Intent(getApplicationContext(),hakkimizda.class);
                startActivity(hakkimizda_intent);

            }
        });
    }
}
