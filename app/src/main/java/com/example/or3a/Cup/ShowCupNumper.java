package com.example.or3a.Cup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.or3a.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
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
    ArrayList<String> teamWinOrder;
    TextView txtTeamName ;
    EditText editTeamNumper ;
    Button btnDone;
    FloatingActionButton fab  , next ;
    int countItemList ;
    SharedPreferences saveCountTeam;
    String teamName ;
    boolean flag = false ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cup_numper);

        teamWin = new ArrayList<>();
        teamWinOrder = new ArrayList<>();

        Intent intent = getIntent();
        teamName = intent.getStringExtra("teamName");

        txtTeamName = findViewById(R.id.txtTeamName);
        txtTeamName.setText(teamName);

        editTeamNumper = findViewById(R.id.editTeamNumper);
        btnDone = findViewById(R.id.btnDone);

        recyclerView = findViewById(R.id.listView);
        layoutManager = new LinearLayoutManager(this);


        loadData();

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editTeamNumper.getText().toString().trim().length() > 0){

                    btnDone.setVisibility(Button.GONE);
                    editTeamNumper.setEnabled(false);
                    theNumperOflist = Integer.parseInt(String.valueOf(editTeamNumper.getText()));

                    teamWin.addAll(Arrays.asList( new String[theNumperOflist]));

                    for (int i=1; i<=theNumperOflist; i++) {
                    allNumper.add(String.valueOf(i));
                }
                    Collections.shuffle(allNumper);

                    int size = allNumper.size();

                    for (int i = 0; i < size / 2; i++)
                        teamNumper1.add(allNumper.get(i));

                    for (int i = size / 2 ; i < size; i++)
                        teamNumper2.add(allNumper.get(i));

                    if(teamNumper1.size()>teamNumper2.size()){

                        teamNumper2.add( teamNumper2.size() - 1 ,"");

                    }else if ( teamNumper1.size()<teamNumper2.size()){

                        teamNumper1.add( teamNumper1.size() - 1 ,"");
                    }

                    ViewData(teamNumper1 , teamNumper2);
                    saveData();

                }else{
                    Toast.makeText(getApplicationContext() ,  "لازم تضيف رقم فى الخانات الناقصة" , Toast.LENGTH_LONG).show();
                }
            }
        });




        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                

                if(teamWinOrder.size() != countItemList || countItemList == 0){
                    Toast.makeText(ShowCupNumper.this, "You Should Choose The Winner", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ShowCupNumper.this, "Good", Toast.LENGTH_SHORT).show();
                    flag = true;
                    saveCountTeam = getSharedPreferences(teamName , MODE_PRIVATE);
                    SharedPreferences.Editor editor = saveCountTeam.edit();
                    Gson gson = new Gson();
                    while(teamWin.remove(null)) { }
                    String team_Win = gson.toJson(teamWin);
                    editor.putString("teamWin" , team_Win);
                    editor.putBoolean("flag" , flag);
                    editor.apply();
                    next.setVisibility(View.VISIBLE);

                }
            }
        });

        next = findViewById(R.id.next);
        next.setVisibility(View.GONE);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences getData = getSharedPreferences(teamName , MODE_PRIVATE);
                boolean flag = getData.getBoolean("flag", false);

                if(flag){

                    getData = getSharedPreferences(teamName , MODE_PRIVATE);
                    Gson gson = new Gson();
                    String teamwin = getData.getString("teamWin", null);
                    Type type = new TypeToken<ArrayList<String>>(){}.getType();
                    allNumper = gson.fromJson(teamwin , type);
                    Collections.shuffle(allNumper);

                    teamNumper1.clear();
                    teamNumper2.clear();

                    int size = allNumper.size();

                    for (int i = 0; i < size / 2; i++)
                        teamNumper1.add(allNumper.get(i));

                    for (int i = size / 2 ; i < size; i++)
                        teamNumper2.add(allNumper.get(i));

                    if(teamNumper1.size()>teamNumper2.size()){

                        teamNumper2.add( teamNumper2.size() - 1 ,"");

                    }else if ( teamNumper1.size()<teamNumper2.size()){

                        teamNumper1.add( teamNumper1.size() - 1 ,"");
                    }


                    saveCountTeam = getSharedPreferences(teamName , MODE_PRIVATE);
                    SharedPreferences.Editor editor = saveCountTeam.edit();
                    editor.putString("teamWin" , null);
                    editor.apply();

                    ViewData(teamNumper1 , teamNumper2);



                }else{
                    Toast.makeText(getApplicationContext() ,  "Not YET" , Toast.LENGTH_LONG).show();
                }
            }
        });

    }



    public void setTeamWin(String win , int index){

        teamWinOrder.add(win);
        teamWin.add(index,win);

    }

    public  void loadData (){

        SharedPreferences getData = getSharedPreferences(teamName , MODE_PRIVATE);
        Gson gson = new Gson();
        int countTeam = getData.getInt("countTeam", 0);
        String team1 = getData.getString("team1", null);
        String team2 = getData.getString("team2", null);
        Type type = new TypeToken<ArrayList<String>>(){}.getType();

        teamNumper1 = gson.fromJson(team1 , type);
        teamNumper2 = gson.fromJson(team2 , type);


        if(countTeam == 0 ){
            teamNumper1 = new ArrayList<>();
            teamNumper2 = new ArrayList<>();
            allNumper = new ArrayList<>();

        }else{

            btnDone.setVisibility(Button.GONE);
            theNumperOflist = countTeam ;
            teamWin.addAll(Arrays.asList( new String[theNumperOflist]));
            editTeamNumper.setText(""+countTeam);
            editTeamNumper.setEnabled(false);
            ViewData(teamNumper1 , teamNumper2);
        }
    }

    public void ViewData(ArrayList<String> team1 , ArrayList<String> team2){

        adapter = new myAdapterForNumperCupParticipants(team1 , team2, ShowCupNumper.this,teamName);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        countItemList =  recyclerView.getAdapter().getItemCount();

    }

    public  void saveData(){

        saveCountTeam = getSharedPreferences(teamName , MODE_PRIVATE);
        SharedPreferences.Editor editor = saveCountTeam.edit();
        Gson gson = new Gson();
        String team1 = gson.toJson(teamNumper1);
        String team2 = gson.toJson(teamNumper2);
        editor.putInt("countTeam" , theNumperOflist);
        editor.putString("team1" , team1);
        editor.putString("team2" , team2);
        editor.apply();


    }


}