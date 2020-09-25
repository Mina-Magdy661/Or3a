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
import java.util.Collection;
import java.util.Collections;

public class ShowCupNumper extends AppCompatActivity {


    RecyclerView recyclerView ;
    RecyclerView.Adapter adapter ;
    RecyclerView.LayoutManager layoutManager ;
    ArrayList<String> allNumper;
    int theNumperOflist ;
    ArrayList<String> teamNumper1;
    ArrayList<String> teamNumper2;
    ArrayList<String> teamWin;
    TextView txtTeamName ;
    EditText editTeamNumper ;
    Button btnDone;
    FloatingActionButton fab ;
    int countItemList ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cup_numper);

        txtTeamName = findViewById(R.id.txtTeamName);
        editTeamNumper = findViewById(R.id.editTeamNumper);
        btnDone = findViewById(R.id.btnDone);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editTeamNumper.getText().toString().trim().length() > 0){

                    theNumperOflist = Integer.parseInt(String.valueOf(editTeamNumper.getText()));

                    btnDone.setVisibility(Button.GONE);
                    editTeamNumper.setEnabled(false);

                for (int i=1; i<=theNumperOflist; i++) {
                    allNumper.add(String.valueOf(i));
                }

                    Collections.shuffle(allNumper);
                    int size = allNumper.size();

                    teamNumper1 = new ArrayList<>();
                    teamNumper2 = new ArrayList<>();

                    for (int i = 0; i < size / 2; i++)
                        teamNumper1.add(allNumper.get(i));
                    for (int i = size / 2; i < size; i++)
                        teamNumper2.add(allNumper.get(i));

                    for (String s : teamNumper1){
                        Log.d("My1", String.valueOf(s));
                    }
                    for (String a : teamNumper2){
                        Log.d("My2", String.valueOf(a));
                    }

                    if(teamNumper1.size()>teamNumper2.size()){

                        teamNumper2.add( teamNumper2.size() - 1 ,"");

                    }else if ( teamNumper1.size()<teamNumper2.size()){

                        teamNumper1.add( teamNumper1.size() - 1 ,"");
                    }else{

                    }

                    adapter = new myAdapterForNumperCupParticipants(teamNumper1 , teamNumper2, ShowCupNumper.this);

                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(adapter);
                    countItemList =  recyclerView.getAdapter().getItemCount();

                }else{
                    Toast.makeText(getApplicationContext() ,  "لازم تضيف رقم فى الخانات الناقصة" , Toast.LENGTH_LONG).show();

                }
            }
        });




        allNumper = new ArrayList<>();
        teamWin = new ArrayList<>();








        Intent intent = getIntent();
        final String teamName = intent.getStringExtra("teamName");
        txtTeamName.setText(teamName);



        recyclerView = findViewById(R.id.listView);
        layoutManager = new LinearLayoutManager(this);





        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(teamWin.size() != countItemList){

                    Toast.makeText(ShowCupNumper.this, "You Should Choose The Winner", Toast.LENGTH_SHORT).show();

                }else{

                    Toast.makeText(ShowCupNumper.this, "Good", Toast.LENGTH_SHORT).show();

                }


            }
        });

    }

    public void setTeamWin( String win){

        teamWin.add(win);
        Log.d("My", String.valueOf(win));

    }




}