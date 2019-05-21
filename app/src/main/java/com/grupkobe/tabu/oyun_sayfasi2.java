package com.grupkobe.tabu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class oyun_sayfasi2 extends AppCompatActivity {

    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    TextView ak_text,yk_text1, yk_text2, yk_text3, yk_text4, yk_text5,skor_text,pas_hakki_text, ikinci_takim_text, birinci_takim_text, zaman_text;
    Button dogru,tabu_buton,pas;
    Integer skor2=0,pas_hakki=3,BScore,data_time2, data_pas2;
    String takim1="", takim2="",kelime, yk1, yk2,yk3,yk4,yk5;


    final static String filename="dosya", filename2="dosya2",filename3="dosya3";
    SharedPreferences veri_sure, veri_pas,veri_puan;

    SharedPreferences sp;
    final static String b_score="b_score_file";

    public int degisken=10000;

    //Declare a variable to hold count down timer's paused status
    private boolean isPaused = false;

    //Declare a variable to hold CountDownTimer remaining time
    private long timeRemaining = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun_sayfasi2);

        dbHelper = new DatabaseHelper(this);
        dbHelper.CreateDataBase();
        db=dbHelper.getWritableDatabase();
        db=dbHelper.getReadableDatabase();


        final MediaPlayer correttMP = MediaPlayer.create(this,R.raw.correct2);
        final MediaPlayer incorrettMP = MediaPlayer.create(this,R.raw.incorrect);
        final MediaPlayer pasMP = MediaPlayer.create(this,R.raw.pas);


        Intent oyuna_basla_intent = getIntent();
        takim1 = oyuna_basla_intent.getStringExtra("takim1");
        takim2 = oyuna_basla_intent.getStringExtra("takim2");

        ikinci_takim_text = (TextView) findViewById(R.id.birinci_takim_text);
        ikinci_takim_text.setText(takim2);

        zaman_text = (TextView) findViewById(R.id.zaman_text);
        skor_text = (TextView) findViewById(R.id.skor_text);
        skor_text.setText(skor2.toString());


        veri_pas = getSharedPreferences(filename2,MODE_PRIVATE);
        data_pas2 = veri_pas.getInt("pas",1);
        pas_hakki=data_pas2;

        pas_hakki_text = (TextView) findViewById(R.id.pas_hakki_text);
        pas_hakki_text.setText(pas_hakki.toString());


        ak_text = (TextView) findViewById(R.id.a_kelime);
        yk_text1 = (TextView) findViewById(R.id.y_kelime1);
        yk_text2 = (TextView) findViewById(R.id.y_kelime2);
        yk_text3 = (TextView) findViewById(R.id.y_kelime3);
        yk_text4 = (TextView) findViewById(R.id.y_kelime4);
        yk_text5 = (TextView) findViewById(R.id.y_kelime5);

        dogru = (Button) findViewById(R.id.dogru_buton);
        tabu_buton = (Button) findViewById(R.id.tabu_buton);
        pas = (Button) findViewById(R.id.pas_buton);




        sp = getSharedPreferences(oyun_sayfasi2.b_score,MODE_PRIVATE);
        BScore = sp.getInt("skor",0);
        skor_text.setText(BScore.toString());
        skor2=BScore;



        Random random = new Random();
        Cursor kapasite=db.rawQuery("select * from tbl_kelimeler",null);
        int  random1 = random.nextInt(kapasite.getCount())+1;

        Cursor cursor = db.rawQuery("select * From tbl_kelimeler Where kelime_ID="+random1+"",null);
        db.isOpen();
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToFirst();
            kelime=cursor.getString(cursor.getColumnIndex("anlatilacak_kelime"));
            ak_text.setText(kelime);

            yk1=cursor.getString(cursor.getColumnIndex("y_kelime_bir"));
            yk_text1.setText(yk1);

            yk2=cursor.getString(cursor.getColumnIndex("y_kelime_iki"));
            yk_text2.setText(yk2);

            yk3=cursor.getString(cursor.getColumnIndex("y_kelime_uc"));
            yk_text3.setText(yk3);

            yk4=cursor.getString(cursor.getColumnIndex("y_kelime_dort"));
            yk_text4.setText(yk4);

            yk5=cursor.getString(cursor.getColumnIndex("y_kelime_bes"));
            yk_text5.setText(yk5);
        }
        else {
            Toast.makeText(getApplicationContext(), "Kelimenin karşılığı bulunamadı", Toast.LENGTH_SHORT).show();
        }



        dogru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* skor2+=1;
                skor_text.setText(skor2.toString());*/

               /* Cursor toplam_ID = db.rawQuery("select count(kelime_ID) From tbl_kelimeler",null);
                int toplam=Integer.parseInt(toplam_ID.toString()); */


                correttMP.start();

                sp = getSharedPreferences(b_score,MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("skor",skor2+=1);
                editor.apply();
                skor_text.setText(skor2.toString());

                sp = getSharedPreferences(oyun_sayfasi2.b_score,MODE_PRIVATE);
                BScore = sp.getInt("skor",0);
                skor_text.setText(BScore.toString());



                Random rand = new Random();
                Cursor kapasite=db.rawQuery("select * from tbl_kelimeler",null);
                int  rand_1 = rand.nextInt(kapasite.getCount())+1;

                Cursor cursor = db.rawQuery("select * From tbl_kelimeler Where kelime_ID="+rand_1+"",null);
                db.isOpen();
                cursor.moveToFirst();
                if (cursor.getCount()>0)
                {
                    cursor.moveToFirst();
                    kelime=cursor.getString(cursor.getColumnIndex("anlatilacak_kelime"));
                    ak_text.setText(kelime);

                    yk1=cursor.getString(cursor.getColumnIndex("y_kelime_bir"));
                    yk_text1.setText(yk1);

                    yk2=cursor.getString(cursor.getColumnIndex("y_kelime_iki"));
                    yk_text2.setText(yk2);

                    yk3=cursor.getString(cursor.getColumnIndex("y_kelime_uc"));
                    yk_text3.setText(yk3);

                    yk4=cursor.getString(cursor.getColumnIndex("y_kelime_dort"));
                    yk_text4.setText(yk4);

                    yk5=cursor.getString(cursor.getColumnIndex("y_kelime_bes"));
                    yk_text5.setText(yk5);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Kelimenin karşılığı bulunamadı", Toast.LENGTH_SHORT).show();
                }

            }
        });


        tabu_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*skor2-=1;
                skor_text.setText(skor2.toString());*/

                incorrettMP.start();

                sp = getSharedPreferences(b_score,MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("skor",skor2-=1);
                editor.apply();
                skor_text.setText(skor2.toString());

                sp = getSharedPreferences(oyun_sayfasi2.b_score,MODE_PRIVATE);
                BScore = sp.getInt("skor",0);
                skor_text.setText(BScore.toString());


                Random rand2 = new Random();
                Cursor kapasite=db.rawQuery("select * from tbl_kelimeler",null);
                int  rand_2 = rand2.nextInt(kapasite.getCount())+1;

                Cursor cursor = db.rawQuery("select * From tbl_kelimeler Where kelime_ID="+rand_2+"",null);
                db.isOpen();
                cursor.moveToFirst();
                if (cursor.getCount()>0) {
                    cursor.moveToFirst();
                    kelime = cursor.getString(cursor.getColumnIndex("anlatilacak_kelime"));
                    ak_text.setText(kelime);

                    yk1 = cursor.getString(cursor.getColumnIndex("y_kelime_bir"));
                    yk_text1.setText(yk1);

                    yk2 = cursor.getString(cursor.getColumnIndex("y_kelime_iki"));
                    yk_text2.setText(yk2);

                    yk3 = cursor.getString(cursor.getColumnIndex("y_kelime_uc"));
                    yk_text3.setText(yk3);

                    yk4 = cursor.getString(cursor.getColumnIndex("y_kelime_dort"));
                    yk_text4.setText(yk4);

                    yk5 = cursor.getString(cursor.getColumnIndex("y_kelime_bes"));
                    yk_text5.setText(yk5);
                }


            }
        });


        pas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(pas_hakki>=1) {
                    pasMP.start();
                    pas_hakki -= 1;
                    pas_hakki_text.setText(pas_hakki.toString());

                    Random rand3 = new Random();
                    Cursor kapasite=db.rawQuery("select * from tbl_kelimeler",null);
                    int  rand_3 = rand3.nextInt(kapasite.getCount())+1;

                    Cursor cursor = db.rawQuery("select * From tbl_kelimeler Where kelime_ID="+rand_3+"",null);
                    db.isOpen();
                    cursor.moveToFirst();
                    if (cursor.getCount()>0) {
                        cursor.moveToFirst();
                        kelime = cursor.getString(cursor.getColumnIndex("anlatilacak_kelime"));
                        ak_text.setText(kelime);

                        yk1 = cursor.getString(cursor.getColumnIndex("y_kelime_bir"));
                        yk_text1.setText(yk1);

                        yk2 = cursor.getString(cursor.getColumnIndex("y_kelime_iki"));
                        yk_text2.setText(yk2);

                        yk3 = cursor.getString(cursor.getColumnIndex("y_kelime_uc"));
                        yk_text3.setText(yk3);

                        yk4 = cursor.getString(cursor.getColumnIndex("y_kelime_dort"));
                        yk_text4.setText(yk4);

                        yk5 = cursor.getString(cursor.getColumnIndex("y_kelime_bes"));
                        yk_text5.setText(yk5);
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Pas hakkın kalmadı.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        final Button btnPause = (Button) findViewById(R.id.btn_pause);
        final Button btnResume = (Button) findViewById(R.id.btn_resume);

        //Initially disabled the pause, resume and cancel button
        btnPause.setEnabled(false);
        btnResume.setEnabled(false);

        //Set a Click Listener for start button

        isPaused = false;

        //Disable the start and pause button
        btnResume.setEnabled(false);
        //Enabled the pause and cancel button
        btnPause.setEnabled(true);


        veri_sure = getSharedPreferences(filename,MODE_PRIVATE);
        data_time2 = veri_sure.getInt("time",30);
        degisken=data_time2;

        CountDownTimer timer;
        long millisInFuture = degisken*1000; //30 seconds
        long countDownInterval = 1000; //1 second


        //Initialize a new CountDownTimer instance
        timer = new CountDownTimer(millisInFuture,countDownInterval){
            public void onTick(long millisUntilFinished){
                //do something in every tick
                if(isPaused)
                {
                    //If the user request to cancel or paused the
                    //CountDownTimer we will cancel the current instance
                    cancel();
                }
                else {
                    //Display the remaining seconds to app interface
                    //1 second = 1000 milliseconds
                    zaman_text.setText("" + millisUntilFinished / 1000);
                    //Put count down timer remaining time in a variable
                    timeRemaining = millisUntilFinished;
                }
            }
            public void onFinish(){
                //Do something when count down finished
                zaman_text.setText("Done");

                //Disable the pause, resume and cancel button
                btnPause.setEnabled(false);
                btnResume.setEnabled(false);

                String a=skor2.toString();
                Intent digersayfa = new Intent(getApplicationContext(),skor2.class);
                digersayfa.putExtra("skor",a);
                digersayfa.putExtra("takim1",takim1);
                digersayfa.putExtra("takim2",takim2);
                startActivity(digersayfa); }

        }.start();



        //Set a Click Listener for pause button
        btnPause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //When user request to pause the CountDownTimer
                isPaused = true;
                btnResume.setEnabled(true);
                btnPause.setEnabled(false);
                btnResume.setVisibility(View.VISIBLE);
                btnPause.setVisibility(View.INVISIBLE);
            }
        });

        //Set a Click Listener for resume button
        btnResume.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                btnResume.setEnabled(false);
                btnPause.setEnabled(true);
                btnResume.setVisibility(View.INVISIBLE);
                btnPause.setVisibility(View.VISIBLE);
                //Specify the current state is not paused and canceled.
                isPaused = false;

                //Initialize a new CountDownTimer instance
                long millisInFuture = timeRemaining;
                long countDownInterval = 1000;
                new CountDownTimer(millisInFuture, countDownInterval){
                    public void onTick(long millisUntilFinished){
                        //Do something in every tick
                        if(isPaused)
                        {
                            //If user requested to pause or cancel the count down timer
                            cancel();
                        }
                        else {
                            zaman_text.setText("" + millisUntilFinished / 1000);
                            //Put count down timer remaining time in a variable
                            timeRemaining = millisUntilFinished;
                        }
                    }
                    public void onFinish(){
                        //Do something when count down finished
                        zaman_text.setText("Done");
                        //Disable the pause, resume and cancel button
                        btnPause.setEnabled(false);
                        btnResume.setEnabled(false);

                        String a=skor2.toString();
                        Intent digersayfa = new Intent(getApplicationContext(),skor2.class);
                        digersayfa.putExtra("skor",a);
                        digersayfa.putExtra("takim1",takim1);
                        digersayfa.putExtra("takim2",takim2);
                        startActivity(digersayfa);}

                }.start();

            }
        });



    }
    protected void onStop()
    {
        super.onStop();
        dbHelper.close();
    }
}


