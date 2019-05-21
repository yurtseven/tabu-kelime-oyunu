package com.grupkobe.tabu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class takim_secme extends AppCompatActivity {

    Button menu, oyuna_basla;
    EditText birinci_takim, ikinci_takim;
    String takim1="",takim2="";

    Integer score_data,BScore;

    SharedPreferences sharedPreferences;
    final static String score2="score_file";

    SharedPreferences sp;
    final static String b_score3="b_score_file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takim_secme);

        oyuna_basla = (Button) findViewById(R.id.oyuna_basla_buton);
        menu = (Button) findViewById(R.id.menu_buton);

        birinci_takim=(EditText) findViewById(R.id.birinci_takim_edit);
        ikinci_takim=(EditText) findViewById(R.id.ikinci_takim_edit);


        oyuna_basla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takim1=birinci_takim.getText().toString();
                takim2=ikinci_takim.getText().toString();

                sp = getSharedPreferences(b_score3,MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                BScore=0;
                editor.putInt("skor",BScore);
                editor.apply();


                sharedPreferences = getSharedPreferences(score2,MODE_PRIVATE);
                SharedPreferences.Editor editor2 = sharedPreferences.edit();
                score_data=0;
                editor2.putInt("skor",score_data);
                editor2.apply();

                Intent oyuna_basla_intent = new Intent(getApplicationContext(),oyun_sayfasi.class);
                oyuna_basla_intent.putExtra("takim1",takim1);
                oyuna_basla_intent.putExtra("takim2",takim2);
                startActivity(oyuna_basla_intent);


            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu_intent = new Intent(getApplicationContext(),Main.class);
                startActivity(menu_intent);

            }
        });
    }
}
