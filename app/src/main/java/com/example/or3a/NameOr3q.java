package com.example.or3a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class NameOr3q extends AppCompatActivity {

    RecyclerView recyclerView ;
    RecyclerView.Adapter adapter ;
    RecyclerView.LayoutManager layoutManager ;
    EditText editName ;
    Button btnAddName;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_or3q);

        editName = findViewById(R.id.editName);
        btnAddName = findViewById(R.id.btnAdd);
        final ArrayList<String> nameOr3a = new ArrayList<>();
        nameOr3a.add("TEST1");
        nameOr3a.add("TEST2");

        btnAddName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editName.getText().toString();
                nameOr3a.add(name);
                adapter.notifyDataSetChanged();
            }
        });


        recyclerView = findViewById(R.id.listView);
        layoutManager = new LinearLayoutManager(this);
        adapter = new myAdapter(nameOr3a);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }
}