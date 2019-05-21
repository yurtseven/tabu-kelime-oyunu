package com.grupkobe.tabu;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class kelime_ekleme extends AppCompatActivity {

    DatabaseHelper  dbHelper;
    SQLiteDatabase db;
    Button ekle,cikis_yap;
    EditText a_kelime, y_kelime1,y_kelime2, y_kelime3, y_kelime4, y_kelime5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelime_ekleme);

        dbHelper = new DatabaseHelper(this);
        dbHelper.CreateDataBase();
        db=dbHelper.getWritableDatabase();

        a_kelime = (EditText) findViewById(R.id.ak_text);
        y_kelime1 = (EditText) findViewById(R.id.yk_text1);
        y_kelime2 = (EditText) findViewById(R.id.yk_text2);
        y_kelime3 = (EditText) findViewById(R.id.yk_text3);
        y_kelime4 = (EditText) findViewById(R.id.yk_text4);
        y_kelime5 = (EditText) findViewById(R.id.yk_text5);

       ekle =(Button) findViewById(R.id.kelime_ekle_buton);
       cikis_yap = (Button) findViewById(R.id.cikis_yap_buton);



          ekle.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if(!a_kelime.getText().toString().trim().equals("") && !y_kelime1.getText().toString().trim().equals("") && !y_kelime2.getText().toString().trim().equals("") && !y_kelime3.getText().toString().trim().equals("") && !y_kelime4.getText().toString().trim().equals("") && !y_kelime5.getText().toString().trim().equals("")) {
                          String anlatilacak_kelime = a_kelime.getText().toString();
                          String yasakli_kelime1 = y_kelime1.getText().toString();
                          String yasakli_kelime2 = y_kelime2.getText().toString();
                          String yasakli_kelime3 = y_kelime3.getText().toString();
                          String yasakli_kelime4 = y_kelime4.getText().toString();
                          String yasakli_kelime5 = y_kelime5.getText().toString();

                      ContentValues cv = new ContentValues();
                      cv.put("anlatilacak_kelime", anlatilacak_kelime);
                      cv.put("y_kelime_bir", yasakli_kelime1);
                      cv.put("y_kelime_iki", yasakli_kelime2);
                      cv.put("y_kelime_uc", yasakli_kelime3);
                      cv.put("y_kelime_dort", yasakli_kelime4);
                      cv.put("y_kelime_bes", yasakli_kelime5);

                      if (db.insert("tbl_kelimeler", null, cv) > 0) {
                          Toast toast3 = Toast.makeText(getApplicationContext(), "Kelime Eklendi", Toast.LENGTH_SHORT);
                          toast3.show();
                          a_kelime.setText("");
                          y_kelime1.setText("");
                          y_kelime2.setText("");
                          y_kelime3.setText("");
                          y_kelime4.setText("");
                          y_kelime5.setText("");
                      } else {
                          Toast toast = Toast.makeText(getApplicationContext(), "İşlem Başarısız", Toast.LENGTH_SHORT);
                          toast.show();
                      }
                  }
                  else
                  {
                      Toast toast2 = Toast.makeText(getApplicationContext(), "Text kutuları boş bırakılamaz.", Toast.LENGTH_SHORT);
                      toast2.show();
                  }

              }
          });



        cikis_yap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cikis_yap_intent = new Intent(getApplicationContext(),Main.class);
                startActivity(cikis_yap_intent);
            }
        });
    }
    protected void onStop()
    {
        super.onStop();
        dbHelper.close();
    }
}
