package com.grupkobe.tabu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class admin_paneli extends AppCompatActivity {

    EditText k_adi,sifre;
    Button giris;
    String k_sifre,kullanici;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_paneli);

         giris = (Button) findViewById(R.id.admin_giris_buton);
         k_adi = (EditText) findViewById(R.id.k_adi_edittext);
         sifre = (EditText) findViewById(R.id.sifre_edittext);


            giris.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if(k_adi.getText().toString().trim().equals("Emre") && sifre.getText().toString().trim().equals("12345")) {

                        Intent admin_giris_intent = new Intent(getApplicationContext(), kelime_ekleme.class);
                        startActivity(admin_giris_intent);
                    }
                    else
                    {
                        Toast toast2 = Toast.makeText(getApplicationContext(), "Kullanıcı adı veya şifre yanlış.", Toast.LENGTH_SHORT);
                        toast2.show();
                    }

                }
            });

    }
}
