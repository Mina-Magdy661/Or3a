package com.example.or3a.Cup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.or3a.Or3a.NameOr3q;
import com.example.or3a.Or3a.NumperOr3a;
import com.example.or3a.Or3a.Or3a;
import com.example.or3a.R;

public class Cup extends AppCompatActivity {

    Button btnNumper , btnName ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cup);

        btnName = findViewById(R.id.btnName);
        btnNumper = findViewById(R.id.btnNumper);
        btnNumper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent goToCupNumper = new Intent(Cup.this , CupNumper.class);
                startActivity(goToCupNumper);



            }
        });

        btnName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });
    }
}