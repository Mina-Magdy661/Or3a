package com.example.or3a.Or3a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.or3a.R;

import java.util.ArrayList;

public class ShowName extends AppCompatActivity {


    RecyclerView recyclerView ;
    RecyclerView.Adapter adapter ;
    RecyclerView.LayoutManager layoutManager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_name);

        ArrayList<String> show = getIntent().getStringArrayListExtra("list");


        recyclerView = findViewById(R.id.listView);
        layoutManager = new LinearLayoutManager(this);
        adapter = new myAdapterForShowName(show,this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        for (String s : show){
            Log.d("My", String.valueOf(s));
        }

        Log.d("My", String.valueOf(show.size()));




    }
}