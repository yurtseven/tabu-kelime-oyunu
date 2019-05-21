package com.grupkobe.tabu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ayarlar extends AppCompatActivity {

    TextView sure,pas_hakki,kazanma_puani;
    final static String filename="dosya", filename2="dosya2",filename3="dosya3";

    SharedPreferences veri_sure, veri_pas,veri_puan;

    Integer time1=0,data_time1=0,data_time2=0;
    Integer time2=0,data_time3=0,data_time4=0;
    Integer time3=0,data_time5=0,data_time6=0;

    Integer pas1=0,data_pas1=0,data_pas2=0;
    Integer pas2=0,data_pas3=0,data_pas4=0;
    Integer pas3=0,data_pas5=0,data_pas6=0;

    Integer puan_25=0, data_puan1=0, data_puan2=0;
    Integer puan_40=0, data_puan3=0, data_puan4=0;
    Integer puan_60=0, data_puan5=0, data_puan6=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayarlar);

        Button geri_don = (Button) findViewById(R.id.geri_don_buton);
        Button otuz_buton = (Button) findViewById(R.id.otuz_buton_ID);
        Button altmis_buton = (Button) findViewById(R.id.altmis_buton_ID);
        Button doksan_buton = (Button) findViewById(R.id.doksan_buton_ID);
        final Button pas_bir = (Button) findViewById(R.id.pas1_buton_ID);
        Button pas_iki = (Button) findViewById(R.id.pas2_buton_ID);
        Button pas_uc = (Button) findViewById(R.id.pas3_buton_ID);
        final Button puan25 = (Button) findViewById(R.id.puan25_buton_ID);
        Button puan40 = (Button) findViewById(R.id.puan40_buton_ID);
        Button puan60 = (Button) findViewById(R.id.puan60_buton_ID);

        sure = (TextView) findViewById(R.id.ayarlar_sure);
        pas_hakki = (TextView) findViewById(R.id.ayarlar_pas_hakki);
        kazanma_puani = (TextView) findViewById(R.id.ayarlar_kazanma_puani);



        veri_sure = getSharedPreferences(filename,MODE_PRIVATE);
        veri_pas = getSharedPreferences(filename2,MODE_PRIVATE);
        veri_puan = getSharedPreferences(filename3,MODE_PRIVATE);

        geri_don.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuye_don_intent = new Intent(getApplicationContext(),Main.class);
                startActivity(menuye_don_intent);
            }
        });


        /*-----------------------------------------------------------------------------------------------------------------------*/


        otuz_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                veri_sure = getSharedPreferences(filename,MODE_PRIVATE);
                SharedPreferences.Editor editor = veri_sure.edit();
                time1=30;
                editor.putInt("time",time1);
                editor.apply();

                veri_sure = getSharedPreferences(filename,MODE_PRIVATE);
                data_time1 = veri_sure.getInt("time",30);
                sure.setText(data_time1.toString());
            }
        });

        veri_sure = getSharedPreferences(filename,MODE_PRIVATE);
        data_time2 = veri_sure.getInt("time",30);
        sure.setText(data_time2.toString());


        /*-----------------------------------------------------------------------------------------------------------------------*/


        altmis_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                veri_sure = getSharedPreferences(filename,MODE_PRIVATE);
                SharedPreferences.Editor editor = veri_sure.edit();
                time2=60;
                editor.putInt("time",time2);
                editor.apply();

                veri_sure = getSharedPreferences(filename,MODE_PRIVATE);
                data_time3 = veri_sure.getInt("time",60);
                sure.setText(data_time3.toString());
            }
        });

        veri_sure = getSharedPreferences(filename,MODE_PRIVATE);
        data_time4 = veri_sure.getInt("time",60);
        sure.setText(data_time4.toString());


        /*-----------------------------------------------------------------------------------------------------------------------*/




        doksan_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                veri_sure = getSharedPreferences(filename,MODE_PRIVATE);
                SharedPreferences.Editor editor = veri_sure.edit();
                time3=90;
                editor.putInt("time",time3);
                editor.apply();

                veri_sure = getSharedPreferences(filename,MODE_PRIVATE);
                data_time5 = veri_sure.getInt("time",90);
                sure.setText(data_time5.toString());
            }
        });

        veri_sure = getSharedPreferences(filename,MODE_PRIVATE);
        data_time6 = veri_sure.getInt("time",90);
        sure.setText(data_time6.toString());




        /*-----------------------------------------------------------------------------------------------------------------------*/



        pas_bir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                veri_pas = getSharedPreferences(filename2,MODE_PRIVATE);
                SharedPreferences.Editor editor = veri_pas.edit();
                pas1=1;
                editor.putInt("pas",pas1);
                editor.apply();

                veri_pas = getSharedPreferences(filename2,MODE_PRIVATE);
                data_pas1 = veri_pas.getInt("pas",1);
                pas_hakki.setText(data_pas1.toString());
            }
        });

        veri_pas = getSharedPreferences(filename2,MODE_PRIVATE);
        data_pas2 = veri_pas.getInt("pas",1);
        pas_hakki.setText(data_pas2.toString());


        /*-----------------------------------------------------------------------------------------------------------------------*/



        pas_iki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                veri_pas = getSharedPreferences(filename2,MODE_PRIVATE);
                SharedPreferences.Editor editor = veri_pas.edit();
                pas2=2;
                editor.putInt("pas",pas2);
                editor.apply();

                veri_pas = getSharedPreferences(filename2,MODE_PRIVATE);
                data_pas3 = veri_pas.getInt("pas",2);
                pas_hakki.setText(data_pas3.toString());
            }
        });

        veri_pas = getSharedPreferences(filename2,MODE_PRIVATE);
        data_pas4 = veri_pas.getInt("pas",2);
        pas_hakki.setText(data_pas4.toString());


        /*-----------------------------------------------------------------------------------------------------------------------*/

        pas_uc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                veri_pas = getSharedPreferences(filename2,MODE_PRIVATE);
                SharedPreferences.Editor editor = veri_pas.edit();
                pas3=3;
                editor.putInt("pas",pas3);
                editor.apply();

                veri_pas = getSharedPreferences(filename2,MODE_PRIVATE);
                data_pas5 = veri_pas.getInt("pas",3);
                pas_hakki.setText(data_pas5.toString());
            }
        });

        veri_pas = getSharedPreferences(filename2,MODE_PRIVATE);
        data_pas6 = veri_pas.getInt("pas",3);
        pas_hakki.setText(data_pas6.toString());



        /*-----------------------------------------------------------------------------------------------------------------------*/


        puan25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                veri_puan = getSharedPreferences(filename3,MODE_PRIVATE);
                SharedPreferences.Editor editor = veri_puan.edit();
                puan_25=25;
                editor.putInt("puan",puan_25);
                editor.apply();

                veri_puan = getSharedPreferences(filename3,MODE_PRIVATE);
                data_puan1 = veri_puan.getInt("puan",25);
                kazanma_puani.setText(data_puan1.toString());
            }
        });

        veri_puan = getSharedPreferences(filename3,MODE_PRIVATE);
        data_puan2 = veri_puan.getInt("puan",25);
        kazanma_puani.setText(data_puan2.toString());


        /*-----------------------------------------------------------------------------------------------------------------------*/



        puan40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                veri_puan = getSharedPreferences(filename3,MODE_PRIVATE);
                SharedPreferences.Editor editor = veri_puan.edit();
                puan_40=40;
                editor.putInt("puan",puan_40);
                editor.apply();

                veri_puan = getSharedPreferences(filename3,MODE_PRIVATE);
                data_puan3 = veri_puan.getInt("puan",40);
                kazanma_puani.setText(data_puan3.toString());
            }
        });

        veri_puan = getSharedPreferences(filename3,MODE_PRIVATE);
        data_puan4 = veri_puan.getInt("puan",40);
        kazanma_puani.setText(data_puan4.toString());

        /*-----------------------------------------------------------------------------------------------------------------------*/


        puan60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                veri_puan = getSharedPreferences(filename3,MODE_PRIVATE);
                SharedPreferences.Editor editor = veri_puan.edit();
                puan_60=60;
                editor.putInt("puan",puan_60);
                editor.apply();

                veri_puan = getSharedPreferences(filename3,MODE_PRIVATE);
                data_puan5 = veri_puan.getInt("puan",60);
                kazanma_puani.setText(data_puan5.toString());
            }
        });

        veri_puan = getSharedPreferences(filename3,MODE_PRIVATE);
        data_puan6 = veri_puan.getInt("puan",60);
        kazanma_puani.setText(data_puan6.toString());


    }
}
