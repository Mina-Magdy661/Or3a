package com.example.or3a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.or3a.Cup.Cup;
import com.example.or3a.Or3a.Or3a;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {


    GifImageView btnRandom , btnCup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRandom = findViewById(R.id.btnRandom);
        btnCup = findViewById(R.id.btnCup);

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToOr3a = new Intent(MainActivity.this , Or3a.class);
                startActivity(goToOr3a);
            }
        });


        btnCup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToCup = new Intent(MainActivity.this , Cup.class);
                startActivity(goToCup);
            }
        });
    }

}