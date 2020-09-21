package com.example.or3a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class ShowNumper extends AppCompatActivity {

    RecyclerView recyclerView ;
    RecyclerView.Adapter adapter ;
    RecyclerView.LayoutManager layoutManager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_numper);

        ArrayList<Integer> show = getIntent().getIntegerArrayListExtra("test");


        recyclerView = findViewById(R.id.listView);
        layoutManager = new LinearLayoutManager(this);
        adapter = new myAdapterForShowNum(show,this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        for (int s : show){
            Log.d("My", String.valueOf(s));
        }

    }
}