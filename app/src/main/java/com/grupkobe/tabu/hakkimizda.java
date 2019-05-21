package com.grupkobe.tabu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class hakkimizda extends AppCompatActivity {

    Button geri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hakkimizda);

        geri= (Button) findViewById(R.id.hakkimizda_geri_button);

        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent geri_intent = new Intent(getApplicationContext(),Main.class);
                startActivity(geri_intent);
            }
        });
    }
}
