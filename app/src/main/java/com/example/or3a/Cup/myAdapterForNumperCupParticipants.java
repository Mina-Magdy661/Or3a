package com.example.or3a.Cup;

import android.content.Context;
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

import java.util.ArrayList;
import java.util.List;

public class myAdapterForNumperCupParticipants extends RecyclerView.Adapter<myAdapterForNumperCupParticipants.myViewHolder> {

    ArrayList<String> list1;
    ArrayList<String> list2;
    ArrayList<String> list3 = new ArrayList<>();

    MutableLiveData allData = new MutableLiveData<>();

    Context context;


    public myAdapterForNumperCupParticipants(ArrayList<String> list1 , ArrayList<String> list2, Context context ) {
        this.list1 = list1;
        this.list2 = list2;
        this.context =context;
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

        if(currentItem1.equals("")){
            holder.txtWin.setText(holder.btn2.getText().toString());
            holder.btn1.setEnabled(false);
            holder.btn2.setEnabled(false);
            list3.add(holder.btn2.getText().toString());

        }
        if(currentItem2.equals("")){
            holder.txtWin.setText(holder.btn1.getText().toString());
            holder.btn1.setEnabled(false);
            holder.btn2.setEnabled(false);
            list3.add(holder.btn1.getText().toString());

        }


        holder.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.btn1.setEnabled(false);
                holder.btn2.setEnabled(false);
                holder.txtWin.setText(holder.btn1.getText().toString());
                list3.add(holder.btn1.getText().toString());


            }
        });

        holder.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.btn2.setEnabled(false);
                holder.btn1.setEnabled(false);
                holder.txtWin.setText(holder.btn2.getText().toString());
                list3.add(holder.btn2.getText().toString());

            }
        });

        allData.setValue(list3);

        allData.observe((LifecycleOwner) context,new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {

                for (String s : strings){
                    Log.d("My", String.valueOf(s));
                }
            }
        });
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
