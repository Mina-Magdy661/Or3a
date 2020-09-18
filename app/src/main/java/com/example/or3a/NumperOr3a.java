package com.example.or3a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumperOr3a extends AppCompatActivity {

    EditText txtAllNumper , txtCountRandom ;

    Button btnDone ;
    List<Integer> list ;
    List<Integer> randNum ;
    int allNumper ,  countRandom ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numper_or3a);

        txtAllNumper = findViewById(R.id.txtAllNumper);
        txtCountRandom = findViewById(R.id.txtCountRandom);
        btnDone = findViewById(R.id.btnDone);



        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                list  = new ArrayList<>();
                randNum = new ArrayList<>();
                allNumper = Integer.parseInt(String.valueOf(txtAllNumper.getText()));
                countRandom = Integer.parseInt(String.valueOf(txtCountRandom.getText()));


                for (int i=1; i<=allNumper; i++) {
                    list.add(i);
                }

//                for (int s : list){
//                    Log.d("My array list content: ", String.valueOf(s));
//                }


                Random rand = new Random();

                for (int i = 0; i < countRandom; i++) {
                    int randomIndex = rand.nextInt(list.size());
                    Integer randomElement = list.get(randomIndex);
                    list.remove(randomIndex);
                    randNum.add(randomElement);
                }

                        for (int s : randNum){
                    Log.d("My", String.valueOf(s));
                }
            }
        });

    }
}