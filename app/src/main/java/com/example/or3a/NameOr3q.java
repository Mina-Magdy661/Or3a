package com.example.or3a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class NameOr3q extends AppCompatActivity {

    RecyclerView recyclerView ;
    RecyclerView.Adapter adapter ;
    RecyclerView.LayoutManager layoutManager ;
    EditText editName ;
    Button btnAddName;
    String name;
    LinearLayout deleteItem;
    FloatingActionButton fab ;
    static ArrayList<String> nameOr3a ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_or3q);
        editName = findViewById(R.id.editName);
        btnAddName = findViewById(R.id.btnAdd);
        deleteItem = findViewById(R.id.delete_item);
        nameOr3a = new ArrayList<>();

        btnAddName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editName.getText().toString();
                nameOr3a.add(name);
                adapter.notifyDataSetChanged();
                editName.setText("");
            }
        });

         fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(nameOr3a.size() < 2){

                    Toast.makeText(getApplicationContext(), "You Should Add at Least 2 Name", Toast.LENGTH_LONG).show();

                }else{

                    openDialog();
                }


            }
        });

        recyclerView = findViewById(R.id.listView);
        layoutManager = new LinearLayoutManager(this);
        adapter = new myAdapterForName(nameOr3a,this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }

    private void openDialog() {

        CustomDialog dialog = new CustomDialog();
        dialog.show(getSupportFragmentManager() , "Dialog");

    }
}