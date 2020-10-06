package com.example.or3a.Cup;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.or3a.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class myAdapterForNumperCupParticipants extends RecyclerView.Adapter<myAdapterForNumperCupParticipants.myViewHolder> {

    ArrayList<String> list1;
    ArrayList<String> list2;
    Context context;
    String teamName ;
    ArrayList<String> winer  =   new ArrayList<>();



    public myAdapterForNumperCupParticipants(ArrayList<String> list1 , ArrayList<String> list2, Context context , String teamName ) {
        this.list1 = list1;
        this.list2 = list2;
        this.context = context;
        this.teamName = teamName;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_of_numper , parent, false);
        myViewHolder view = new myViewHolder(v);
        return  view;
    }

    @Override
    public void onBindViewHolder(@NonNull final myViewHolder holder, final int position) {



        String currentItem1 = list1.get(position);
        String currentItem2 = list2.get(position);

        holder.btn1.setText(currentItem1);
        holder.btn2.setText(currentItem2);


        SharedPreferences getData =  context.getSharedPreferences(teamName , context.MODE_PRIVATE);
        Gson gson = new Gson();
        String teamWin = getData.getString("teamWin", null);
        Type type = new TypeToken<ArrayList<String>>(){}.getType();
         winer = gson.fromJson(teamWin , type);


//        for (String s : winer){
//            Log.d("My", String.valueOf(s));
//        }
//
//
        if(winer != null) {
            holder.txtWin.setText(winer.get(position));
        }else{

            if(currentItem1.equals("")){
                holder.txtWin.setText(holder.btn2.getText().toString());
                holder.btn1.setEnabled(false);
                holder.btn2.setEnabled(false);
                ((ShowCupNumper) context).setTeamWin(holder.txtWin.getText().toString(),position);

            }
            if(currentItem2.equals("")){
                holder.txtWin.setText(holder.btn1.getText().toString());
                holder.btn1.setEnabled(false);
                holder.btn2.setEnabled(false);
                ((ShowCupNumper) context).setTeamWin(holder.txtWin.getText().toString(),position);

            }

            holder.btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    holder.btn1.setEnabled(false);
                    holder.btn2.setEnabled(false);
                    holder.txtWin.setText(holder.btn1.getText().toString());
                    ((ShowCupNumper) context).setTeamWin(holder.txtWin.getText().toString(),position);

                }
            });

            holder.btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    holder.btn2.setEnabled(false);
                    holder.btn1.setEnabled(false);
                    holder.txtWin.setText(holder.btn2.getText().toString());
                    ((ShowCupNumper) context).setTeamWin(holder.txtWin.getText().toString(),position);

                }
            });

        }


    }

    @Override
    public int getItemCount() {

        if(list1.size() > list2.size()){
            return list1.size();
        }else{
            return list2.size();
        }
    }

    public class  myViewHolder extends RecyclerView.ViewHolder{

        TextView txtWin ;
        Button btn1 , btn2 ;



        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            txtWin = itemView.findViewById(R.id.txtWin);
            btn1 = itemView.findViewById(R.id.btn1);
            btn2 = itemView.findViewById(R.id.btn2);

        }
    }
}
