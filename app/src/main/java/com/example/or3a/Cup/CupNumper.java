package com.example.or3a.Cup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.or3a.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class CupNumper extends AppCompatActivity {

    RecyclerView recyclerView ;
    RecyclerView.Adapter adapter ;
    RecyclerView.LayoutManager layoutManager ;
    EditText editName ;
    Button btnAddNameTeam;
    String name;
    FloatingActionButton fab ;
     ArrayList<String> teamName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cup_numper);

        loadData();

        editName = findViewById(R.id.editName);
        btnAddNameTeam = findViewById(R.id.btnAdd);

        btnAddNameTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editName.getText().toString().trim().length() > 0){
                    name = editName.getText().toString();
                    teamName.add(name);
                    adapter.notifyDataSetChanged();
                    editName.setText("");
                    saveData();
                }
                else{
                    Toast.makeText(CupNumper.this, "لازم تكتب اسم التيم", Toast.LENGTH_SHORT).show();
                }

            }
        });


        recyclerView = findViewById(R.id.listView);
        layoutManager = new LinearLayoutManager(this);
        adapter = new myAdapterForNameCup(teamName,this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    public void loadData (){

        SharedPreferences sharedPreferences = getSharedPreferences("Shared For Team Numper" , MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("list", null);
        Type type = new TypeToken<ArrayList<String>>(){}.getType();
        teamName = gson.fromJson(json , type);

        if(teamName == null){
            teamName = new ArrayList<>();

        }

    }
    public void saveData () {

        SharedPreferences sharedPreferences = getSharedPreferences("Shared For Team Numper" , MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(teamName);
        editor.putString("list" , json);
        editor.apply();

    }

    }