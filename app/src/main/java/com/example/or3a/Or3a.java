package com.example.or3a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Or3a extends AppCompatActivity {

    Button btnNumper , btnName ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_or3a);

        btnName = findViewById(R.id.btnName);
        btnNumper = findViewById(R.id.btnNumper);

        btnNumper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToOr3aNumper = new Intent(Or3a.this , NumperOr3a.class);
                startActivity(goToOr3aNumper);


                 

            }
        });
    }
}