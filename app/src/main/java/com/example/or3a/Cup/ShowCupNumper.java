package com.example.or3a.Cup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.or3a.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ShowCupNumper extends AppCompatActivity {


    RecyclerView recyclerView ;
    RecyclerView.Adapter adapter ;
    RecyclerView.LayoutManager layoutManager ;
    ArrayList<String> teamNumper1;
    ArrayList<String> teamNumper2;
    ArrayList<String> teamWin;
    TextView txtTeamName ;
    EditText editTeamNumper ;
    Button btnDone;
    FloatingActionButton fab ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cup_numper);

        teamNumper1 = new ArrayList<>();
        teamNumper2 = new ArrayList<>();
        teamWin = new ArrayList<>();


        teamNumper1.add("15");
        teamNumper1.add("7");
        teamNumper1.add("11");
        teamNumper1.add("12");

        teamNumper2.add("17");
        teamNumper2.add("20");
        teamNumper2.add("10");
        teamNumper2.add("33");






        if(teamNumper1.size()>teamNumper2.size()){

            teamNumper2.add( teamNumper2.size() - 1 ,"");

        }else if ( teamNumper1.size()<teamNumper2.size()){

            teamNumper1.add( teamNumper1.size() - 1 ,"");
        }else{

        }


        txtTeamName = findViewById(R.id.txtTeamName);
        editTeamNumper = findViewById(R.id.editTeamNumper);
        btnDone = findViewById(R.id.btnDone);

        Intent intent = getIntent();
        String teamName = intent.getStringExtra("teamName");
        txtTeamName.setText(teamName);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDone.setVisibility(Button.GONE);
                editTeamNumper.setEnabled(false);
            }
        });


        recyclerView = findViewById(R.id.listView);
        layoutManager = new LinearLayoutManager(this);
        adapter = new myAdapterForNumperCupParticipants(teamNumper1 , teamNumper2, this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        for (String s : teamWin){
            Log.d("My", String.valueOf(s));
             }

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(ShowCupNumper.this, "TEST", Toast.LENGTH_SHORT).show();


            }
        });
    }
}