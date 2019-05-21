package com.grupkobe.tabu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class skor2 extends AppCompatActivity {

    TextView skor_1,skor_2, takim_1,takim_2;
    Button devam_buton;
    String takim1="",takim2="",sk;
    Integer skor,score_data, BScore, data_puan2;

    final static String filename3="dosya3";
    SharedPreferences veri_puan;

    SharedPreferences sharedPreferences;
    final static String score2="score_file";

    SharedPreferences sp;
    final static String b_score3="b_score_file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skor2);

        devam_buton = (Button) findViewById(R.id.devam_buton);
        skor_1 = (TextView) findViewById(R.id.skor_1);
        skor_2 = (TextView) findViewById(R.id.skor_2);
        takim_1 = (TextView) findViewById(R.id.takim_1);
        takim_2 = (TextView) findViewById(R.id.takim_2);


        veri_puan = getSharedPreferences(filename3,MODE_PRIVATE);
        data_puan2 = veri_puan.getInt("puan",25);

        sharedPreferences = getSharedPreferences(oyun_sayfasi.score,MODE_PRIVATE);
        score_data = sharedPreferences.getInt("skor",-1);

        sharedPreferences = getSharedPreferences(score2,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("skor",score_data);
        editor.apply();



        Intent oyuna_basla_intent = getIntent();
        takim1 = oyuna_basla_intent.getStringExtra("takim1");
        takim2 = oyuna_basla_intent.getStringExtra("takim2");
        sk = oyuna_basla_intent.getStringExtra("skor");
        skor=Integer.valueOf(sk);



        takim_1 = (TextView) findViewById(R.id.takim_1);
        takim_1.setText(takim1);

        takim_2 = (TextView) findViewById(R.id.takim_2);
        takim_2.setText(takim2);

        skor_2 = (TextView) findViewById(R.id.skor_2);
        skor_2.setText(skor.toString());

        skor_1 = (TextView) findViewById(R.id.skor_1);
        //skor_1.setText(score_data.toString());

        sharedPreferences = getSharedPreferences(oyun_sayfasi.score,MODE_PRIVATE);
        score_data = sharedPreferences.getInt("skor",0);
        skor_1.setText(score_data.toString());

        sp = getSharedPreferences(oyun_sayfasi2.b_score,MODE_PRIVATE);
        BScore = sp.getInt("skor",0);
        skor_2.setText(BScore.toString());

        if(skor>=data_puan2)
        {
            takim_2.setText(takim2+" Kazandı");
        }

        devam_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(BScore>=data_puan2)
                {

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

                    Intent oyuna_devam = new Intent(getApplicationContext(), Main.class);
                    startActivity(oyuna_devam);

                }
                else {
                    Intent oyuna_devam = new Intent(getApplicationContext(), oyun_sayfasi.class);
                    oyuna_devam.putExtra("oyun_sayfai_2_skor", skor);
                    oyuna_devam.putExtra("takim1",takim1);
                    oyuna_devam.putExtra("takim2",takim2);
                    startActivity(oyuna_devam);
                }

            }
        });
    }
}
