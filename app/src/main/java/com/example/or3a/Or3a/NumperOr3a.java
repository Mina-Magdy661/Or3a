package com.example.or3a.Or3a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.or3a.R;

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

                if(txtAllNumper.getText().toString().trim().length() > 0 && txtCountRandom.getText().toString().trim().length() > 0){

                    allNumper = Integer.parseInt(String.valueOf(txtAllNumper.getText()));
                    countRandom = Integer.parseInt(String.valueOf(txtCountRandom.getText()));

                    for (int i=1; i<=allNumper; i++) {
                        list.add(i);
                    }

                    if(countRandom<allNumper){

                        Random rand = new Random();
                        for (int i = 0; i < countRandom ; i++) {
                            int randomIndex = rand.nextInt(list.size());
                            Integer randomElement = list.get(randomIndex);
                            list.remove(randomIndex);
                            randNum.add(randomElement);

                        }
                        Intent goToShowNum = new Intent(NumperOr3a.this , ShowNumper.class);
                        goToShowNum.putIntegerArrayListExtra("test", (ArrayList<Integer>) randNum);
                        startActivity(goToShowNum);
                    }else{
                        Toast.makeText(getApplicationContext() ,  "لازم الرقم المطلوب يكون اقل من عدد الارقام" , Toast.LENGTH_LONG).show();

                    }


                }else{
                    Toast.makeText(getApplicationContext() ,  "لازم تضيف رقم فى الخانات الناقصة" , Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}