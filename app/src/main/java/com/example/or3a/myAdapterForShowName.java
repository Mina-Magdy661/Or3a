package com.example.or3a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapterForShowName extends RecyclerView.Adapter<myAdapterForShowName.myViewHolder> {

    ArrayList<String> list ;
    Context context;


    public myAdapterForShowName(ArrayList<String> list, Context context) {
        this.list = list;
        this.context =context;

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.name_item_show , parent, false);
        myViewHolder view = new myViewHolder(v);
        return  view;
    }

    @Override
    public void onBindViewHolder(@NonNull final myViewHolder holder, final int position) {

        String currentItem = list.get(position);
        holder.txtNameItem.setText(currentItem);


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
