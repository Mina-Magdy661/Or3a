package com.example.or3a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapterForShowNum extends RecyclerView.Adapter<myAdapterForShowNum.myViewHolder> {

    ArrayList<Integer> list ;
    Context context;


    public myAdapterForShowNum(ArrayList<Integer> list, Context context) {
        this.list = list;
        this.context =context;

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.numper_item_show, parent, false);
        myViewHolder view = new myViewHolder(v);
        return  view;
    }

    @Override
    public void onBindViewHolder(@NonNull final myViewHolder holder, final int position) {

        int currentItem = list.get(position);

        holder.txtNameItem.setText(String.valueOf(currentItem));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class  myViewHolder extends RecyclerView.ViewHolder{

        TextView txtNameItem ;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNameItem = itemView.findViewById(R.id.txtNameItem);
        }
    }
}
